/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import connection.DBConnection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
import model.Aluno;
import model.RealizarMatricula;
import model.Turma;

/**
 *
 * @author Acerpc
 */
public class RealizarMatriculaDAO {
    public boolean cadastrar (RealizarMatricula matricula) throws SQLException {
        PreparedStatement pstm;
        String sql = "INSERT INTO aluno_turma (idAluno, idTurma) VALUES (?, ?);";
        pstm = DBConnection.getConnection().prepareStatement(sql);
        pstm.setInt(1, matricula.getAluno().getId());
        pstm.setInt(2, matricula.getTurma().getId());
        System.out.println("Cadastrar Turma - Cadastrando");
        pstm.executeUpdate();
        System.out.println("Cadastrar Turma - Cadastrou");
        DBConnection.close();
        return true;
    }
}
