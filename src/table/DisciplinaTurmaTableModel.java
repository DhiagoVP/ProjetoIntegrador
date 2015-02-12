/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package table;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Disciplina;

/**
 *
 * @author Ana Paula
 */
public class DisciplinaTurmaTableModel extends AbstractTableModel {

    private List<Disciplina> disciplinas;

    private String[] colunas = new String[]{"Nome", "Data de Início", "Data de Término"};

    private static final int NOME = 0;
    private static final int DATAINICIO = 1;
    private static final int DATATERMINO = 2;

    public DisciplinaTurmaTableModel(List<Disciplina> listaDisciplinas) {
        disciplinas = new ArrayList<Disciplina>(listaDisciplinas);
    }

    public DisciplinaTurmaTableModel() {
        disciplinas = new ArrayList<Disciplina>();
    }

    @Override
    public int getRowCount() {
        return disciplinas.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Disciplina disciplina = disciplinas.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return disciplina.getNome();
            case 1:
                return disciplina.getDataDeInicio();
            case 2:
                return disciplina.getDataDeTermino();
        }
        return null;
    }

    @Override
    public String getColumnName(int columnIndex) {
        return colunas[columnIndex];
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex) {
            case NOME:
                return String.class;
            case DATAINICIO:
                return Date.class;
            case DATATERMINO:
                return Date.class;
            default:
                throw new IndexOutOfBoundsException("Índice de coluna não encontrado");
        }
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        Disciplina disciplina = disciplinas.get(rowIndex);
        switch (columnIndex) {
            case NOME:
                disciplina.setNome((String) aValue);
                break;
            case DATAINICIO:
                disciplina.setDataDeInicio((Date) aValue);
                break;
            case DATATERMINO:
                disciplina.setDataDeTermino((Date) aValue);
                break;
            default:
                throw new IndexOutOfBoundsException("Índice de coluna não encontrado");
        }
    }

    public Disciplina getDisciplina(int indiceLinha) {
        return disciplinas.get(indiceLinha);
    }

    public void limpar() {
        disciplinas.clear();
        fireTableDataChanged();
    }

    

}
