package form;

import dao.ProfessorDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.Professor;
import table.ProfessorTableModel;

/**
 *
 * @author Giseli E Keyve
 */
public class DlgConsultarProfessor extends javax.swing.JDialog {

    public DlgConsultarProfessor(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        carregardados();
    }
    private DlgGerenciadorProfessor janelaProfessor;
    private ProfessorDAO professorDAO = new ProfessorDAO();
    private List<Professor> listaProfessor = new ArrayList<>();
    private int nivelUsuario;

    public void atualizarTabela(String sql) {
        try {
            listaProfessor = professorDAO.consultarSQL(sql);
            if (listaProfessor != null) {
                tableProfessor.setModel(new ProfessorTableModel(listaProfessor));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbNome = new javax.swing.JLabel();
        tfItemBusca = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableProfessor = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        btEnviar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        btVoltar = new javax.swing.JButton();
        cbTipoPesquisa = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Consultar Professor");
        setResizable(false);

        lbNome.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbNome.setText("Pesquisar por");

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

        tableProfessor.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        tableProfessor.setModel(new javax.swing.table.DefaultTableModel(
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
        tableProfessor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableProfessorMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableProfessor);
        if (tableProfessor.getColumnModel().getColumnCount() > 0) {
            tableProfessor.getColumnModel().getColumn(0).setResizable(false);
            tableProfessor.getColumnModel().getColumn(1).setResizable(false);
            tableProfessor.getColumnModel().getColumn(2).setResizable(false);
            tableProfessor.getColumnModel().getColumn(3).setResizable(false);
            tableProfessor.getColumnModel().getColumn(4).setResizable(false);
            tableProfessor.getColumnModel().getColumn(5).setResizable(false);
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
        cbTipoPesquisa.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbTipoPesquisaItemStateChanged(evt);
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
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lbNome)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbTipoPesquisa, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tfItemBusca, javax.swing.GroupLayout.PREFERRED_SIZE, 479, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 695, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbNome)
                    .addComponent(tfItemBusca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
        if (this.tableProfessor.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(this, "Um professor precisa estar selecionado na tabela!");
        } else {
            int linhaSelecionada = this.tableProfessor.getSelectedRow();
            int idProfessor = Integer.parseInt(this.tableProfessor.getValueAt(linhaSelecionada, 0).toString());
            janelaProfessor = new DlgGerenciadorProfessor(null, true);
            janelaProfessor.recuperarDadosAlterarProfessor(idProfessor);
            janelaProfessor.verificarNivel(nivelUsuario);
            this.dispose();
            janelaProfessor.setVisible(true);
        }
    }//GEN-LAST:event_btEnviarActionPerformed

    private void btVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btVoltarActionPerformed
        if (nivelUsuario == 3){
            this.dispose();
            DlgMenuConsultas menu = new DlgMenuConsultas(null, true);
            menu.verificarNivel(nivelUsuario);
            menu.setVisible(true);
        } else {
        janelaProfessor = new DlgGerenciadorProfessor(null, true);
        this.dispose();
        janelaProfessor.setVisible(true);
        }
    }//GEN-LAST:event_btVoltarActionPerformed

    private void tableProfessorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableProfessorMouseClicked
        if (evt.getClickCount() == 2) {
            if (this.tableProfessor.getSelectedRow() == -1) {
                JOptionPane.showMessageDialog(this, "Um professor precisa estar selecionado na tabela!");
            } else {
                int linhaSelecionada = this.tableProfessor.getSelectedRow();
                int idProfessor = (int) this.tableProfessor.getValueAt(linhaSelecionada, 0);
                janelaProfessor = new DlgGerenciadorProfessor(null, true);
                janelaProfessor.recuperarDadosAlterarProfessor(idProfessor);
                janelaProfessor.verificarNivel(nivelUsuario);
                this.dispose();
                janelaProfessor.setVisible(true);
            }
        }
    }//GEN-LAST:event_tableProfessorMouseClicked

    private void tfItemBuscaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfItemBuscaKeyTyped
        if (cbTipoPesquisa.getSelectedItem().toString().equalsIgnoreCase("Nome")) {
            String caracteres = "0987654321.";
            if (caracteres.contains(evt.getKeyChar() + "")) {
                evt.consume();
            }
        } else if (cbTipoPesquisa.getSelectedItem().toString().equalsIgnoreCase("CPF")) {
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
        if(tfItemBusca.getText().isEmpty()) {
            this.atualizarTabela("SELECT * FROM Professor p, Endereco e, ContaBancaria cb "
                    + "WHERE p.idEndereco = e.idEndereco AND p.idContaBancaria = cb.idContaBancaria;");
        }
        
        if (cbTipoPesquisa.getSelectedItem().toString().equalsIgnoreCase("Nome") && tfItemBusca.getText() != null ) {
                        atualizarTabela("SELECT * FROM Professor p, Endereco e, ContaBancaria cb "
                        + "WHERE p.nome LIKE '%" + tfItemBusca.getText() + "%' AND "
                        + "p.idEndereco = e.idEndereco AND p.idContaBancaria = cb.idContaBancaria;");
        }
        
        if (cbTipoPesquisa.getSelectedItem().toString().equalsIgnoreCase("CPF") && tfItemBusca.getText() != null ) {
                        atualizarTabela("SELECT * FROM Professor p, Endereco e, ContaBancaria cb "
                        + "WHERE p.cpf LIKE '%" + tfItemBusca.getText() + "%' AND "
                        + "p.idEndereco = e.idEndereco AND p.idContaBancaria = cb.idContaBancaria;");
        }
        
        if (cbTipoPesquisa.getSelectedItem().toString().equalsIgnoreCase("RG") && tfItemBusca.getText() != null ) {
                        atualizarTabela("SELECT * FROM Professor p, Endereco e, ContaBancaria cb "
                        + "WHERE p.rg LIKE '%" + tfItemBusca.getText() + "%' AND "
                        + "p.idEndereco = e.idEndereco AND p.idContaBancaria = cb.idContaBancaria;");
        }
    }//GEN-LAST:event_tfItemBuscaCaretUpdate

    private void cbTipoPesquisaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbTipoPesquisaItemStateChanged
        limparCampos();
    }//GEN-LAST:event_cbTipoPesquisaItemStateChanged

    public void limparCampos() {
     tfItemBusca.setText(null);
    }

    public static void main(String args[]) {

        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Metal".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DlgConsultarProfessor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DlgConsultarProfessor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DlgConsultarProfessor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DlgConsultarProfessor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DlgConsultarProfessor dialog = new DlgConsultarProfessor(new javax.swing.JFrame(), true);
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
    private javax.swing.JLabel lbNome;
    private javax.swing.JTable tableProfessor;
    private javax.swing.JTextField tfItemBusca;
    // End of variables declaration//GEN-END:variables

    private void carregardados() {
       if (listaProfessor != null) {
            atualizarTabela("SELECT * FROM Professor p, Endereco e, ContaBancaria cb "
                    + "WHERE p.idEndereco = e.idEndereco AND p.idContaBancaria = cb.idContaBancaria;");
        }
    }
    
    public void verificarNivel (int nivel) {
        if (nivel == 3) {
            this.nivelUsuario = 3;
        }
    }
}
