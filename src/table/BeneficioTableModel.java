/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package table;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Beneficio;

/**
 *
 * @author Acerpc
 */
public class BeneficioTableModel extends AbstractTableModel{
    
    private List<Beneficio> valores;

    public BeneficioTableModel(List<Beneficio> valores) {
        this.valores = valores;
    }

    @Override
    public int getRowCount() {
        return valores.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Beneficio curso = valores.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return curso.getId();
            case 1:
                return curso.getTipo();
            case 2:
                return curso.getValor();
            case 3:
                return curso.getDescricao();
        }
        return null;
    }

    @Override
    public String getColumnName(int column) {
        String coluna = "";
        switch (column) {
            case 0:
                return coluna = "Id";
            case 1:
                return coluna = "Tipo";
            case 2:
                return coluna = "Valor";
            case 3:
                return coluna = "Descrição";
        }
        return null;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return String.class;
            case 1:
                return String.class;
            case 2:
                return String.class;
            case 3:
                return String.class;
        }
        return null;
    }

    public Beneficio get(int row) {
        return valores.get(row);
    }
    
}
