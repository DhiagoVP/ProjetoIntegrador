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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import model.Aluno;
import model.Beneficio;
import model.Curso;
import model.Login;
import model.Orientador;
import model.Pagamento;
import model.Supervisor;
import model.Turma;

/**
 *
 * @author Aluno
 */
public class PagamentoDAO {

    SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");

    public int inserir(Pagamento pagamentoFinal) throws SQLException {
        long dataAtual = new java.util.Date().getTime();
        int idTurma = pagamentoFinal.getTurma().getId();
        String sql = "INSERT INTO pagamento (idpagamento, date, idTurma, idUsuario, totalPago, mes, diasLetivos) "
                + "VALUES(?,?,?,?,?,?,?)";
        PreparedStatement pstm = DBConnection.getConnection().prepareStatement(sql);
        pstm.setInt(1, pagamentoFinal.getId());
        pstm.setDate(2, new Date(dataAtual));
        pstm.setInt(3, idTurma);
        pstm.setInt(4, pagamentoFinal.getUsuario().getId());
        pstm.setDouble(5, pagamentoFinal.getValorAPagarPorTurma());
        pstm.setString(6, pagamentoFinal.getMes());
        pstm.setInt(7, pagamentoFinal.getDiasLetivos());
        pstm.execute();
        pstm.close();
        DBConnection.close();
        for (Aluno aluno : pagamentoFinal.getAlunos()) {
            for (Beneficio beneficio : pagamentoFinal.getBeneficios()) {
                inserirTabelaAluno_Beneficio(aluno, beneficio, pagamentoFinal);
            }
            inserirTabelaAluno_Pagamento(aluno);
        }
        int id = -1;
        String sqlPesquisa = "SELECT MAX(idPagamento) FROM Pagamento";
        pstm = DBConnection.getConnection().prepareStatement(sqlPesquisa);
         ResultSet rs = pstm.executeQuery();
        if (rs.next()) {
            id = rs.getInt("MAX(idPagamento)");
        }
        pstm.close();
        DBConnection.close();
        return id;
    }

    private void inserirTabelaAluno_Beneficio(Aluno aluno, Beneficio beneficio, Pagamento pagamento) throws SQLException {
        String sql = "INSERT INTO aluno_beneficio (idAluno, idBeneficio, idPagamento, valorRecebido) "
                + "VALUES(?,?,?,?)";
        double valorPorBeneficio = (pagamento.getDiasLetivos() - aluno.getFaltas()) * beneficio.getValor();
        PreparedStatement pstm = DBConnection.getConnection().prepareStatement(sql);
        pstm.setInt(1, aluno.getId());
        pstm.setInt(2, beneficio.getId());
        pstm.setInt(3, buscarUltimoID());
        pstm.setDouble(4, valorPorBeneficio);
        pstm.execute();
        pstm.close();
        DBConnection.close();
    }

    private void inserirTabelaAluno_Pagamento(Aluno aluno) throws SQLException {
        String sql = "INSERT INTO aluno_pagamento (idAluno, idPagamento, faltas, valorDescontado, totalRecebido) "
                + "VALUES(?,?,?,?,?)";
        PreparedStatement pstm = DBConnection.getConnection().prepareStatement(sql);
        pstm.setInt(1, aluno.getId());
        pstm.setInt(2, buscarUltimoID());
        pstm.setInt(3, aluno.getFaltas());
        pstm.setDouble(4, aluno.getValorDescontado());
        pstm.setDouble(5, aluno.getValorRecebido());
        pstm.execute();
        pstm.close();
        DBConnection.close();
    }

    private int buscarUltimoID() throws SQLException {
        int id = 0;
        String sql = "SELECT MAX(IdPagamento) FROM PAGAMENTO";
        PreparedStatement pstm = DBConnection.getConnection().prepareStatement(sql);
        ResultSet rs = pstm.executeQuery();
        if (rs.next()) {
            id = rs.getInt("MAX(IdPagamento)");
        }
        pstm.close();
        DBConnection.close();
        return id;
    }

    public List<Pagamento> listarTodos() throws SQLException {
        String sql = "SELECT * FROM pagamento p, turma t, "
                + "login l, orientador o, supervisor s, curso c"
                + " WHERE p.idTurma = t.idTurma AND p.idUsuario = l.id AND "
                + "t.idOrientador = o.idOrientador AND t.idSupervisor = s.idSupervisor"
                + " AND t.idCurso = c.idCurso";
        List<Pagamento> listaPagamento = new ArrayList<>();
        PreparedStatement ps = DBConnection.getConnection().prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        Pagamento pagamento;
        while (rs.next()) {

            pagamento = new Pagamento(
                    rs.getInt("p.idpagamento"),
                    rs.getDouble("p.totalPago"),
                    new Turma(rs.getInt("t.idTurma"),
                            rs.getString("t.nome"),
                            rs.getString("t.cidadeDemandante"),
                            rs.getString("t.campusOfertante"),
                            rs.getString("t.turno"),
                            rs.getDate("t.dataInicio"),
                            rs.getDate("t.dataFinal"),
                            new Orientador(rs.getInt("o.idOrientador"), rs.getString("o.nome")),
                            new Supervisor(rs.getInt("s.idSupervisor"), rs.getString("s.nome")),
                            new Curso(rs.getInt("c.idCurso"), rs.getString("c.nome"))),
                    rs.getString("p.mes"),
                    rs.getDate("p.date"),
                    new Login(rs.getInt("p.idUsuario"), rs.getString("l.usuario")),
                    rs.getInt("p.diasLetivos"));
            listaPagamento.add(pagamento);
        }
        return listaPagamento;
    }

    public List<Beneficio> buscarBeneficios(int idPagamento) throws SQLException {
        String sql = "SELECT DISTINCT b.id, b.tipo, b.valor, b.descricao FROM aluno_beneficio ab, beneficio b "
                + "WHERE ab.idBeneficio = b.id AND ab.idPagamento = ?";
        List<Beneficio> listaBeneficio = new ArrayList<>();
        PreparedStatement ps = DBConnection.getConnection().prepareStatement(sql);
        ps.setInt(1, idPagamento);
        ResultSet rs = ps.executeQuery();
        Beneficio beneficio;
        while (rs.next()) {
            beneficio = new Beneficio(
                    rs.getInt("b.id"),
                    rs.getString("b.tipo"),
                    rs.getDouble("b.valor"),
                    rs.getString("b.descricao"));
            listaBeneficio.add(beneficio);
        }
        return listaBeneficio;
    }

    public List<Aluno> buscarAlunosPagos(int idPagamento) throws SQLException {
        String sql = "SELECT * FROM aluno_pagamento WHERE idPagamento = ?";
        List<Aluno> listaAlunos = new ArrayList<>();
        PreparedStatement ps = DBConnection.getConnection().prepareStatement(sql);
        ps.setInt(1, idPagamento);
        ResultSet rs = ps.executeQuery();
        Aluno aluno;
        while (rs.next()) {
            aluno = new Aluno(
                    rs.getInt("idAluno"),
                    rs.getInt("faltas"),
                    rs.getDouble("totalRecebido"),
                    rs.getDouble("valorDescontado"));
            listaAlunos.add(aluno);
        }
        return listaAlunos;
    }

    public List<Pagamento> listarTodosPorTurma(Turma turma) throws SQLException {
        String sql = "SELECT * FROM pagamento p, turma t, login l, "
                + "orientador o, supervisor s, curso c"
                + " WHERE p.idTurma = ? AND t.nome = ? AND p.idUsuario = l.id AND "
                + "t.idOrientador = o.idOrientador AND t.idSupervisor = s.idSupervisor "
                + "AND t.idCurso = c.idCurso";
        List<Pagamento> listaPagamento = new ArrayList<>();
        PreparedStatement ps = DBConnection.getConnection().prepareStatement(sql);
        ps.setInt(1, turma.getId());
        ps.setString(2, turma.getNome());
        ResultSet rs = ps.executeQuery();
        Pagamento pagamento;
        while (rs.next()) {
            pagamento = new Pagamento(
                    rs.getInt("p.idpagamento"),
                    rs.getDouble("p.totalPago"),
                    new Turma(rs.getInt("t.idTurma"),
                            rs.getString("t.nome"),
                            rs.getString("t.cidadeDemandante"),
                            rs.getString("t.campusOfertante"),
                            rs.getString("t.turno"),
                            rs.getDate("t.dataInicio"),
                            rs.getDate("t.dataFinal"),
                            new Orientador(rs.getInt("o.idOrientador"), rs.getString("o.nome")),
                            new Supervisor(rs.getInt("s.idSupervisor"), rs.getString("s.nome")),
                            new Curso(rs.getInt("c.idCurso"), rs.getString("c.nome"))),
                    rs.getString("p.mes"),
                    rs.getDate("p.date"),
                    new Login(rs.getInt("p.idUsuario"), rs.getString("l.usuario")),
                    rs.getInt("p.diasLetivos"));
            listaPagamento.add(pagamento);
        }
        return listaPagamento;
    }

    public List<Pagamento> listarTodosPorMes(String mes) throws SQLException {
        String sql = "SELECT * FROM pagamento p, turma t, login l, "
                + "orientador o, supervisor s, curso c WHERE p.idTurma = t.idTurma AND p.idUsuario = l.id AND "
                + "t.idOrientador = o.idOrientador AND p.mes = ? AND t.idSupervisor = s.idSupervisor "
                + "AND t.idCurso = c.idCurso";
        List<Pagamento> listaPagamento = new ArrayList<>();
        PreparedStatement ps = DBConnection.getConnection().prepareStatement(sql);
        ps.setString(1, mes);
        ResultSet rs = ps.executeQuery();
        Pagamento pagamento;
        while (rs.next()) {
            pagamento = new Pagamento(
                    rs.getInt("p.idpagamento"),
                    rs.getDouble("p.totalPago"),
                    new Turma(rs.getInt("t.idTurma"),
                            rs.getString("t.nome"),
                            rs.getString("t.cidadeDemandante"),
                            rs.getString("t.campusOfertante"),
                            rs.getString("t.turno"),
                            rs.getDate("t.dataInicio"),
                            rs.getDate("t.dataFinal"),
                            new Orientador(rs.getInt("o.idOrientador"), rs.getString("o.nome")),
                            new Supervisor(rs.getInt("s.idSupervisor"), rs.getString("s.nome")),
                            new Curso(rs.getInt("c.idCurso"), rs.getString("c.nome"))),
                    rs.getString("p.mes"),
                    rs.getDate("p.date"),
                    new Login(rs.getInt("p.idUsuario"), rs.getString("l.usuario")),
                    rs.getInt("p.diasLetivos"));
            listaPagamento.add(pagamento);
        }
        return listaPagamento;
    }

    public List<Pagamento> listarTodosPorTurmaEMes(Turma turma, String mes) throws SQLException {
        String sql = "SELECT * FROM pagamento p, turma t, login l, "
                + "orientador o, supervisor s, curso c WHERE p.idTurma = ? AND t.nome = ? AND p.idUsuario = l.id AND "
                + "t.idOrientador = o.idOrientador AND t.idSupervisor = s.idSupervisor AND "
                + "t.idCurso = c.idCurso AND p.mes = ?";
        List<Pagamento> listaPagamento = new ArrayList<>();
        PreparedStatement ps = DBConnection.getConnection().prepareStatement(sql);
        ps.setInt(1, turma.getId());
        ps.setString(2, turma.getNome());
        ps.setString(3, mes);
        ResultSet rs = ps.executeQuery();
        Pagamento pagamento;
        while (rs.next()) {
            pagamento = new Pagamento(
                    rs.getInt("p.idpagamento"),
                    rs.getDouble("p.totalPago"),
                    new Turma(rs.getInt("t.idTurma"),
                            rs.getString("t.nome"),
                            rs.getString("t.cidadeDemandante"),
                            rs.getString("t.campusOfertante"),
                            rs.getString("t.turno"),
                            rs.getDate("t.dataInicio"),
                            rs.getDate("t.dataFinal"),
                            new Orientador(rs.getInt("o.idOrientador"), rs.getString("o.nome")),
                            new Supervisor(rs.getInt("s.idSupervisor"), rs.getString("s.nome")),
                            new Curso(rs.getInt("c.idCurso"), rs.getString("c.nome"))),
                    rs.getString("p.mes"),
                    rs.getDate("p.date"),
                    new Login(rs.getInt("p.idUsuario"), rs.getString("l.usuario")),
                    rs.getInt("p.diasLetivos"));
            listaPagamento.add(pagamento);
        }
        return listaPagamento;
    }
    
    public double recuperarTotalPagoPorBeneficio(int idBeneficio, int idPagamento) throws SQLException{
        double valorRecebido = 0.0;
        String sql = "SELECT SUM(valorRecebido) FROM aluno_beneficio where idBeneficio = ? and idPagamento = ?";
        PreparedStatement pstm = DBConnection.getConnection().prepareStatement(sql);
        pstm.setInt(1, idBeneficio);
        pstm.setInt(2, idPagamento);
        ResultSet rs = pstm.executeQuery();
        if (rs.next()) {
               valorRecebido = rs.getDouble("SUM(valorRecebido)");
        }
        pstm.close();
        DBConnection.close();
        return valorRecebido;
    }
}
