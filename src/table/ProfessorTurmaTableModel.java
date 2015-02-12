/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package table;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Professor;

/**
 *
 * @author Ana Paula
 */
public class ProfessorTurmaTableModel extends AbstractTableModel{
    private List<Professor> professores;

    private String[] colunas = new String[]{"Professor"};

    private static final int NOMEPROFESSOR = 0;

    public ProfessorTurmaTableModel(List<Professor> listaProfessores) {
        professores = new ArrayList<Professor>(listaProfessores);
    }

    public ProfessorTurmaTableModel() {
        professores = new ArrayList<Professor>();
    }
    @Override
    public int getRowCount() {
        return professores.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
       Professor professor = professores.get(rowIndex);
       return professor.getNome();
    }
    
    @Override
    public String getColumnName(int columnIndex) {
        return colunas[columnIndex];
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex) {
            case NOMEPROFESSOR:
                return String.class;
            default:
                throw new IndexOutOfBoundsException("Índice de coluna não encontrado");
        }
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        Professor professor = professores.get(rowIndex);
        switch (columnIndex) {
            case NOMEPROFESSOR:
                professor.setNome((String) aValue);
                break;
            default:
                throw new IndexOutOfBoundsException("Índice de coluna não encontrado");
        }
    }

    public Professor getProfessor(int indiceLinha) {
        return professores.get(indiceLinha);
    }

    public void limpar() {
        professores.clear();
        fireTableDataChanged();
    }
    
}
