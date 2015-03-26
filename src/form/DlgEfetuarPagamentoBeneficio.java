/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package form;

import dao.AlunoDAO;
import dao.PagamentoDAO;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import model.Aluno;
import model.Beneficio;
import model.Pagamento;
import model.Turma;
import table.PagamentoTableModel;

/**
 *
 * @author Acerpc
 */
public class DlgEfetuarPagamentoBeneficio extends javax.swing.JDialog {
    private List<Aluno> listaAlunos;
    private PagamentoTableModel pagamentoTable;
    private List<Pagamento> listaPagamento;
    private List<Beneficio> listaBeneficio;
    private Turma turma = new Turma();
    private Pagamento pagamento = new Pagamento();
    private PagamentoTableModel pagamentoModel = new PagamentoTableModel();

    /**
     * Creates new form DlgEfetuarPagamentoBeneficio
     */
    public DlgEfetuarPagamentoBeneficio(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        
        tbPagamentoBeneficio.addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent e) {}

            @Override
            public void keyPressed(KeyEvent e) {}

            @Override
            public void keyReleased(KeyEvent e) {
                if (tbPagamentoBeneficio.getRowCount() > 0) {
                    if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                        int linha = tbPagamentoBeneficio.getSelectedRow();
                        int faltas = Integer.parseInt(tbPagamentoBeneficio.getValueAt(linha, 6).toString());
                        int dias = pagamento.getDiasLetivos() - faltas;
                        tbPagamentoBeneficio.setValueAt(calcularValorBeneficio(dias), linha, 7);
                        tbPagamentoBeneficio.updateUI();
                        calcularTotal();
                    }
                }
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelGerarPagamento = new javax.swing.JPanel();
        labelOrientador = new javax.swing.JLabel();
        labelTurma = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbPagamentoBeneficio = new javax.swing.JTable();
        labelTotalPagar = new javax.swing.JLabel();
        tfTotalAPagar = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        buttonSalva = new javax.swing.JButton();
        btImprimir = new javax.swing.JButton();
        btCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        panelGerarPagamento.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Gerar Pagamento de Benefício", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 18), new java.awt.Color(0, 102, 204))); // NOI18N

        labelOrientador.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        labelOrientador.setText("Orientador");

        labelTurma.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        labelTurma.setText("Turma");

        tbPagamentoBeneficio.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null,  new Boolean(true)},
                {null, null, null, null, null, null, null, null,  new Boolean(true)},
                {null, null, null, null, null, null, null, null,  new Boolean(true)},
                {null, null, null, null, null, null, null, null,  new Boolean(true)}
            },
            new String [] {
                "CPF", "Nome", "Status", "Banco", "Agência", "Conta", "Faltas", "Valor a pagar", "Pagar"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Double.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, true, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbPagamentoBeneficio.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tbPagamentoBeneficio);
        if (tbPagamentoBeneficio.getColumnModel().getColumnCount() > 0) {
            tbPagamentoBeneficio.getColumnModel().getColumn(0).setResizable(false);
            tbPagamentoBeneficio.getColumnModel().getColumn(1).setResizable(false);
            tbPagamentoBeneficio.getColumnModel().getColumn(2).setResizable(false);
            tbPagamentoBeneficio.getColumnModel().getColumn(3).setResizable(false);
            tbPagamentoBeneficio.getColumnModel().getColumn(4).setResizable(false);
            tbPagamentoBeneficio.getColumnModel().getColumn(5).setResizable(false);
        }

        labelTotalPagar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        labelTotalPagar.setText("Total a pagar");
        labelTotalPagar.setToolTipText("");

        tfTotalAPagar.setEditable(false);

        jPanel2.setLayout(new java.awt.GridLayout(1, 0));

        buttonSalva.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        buttonSalva.setText("Salvar");
        buttonSalva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSalvaActionPerformed(evt);
            }
        });
        jPanel2.add(buttonSalva);

        btImprimir.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btImprimir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/MiniImpressora.png"))); // NOI18N
        btImprimir.setText("Imprimir relatório");
        btImprimir.setEnabled(false);
        btImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btImprimirActionPerformed(evt);
            }
        });
        jPanel2.add(btImprimir);

        btCancelar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Cancelar.png"))); // NOI18N
        btCancelar.setText("Cancelar");
        btCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelarActionPerformed(evt);
            }
        });
        jPanel2.add(btCancelar);

        javax.swing.GroupLayout panelGerarPagamentoLayout = new javax.swing.GroupLayout(panelGerarPagamento);
        panelGerarPagamento.setLayout(panelGerarPagamentoLayout);
        panelGerarPagamentoLayout.setHorizontalGroup(
            panelGerarPagamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(panelGerarPagamentoLayout.createSequentialGroup()
                .addGroup(panelGerarPagamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelGerarPagamentoLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(labelOrientador)
                        .addGap(18, 18, 18)
                        .addComponent(labelTurma)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(panelGerarPagamentoLayout.createSequentialGroup()
                        .addComponent(labelTotalPagar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfTotalAPagar, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        panelGerarPagamentoLayout.setVerticalGroup(
            panelGerarPagamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelGerarPagamentoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelGerarPagamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelOrientador)
                    .addComponent(labelTurma))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 422, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelGerarPagamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelGerarPagamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(labelTotalPagar)
                        .addComponent(tfTotalAPagar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelGerarPagamento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelGerarPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 1, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btImprimirActionPerformed
        
    }//GEN-LAST:event_btImprimirActionPerformed

    private void btCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btCancelarActionPerformed

    private void buttonSalvaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSalvaActionPerformed
        for (int linha = 0; linha < listaAlunos.size(); linha++) {
            listaAlunos.get(linha).setFaltas(
                    Integer.parseInt(tbPagamentoBeneficio.getValueAt(linha, 6).toString()));
            listaAlunos.get(linha).setValorRecebido(
                    Double.parseDouble(tbPagamentoBeneficio.getValueAt(linha, 7).toString()));
        }
        Pagamento pagamentoFinal = new Pagamento(listaAlunos,listaBeneficio,
                Double.parseDouble(tfTotalAPagar.getText().replace("RS","")),pagamento.getDiasLetivos());
        btImprimir.setEnabled(true);
        try {
            new PagamentoDAO().inserir(pagamentoFinal);
        } catch (SQLException ex) {
            Logger.getLogger(DlgEfetuarPagamentoBeneficio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_buttonSalvaActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DlgEfetuarPagamentoBeneficio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DlgEfetuarPagamentoBeneficio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DlgEfetuarPagamentoBeneficio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DlgEfetuarPagamentoBeneficio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DlgEfetuarPagamentoBeneficio dialog = new DlgEfetuarPagamentoBeneficio(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    public JTable getTbPagamentoBeneficio() {
        return tbPagamentoBeneficio;
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCancelar;
    private javax.swing.JButton btImprimir;
    private javax.swing.JButton buttonSalva;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelOrientador;
    private javax.swing.JLabel labelTotalPagar;
    private javax.swing.JLabel labelTurma;
    private javax.swing.JPanel panelGerarPagamento;
    private javax.swing.JTable tbPagamentoBeneficio;
    private javax.swing.JTextField tfTotalAPagar;
    // End of variables declaration//GEN-END:variables

    public void carregarLabel(Turma turma) {
        labelTurma.setText("Turma: " + turma.getNome());
        labelOrientador.setText("Orientador: " + turma.getOrientador().getNome());
    }

    public boolean carregarDados(Turma turmaParaPagar, List<Beneficio> beneficios, int diasLetivos) {
        turma = turmaParaPagar;
        listaBeneficio = beneficios;
        pagamento.setDiasLetivos(diasLetivos);
        carregarLabel(turma);
        if(buscarTodosOsAlunos(turma)){
            atualizarTabela();
            calcularTotalPorAluno(diasLetivos);
            calcularTotal();
        }
        else{
            JOptionPane.showMessageDialog(DlgEfetuarPagamentoBeneficio.this, "Nenhum aluno encontrado na turma " + turma.getNome(), 
                    "Erro!", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        return true;
    }

    private void calcularTotalPorAluno(int diasLetivos) {
        for (int linha = 0; linha < listaAlunos.size(); linha++) {
            if ((Boolean)tbPagamentoBeneficio.getValueAt(linha, 8))
                tbPagamentoBeneficio.setValueAt(calcularValorBeneficio(diasLetivos), linha, 7);
        }
    }
    
    private void atualizarTabela() {
       pagamentoTable = new PagamentoTableModel((ArrayList<Aluno>) listaAlunos);
       tbPagamentoBeneficio.setModel(pagamentoTable);
    }

    private boolean buscarTodosOsAlunos(Turma turma) {
        try {
            listaAlunos = new AlunoDAO().buscarPorTurma(turma.getId());
        } catch (SQLException ex) {
            Logger.getLogger(DlgEfetuarPagamentoBeneficio.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (listaAlunos.isEmpty()) 
            return false;
        return true;
    }

    private double calcularValorBeneficio(int diasLetivos) {
        double valorPorAluno = 0;
        for(Beneficio beneficio : listaBeneficio){
            valorPorAluno += (beneficio.getValor() * diasLetivos);
        }
        return valorPorAluno;
    }

    private void calcularTotal() {
        double totalAPagar = 0.0;
        for (int linha = 0; linha < listaAlunos.size(); linha++) {
                totalAPagar += Double.parseDouble(tbPagamentoBeneficio.getValueAt(linha, 7).toString());
        }
        tfTotalAPagar.setText("RS" +totalAPagar);
    }
}
