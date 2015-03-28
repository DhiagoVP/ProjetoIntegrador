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
import model.Aluno;
import model.Beneficio;
import model.Pagamento;

/**
 *
 * @author Aluno
 */
public class PagamentoDAO {

    public boolean inserir(Pagamento pagamentoFinal) throws SQLException {
        pagamentoFinal.setId(buscarUltimoID());
        long dataAtual = new java.util.Date().getTime();
        int idTurma = pagamentoFinal.getTurma().getId();
        String sql = "INSERT INTO pagamento (idPagamento, data, nomeAluno, CPF, banco, agencia, conta, faltas, "
                + "valorDescontado, valorTotal, idTurma, idAluno) VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement pstm = DBConnection.getConnection().prepareStatement(sql);
        for (Aluno aluno : pagamentoFinal.getAlunos()){
            pstm.setInt(1, pagamentoFinal.getId());
            pstm.setDate(2, new Date(dataAtual));
            pstm.setString(3, aluno.getNome());
            pstm.setString(4, aluno.getCpf());
            pstm.setString(5, aluno.getContaBancaria().getNomeBanco());
            pstm.setInt(6, aluno.getContaBancaria().getAgencia());
            pstm.setInt(7, aluno.getContaBancaria().getNumeroConta());
            pstm.setInt(8, aluno.getFaltas());
            pstm.setDouble(9, aluno.getValorDescontado());
            pstm.setDouble(10, aluno.getValorRecebido());
            pstm.setInt(11, idTurma);
            pstm.setInt(12, aluno.getId());
            pstm.execute();
            for(Beneficio beneficio:  pagamentoFinal.getBenefios()){
                inserirTabelaAssossiativa(aluno, beneficio, pagamentoFinal);
            }
        }
        pstm.close();
        DBConnection.close();
        return true;
    }

    private void inserirTabelaAssossiativa(Aluno aluno, Beneficio beneficio, Pagamento pagamento) throws SQLException {
        String sql = "INSERT INTO aluno_beneficio (idAluno, idBeneficio, idPagamento, valorRecebido) "
                + "VALUES(?,?,?,?)";
        double valorPorBeneficio = (pagamento.getDiasLetivos() - aluno.getFaltas()) * beneficio.getValor();
        PreparedStatement pstm = DBConnection.getConnection().prepareStatement(sql);
        pstm.setInt(1, aluno.getId());
        pstm.setInt(2, beneficio.getId());
        pstm.setInt(3, pagamento.getId());
        pstm.setDouble(4, valorPorBeneficio);
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
            id = rs.getInt("MAX(IdPagamento)") +1;
        }
        pstm.close();
        DBConnection.close();
        return id;
    }
}
