/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import connection.DBConnection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Curso;
import model.Endereco;
import model.Orientador;
import model.Professor;
import model.Supervisor;
import model.Turma;

/**
 *
 * @author Ana Paula e Dhiago
 */

public class TurmaDAO {
    
    List<Turma> listaTurma;

    public boolean cadastrar(Turma turma) throws SQLException {
        String sqlAluno = "INSERT INTO turma "
                + "(nome, dataInicio, dataFinal, turno, campusOfertante, cidadeDemandante, responsavel,"
                + " idCurso, idEndereco, idOrientador, idSupervisor)"
                + " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
        PreparedStatement pstm = DBConnection.getConnection().prepareStatement(sqlAluno);
        pstm.setString(1, turma.getNome());
        pstm.setDate(2, new Date(turma.getDataInicioAulas().getTime()));
        pstm.setDate(3, new Date(turma.getDataTerminoAulas().getTime()));
        pstm.setString(4, turma.getTurno());
        pstm.setString(5, turma.getCampusOfertante());
        pstm.setString(6, turma.getCidadeDemandande());
        pstm.setString(7, turma.getResponsavel());
        pstm.setInt(8, turma.getCurso().getId());
        pstm.setInt(9, new EnderecoDAO().inserir(turma.getEndereco()));
        pstm.setInt(10, turma.getOrientador().getId());
        pstm.setInt(11, turma.getSupervisor().getId());
        pstm.execute();
        pstm.close();
        DBConnection.close();
        int id = -1;
        String sqlPesquisa = "SELECT MAX(idTurma) FROM Turma;";
        pstm = DBConnection.getConnection().prepareStatement(sqlPesquisa);
         ResultSet rs = pstm.executeQuery();
        if (rs.next()) {
            id = rs.getInt("MAX(idTurma)");
        }
        new DiasAulaDAO().inserir(turma.getAulasSemana(), id);
        new DisciplinaDAO().inserir(turma.getDisciplinas(), id);
        new ProfessorDAO().assossiarATurma(turma.getProfessores(), id);
        pstm.close();
        DBConnection.close();
        return true;
    }

    public boolean atualizar(Turma turma) throws SQLException {
        String sql = "UPDATE turma SET nome = ?, campusOfertante = ?,"
                + " cidadeDemandante = ?, idcurso= ?, dataInicio = ?, dataFinal = ?, turno = ?,"
                + " responsavel = ?,idOrientador = ?, idSupervisor = ? WHERE idTurma = ?";
        PreparedStatement pstm = DBConnection.getConnection().prepareStatement(sql);
        pstm.setString(1, turma.getNome());
        pstm.setString(2, turma.getCampusOfertante());
        pstm.setString(3, turma.getCidadeDemandande());
        pstm.setInt(4, turma.getCurso().getId());
        pstm.setDate(5, new Date(turma.getDataInicioAulas().getTime()));
        pstm.setDate(6, new Date(turma.getDataTerminoAulas().getTime()));
        pstm.setString(7, turma.getTurno());
        pstm.setString(8, turma.getResponsavel());
        pstm.setInt(9, turma.getOrientador().getId());
        pstm.setInt(10, turma.getSupervisor().getId());
        pstm.setInt(11, turma.getId());
        pstm.execute();
        pstm.close();
        DBConnection.close();
        return true;
    }
    public boolean remover(Turma turma) throws SQLException {
        String sql = "DELETE FROM turma WHERE idTurma = ?";
        PreparedStatement pstm = DBConnection.getConnection().prepareStatement(sql);
        pstm.setInt(1, turma.getId());
        pstm.execute();
        pstm.close();
        DBConnection.close();
        return true;
    }

    public List<Turma> listarTodos() throws SQLException {
        String sql = "SELECT t.nome, idTurma, o.nome, o.idOrientador, s.nome, s.idSupervisor, c.nome,"+
                " c.idCurso, t.campusOfertante, t.cidadeDemandante, t.turno "+
                "FROM turma t, orientador o, supervisor s, curso c where t.idOrientador = o.idOrientador "+
                "AND t.idSupervisor = s.idSupervisor AND t.idCurso = c.idcurso ORDER BY t.nome";
        PreparedStatement preparedStatement = DBConnection.getConnection().prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        listaTurma = getParametrosDeTurma(resultSet);
        preparedStatement.close();
        DBConnection.close();
        return listaTurma;
    }
    
    
    public Turma buscarPorId(int id) throws SQLException {
        String sql = "SELECT * FROM turma t, curso c, endereco e, supervisor s, orientador o, professor p,"
                + " turma_professor tp  WHERE idTurma = ? " +
                    "AND t.idEndereco = e.idEndereco AND t.idcurso = c.idcurso AND t.idOrientador = o.idOrientador "+
                    "AND t.idSupervisor = s.idSupervisor AND t.idTurma = tp.Turma_idTurma " +
                    "AND p.idprofessor = tp.Professor_idprofessor";
        PreparedStatement preparedStatement = DBConnection.getConnection().prepareStatement(sql);
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        Turma turma = null;
        if (resultSet.next()) 
            turma = transformarResultSet(resultSet);
        return turma;
    }

    public List<Turma> buscarPorCurso(Curso curso) throws SQLException {
        String sql = "SELECT t.nome, idTurma, o.nome, o.idOrientador, s.nome, s.idSupervisor, c.nome, "+
                "c.idCurso, t.campusOfertante, t.cidadeDemandante, t.turno " +
                "FROM turma t, orientador o, supervisor s, curso c WHERE t.idCurso = c.idcurso and c.idcurso = ?" +
                " ORDER BY t.nome";
        PreparedStatement preparedStatement = DBConnection.getConnection().prepareStatement(sql);
        preparedStatement.setInt(1, curso.getId());
        ResultSet resultSet = preparedStatement.executeQuery();
        listaTurma = getParametrosDeTurma(resultSet);
        preparedStatement.close();
        DBConnection.close();
        return listaTurma;
    }
    
    public List<Turma> buscarPorNome(String nome) throws SQLException{
        String sql = "SELECT t.nome, idTurma, o.nome, o.idOrientador, s.nome, s.idSupervisor, c.nome, " +
            "c.idCurso, t.campusOfertante, t.cidadeDemandante, t.turno FROM turma t, orientador o, supervisor s, " +
            "curso c WHERE t.nome = ? AND t.idCurso = c.idcurso AND t.idOrientador = o.idOrientador AND "+
            "t.idSupervisor = s.idSupervisor AND t.idCurso = c.idcurso AND t.idSupervisor = s.idSupervisor " +
                "ORDER BY t.nome";
        PreparedStatement ps = DBConnection.getConnection().prepareStatement(sql);
        ps.setString(1, nome);
        ResultSet resultSet = ps.executeQuery();
        listaTurma = getParametrosDeTurma(resultSet);
        ps.close();
        DBConnection.close();
        return listaTurma;
    }
    
    public List<Turma> buscarPorOrientador(Orientador orientador) throws SQLException{
        String sql = "SELECT t.nome, idTurma, o.nome, o.idOrientador, s.nome, s.idSupervisor, c.nome, " +
            "c.idCurso, t.campusOfertante, t.cidadeDemandante, t.turno FROM turma t, orientador o, supervisor s, " +
            "curso c WHERE t.idOrientador = ? " +
            "AND t.idCurso = c.idcurso AND t.idSupervisor = s.idSupervisor AND t.idCurso = c.idcurso"+
                " AND t.idSupervisor = s.idSupervisor ORDER BY t.nome";
        PreparedStatement ps = DBConnection.getConnection().prepareStatement(sql);
        ps.setInt(1, orientador.getId());
        ResultSet resultSet = ps.executeQuery();
        listaTurma = getParametrosDeTurma(resultSet);
        ps.close();
        DBConnection.close();
        return listaTurma;
    }
    
    public List<Turma> buscarPorSupervisor(Supervisor supervisor) throws SQLException{
        String sql = "SELECT t.nome, idTurma, o.nome, o.idOrientador, s.nome, s.idSupervisor, c.nome, c.idCurso,"
            + " t.campusOfertante, t.cidadeDemandante, t.turno FROM turma t, orientador o, supervisor s, curso c "+
            "WHERE t.idSupervisor = ? AND t.idCurso = c.idcurso AND t.idOrientador = o.idOrientador ORDER BY t.nome";
        PreparedStatement ps = DBConnection.getConnection().prepareStatement(sql);
        ps.setInt(1, supervisor.getId());
        ResultSet resultSet = ps.executeQuery();
        listaTurma = getParametrosDeTurma(resultSet);
        ps.close();
        DBConnection.close();
        return listaTurma;
    }
    
    public List<Turma> buscarPorProfessor(Professor professor) throws SQLException{
        String sql = "SELECT t.nome, idTurma, o.nome, o.idOrientador, s.nome, s.idSupervisor, c.nome,c.idCurso, "+
                "t.campusOfertante, t.cidadeDemandante, t.turno FROM turma t,orientador o, supervisor s, curso c, "+
                "turma_professor tp WHERE tp.Professor_idprofessor = ? AND tp.Turma_idTurma = t.idTurma AND "+
                "t.idCurso = c.idcurso AND t.idOrientador = o.idOrientador AND t.idSupervisor = s.idSupervisor "+
                "ORDER BY t.nome";
        PreparedStatement ps = DBConnection.getConnection().prepareStatement(sql);
        ps.setInt(1, professor.getId());
        ResultSet resultSet = ps.executeQuery();
        listaTurma = getParametrosDeTurma(resultSet);
        ps.close();
        DBConnection.close();
        return listaTurma;
    }
    
    private List<Turma> getParametrosDeTurma(ResultSet resultSet) throws SQLException {
        listaTurma = new ArrayList<>();
        Turma turma;
        while (resultSet.next()) {
            turma = new Turma(resultSet.getInt("t.idTurma"),
                    resultSet.getString("t.nome"),
                    resultSet.getString("t.cidadeDemandante"),
                    resultSet.getString("t.campusOfertante"),
                    resultSet.getString("t.turno"),
                    new Orientador(resultSet.getInt("o.idOrientador"), resultSet.getString("o.nome")),
                    new Supervisor(resultSet.getInt("s.idSupervisor"), resultSet.getString("s.nome")),
                    new Curso(resultSet.getInt("c.idCurso"),resultSet.getString("c.nome"))
            );
            listaTurma.add(turma);
        }
        return listaTurma;
    }
    
     private Turma transformarResultSet(ResultSet rs) throws SQLException {
        int idTurma = rs.getInt("t.idTurma");
        Turma turma = new Turma(
                idTurma,
                rs.getString("t.cidadeDemandante"),
                rs.getString("t.campusOfertante"),
                rs.getString("t.nome"),
                rs.getString("t.turno"),
                new DiasAulaDAO().listarTodasAsAulas(idTurma),
                rs.getDate("t.dataInicio"),
                rs.getDate("t.dataFinal"),
                new Endereco(
                        rs.getInt("e.idEndereco"),
                        rs.getString("e.rua"),
                        rs.getInt("e.numero"),
                        rs.getString("e.bairro"),
                        rs.getString("e.estado"),
                        rs.getString("e.cidade")
                ),
                true,
                new Orientador(
                        rs.getInt("o.idOrientador"),
                        rs.getString("o.nome"),
                        rs.getString("o.cpf"),
                        rs.getString("o.rg"),
                        rs.getString("o.titulacao"),
                        rs.getString("o.telefone"),
                        rs.getString("o.email"),
                        rs.getBoolean("o.status"),
                        rs.getDate("o.dataEntrada")
                ),
                new Supervisor(
                        rs.getInt("s.idSupervisor"),
                        rs.getString("s.nome"),
                        rs.getString("s.cpf"),
                        rs.getString("s.rg"),
                        rs.getString("s.titulacao"),
                        rs.getString("s.telefone"),
                        rs.getString("s.email"),
                        rs.getBoolean("s.status"),
                        rs.getDate("s.dataEntrada")),
                new ProfessorDAO().listarTodosComRelacaoAUmaTurma(idTurma), 
                rs.getString("t.responsavel"),
                new Curso(rs.getInt("c.idCurso"),
                        rs.getString("c.nome"),
                        rs.getString("c.descricao"),
                        rs.getString("c.eixoTecnologico"),
                        rs.getString("c.cargaHoraria"),
                        rs.getBoolean("c.status")), 
                new DisciplinaDAO().listarDisciplinas(idTurma)
        );

        return turma;
    }
}
