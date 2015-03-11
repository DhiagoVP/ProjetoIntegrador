/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package table;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Pagamento;

/**
 *
 * @author Ana Paula
 */
public class PagamentoTableModel extends AbstractTableModel {

    private List<Pagamento> pagamentos;

    private String[] colunas = new String[]{ "CPF", "Nome", "Status", "Faltas", "Valor a Pagar", "Pagar"};

    private static final int CPF = 0;
    private static final int NOME = 1;
    private static final int STATUS = 2;
    private static final int FALTAS = 3;
    private static final int VALOR_A_PAGAR = 4;
    private static final int PAGAR = 5;

    public PagamentoTableModel(List<Pagamento> listaPagamento) {
        pagamentos = new ArrayList<Pagamento>(listaPagamento);
    }

    public PagamentoTableModel() {
        pagamentos = new ArrayList<Pagamento>();
    }

    @Override
    public int getRowCount() {
        return pagamentos.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Pagamento pagamento = pagamentos.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return pagamento.getAluno().getCpf();
            case 1:
                return pagamento.getAluno().getNome();
            case 2:
                return pagamento.getAluno().getSituacao();
            case 3:
                return pagamento.getAluno().getFaltas();
            case 4:
                return pagamento.getValorAPagar();
            case 5:
                return pagamento.isPagar();
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
        Pagamento pagamento = pagamentos.get(rowIndex);
        switch (columnIndex) {
            case CPF:
                pagamento.getAluno().setCpf((String) aValue);
                break;
            case NOME:
                pagamento.getAluno().setNome((String) aValue);
                break;
            case STATUS:
                pagamento.getAluno().setSituacao((String) aValue);
                break;
            case FALTAS:
                pagamento.getAluno().setFaltas((Integer) aValue);
                break;
            case VALOR_A_PAGAR:
                pagamento.setValorAPagar((Double) aValue);
                break;
            case PAGAR:
                pagamento.setPagar((Boolean) true);
                break;
            default:
                throw new IndexOutOfBoundsException("Índice de coluna não encontrado");
        }
    }

    @Override  
    public boolean isCellEditable(int rowIndex, int columnIndex) {  
        switch (columnIndex) {
            case 3:
                return true;
            case 5:
                return true;
            default:
                throw new IndexOutOfBoundsException("Índice de coluna não encontrado");
        }
    }  
    
    public Pagamento getPagamento(int indiceLinha) {
        return pagamentos.get(indiceLinha);
    }

    public void limpar() {
        pagamentos.clear();
        fireTableDataChanged();
    }
    
}
