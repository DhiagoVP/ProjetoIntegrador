package form;

import dao.AlunoDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.Aluno;
import table.AlunoTableModel;

/**
 *
 * @author Giseli E Keyve
 */
public class DlgConsultarAluno extends javax.swing.JDialog {

    public DlgConsultarAluno(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        if (listaAluno != null) {
            atualizarTabela("SELECT * FROM Aluno a, Endereco e, ContaBancaria cb "
                    + "WHERE a.idEndereco = e.idEndereco AND a.idContaBancaria = cb.idContaBancaria;");
        }
    }
    DlgGerenciadorAluno janelaAluno;
    AlunoDAO alunoDAO = new AlunoDAO();
    List<Aluno> listaAluno = new ArrayList<>();
    Aluno aluno;

    public void atualizarTabela(String sql) {
        try {
            listaAluno = alunoDAO.consultarSQL(sql);
            if (listaAluno != null) {
                tableAluno.setModel(new AlunoTableModel(listaAluno));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tfItemBusca = new javax.swing.JTextField();
        btBuscar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableAluno = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        btEnviar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        btVoltar = new javax.swing.JButton();
        cbTipoPesquisa = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Consultar Aluno");

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

        btBuscar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/consultar.png"))); // NOI18N
        btBuscar.setText("Buscar");
        btBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btBuscarActionPerformed(evt);
            }
        });

        tableAluno.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        tableAluno.setModel(new javax.swing.table.DefaultTableModel(
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
        tableAluno.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableAlunoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableAluno);
        if (tableAluno.getColumnModel().getColumnCount() > 0) {
            tableAluno.getColumnModel().getColumn(0).setResizable(false);
            tableAluno.getColumnModel().getColumn(1).setResizable(false);
            tableAluno.getColumnModel().getColumn(2).setResizable(false);
            tableAluno.getColumnModel().getColumn(3).setResizable(false);
            tableAluno.getColumnModel().getColumn(4).setResizable(false);
            tableAluno.getColumnModel().getColumn(5).setResizable(false);
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

        cbTipoPesquisa.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        cbTipoPesquisa.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Nome", "CPF", "RG" }));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel1.setText("Pesquisar por");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cbTipoPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfItemBusca, javax.swing.GroupLayout.PREFERRED_SIZE, 363, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 695, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfItemBusca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btBuscar)
                    .addComponent(cbTipoPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
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
        if (this.tableAluno.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(this, "É nescessário selecionar um aluno na tabela!");
        } else {
            int linhaSelecionada = this.tableAluno.getSelectedRow();
            int idAluno = Integer.parseInt(this.tableAluno.getValueAt(linhaSelecionada, 0).toString());
            janelaAluno = new DlgGerenciadorAluno(null, true);
            janelaAluno.recuperarDadosAlterarAluno(idAluno);
            this.dispose();
            janelaAluno.setVisible(true);
        }
    }//GEN-LAST:event_btEnviarActionPerformed

    private void btVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btVoltarActionPerformed
        if (tfItemBusca.getText().isEmpty()) {
        janelaAluno = new DlgGerenciadorAluno(null, true);
        this.dispose();
        janelaAluno.setVisible(true);
        } else {
            tfItemBusca.setText(null);
            cbTipoPesquisa.setSelectedIndex(0);
            this.atualizarTabela("SELECT * FROM Aluno a, Endereco e, ContaBancaria cb "
                + "WHERE a.idEndereco = e.idEndereco AND a.idContaBancaria = cb.idContaBancaria;");
        }
    }//GEN-LAST:event_btVoltarActionPerformed

    private void tableAlunoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableAlunoMouseClicked
        if (evt.getClickCount() == 2) {
            int linhaSelecionada = this.tableAluno.getSelectedRow();
            int idAluno = (int) this.tableAluno.getValueAt(linhaSelecionada, 0);
            janelaAluno = new DlgGerenciadorAluno(null, true);
            janelaAluno.recuperarDadosAlterarAluno(idAluno);
            this.dispose();
            janelaAluno.setVisible(true);
        }
    }//GEN-LAST:event_tableAlunoMouseClicked

    private void btBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBuscarActionPerformed
        switch (cbTipoPesquisa.getSelectedItem().toString()) {
            case ("Nome"):
                try {
                    aluno = alunoDAO.buscarPorNome(tfItemBusca.getText());
                    this.limparCampos();
                    if (aluno != null) {
                        atualizarTabela("SELECT * FROM Aluno a, Endereco e, ContaBancaria cb "
                                + "WHERE a.nome LIKE \"" + aluno.getNome() + "%\" AND "
                                + "a.idEndereco = e.idEndereco AND a.idContaBancaria = cb.idContaBancaria;");

                    } else {
                        JOptionPane.showMessageDialog(this, "O aluno não foi encontrado!", "Informação",
                                JOptionPane.INFORMATION_MESSAGE);
                    }
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(this, ex.getMessage());
                }
                break;
            case ("CPF"):
                try {
                    aluno = alunoDAO.buscarPorCpf(tfItemBusca.getText());
                    this.limparCampos();
                    if (aluno != null) {
                        atualizarTabela("SELECT * FROM Aluno a, Endereco e, ContaBancaria cb "
                                + "WHERE a.cpf = " + aluno.getCpf() + " AND "
                                + "a.idEndereco = e.idEndereco AND a.idContaBancaria = cb.idContaBancaria;");
                    } else {
                        JOptionPane.showMessageDialog(this, "O aluno não foi encontrado!", "Informação", JOptionPane.INFORMATION_MESSAGE);
                    }
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(this, ex.getMessage());
                }
                break;
            case ("RG"):
                try {
                    aluno = alunoDAO.buscarPorCpf(tfItemBusca.getText());
                    this.limparCampos();
                    if (aluno != null) {
                        atualizarTabela("SELECT * FROM Aluno a, Endereco e, ContaBancaria cb "
                                + "WHERE a.rg = " + aluno.getRg() + " AND "
                                + "a.idEndereco = e.idEndereco AND a.idContaBancaria = cb.idContaBancaria;");

                    } else {
                        JOptionPane.showMessageDialog(this, "O aluno não foi encontrado!", "Informação", JOptionPane.INFORMATION_MESSAGE);
                    }
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(this, ex.getMessage());
                }
                break;
        }
    }//GEN-LAST:event_btBuscarActionPerformed

    private void tfItemBuscaCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_tfItemBuscaCaretUpdate
        if(tfItemBusca.getText().isEmpty()) {
            this.atualizarTabela("SELECT * FROM Aluno a, Endereco e, ContaBancaria cb "
                + "WHERE a.idEndereco = e.idEndereco AND a.idContaBancaria = cb.idContaBancaria;");
        }
        
        if (cbTipoPesquisa.getSelectedItem().toString() == "Nome" || tfItemBusca.getText() != null ) {
            try {
                    aluno = alunoDAO.buscarPorNome(tfItemBusca.getText());
                    if (aluno != null) {
                        atualizarTabela("SELECT * FROM Aluno a, Endereco e, ContaBancaria cb "
                                + "WHERE a.nome LIKE '%" + tfItemBusca.getText() + "%' AND "
                                + "a.idEndereco = e.idEndereco AND a.idContaBancaria = cb.idContaBancaria;");
                    }
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(this, ex.getMessage());
                }
        }
    }//GEN-LAST:event_tfItemBuscaCaretUpdate

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
            String caracteres = "0987654321";
            if (!caracteres.contains(evt.getKeyChar() + "")) {
                evt.consume();
            }
        }
    }//GEN-LAST:event_tfItemBuscaKeyTyped

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
            java.util.logging.Logger.getLogger(DlgConsultarAluno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DlgConsultarAluno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DlgConsultarAluno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DlgConsultarAluno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                DlgConsultarAluno dialog = new DlgConsultarAluno(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btBuscar;
    private javax.swing.JButton btEnviar;
    private javax.swing.JButton btVoltar;
    private javax.swing.JComboBox cbTipoPesquisa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableAluno;
    private javax.swing.JTextField tfItemBusca;
    // End of variables declaration//GEN-END:variables
}
