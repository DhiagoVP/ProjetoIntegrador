/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import connection.DBConnection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import model.Pagamento;

/**
 *
 * @author Aluno
 */
public class PagamentoDAO {

    //TODO: Implementar método para inserir um pagamento
    public boolean inserir(Pagamento pagamentoFinal) throws SQLException {
        String sql = "INSERT INTO pagamento ";
        PreparedStatement pstm = DBConnection.getConnection().prepareStatement(sql);
        
        pstm.execute();
        pstm.close();
        DBConnection.close();
        return true;
    }
}
