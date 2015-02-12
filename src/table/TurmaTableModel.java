/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package table;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Turma;

/**
 *
 * @author Ana Paula
 */
public class TurmaTableModel extends AbstractTableModel {

    private List<Turma> turmas;

    private String[] colunas = new String[]{ "Nome", "Orientador", "Supervisor", "Cidade Demandante", "Campus Ofertante", "Turno"};

    private static final int NOME = 0;
    private static final int ORIENTADOR = 1;
    private static final int SUOERVISOR = 2;
    private static final int CIADADEDEMANDANTE = 3;
    private static final int CAMPUSOFERTANTE = 4;
    private static final int TURNO = 5;

    public TurmaTableModel(List<Turma> listaTurmas) {
        turmas = new ArrayList<Turma>(listaTurmas);
    }

    public TurmaTableModel() {
        turmas = new ArrayList<Turma>();
    }

    @Override
    public int getRowCount() {
        return turmas.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Turma turma = turmas.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return turma.getNome();
            case 1:
                return turma.getOrientador().getNome();
            case 2:
                return turma.getSupervisor().getNome();
            case 3:
                return turma.getCidadeDemandande();
            case 4:
                return turma.getCampusOfertante();
            case 5:
                return turma.getTurno();
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
            case ORIENTADOR:
                return String.class;
            case SUOERVISOR:
                return String.class;
            case CIADADEDEMANDANTE:
                return String.class;
            case CAMPUSOFERTANTE:
                return String.class;
            case TURNO:
                return String.class;
            default:
                throw new IndexOutOfBoundsException("Índice de coluna não encontrado");
        }
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        Turma turma = turmas.get(rowIndex);
        switch (columnIndex) {
            case NOME:
                turma.setNome((String) aValue);
                break;
            case ORIENTADOR:
                turma.getOrientador().setNome((String) aValue);
                break;
            case SUOERVISOR:
                turma.getSupervisor().setNome((String) aValue);
                break;
            case CIADADEDEMANDANTE:
                turma.setCidadeDemandande((String) aValue);
                break;
            case CAMPUSOFERTANTE:
                turma.setCampusOfertante((String) aValue);
                break;
            case TURNO:
                turma.setTurno((String) aValue);
                break;
            default:
                throw new IndexOutOfBoundsException("Índice de coluna não encontrado");
        }
    }

    public Turma getTurma(int indiceLinha) {
        return turmas.get(indiceLinha);
    }

    public void limpar() {
        turmas.clear();
        fireTableDataChanged();
    }
}
