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
import model.Pagamento;
import model.Turma;
import model.Usuario;

/**
 *
 * @author Ana Paula
 */
public class ConsultaPagamentoTableModel extends AbstractTableModel {
    private List<Pagamento> pagamentos;

    private String[] colunas = new String[]{"Turma", "Valor Pago (RS)","Mês", "Data", "Usuário"};

    private static final int TURMA = 0;
    private static final int VALOR_PAGO = 1;
    private static final int MES = 2;
    private static final int USUARIO = 3;
    private static final int DATA = 4;

    public ConsultaPagamentoTableModel(List<Pagamento> listaPagamentos) {
        pagamentos = new ArrayList<Pagamento>(listaPagamentos);
    }

    public ConsultaPagamentoTableModel() {
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
                return pagamento.getTurma();
            case 1:
                return pagamento.getValorAPagarPorTurma();
            case 2:
                return pagamento.getMes();
            case 3:
                return pagamento.getData();
            case 4:
                return pagamento.getUsuario().getUsuario();
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
                return Turma.class;
            case VALOR_PAGO:
                return Double.class;
            case MES:
                return String.class;
            case DATA:
                return String.class;
            case USUARIO:
                return Usuario.class;
            default:
                throw new IndexOutOfBoundsException("Índice de coluna não encontrado");
        }
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        Pagamento pagamento = pagamentos.get(rowIndex);
        switch (columnIndex) {
            case TURMA:
                pagamento.getTurma().setNome((String) aValue);
                break;
            case VALOR_PAGO:
                pagamento.setValorAPagarPorTurma((Double) aValue);
                break;
            case MES:
                pagamento.setMes((String) aValue);
                break;
             case DATA:
                pagamento.setData((Date)aValue);
                break;
            case USUARIO:
                 pagamento.getUsuario().setUsuario((String)aValue);
                break;
            default:
                throw new IndexOutOfBoundsException("Índice de coluna não encontrado");
        }
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    public Pagamento getPagamento(int indiceLinha) {
        return pagamentos.get(indiceLinha);
    }

    public void limpar() {
        pagamentos.clear();
        fireTableDataChanged();
    }
}
