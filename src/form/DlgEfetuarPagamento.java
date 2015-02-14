/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package form;

import dao.CursoDAO;
import dao.TurmaDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Curso;
import model.Turma;

/**
 *
 * @author Acerpc
 */
public class DlgEfetuarPagamento extends javax.swing.JDialog {

    /**
     * Creates new form DlgEfetuarPagamento
     */
    public DlgEfetuarPagamento(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        carregarComboBoxCurso();
        carregarComboBoxTurma();
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
        labelCurso = new javax.swing.JLabel();
        labelTurma = new javax.swing.JLabel();
        cbCurso = new javax.swing.JComboBox();
        cbTurma = new javax.swing.JComboBox();
        btAddCurso = new javax.swing.JButton();
        btAddTurma = new javax.swing.JButton();
        btPagar = new javax.swing.JButton();
        btCancelar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        listBeneficiosCadastrados = new javax.swing.JList();
        jScrollPane2 = new javax.swing.JScrollPane();
        listBeneficiosParaPagar = new javax.swing.JList();
        btAdicionarBeneficioAPagar = new javax.swing.JButton();
        btRemoverBeneficioAPagar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Efetuar Pagamento");
        setResizable(false);

        panelPagamento.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Efetuar Pagamento", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 18), new java.awt.Color(0, 153, 204))); // NOI18N

        labelCurso.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        labelCurso.setText("Curso");

        labelTurma.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        labelTurma.setText("Turma");

        cbCurso.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cbCurso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbCursoActionPerformed(evt);
            }
        });

        cbTurma.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        btAddCurso.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/MiniCurso.png"))); // NOI18N
        btAddCurso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAddCursoActionPerformed(evt);
            }
        });

        btAddTurma.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/MiniTurma.png"))); // NOI18N
        btAddTurma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAddTurmaActionPerformed(evt);
            }
        });

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

        javax.swing.GroupLayout panelPagamentoLayout = new javax.swing.GroupLayout(panelPagamento);
        panelPagamento.setLayout(panelPagamentoLayout);
        panelPagamentoLayout.setHorizontalGroup(
            panelPagamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelPagamentoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelPagamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btAdicionarBeneficioAPagar, javax.swing.GroupLayout.DEFAULT_SIZE, 61, Short.MAX_VALUE)
                    .addComponent(btRemoverBeneficioAPagar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelPagamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btPagar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelPagamentoLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(panelPagamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panelPagamentoLayout.createSequentialGroup()
                        .addComponent(labelCurso)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbCurso, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(panelPagamentoLayout.createSequentialGroup()
                        .addComponent(labelTurma)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbTurma, 0, 389, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelPagamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btAddCurso)
                    .addComponent(btAddTurma)))
        );
        panelPagamentoLayout.setVerticalGroup(
            panelPagamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPagamentoLayout.createSequentialGroup()
                .addGroup(panelPagamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelPagamentoLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panelPagamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelCurso)
                            .addComponent(cbCurso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(btAddCurso))
                .addGap(0, 0, 0)
                .addGroup(panelPagamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelPagamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(labelTurma)
                        .addComponent(cbTurma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btAddTurma))
                .addGroup(panelPagamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelPagamentoLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelPagamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(panelPagamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelPagamentoLayout.createSequentialGroup()
                                    .addComponent(btPagar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(btCancelar)))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelPagamentoLayout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(btAdicionarBeneficioAPagar)
                        .addGap(18, 18, 18)
                        .addComponent(btRemoverBeneficioAPagar)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelPagamento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
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

    private void btAddCursoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAddCursoActionPerformed
        new DlgGerenciadorCurso(null, rootPaneCheckingEnabled).setVisible(true);
    }//GEN-LAST:event_btAddCursoActionPerformed

    private void btAddTurmaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAddTurmaActionPerformed
        new DlgGerenciadorTurma(null, rootPaneCheckingEnabled).setVisible(true);
    }//GEN-LAST:event_btAddTurmaActionPerformed

    private void btAdicionarBeneficioAPagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAdicionarBeneficioAPagarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btAdicionarBeneficioAPagarActionPerformed

    private void btRemoverBeneficioAPagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btRemoverBeneficioAPagarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btRemoverBeneficioAPagarActionPerformed

    private void btPagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPagarActionPerformed
        DlgEfetuarPagamentoBeneficio beneficio = new DlgEfetuarPagamentoBeneficio(null, rootPaneCheckingEnabled);
        beneficio.carregarLabel(cbCurso.getSelectedItem().toString(), cbTurma.getSelectedItem().toString());
        beneficio.setVisible(true);
    }//GEN-LAST:event_btPagarActionPerformed

    private void btCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btCancelarActionPerformed

    private void cbCursoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbCursoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbCursoActionPerformed

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
            java.util.logging.Logger.getLogger(DlgEfetuarPagamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DlgEfetuarPagamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DlgEfetuarPagamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DlgEfetuarPagamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DlgEfetuarPagamento dialog = new DlgEfetuarPagamento(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btAddCurso;
    private javax.swing.JButton btAddTurma;
    private javax.swing.JButton btAdicionarBeneficioAPagar;
    private javax.swing.JButton btCancelar;
    private javax.swing.JButton btPagar;
    private javax.swing.JButton btRemoverBeneficioAPagar;
    private javax.swing.JComboBox cbCurso;
    private javax.swing.JComboBox cbTurma;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel labelCurso;
    private javax.swing.JLabel labelTurma;
    private javax.swing.JList listBeneficiosCadastrados;
    private javax.swing.JList listBeneficiosParaPagar;
    private javax.swing.JPanel panelPagamento;
    // End of variables declaration//GEN-END:variables

    public void carregarComboBoxCurso() {
        List<Curso> listaCurso = new ArrayList();
        try {
            listaCurso = new CursoDAO().listarTodos();
            for (Curso curso : listaCurso) {
                cbCurso.addItem(curso);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DlgEfetuarPagamento.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void carregarComboBoxTurma() {
        List<Turma> litaTurma = new ArrayList();
        try {
            litaTurma = new TurmaDAO().listarTodos();
            for (Turma turma : litaTurma) {
                cbTurma.addItem(turma);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DlgEfetuarPagamento.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
