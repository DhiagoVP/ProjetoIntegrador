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

    private String[] colunas = new String[]{ "Turma", "Curso", "Orientador", "Supervisor", "Cidade Demandante", "Campus Ofertante", "Turno"};

    private static final int TURMA = 0;
    private static final int CURSO = 1;
    private static final int ORIENTADOR = 2;
    private static final int SUPERVISOR = 3;
    private static final int CIADADEDEMANDANTE = 4;
    private static final int CAMPUSOFERTANTE = 5;
    private static final int TURNO = 6;

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
                return turma.getCurso().getNome();
            case 2:
                return turma.getOrientador().getNome();
            case 3:
                return turma.getSupervisor().getNome();
            case 4:
                return turma.getCidadeDemandande();
            case 5:
                return turma.getCampusOfertante();
            case 6:
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
            case TURMA:
                return String.class;
            case CURSO:
                return String.class;
            case ORIENTADOR:
                return String.class;
            case SUPERVISOR:
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
            case TURMA:
                turma.setNome((String) aValue);
                break;
            case CURSO:
                turma.getCurso().setNome((String) aValue);
                break;
            case ORIENTADOR:
                turma.getOrientador().setNome((String) aValue);
                break;
            case SUPERVISOR:
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
