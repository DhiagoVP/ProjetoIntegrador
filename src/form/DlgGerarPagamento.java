/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package form;

import dao.BeneficioDAO;
import dao.CursoDAO;
import dao.TurmaDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import model.Beneficio;
import model.Curso;
import model.Turma;

/**
 *
 * @author Acerpc
 */
public class DlgGerarPagamento extends javax.swing.JDialog {

    /**
     * Creates new form DlgEfetuarPagamento
     */
    List<Beneficio> listaBeneficio = null;
    List<String> listaBeneficiosParaPagar = null;
    DefaultListModel modeloListaBeneficio = new DefaultListModel();

    public DlgGerarPagamento(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        carregarComboBoxTurma();
        carregarListaBeneficios();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelPagamento = new javax.swing.JPanel();
        labelTurma = new javax.swing.JLabel();
        cbTurma = new javax.swing.JComboBox();
        btPagar = new javax.swing.JButton();
        btCancelar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        listBeneficiosCadastrados = new javax.swing.JList();
        jScrollPane2 = new javax.swing.JScrollPane();
        listBeneficiosParaPagar = new javax.swing.JList();
        btAdicionarBeneficioAPagar = new javax.swing.JButton();
        btRemoverBeneficioAPagar = new javax.swing.JButton();
        labelMes = new javax.swing.JLabel();
        labelDiasLetivos = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jSpinner1 = new javax.swing.JSpinner();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Efetuar Pagamento");
        setResizable(false);

        panelPagamento.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Gerar Pagamento", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 18), new java.awt.Color(0, 153, 204))); // NOI18N

        labelTurma.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        labelTurma.setText("Turma");

        cbTurma.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        btPagar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btPagar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/MiniPagamento.png"))); // NOI18N
        btPagar.setText("Pagar");
        btPagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btPagarActionPerformed(evt);
            }
        });

        btCancelar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Cancelar.png"))); // NOI18N
        btCancelar.setText("Cancelar");
        btCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelarActionPerformed(evt);
            }
        });

        listBeneficiosCadastrados.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jScrollPane1.setViewportView(listBeneficiosCadastrados);

        listBeneficiosParaPagar.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jScrollPane2.setViewportView(listBeneficiosParaPagar);

        btAdicionarBeneficioAPagar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btAdicionarBeneficioAPagar.setText(">>");
        btAdicionarBeneficioAPagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAdicionarBeneficioAPagarActionPerformed(evt);
            }
        });

        btRemoverBeneficioAPagar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btRemoverBeneficioAPagar.setText("<<");
        btRemoverBeneficioAPagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btRemoverBeneficioAPagarActionPerformed(evt);
            }
        });

        labelMes.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        labelMes.setText("Mês");

        labelDiasLetivos.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        labelDiasLetivos.setText("Dias letivos/mês");

        jComboBox1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro" }));

        jSpinner1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        javax.swing.GroupLayout panelPagamentoLayout = new javax.swing.GroupLayout(panelPagamento);
        panelPagamento.setLayout(panelPagamentoLayout);
        panelPagamentoLayout.setHorizontalGroup(
            panelPagamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPagamentoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelPagamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelPagamentoLayout.createSequentialGroup()
                        .addComponent(btPagar, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btCancelar))
                    .addGroup(panelPagamentoLayout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelPagamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btAdicionarBeneficioAPagar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btRemoverBeneficioAPagar, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelPagamentoLayout.createSequentialGroup()
                        .addGroup(panelPagamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(labelTurma)
                            .addComponent(labelMes))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelPagamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cbTurma, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(panelPagamentoLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(14, 14, 14)
                                .addComponent(labelDiasLetivos)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(17, Short.MAX_VALUE))
        );
        panelPagamentoLayout.setVerticalGroup(
            panelPagamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPagamentoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelPagamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelTurma)
                    .addComponent(cbTurma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelPagamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelMes)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelDiasLetivos)
                    .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(panelPagamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelPagamentoLayout.createSequentialGroup()
                        .addGap(18, 23, Short.MAX_VALUE)
                        .addGroup(panelPagamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panelPagamentoLayout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addComponent(btAdicionarBeneficioAPagar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btRemoverBeneficioAPagar)
                        .addGap(22, 22, 22)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addGroup(panelPagamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btCancelar)
                    .addComponent(btPagar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btRemoverBeneficioAPagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btRemoverBeneficioAPagarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btRemoverBeneficioAPagarActionPerformed

    private void btAdicionarBeneficioAPagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAdicionarBeneficioAPagarActionPerformed
        adicionarListaParaPagar(listBeneficiosCadastrados.getSelectedValue());
    }//GEN-LAST:event_btAdicionarBeneficioAPagarActionPerformed

    private void btCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btCancelarActionPerformed

    private void btPagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPagarActionPerformed
        DlgEfetuarPagamentoBeneficio beneficio = new DlgEfetuarPagamentoBeneficio(null, rootPaneCheckingEnabled);
        beneficio.carregarLabel(cbTurma.getSelectedItem().toString());
        beneficio.setVisible(true);
    }//GEN-LAST:event_btPagarActionPerformed

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
            java.util.logging.Logger.getLogger(DlgGerarPagamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DlgGerarPagamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DlgGerarPagamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DlgGerarPagamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DlgGerarPagamento dialog = new DlgGerarPagamento(new javax.swing.JFrame(), true);
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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAdicionarBeneficioAPagar;
    private javax.swing.JButton btCancelar;
    private javax.swing.JButton btPagar;
    private javax.swing.JButton btRemoverBeneficioAPagar;
    private javax.swing.JComboBox cbTurma;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JLabel labelDiasLetivos;
    private javax.swing.JLabel labelMes;
    private javax.swing.JLabel labelTurma;
    private javax.swing.JList listBeneficiosCadastrados;
    private javax.swing.JList listBeneficiosParaPagar;
    private javax.swing.JPanel panelPagamento;
    // End of variables declaration//GEN-END:variables

    private void carregarComboBoxTurma() {
        List<Turma> litaTurma = new ArrayList();
        try {
            litaTurma = new TurmaDAO().listarTodos();
            for (Turma turma : litaTurma) {
                cbTurma.addItem(turma);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DlgGerarPagamento.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void carregarListaBeneficios() {
        try {
            listaBeneficio = new BeneficioDAO().recuperarTodos();
            listBeneficiosCadastrados.setModel(atualizarList(listaBeneficio));
        } catch (SQLException ex) {
            Logger.getLogger(DlgGerarPagamento.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private DefaultListModel atualizarList(List<Beneficio> listaBeneficio) {
        DefaultListModel modelo = new DefaultListModel();
        if (!listaBeneficio.isEmpty()) {
            for (Beneficio beneficio : listaBeneficio) {
                modelo.addElement(beneficio.getTipo());
            }
        }
        return modelo;
    }

    private void adicionarListaParaPagar(Object beneficio) {

        modeloListaBeneficio.addElement(beneficio.toString());
        listBeneficiosParaPagar.setModel(modeloListaBeneficio);
        removerBeneficioCadastrado();
    }

    private void removerBeneficioCadastrado() {
        listaBeneficio.remove(listBeneficiosCadastrados.getSelectedIndex());
        listBeneficiosCadastrados.setModel(atualizarList(listaBeneficio));
    }
}