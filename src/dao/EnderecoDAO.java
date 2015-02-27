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
import model.Endereco;

/**
 *
 * @author Ana Paula
 */
public class EnderecoDAO {
    public int inserir(Endereco endereco) throws SQLException {
        PreparedStatement pstm;
        String sqlEndereco = "INSERT INTO endereco (rua, numero, bairro, estado, cidade)"
                + " VALUES (?, ?, ?, ?, ?);";
        pstm = DBConnection.getConnection().prepareStatement(sqlEndereco);
        pstm.setString(1, endereco.getRua());
        pstm.setInt(2, endereco.getNumero());
        pstm.setString(3, endereco.getBairro());
        pstm.setString(4, endereco.getEstado());
        pstm.setString(5, endereco.getCidade());
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
    
    public boolean atualizar(Endereco endereco) throws SQLException{
        String sql = "UPDATE endereco SET rua = ?, numero = ?, bairro = ?, cidade = ?, estado =? WHERE idEndereco = ?"; 
        PreparedStatement pstm = DBConnection.getConnection().prepareStatement(sql);
        pstm.setString(1, endereco.getRua());
        pstm.setInt(2, endereco.getNumero());
        pstm.setString(3, endereco.getBairro());
        pstm.setString(4, endereco.getCidade());
        pstm.setString(5, endereco.getEstado());
        pstm.setInt(6, endereco.getId());
        pstm.execute();
        pstm.close();
        DBConnection.close();
        return true;
    }
}
