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
import java.sql.SQLException;import java.util.ArrayList;
;
import java.util.List;
import model.Disciplina;

/**
 *
 * @author Ana Paula
 */
public class DisciplinaDAO {
    
    public void inserir(List<Disciplina> listaDisciplinas,  int idTurma) throws SQLException {
        if(listaDisciplinas.isEmpty())
            return;
        for (Disciplina disciplina : listaDisciplinas) {
            String sqlDisciplina = "INSERT INTO disciplina (nomeDisciplina, dataInicioDisciplina, dataTerminoDisciplina)"
                    + "VALUES (?,?,?)";
            PreparedStatement pstm = DBConnection.getConnection().prepareStatement(sqlDisciplina);
            pstm.setString(1, disciplina.getNome());
            pstm.setDate(2, new Date(disciplina.getDataDeInicio().getTime()));
            pstm.setDate(3, new Date(disciplina.getDataDeTermino().getTime()));
            pstm.execute();
            int id = -1;
            String sqlPesquisa = "SELECT MAX(idDisciplina) FROM Disciplina;";
            pstm = DBConnection.getConnection().prepareStatement(sqlPesquisa);
            ResultSet rs = pstm.executeQuery();
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
    
    public void remover(List<Disciplina> listaDisciplinas,  int idTurma) throws SQLException{
        if(listaDisciplinas.isEmpty())
            return;
        String sql = "DELETE FROM turma_disciplina where idTurma = ?";
        PreparedStatement ps = DBConnection.getConnection().prepareStatement(sql);
        ps.setInt(1, idTurma);
        ps.close();
        DBConnection.close();
    }
    public List<Disciplina> listarDisciplinas(int idTurma) throws SQLException{
        String sql = "SELECT * FROM disciplina d, turma_disciplina td where d.idDisciplina = td.disciplina_idDisciplina"
                + " AND td.turma_idTurma = ? ORDER BY nomeDisciplina";
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
}
