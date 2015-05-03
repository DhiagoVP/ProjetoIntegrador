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
import model.Login;

/**
 *
 * @author Acerpc
 */
public class LoginDAO {

    public int cadastrar(Login login) throws SQLException {
        PreparedStatement pstm;
        String sql = "INSERT INTO login (usuario, senha, nivel, ativo) VALUES (?, ?, ?, ?);";
        pstm = DBConnection.getConnection().prepareStatement(sql);
        pstm.setString(1, login.getUsuario());
        pstm.setString(2, login.getSenha());
        pstm.setInt(3, login.getNivel());
        pstm.setInt(4, 0);
        pstm.execute();
        pstm.close();
        return getMaxId();
    }

    public void atualizar(Login login) throws SQLException {
        PreparedStatement pstm;
        String sql = "UPDATE login l SET l.usuario = ?, l.senha = ?, l.nivel = ? WHERE l.id = ?;";
        pstm = DBConnection.getConnection().prepareStatement(sql);
        pstm.setString(1, login.getUsuario());
        pstm.setString(2, login.getSenha());
        pstm.setInt(3, login.getNivel());
        pstm.setInt(4, login.getId());
        pstm.execute();
        pstm.close();
    }
    
    public void setAtivo(int id) throws SQLException {
        PreparedStatement pstm;
        String sql = "UPDATE login l SET ativo = 1 WHERE l.id = ?;";
        pstm = DBConnection.getConnection().prepareStatement(sql);
        pstm.setInt(1, id);
        pstm.execute();
        pstm.close();
    }
    
    public void setDesativado() throws SQLException {
        PreparedStatement pstm;
        String sql = "UPDATE login l SET ativo = 0;";
        pstm = DBConnection.getConnection().prepareStatement(sql);
        pstm.execute();
        pstm.close();
    }
    
    public boolean remover(int id) throws SQLException {
        PreparedStatement pstm;
        String sql = "DELETE FROM login WHERE id = ?";
        pstm = DBConnection.getConnection().prepareStatement(sql);
        pstm.setInt(1, id);
        pstm.execute();
        pstm.close();
        return true;
    }

    public Login pesquisarPorId(int id) throws SQLException {
        PreparedStatement pstm;
        String sql = "SELECT * FROM login l WHERE l.id = " + id + ";";
        pstm = DBConnection.getConnection().prepareStatement(sql);
        ResultSet rs = pstm.executeQuery();
        Login login = null;
        if (rs.first()) {
            login = new Login(
                    rs.getInt("id"),
                    rs.getInt("nivel"),
                    rs.getString("usuario"),
                    rs.getString("senha"));
        }
        return login;
    }

    public Login pesquisarPorNome(String usuario) throws SQLException {
        PreparedStatement pstm;
        String sql = "SELECT * FROM login WHERE usuario = '" + usuario +"';";
        pstm = DBConnection.getConnection().prepareStatement(sql);
        //pstm.setString(1, usuario);
        ResultSet rs = pstm.executeQuery();
        Login login = null;
        if (rs.first()) {
            login = new Login(
                    rs.getInt("id"),
                    rs.getInt("nivel"),
                    rs.getString("usuario"),
                    rs.getString("senha"));
        }
        return login;
    }
    
    public Login pesquisarPorNivel(int nivel) throws SQLException {
        PreparedStatement pstm;
        String sql = "SELECT * FROM login l WHERE l.nivel = " + nivel + ";";
        pstm = DBConnection.getConnection().prepareStatement(sql);
        ResultSet rs = pstm.executeQuery();
        Login login = null;
        if (rs.first()) {
            login = new Login(
                    rs.getInt("id"),
                    rs.getInt("nivel"),
                    rs.getString("usuario"),
                    rs.getString("senha"));
        }
        return login;
    }

    public List<Login> recuperarTodos() throws SQLException {
        PreparedStatement pstm;
        String sql = "SELECT * FROM login l ORDER BY l.usuario;";
        List<Login> lista = new ArrayList<>();
        pstm = DBConnection.getConnection().prepareStatement(sql);
        ResultSet rs = pstm.executeQuery();
        Login login;
        while (rs.next()) {
            login = new Login(
                    rs.getInt("id"),
                    rs.getInt("nivel"),
                    rs.getString("usuario"),
                    rs.getString("senha"));
            lista.add(login);
        }
        pstm.close();
        return lista;
    }
    
    public Login pesquisarAtivo() throws SQLException {
        PreparedStatement pstm;
        String sql = "SELECT * FROM login l WHERE ativo = 1";
        pstm = DBConnection.getConnection().prepareStatement(sql);
        ResultSet rs = pstm.executeQuery();
        Login login = null;
        if (rs.first()) {
            login = new Login(
                    rs.getInt("id"),
                    rs.getInt("nivel"),
                    rs.getString("usuario"),
                    rs.getString("senha"));
        }
        return login;
    }

    private int getMaxId() throws SQLException {
        int id = -1;
        String sqlPesquisa = "SELECT MAX(idTurma) FROM Turma;";
        PreparedStatement pstm = DBConnection.getConnection().prepareStatement(sqlPesquisa);
         ResultSet rs = pstm.executeQuery();
        if (rs.next()) {
            id = rs.getInt("MAX(idTurma)");
        }
        return id;
    }
    
}
