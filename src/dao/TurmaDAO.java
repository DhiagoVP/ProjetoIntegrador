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
import model.Aluno;
import model.Curso;
import model.Disciplina;
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
        int idEndereco = inserirEndereco(turma);
        PreparedStatement pstm;
        String sqlAluno = "INSERT INTO turma "
                + "(nome, dataInicio, dataFinal, turno, campusOfertante, cidadeDemandante, responsavel,"
                + " idCurso, idEndereco, idOrientador, idSupervisor)"
                + " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
        pstm = DBConnection.getConnection().prepareStatement(sqlAluno);
        pstm.setString(1, turma.getNome());
        pstm.setDate(2, new Date(turma.getDataInicioAulas().getTime()));
        pstm.setDate(3, new Date(turma.getDataTerminoAulas().getTime()));
        pstm.setString(4, turma.getTurno());
        pstm.setString(5, turma.getCampusOfertante());
        pstm.setString(6, turma.getCidadeDemandande());
        pstm.setString(7, turma.getResponsavel());
        pstm.setInt(8, turma.getCurso().getId());
        pstm.setInt(9, idEndereco);
        pstm.setInt(10, turma.getOrientador().getId());
        pstm.setInt(11, turma.getSupervisor().getId());
        pstm.execute();
        pstm.close();
        DBConnection.close();
        ResultSet rs;
        int id = -1;
        String sqlPesquisa = "SELECT MAX(idTurma) FROM Turma;";
        pstm = DBConnection.getConnection().prepareStatement(sqlPesquisa);
        rs = pstm.executeQuery();
        if (rs.next()) {
            id = rs.getInt("MAX(idTurma)");
        }
        inserirDiasAula(turma, id);
        inserirDisciplina(turma, id);
        assossiarProfessorATurma(turma, id);
        pstm.close();
        DBConnection.close();
        return true;
    }

    private int inserirEndereco(Turma turma) throws SQLException {
        PreparedStatement pstm;
        String sqlEndereco = "INSERT INTO endereco (rua, numero, bairro, estado, cidade)"
                + " VALUES (?, ?, ?, ?, ?);";
        pstm = DBConnection.getConnection().prepareStatement(sqlEndereco);
        pstm.setString(1, turma.getEndereco().getRua());
        pstm.setInt(2, turma.getEndereco().getNumero());
        pstm.setString(3, turma.getEndereco().getBairro());
        pstm.setString(4, turma.getEndereco().getEstado());
        pstm.setString(5, turma.getEndereco().getCidade());
        pstm.execute();
        ResultSet rs;
        int id = -1;
        String sqlPesquisa = "SELECT MAX(idEndereco) FROM Endereco;";
        pstm = DBConnection.getConnection().prepareStatement(sqlPesquisa);
        rs = pstm.executeQuery();
        if (rs.next()) {
            id = rs.getInt("MAX(idEndereco)");
        }
        pstm.close();
        DBConnection.close();
        return id;
    }

    private void inserirDisciplina(Turma turma, int idTurma) throws SQLException {
        PreparedStatement pstm;
        for (Disciplina disciplina : turma.getDisciplinas()) {
            String sqlDisciplina = "INSERT INTO disciplina (nomeDisciplina, dataInicioDisciplina, dataTerminoDisciplina)"
                    + "VALUES (?,?,?)";
            pstm = DBConnection.getConnection().prepareStatement(sqlDisciplina);
            pstm.setString(1, disciplina.getNome());
            pstm.setDate(2, new Date(disciplina.getDataDeInicio().getTime()));
            pstm.setDate(3, new Date(disciplina.getDataDeTermino().getTime()));
            pstm.execute();
            ResultSet rs;
            int id = -1;
            String sqlPesquisa = "SELECT MAX(idDisciplina) FROM Disciplina;";
            pstm = DBConnection.getConnection().prepareStatement(sqlPesquisa);
            rs = pstm.executeQuery();
            if (rs.next()) {
                id = rs.getInt("MAX(idDisciplina)");
            }
            assossiarDisciplinaATurma(idTurma, id);
        }
    }

    private void assossiarDisciplinaATurma(int idTurma, int idDisciplina) throws SQLException {
        PreparedStatement pstm;
        String sqlTurmaEDisciplina = "INSERT INTO turma_disciplina (turma_idTurma, disciplina_idDisciplina)"
                + "VALUES (?,?)";
        pstm = DBConnection.getConnection().prepareStatement(sqlTurmaEDisciplina);
        pstm.setInt(1, idTurma);
        pstm.setInt(2, idDisciplina);
        pstm.execute();
    }

    private void assossiarProfessorATurma(Turma turma, int idTurma) throws SQLException {
        PreparedStatement pstm;
        String sqlTurmaEDisciplina = "INSERT INTO turma_professor (Turma_idTurma, Professor_idProfessor)"
                + "VALUES (?,?)";
        pstm = DBConnection.getConnection().prepareStatement(sqlTurmaEDisciplina);
        for (Professor professor : turma.getProfessores()) {
            pstm.setInt(1, idTurma);
            pstm.setInt(2, professor.getId());
            pstm.execute();
        }
    }

    private void inserirDiasAula(Turma turma, int idTurma) throws SQLException {
        PreparedStatement pstm;
        String sqlDisciplina = "INSERT INTO turma_diasaula (diaAula, idTurma)"
                + "VALUES (?,?)";
        pstm = DBConnection.getConnection().prepareStatement(sqlDisciplina);
        for (String dias : turma.getAulasSemana()) {
            pstm.setString(1, dias);
            pstm.setInt(2, idTurma);
            pstm.execute();
        }
    }

    public boolean atualizar(Turma turma) throws SQLException {
        String sql = "UPDATE turma t, endereco e, orientador o, supervisor s, curso c, turma_professor tp, "
                + "turma_disciplina tdisciplina, turma_diasaula taula SET t.nome = ?, t.campusOfertante = ?,"
                + " t.cidadeDemandante = ?, t.idcurso= ?, t.dataInicio = ?, t.dataFinal = ?, t.turno = ?,"
                + " t.responsavel = ?,t.idOrientador = ?, t.idSupervisor = ?";
        PreparedStatement pstm = DBConnection.getConnection().prepareStatement(sql);
        pstm.setString(1, turma.getNome());
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
    
    private List<Disciplina> listarDisciplinas(int idTurma) throws SQLException{
        String sql = "SELECT * FROM disciplina d, turma_disciplina td where d.idDisciplina = td.disciplina_idDisciplina AND td.turma_idTurma = ? ORDER BY nomeDisciplina";
        List<Disciplina> listaDisciplinas = new ArrayList<>();
        PreparedStatement ps = DBConnection.getConnection().prepareStatement(sql);
        ps.setInt(1, idTurma);
        ResultSet rs = ps.executeQuery();
        Disciplina disciplina;
        while (rs.next()) {
            disciplina = new Disciplina(
                    rs.getInt("d.idDisciplina"),
                    rs.getString("d.nomeDisciplina"),
                    rs.getDate("d.dataInicioDisciplina"),
                    rs.getDate("d.dataTerminoDisciplina")
            );
            listaDisciplinas.add(disciplina);
        }
        return listaDisciplinas;
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
    
    private List<String> listarDiasAula(int idTurma) throws SQLException{
        String sql = "SELECT diaAula FROM turma_diasaula where idTurma = ? ORDER BY diaAula";
        List<String> listaDiasAula= new ArrayList<>();
        PreparedStatement ps = DBConnection.getConnection().prepareStatement(sql);
        ps.setInt(1, idTurma);
        ResultSet rs = ps.executeQuery();
        String dia;
        while (rs.next()) {
            dia = rs.getString("diaAula");
            listaDiasAula.add(dia);
        }
        ps.close();
        DBConnection.close();
        return listaDiasAula;
    }
    
     private Turma transformarResultSet(ResultSet rs) throws SQLException {
        int idTurma = rs.getInt("t.idTurma");
        Turma turma = new Turma(
                idTurma,
                rs.getString("t.cidadeDemandante"),
                rs.getString("t.campusOfertante"),
                rs.getString("t.nome"),
                rs.getString("t.turno"),
                listarDiasAula(idTurma),
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
                listarDisciplinas(idTurma)
        );

        return turma;
    }

    public Turma buscarPorId(int id) throws SQLException {
        String sql = "SELECT * FROM turma t, curso c, endereco e, supervisor s, orientador o  WHERE idTurma = ? " +
                    "AND t.idEndereco = e.idEndereco AND t.idcurso = c.idcurso AND t.idOrientador = o.idOrientador "+
                    "AND t.idSupervisor = s.idSupervisor";
        PreparedStatement preparedStatement = DBConnection.getConnection().prepareStatement(sql);
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        Turma turma = null;
        if (resultSet.first()) 
            turma = transformarResultSet(resultSet);
        return turma;
    }
}
