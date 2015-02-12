package form;

import dao.OrientadorDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.Orientador;
import table.OrientadorTableModel;

/**
 *
 * @author Giseli E Keyve
 */
public class DlgConsultarOrientador extends javax.swing.JDialog {

    public DlgConsultarOrientador(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        if (listaOrientador != null) {
            atualizarTabela("SELECT * FROM Orientador o, Endereco e, ContaBancaria cb "
                    + "WHERE o.idEndereco = e.idEndereco AND o.idContaBancaria = cb.idContaBancaria;");
        }
    }
    DlgGerenciadorOrientador janelaOrientador;
    OrientadorDAO orientadorDAO = new OrientadorDAO();
    List<Orientador> listaOrientador = new ArrayList<>();
    Orientador orientador;

    public void atualizarTabela(String sql) {
        try {
            listaOrientador = orientadorDAO.consultarSQL(sql);
            if (listaOrientador != null) {
                tableOrientador.setModel(new OrientadorTableModel(listaOrientador));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbNome = new javax.swing.JLabel();
        tfNome = new javax.swing.JTextField();
        btBuscarPorNome = new javax.swing.JButton();
        lbCpf = new javax.swing.JLabel();
        tfCpf = new javax.swing.JTextField();
        btBuscarPorCpf = new javax.swing.JButton();
        lbRg = new javax.swing.JLabel();
        btBuscarPorRG = new javax.swing.JButton();
        tfRg = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableOrientador = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        btEnviar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        btVoltar = new javax.swing.JButton();
        btCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Consultar Orientador");

        lbNome.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbNome.setText("Nome:");

        tfNome.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        btBuscarPorNome.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btBuscarPorNome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/consultar.png"))); // NOI18N
        btBuscarPorNome.setText("Buscar");
        btBuscarPorNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btBuscarPorNomeActionPerformed(evt);
            }
        });

        lbCpf.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbCpf.setText("CPF:");

        tfCpf.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        btBuscarPorCpf.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btBuscarPorCpf.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/consultar.png"))); // NOI18N
        btBuscarPorCpf.setText("Buscar");
        btBuscarPorCpf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btBuscarPorCpfActionPerformed(evt);
            }
        });

        lbRg.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbRg.setText("RG:");

        btBuscarPorRG.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btBuscarPorRG.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/consultar.png"))); // NOI18N
        btBuscarPorRG.setText("Buscar");
        btBuscarPorRG.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btBuscarPorRGActionPerformed(evt);
            }
        });

        tfRg.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        tableOrientador.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        tableOrientador.setModel(new javax.swing.table.DefaultTableModel(
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
        tableOrientador.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableOrientadorMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableOrientador);
        if (tableOrientador.getColumnModel().getColumnCount() > 0) {
            tableOrientador.getColumnModel().getColumn(0).setResizable(false);
            tableOrientador.getColumnModel().getColumn(1).setResizable(false);
            tableOrientador.getColumnModel().getColumn(2).setResizable(false);
            tableOrientador.getColumnModel().getColumn(3).setResizable(false);
            tableOrientador.getColumnModel().getColumn(4).setResizable(false);
            tableOrientador.getColumnModel().getColumn(5).setResizable(false);
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

        btCancelar.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        btCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Cancelar.png"))); // NOI18N
        btCancelar.setText("Cancelar");
        btCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbNome)
                            .addComponent(lbCpf, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lbRg, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfNome)
                            .addComponent(tfCpf)
                            .addComponent(tfRg))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(btBuscarPorNome, javax.swing.GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE)
                            .addComponent(btBuscarPorCpf, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btBuscarPorRG, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 695, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(134, 134, 134)
                        .addComponent(btCancelar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbNome)
                    .addComponent(tfNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btBuscarPorNome))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbCpf)
                    .addComponent(tfCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btBuscarPorCpf))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfRg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbRg)
                    .addComponent(btBuscarPorRG))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btCancelar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEnviarActionPerformed
        if (this.tableOrientador.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(this, "É nescessário selecionar um orientador na tabela!");
        } else {
            int linhaSelecionada = this.tableOrientador.getSelectedRow();
            int idOrientador = Integer.parseInt(this.tableOrientador.getValueAt(linhaSelecionada, 0).toString());
            janelaOrientador = new DlgGerenciadorOrientador(null, true);
            janelaOrientador.recuperarDadosAlterarOrientador(idOrientador);
            this.dispose();
            janelaOrientador.setVisible(true);
        }
    }//GEN-LAST:event_btEnviarActionPerformed

    private void btVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btVoltarActionPerformed
        janelaOrientador = new DlgGerenciadorOrientador(null, true);
        this.dispose();
        janelaOrientador.setVisible(true);
    }//GEN-LAST:event_btVoltarActionPerformed

    private void tableOrientadorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableOrientadorMouseClicked
        if (evt.getClickCount() == 2) {
            if (this.tableOrientador.getSelectedRow() == -1) {
                JOptionPane.showMessageDialog(this, "É nescessário selecionar um orientador na tabela!");
            } else {
                int linhaSelecionada = this.tableOrientador.getSelectedRow();
                int idOrientador = (int) this.tableOrientador.getValueAt(linhaSelecionada, 0);
                janelaOrientador = new DlgGerenciadorOrientador(null, true);
                janelaOrientador.recuperarDadosAlterarOrientador(idOrientador);
                this.dispose();
                janelaOrientador.setVisible(true);
            }
        }
    }//GEN-LAST:event_tableOrientadorMouseClicked

    private void btBuscarPorNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBuscarPorNomeActionPerformed
        try {
            orientador = orientadorDAO.buscarPorNome(tfNome.getText());
            this.limparCampos();
            if (orientador != null) {
                atualizarTabela("SELECT * FROM Orientador o, Endereco e, ContaBancaria cb "
                        + "WHERE o.nome LIKE \"" + orientador.getNome() + "%\" AND "
                        + "o.idEndereco = e.idEndereco AND o.idContaBancaria = cb.idContaBancaria;");

            } else {
                JOptionPane.showMessageDialog(this, "O orientador não foi encontrado!", "Informação",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }//GEN-LAST:event_btBuscarPorNomeActionPerformed

    private void btBuscarPorCpfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBuscarPorCpfActionPerformed
        try {
            orientador = orientadorDAO.buscarPorCpf(tfCpf.getText());
            this.limparCampos();
            if (orientador != null) {
                atualizarTabela("SELECT * FROM Orientador o, Endereco e, ContaBancaria cb "
                        + "WHERE o.cpf = " + orientador.getCpf() + " AND "
                        + "o.idEndereco = e.idEndereco AND o.idContaBancaria = cb.idContaBancaria;");

            } else {
                JOptionPane.showMessageDialog(this, "O orientador não foi encontrado!", "Informação", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }//GEN-LAST:event_btBuscarPorCpfActionPerformed

    private void btBuscarPorRGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBuscarPorRGActionPerformed
        try {
            orientador = orientadorDAO.buscarPorRg(tfRg.getText());
            this.limparCampos();
            if (orientador != null) {
                atualizarTabela("SELECT * FROM Orientador o, Endereco e, ContaBancaria cb "
                        + "WHERE o.rg = " + orientador.getRg() + " AND "
                        + "o.idEndereco = e.idEndereco AND o.idContaBancaria = cb.idContaBancaria;");

            } else {
                JOptionPane.showMessageDialog(this, "O orientador não foi encontrado!", "Informação", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }//GEN-LAST:event_btBuscarPorRGActionPerformed

    private void btCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelarActionPerformed
        this.limparCampos();
        this.atualizarTabela("SELECT * FROM Orientador o, Endereco e, ContaBancaria cb "
                + "WHERE o.idEndereco = e.idEndereco AND o.idContaBancaria = cb.idContaBancaria;");
    }//GEN-LAST:event_btCancelarActionPerformed

    public void limparCampos() {
        this.tfNome.setText(null);
        this.tfCpf.setText(null);
        this.tfRg.setText(null);
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
            java.util.logging.Logger.getLogger(DlgConsultarOrientador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DlgConsultarOrientador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DlgConsultarOrientador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DlgConsultarOrientador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DlgConsultarOrientador dialog = new DlgConsultarOrientador(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btBuscarPorCpf;
    private javax.swing.JButton btBuscarPorNome;
    private javax.swing.JButton btBuscarPorRG;
    private javax.swing.JButton btCancelar;
    private javax.swing.JButton btEnviar;
    private javax.swing.JButton btVoltar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbCpf;
    private javax.swing.JLabel lbNome;
    private javax.swing.JLabel lbRg;
    private javax.swing.JTable tableOrientador;
    private javax.swing.JTextField tfCpf;
    private javax.swing.JTextField tfNome;
    private javax.swing.JTextField tfRg;
    // End of variables declaration//GEN-END:variables
}
