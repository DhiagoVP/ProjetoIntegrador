/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import connection.DBConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Beneficio;

/**
 *
 * @author Acerpc
 */
public class BeneficioDAO {

    public boolean cadastrar(Beneficio beneficio) throws SQLException {
        PreparedStatement pstm;
        String sql = "INSERT INTO Beneficio (tipo, valor, descricao) VALUES (?, ?, ?)";
        pstm = DBConnection.getConnection().prepareStatement(sql);
        System.out.println("Cadastro - Conectou");
        pstm.setString(1, beneficio.getTipo());
        pstm.setDouble(2, beneficio.getValor());
        pstm.setString(3, beneficio.getDescricao());
        pstm.execute();
        System.out.println("Cadastro - Salvo");
        pstm.close();
        DBConnection.close();
        System.out.println("Cadastro - Conexão fechada");
        return true;
    }

    public void atualizar(Beneficio beneficio) throws SQLException {
        PreparedStatement pstm;
        String sql = "UPDATE Beneficio b SET b.tipo = ?, b.valor = ?, b.descricao = ? WHERE b.id = ?";
        pstm = DBConnection.getConnection().prepareStatement(sql);
        System.out.println("Atualizar - Conectou");
        pstm.setString(1, beneficio.getTipo());
        pstm.setDouble(2, beneficio.getValor());
        pstm.setString(3, beneficio.getDescricao());
        pstm.setInt(4, beneficio.getId());
        System.out.println("Atualizar - sets");
        pstm.executeUpdate();
        System.out.println("Atualizar - Salvou");
        pstm.close();
        DBConnection.close();
        System.out.println("Atulizar - Conexão fechada");
    }

    public List<Beneficio> recuperarTodos() throws SQLException {
        System.out.println("RecuperarTodos - Iniciando");
        String sql = "SELECT * FROM beneficio ORDER BY tipo;";
        List<Beneficio> listaBeneficio = new ArrayList<>();
        PreparedStatement pstm;
        pstm = DBConnection.getConnection().prepareStatement(sql);
        ResultSet rs = pstm.executeQuery();
        System.out.println("RecuperarTodos - Iniciando WHILE");
        while (rs.next()) {
            Beneficio beneficio = new Beneficio(
                    rs.getInt("id"),
                    rs.getString("tipo"),
                    rs.getDouble("valor"),
                    rs.getString("descricao")
            );
            listaBeneficio.add(beneficio);
        }
        System.out.println("RecuperarTodos - WHILE terminou");
        pstm.close();
        DBConnection.close();
        System.out.println("RecuperarTodos - Concluído");
        return listaBeneficio;
    }

    public void remover(Beneficio beneficio) throws SQLException {
        System.out.println("Remover - Iniciando");
        PreparedStatement pstm;
        String sql = "DELETE FROM Beneficio WHERE id = ?;";
        pstm = DBConnection.getConnection().prepareStatement(sql);
        System.out.println("Remover - Conectou");
        pstm.setInt(1, beneficio.getId());
        pstm.executeUpdate();
        System.out.println("Remover - Deletou");
        pstm.close();
        DBConnection.close();
        System.out.println("Remover - Concluído");
    }

    public Beneficio recuperarById(int id) throws SQLException {
        System.out.println("RecuperarById - Iniciando");
        PreparedStatement pstm;
        String sql = "SELECT * FROM Beneficio WHERE id = ?";
        pstm = DBConnection.getConnection().prepareStatement(sql);
        pstm.setInt(1, id);
        pstm.execute();
        ResultSet rs = pstm.getResultSet();
        if (rs.first()) {
            Beneficio beneficio = new Beneficio(
                    rs.getInt("id"),
                    rs.getString("tipo"),
                    rs.getDouble("valor"),
                    rs.getString("descricao"));
            System.out.println("RecuperarById - Recuperando");
            return beneficio;
        } else {
            return null;
        }

    }

    public Beneficio recuperarPorNome(String nomeBeneficio) throws SQLException {
        System.out.println("RecuperarPorNome - Iniciando");
        PreparedStatement pstm;
        String sql = "SELECT * FROM Beneficio WHERE tipo = ?";
        pstm = DBConnection.getConnection().prepareStatement(sql);
        pstm.setString(1, nomeBeneficio);
        pstm.execute();
        ResultSet rs = pstm.getResultSet();
        if (rs.first()) {
            Beneficio beneficio = new Beneficio(
                    rs.getInt("id"),
                    rs.getString("tipo"),
                    rs.getDouble("valor"),
                    rs.getString("descricao"));
            System.out.println("RecuperarById - Recuperando");
            return beneficio;
        }
        return null;
    }
}
