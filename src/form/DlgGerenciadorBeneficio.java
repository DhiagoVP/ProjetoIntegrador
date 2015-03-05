/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package form;

import dao.BeneficioDAO;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Beneficio;

/**
 *
 * @author Ana Paula, Dhiago
 */
public class DlgGerenciadorBeneficio extends javax.swing.JDialog {

    /**
     * Creates new form DlgGerenciarBeneficio
     */
    public DlgGerenciadorBeneficio(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    private Beneficio beneficio;
    private BeneficioDAO beneficioDAO = new BeneficioDAO();

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelDadosBeneficio = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        labelDescricao = new javax.swing.JLabel();
        tfValor = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        taDescricao = new javax.swing.JTextArea();
        tfTipo = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        buttonCadastrar = new javax.swing.JButton();
        buttonConsultar = new javax.swing.JButton();
        buttonAlterar = new javax.swing.JButton();
        buttonExcluir = new javax.swing.JButton();
        buttonCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        panelDadosBeneficio.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Dados Benefício", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 18), new java.awt.Color(0, 102, 204))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel1.setText("Tipo");

        jLabel2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel2.setText("Valor");

        labelDescricao.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        labelDescricao.setText("Descrição");

        tfValor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfValorKeyTyped(evt);
            }
        });

        taDescricao.setColumns(20);
        taDescricao.setRows(5);
        jScrollPane1.setViewportView(taDescricao);

        tfTipo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfTipoKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout panelDadosBeneficioLayout = new javax.swing.GroupLayout(panelDadosBeneficio);
        panelDadosBeneficio.setLayout(panelDadosBeneficioLayout);
        panelDadosBeneficioLayout.setHorizontalGroup(
            panelDadosBeneficioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDadosBeneficioLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelDadosBeneficioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelDadosBeneficioLayout.createSequentialGroup()
                        .addGroup(panelDadosBeneficioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(panelDadosBeneficioLayout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tfTipo))
                            .addGroup(panelDadosBeneficioLayout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tfValor, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(labelDescricao))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jScrollPane1)))
        );
        panelDadosBeneficioLayout.setVerticalGroup(
            panelDadosBeneficioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDadosBeneficioLayout.createSequentialGroup()
                .addGroup(panelDadosBeneficioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tfTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelDadosBeneficioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tfValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelDescricao)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE))
        );

        jPanel1.setLayout(new java.awt.GridLayout(1, 0));

        buttonCadastrar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        buttonCadastrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Cadastrar.png"))); // NOI18N
        buttonCadastrar.setText("Cadastrar");
        buttonCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCadastrarActionPerformed(evt);
            }
        });
        jPanel1.add(buttonCadastrar);

        buttonConsultar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        buttonConsultar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Consultar.png"))); // NOI18N
        buttonConsultar.setText("Consultar");
        buttonConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonConsultarActionPerformed(evt);
            }
        });
        jPanel1.add(buttonConsultar);

        buttonAlterar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        buttonAlterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Alterar.png"))); // NOI18N
        buttonAlterar.setText("Alterar");
        buttonAlterar.setEnabled(false);
        buttonAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAlterarActionPerformed(evt);
            }
        });
        jPanel1.add(buttonAlterar);

        buttonExcluir.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        buttonExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Remover.png"))); // NOI18N
        buttonExcluir.setText("Excluir");
        buttonExcluir.setEnabled(false);
        buttonExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonExcluirActionPerformed(evt);
            }
        });
        jPanel1.add(buttonExcluir);

        buttonCancelar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        buttonCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Cancelar.png"))); // NOI18N
        buttonCancelar.setText("Cancelar");
        buttonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCancelarActionPerformed(evt);
            }
        });
        jPanel1.add(buttonCancelar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelDadosBeneficio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelDadosBeneficio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void buttonConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonConsultarActionPerformed
        this.setVisible(false);
        new DlgConsultarBeneficio(null, true).setVisible(true);
    }//GEN-LAST:event_buttonConsultarActionPerformed

    private void buttonCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCadastrarActionPerformed
        try {
            if (beneficio == null) {
                beneficio = new Beneficio();
                carregarDadosAdicionar();
                if (beneficioDAO.cadastrar(beneficio)) {
                    JOptionPane.showMessageDialog(this, "Cadastro efetuado com sucesso!");
                    limparCampos();
                } else {
                    JOptionPane.showMessageDialog(this, "Esse benefício já foi cadastrado", "Cadastro de Benefício", JOptionPane.ERROR_MESSAGE);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(DlgGerenciadorBeneficio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_buttonCadastrarActionPerformed

    private void buttonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCancelarActionPerformed
        if (tfTipo.getText().isEmpty() && tfValor.getText().isEmpty() && taDescricao.getText().isEmpty()) {
            this.dispose();
        } else {
            tfTipo.setText(null);
            tfValor.setText(null);
            taDescricao.setText(null);
        }
    }//GEN-LAST:event_buttonCancelarActionPerformed

    private void buttonAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAlterarActionPerformed
        if (beneficio != null) {
            try {
                carregarDadosAdicionar();
                beneficioDAO.atualizar(beneficio);
                JOptionPane.showMessageDialog(this, "Beneficio alterado com sucesso!");
                limparCampos();
                estadoInicial();
            } catch (SQLException ex) {
                Logger.getLogger(DlgGerenciadorBeneficio.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_buttonAlterarActionPerformed

    private void buttonExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonExcluirActionPerformed
        if (beneficio != null) {
            try {
                int resultado = JOptionPane.showConfirmDialog(this, "Deseja remover esse benefício?", "ATENÇÃO", JOptionPane.YES_NO_OPTION);
                if (resultado == 0) {
                    beneficioDAO.remover(beneficio);
                    JOptionPane.showMessageDialog(this, "Benefício removido!");
                    limparCampos();
                    estadoInicial();
                }
            } catch (SQLException ex) {
                Logger.getLogger(DlgGerenciadorBeneficio.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_buttonExcluirActionPerformed

    private void tfValorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfValorKeyTyped
        String caracteres = "0987654321.";
        if (!caracteres.contains(evt.getKeyChar() + "")) {
            evt.consume();
        }
    }//GEN-LAST:event_tfValorKeyTyped

    private void tfTipoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfTipoKeyTyped
        String caracteres = "0987654321!@#$%¨&*()'<>;:][}{=-_+§ªº¬¹/?°²³~´`^";
        if (caracteres.contains(evt.getKeyChar() + "")) {
            evt.consume();
        }
    }//GEN-LAST:event_tfTipoKeyTyped

    public void carregarDadosAdicionar() {
        beneficio.setTipo(tfTipo.getText());
        beneficio.setValor(Double.parseDouble(tfValor.getText()));
        beneficio.setDescricao(taDescricao.getText());
    }

    public void recuperarDados(int id) {
        try {
            beneficio = beneficioDAO.recuperarById(id);
            tfTipo.setText(beneficio.getTipo());
            tfValor.setText(beneficio.getValor().toString());
            taDescricao.setText(beneficio.getDescricao());
            estadoAlterar();
        } catch (SQLException ex) {
            Logger.getLogger(DlgGerenciadorBeneficio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void limparCampos() {
        tfTipo.setText(null);
        tfValor.setText(null);
        taDescricao.setText(null);
    }

    public void estadoInicial() {
        buttonAlterar.setEnabled(false);
        buttonCadastrar.setEnabled(true);
        buttonCancelar.setEnabled(true);
        buttonConsultar.setEnabled(true);
        buttonExcluir.setEnabled(false);
    }

    public void estadoAlterar() {
        buttonAlterar.setEnabled(true);
        buttonCadastrar.setEnabled(true);
        buttonCancelar.setEnabled(true);
        buttonConsultar.setEnabled(true);
        buttonExcluir.setEnabled(true);
    }

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
            java.util.logging.Logger.getLogger(DlgGerenciadorBeneficio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DlgGerenciadorBeneficio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DlgGerenciadorBeneficio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DlgGerenciadorBeneficio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DlgGerenciadorBeneficio dialog = new DlgGerenciadorBeneficio(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton buttonAlterar;
    private javax.swing.JButton buttonCadastrar;
    private javax.swing.JButton buttonCancelar;
    private javax.swing.JButton buttonConsultar;
    private javax.swing.JButton buttonExcluir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelDescricao;
    private javax.swing.JPanel panelDadosBeneficio;
    private javax.swing.JTextArea taDescricao;
    private javax.swing.JTextField tfTipo;
    private javax.swing.JTextField tfValor;
    // End of variables declaration//GEN-END:variables
}
