/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package table;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Login;

/**
 *
 * @author Acerpc
 */
public class LoginTableModel extends AbstractTableModel{
    List <Login> login;

    public LoginTableModel(List<Login> login) {
        this.login = login;
    }
    
    @Override
    public int getRowCount() {
        return login.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Login log = login.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return log.getUsuario();
            case 1:
                return log.getNivel();
        }
        return null;
    }

    @Override
    public String getColumnName(int column) {
        String coluna = "";
        switch (column) {
            case 0:
                return coluna = "Usuário";
            case 1:
                return coluna = "Nível";
        }
        return null;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return String.class;
            case 1:
                return Integer.class;
        }
        return null;
    }

    public List<Login> getLogin() {
        return login;
    }

    public void setLogin(List<Login> login) {
        this.login = login;
    }
    
}
