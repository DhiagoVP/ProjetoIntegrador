package form;

import dao.SupervisorDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.Supervisor;
import table.SupervisorTableModel;

/**
 *
 * @author Giseli E Keyve
 */
public final class DlgConsultarSupervisor extends javax.swing.JDialog {

    public DlgConsultarSupervisor(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        if (listaSupervisor != null) {
            atualizarTabela("SELECT * FROM Supervisor s, Endereco e, ContaBancaria cb "
                    + "WHERE s.idEndereco = e.idEndereco AND s.idContaBancaria = cb.idContaBancaria;");
        }
    }
    DlgGerenciadorSupervisor janelaSupervisor;
    SupervisorDAO supervisorDAO = new SupervisorDAO();
    List<Supervisor> listaSupervisor = new ArrayList<>();
    
    /**
     *
     * @param sql
     */
    public void atualizarTabela(String sql) {
        try {
            listaSupervisor = supervisorDAO.consultarSQL(sql);
            if (listaSupervisor != null) {
                tableSupervisor.setModel(new SupervisorTableModel(listaSupervisor));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tfItemBusca = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableSupervisor = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        btEnviar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        btVoltar = new javax.swing.JButton();
        lbPesquisar = new javax.swing.JLabel();
        cbTipoPesquisa = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Consultar Supervisor");

        tfItemBusca.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        tfItemBusca.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                tfItemBuscaCaretUpdate(evt);
            }
        });
        tfItemBusca.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfItemBuscaKeyTyped(evt);
            }
        });

        tableSupervisor.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        tableSupervisor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nome", "CPF", "RG", "Data De Entrada", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableSupervisor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableSupervisorMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableSupervisor);
        if (tableSupervisor.getColumnModel().getColumnCount() > 0) {
            tableSupervisor.getColumnModel().getColumn(0).setResizable(false);
            tableSupervisor.getColumnModel().getColumn(1).setResizable(false);
            tableSupervisor.getColumnModel().getColumn(2).setResizable(false);
            tableSupervisor.getColumnModel().getColumn(3).setResizable(false);
            tableSupervisor.getColumnModel().getColumn(4).setResizable(false);
            tableSupervisor.getColumnModel().getColumn(5).setResizable(false);
        }

        jPanel1.setLayout(new java.awt.GridLayout(1, 0));

        btEnviar.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        btEnviar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Enviar.png"))); // NOI18N
        btEnviar.setText("Enviar");
        btEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEnviarActionPerformed(evt);
            }
        });
        jPanel1.add(btEnviar);

        jPanel2.setLayout(new java.awt.GridLayout(1, 0));

        btVoltar.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        btVoltar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Voltar.png"))); // NOI18N
        btVoltar.setText("Voltar");
        btVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btVoltarActionPerformed(evt);
            }
        });
        jPanel2.add(btVoltar);

        lbPesquisar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbPesquisar.setText("Pesquisar por");

        cbTipoPesquisa.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        cbTipoPesquisa.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Nome", "CPF", "RG" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lbPesquisar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbTipoPesquisa, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tfItemBusca, javax.swing.GroupLayout.PREFERRED_SIZE, 483, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 695, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfItemBusca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbPesquisar)
                    .addComponent(cbTipoPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEnviarActionPerformed
        if (this.tableSupervisor.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(this, "Um supervisor precisa estar selecionado na tabela!");
        } else {
            int linhaSelecionada = this.tableSupervisor.getSelectedRow();
            int idSupervisor = Integer.parseInt(this.tableSupervisor.getValueAt(linhaSelecionada, 0).toString());
            janelaSupervisor = new DlgGerenciadorSupervisor(null, true);
            janelaSupervisor.recuperarDadosAlterarSupervisor(idSupervisor);
            this.dispose();
            janelaSupervisor.setVisible(true);
        }
    }//GEN-LAST:event_btEnviarActionPerformed

    private void btVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btVoltarActionPerformed
        janelaSupervisor = new DlgGerenciadorSupervisor(null, true);
        this.dispose();
        janelaSupervisor.setVisible(true);
    }//GEN-LAST:event_btVoltarActionPerformed

    private void tableSupervisorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableSupervisorMouseClicked
        if (evt.getClickCount() == 2) {
            if (this.tableSupervisor.getSelectedRow() == -1) {
                JOptionPane.showMessageDialog(this, "Um supervisor precisa estar selecionado na tabela!");
            } else {
                int linhaSelecionada = this.tableSupervisor.getSelectedRow();
                int idSupervisor = (int) this.tableSupervisor.getValueAt(linhaSelecionada, 0);
                janelaSupervisor = new DlgGerenciadorSupervisor(null, true);
                janelaSupervisor.recuperarDadosAlterarSupervisor(idSupervisor);
                this.dispose();
                janelaSupervisor.setVisible(true);
            }
        }
    }//GEN-LAST:event_tableSupervisorMouseClicked

    private void tfItemBuscaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfItemBuscaKeyTyped
        if (cbTipoPesquisa.getSelectedItem().toString() == "Nome") {
            String caracteres = "0987654321.";
            if (caracteres.contains(evt.getKeyChar() + "")) {
                evt.consume();
            }
        } else if (cbTipoPesquisa.getSelectedItem().toString() == "CPF") {
            String caracteres = "0987654321.-";
            if (!caracteres.contains(evt.getKeyChar() + "")) {
                evt.consume();
            }
        } else {
            String caracteres = "0987654321.";
            if (!caracteres.contains(evt.getKeyChar() + "")) {
                evt.consume();
            }
        }
    }//GEN-LAST:event_tfItemBuscaKeyTyped

    private void tfItemBuscaCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_tfItemBuscaCaretUpdate
        if (tfItemBusca.getText().isEmpty()) {
            atualizarTabela("SELECT * FROM Supervisor s, Endereco e, ContaBancaria cb "
                    + "WHERE s.idEndereco = e.idEndereco AND s.idContaBancaria = cb.idContaBancaria;");
            limparCampos();
        }
        
        if (cbTipoPesquisa.getSelectedItem().toString() == "Nome" && !tfItemBusca.getText().isEmpty()) {
            atualizarTabela("SELECT * FROM Supervisor s, Endereco e, ContaBancaria cb "
                                + "WHERE s.nome LIKE '%" + tfItemBusca.getText() + "%'"
                                + "AND s.idEndereco = e.idEndereco AND s.idContaBancaria = cb.idContaBancaria;");
        }
        
        if (cbTipoPesquisa.getSelectedItem().toString() == "CPF" && !tfItemBusca.getText().isEmpty()) {
            atualizarTabela("SELECT * FROM Supervisor s, Endereco e, ContaBancaria cb "
                                + "WHERE s.cpf LIKE '%" + tfItemBusca.getText() + "%'"
                                + "AND s.idEndereco = e.idEndereco AND s.idContaBancaria = cb.idContaBancaria;");
        }
        
        if (cbTipoPesquisa.getSelectedItem().toString() == "RG" && !tfItemBusca.getText().isEmpty()) {
            atualizarTabela("SELECT * FROM Supervisor s, Endereco e, ContaBancaria cb "
                                + "WHERE s.rg LIKE'" + tfItemBusca.getText() + "%'"
                                + "AND s.idEndereco = e.idEndereco AND s.idContaBancaria = cb.idContaBancaria;");
        }
    }//GEN-LAST:event_tfItemBuscaCaretUpdate

    public void limparCampos() {
        this.tfItemBusca.setText(null);
    }

    public static void main(String args[]) {

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
            java.util.logging.Logger.getLogger(DlgConsultarSupervisor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DlgConsultarSupervisor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DlgConsultarSupervisor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DlgConsultarSupervisor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                DlgConsultarSupervisor dialog = new DlgConsultarSupervisor(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btEnviar;
    private javax.swing.JButton btVoltar;
    private javax.swing.JComboBox cbTipoPesquisa;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbPesquisar;
    private javax.swing.JTable tableSupervisor;
    private javax.swing.JTextField tfItemBusca;
    // End of variables declaration//GEN-END:variables
}
