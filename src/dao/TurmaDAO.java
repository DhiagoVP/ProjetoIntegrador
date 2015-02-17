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

//TODO: refatorar o método listar todos, fazendo com que ele retorne as informações básicas de cada objeto. 
//Quando o usuário quiser mais detalhes, seleciona o objeto desejado e faz-se mais uma busca no banco, 
//agora com o objeto completo
public class TurmaDAO {

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

    public void atualizar(Turma turma) {

    }

    public void remover(Turma turma) {
        
    }

    public List<Turma> listarTodos() throws SQLException {
        String sql = "SELECT t.nome, idTurma, o.nome, o.idOrientador, s.nome, s.idSupervisor, c.nome, c.idCurso, t.campusOfertante, t.cidadeDemandante, t.turno "+
                "FROM turma t, orientador o, supervisor s, curso c where t.idOrientador = o.idOrientador "+
                "AND t.idSupervisor = s.idSupervisor AND t.idCurso = c.idcurso ORDER BY t.nome";
        List<Turma> listaTurma = new ArrayList<>();
        PreparedStatement ps = DBConnection.getConnection().prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        Turma turma;
        while (rs.next()) {
            turma = new Turma(rs.getInt("t.idTurma"),
                    rs.getString("t.nome"),
                    rs.getString("t.cidadeDemandante"),
                    rs.getString("t.campusOfertante"),
                    rs.getString("t.turno"),
                    new Orientador(rs.getInt("o.idOrientador"), rs.getString("o.nome")),
                    new Supervisor(rs.getInt("s.idSupervisor"), rs.getString("s.nome")),
                    new Curso(rs.getInt("c.idCurso"),rs.getString("c.nome"))
                    );
            listaTurma.add(turma);
        }
        ps.close();
        DBConnection.close();
        
        return listaTurma;
    }

    public Turma transformarResultSet(ResultSet rs) throws SQLException {
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

    public List<Turma> buscarPorCurso(Curso curso) throws SQLException {
        String sql = "SELECT * FROM turma t, endereco e, orientador o, supervisor s, curso c WHERE t.idCurso = ?" +
                " ORDER BY t.nome";
        List<Turma> listaTurmas = new ArrayList<>();
        PreparedStatement ps = DBConnection.getConnection().prepareStatement(sql);
        ps.setInt(1, curso.getId());
        ResultSet rs = ps.executeQuery();
        Turma turma;
        while (rs.next()) {
            turma = transformarResultSet(rs);
            listaTurmas.add(turma);
        }
        ps.close();
        DBConnection.close();
        return listaTurmas;
    }
    
    public List<Turma> buscarPorNome(String nome) throws SQLException{
        String sql = "SELECT * FROM turma t, endereco e, orientador o, supervisor s, curso c WHERE t.nome = ?" + 
                " ORDER BY t.nome";
        List<Turma> listaTurmas = new ArrayList<>();
        PreparedStatement ps = DBConnection.getConnection().prepareStatement(sql);
        ps.setString(1, nome);
        ResultSet rs = ps.executeQuery();
        Turma turma;
        while (rs.next()) {
            turma = transformarResultSet(rs);
            listaTurmas.add(turma);
        }
        ps.close();
        DBConnection.close();
        return listaTurmas;
    }
    
    public List<Turma> buscarPorOrientador(Orientador orientador) throws SQLException{
        String sql = "SELECT * FROM turma t, endereco e, orientador o, supervisor s, curso c WHERE t.idOrientador = ? " +
                "ORDER BY t.nome";
        List<Turma> listaTurmas = new ArrayList<>();
        PreparedStatement ps = DBConnection.getConnection().prepareStatement(sql);
        ps.setInt(1, orientador.getId());
        ResultSet rs = ps.executeQuery();
        Turma turma;
        while (rs.next()) {
            turma = transformarResultSet(rs);
            listaTurmas.add(turma);
        }
        ps.close();
        DBConnection.close();
        return listaTurmas;
    }
    
    public List<Turma> buscarPorSupervisor(Supervisor supervisor) throws SQLException{
        String sql = "SELECT * FROM turma t, endereco e, orientador o, supervisor s, curso c WHERE t.idSuprvisor = ?" +
                " ORDER BY t.nome";
        List<Turma> listaTurmas = new ArrayList<>();
        PreparedStatement ps = DBConnection.getConnection().prepareStatement(sql);
        ps.setInt(1, supervisor.getId());
        ResultSet rs = ps.executeQuery();
        Turma turma;
        while (rs.next()) {
            turma = transformarResultSet(rs);
            listaTurmas.add(turma);
        }
        ps.close();
        DBConnection.close();
        return listaTurmas;
    }
    
    public List<Turma> buscarPorProfessor(Professor professor) throws SQLException{
        String sql = "SELECT * FROM turma t, endereco e, orientador o, supervisor s, curso c, turma_professor tp" +
                " WHERE tp.Professor_idprofessor = ? ORDER BY t.nome"; //SQL não retorna corretamente
        List<Turma> listaTurmas = new ArrayList<>();
        
        PreparedStatement ps = DBConnection.getConnection().prepareStatement(sql);
        ps.setInt(1, professor.getId());
        ResultSet rs = ps.executeQuery();
        Turma turma;
        while (rs.next()) {
            turma = transformarResultSet(rs);
            listaTurmas.add(turma);
        }
        ps.close();
        DBConnection.close();
        return listaTurmas;
    }
}
