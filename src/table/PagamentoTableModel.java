/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package table;

import form.DlgEfetuarPagamentoBeneficio;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Aluno;

/**
 *
 * @author Ana Paula
 */
public class PagamentoTableModel extends AbstractTableModel {
    DlgEfetuarPagamentoBeneficio dlgEfetuarPagamento;
    
    private List<Aluno> alunos;

    private String[] colunas = new String[]{"CPF", "Nome", "Banco", "Agência", "Conta","Status",
        "Faltas", "Valor a Pagar", "Pagar"};

    private static final int CPF = 0;
    private static final int NOME = 1;
    private static final int NOMEBANCO = 2;
    private static final int NUMEROAGENCIA = 3;
    private static final int NUMEROCONTA = 4;
    private static final int STATUS = 5;
    private static final int FALTAS = 6;
    private static final int VALOR_A_PAGAR = 7;
    private static final int PAGAR = 8;

    public PagamentoTableModel(List<Aluno> listaAlunos) {
        alunos = new ArrayList<Aluno>(listaAlunos);
    }

    public PagamentoTableModel() {
        alunos = new ArrayList<Aluno>();
    }

    @Override
    public int getRowCount() {
        return alunos.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Aluno aluno = alunos.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return aluno.getCpf();
            case 1:
                return aluno.getNome();
            case 2:
                return aluno.getContaBancaria().getNomeBanco();
            case 3:
                return aluno.getContaBancaria().getAgencia();
            case 4:
                return aluno.getContaBancaria().getNumeroConta();
            case 5:
                return aluno.getSituacao();
            case 6:
                return aluno.getFaltas();
            case 7:
                return aluno.getValorRecebido();
            case 8:
                return aluno.isRecece();
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
            case CPF:
                return String.class;
            case NOME:
                return String.class;
            case NOMEBANCO:
                return String.class;
            case NUMEROAGENCIA:
                return Integer.class;
            case NUMEROCONTA:
                return Integer.class;
            case STATUS:
                return String.class;
            case FALTAS:
                return Integer.class;
            case VALOR_A_PAGAR:
                return Double.class;
            case PAGAR:
                return Boolean.class;
            default:
                throw new IndexOutOfBoundsException("Índice de coluna não encontrado");
        }
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        Aluno aluno = alunos.get(rowIndex);
        switch (columnIndex) {
            case CPF:
                aluno.setCpf((String) aValue);
                break;
            case NOME:
                aluno.setNome((String) aValue);
                break;
             case NOMEBANCO:
                aluno.getContaBancaria().setNomeBanco((String)aValue);
                break;
            case NUMEROAGENCIA:
                 aluno.getContaBancaria().setAgencia((Integer)aValue);
                break;
            case NUMEROCONTA:
                 aluno.getContaBancaria().setNumeroConta((Integer)aValue);
                break;  
            case STATUS:
                aluno.setSituacao((String) aValue);
                break;
            case FALTAS:
                aluno.setFaltas((Integer) aValue);
                break;
            case VALOR_A_PAGAR:
                aluno.setValorRecebido((Double) aValue);
                break;
            case PAGAR:
                aluno.setRecece((Boolean) aValue);
                break;
            default:
                throw new IndexOutOfBoundsException("Índice de coluna não encontrado");
        }
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 6:
                return true;
            case 7:
                return true;
            case 8:
                return true;
            default:
                throw new IndexOutOfBoundsException("Índice de coluna não encontrado");
        }
    }

    public Aluno getAluno(int indiceLinha) {
        return alunos.get(indiceLinha);
    }

    public void limpar() {
        alunos.clear();
        fireTableDataChanged();
    }
}
