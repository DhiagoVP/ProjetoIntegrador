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

/**
 *
 * @author Ana Paula
 */
public class DiasAulaDAO {
    
    public void inserir(List<String> listaDiasDeAula, int idTurma) throws SQLException {
        String sqlDisciplina = "INSERT INTO turma_diasaula (diaAula, idTurma)"
                + "VALUES (?,?)";
        PreparedStatement pstm = DBConnection.getConnection().prepareStatement(sqlDisciplina);
        for (String dias : listaDiasDeAula) {
            pstm.setString(1, dias);
            pstm.setInt(2, idTurma);
            pstm.execute();
        }
    }
    
    public void alterar(List<String> listaDiasDeAula, int idTurma) throws SQLException{
        String sql = "DELETE FROM turma_diasaula where idTurma = ?";
        PreparedStatement ps = DBConnection.getConnection().prepareStatement(sql);
        ps.setInt(1, idTurma);
        ps.close();
        DBConnection.close();
        inserir(listaDiasDeAula, idTurma);
    }
    
    public List<String> listarTodasAsAulas(int idTurma) throws SQLException{
        String sql = "SELECT diaAula FROM turma_diasaula where idTurma = ?";
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
}
