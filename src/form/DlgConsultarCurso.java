package form;

import dao.CursoDAO;
import java.awt.FontMetrics;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.Curso;
import table.CursoColumnModel;
import table.CursoTableModel;

/**
 *
 * @author Giseli e Keyve
 */
public class DlgConsultarCurso extends javax.swing.JDialog {

    CursoDAO cursoDAO = new CursoDAO();
    List<Curso> listaCurso = new ArrayList<>();
    Curso curso = null;
    
    public DlgConsultarCurso(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        if (listaCurso != null) {
            atualizarTabela("SELECT * FROM Curso c ORDER BY c.nome;");
        }
    }
    
    public void atualizarTabela(String sql) {
        try {
            listaCurso = cursoDAO.consultarSQL(sql);
            if (listaCurso != null) {
                tableCurso.setModel(new CursoTableModel(listaCurso));
                FontMetrics fm = tableCurso.getFontMetrics(tableCurso.getFont());
                tableCurso.setColumnModel(new CursoColumnModel(fm));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "ERRO: "+ ex.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        popupMenuAlterar = new javax.swing.JPopupMenu();
        popupMenuRemover = new javax.swing.JPopupMenu();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableCurso = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        tfItemBusca = new javax.swing.JTextField();
        btBuscar = new javax.swing.JButton();
        btVoltar = new javax.swing.JButton();
        btEnviar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Consultar Curso");

        tableCurso.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Curso", "Descrição", "Eixo Tecnológico", "Carga Horária", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableCurso.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableCursoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableCurso);

        jLabel1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel1.setText("Nome");

        tfItemBusca.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        tfItemBusca.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                tfItemBuscaCaretUpdate(evt);
            }
        });

        btBuscar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/consultar.png"))); // NOI18N
        btBuscar.setText("Buscar");
        btBuscar.setToolTipText("");
        btBuscar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btBuscarActionPerformed(evt);
            }
        });

        btVoltar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btVoltar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Voltar.png"))); // NOI18N
        btVoltar.setText("Voltar");
        btVoltar.setActionCommand("btVoltar");
        btVoltar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btVoltarActionPerformed(evt);
            }
        });

        btEnviar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btEnviar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Enviar.png"))); // NOI18N
        btEnviar.setText("Enviar");
        btEnviar.setActionCommand("btEnviar");
        btEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEnviarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btEnviar, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
                        .addGap(462, 462, 462)
                        .addComponent(btVoltar, javax.swing.GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfItemBusca, javax.swing.GroupLayout.PREFERRED_SIZE, 527, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tfItemBusca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btEnviar)
                    .addComponent(btVoltar))
                .addGap(12, 12, 12))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBuscarActionPerformed
        try {
            curso = cursoDAO.buscarPorNome(tfItemBusca.getText());
            if (curso != null) {
                atualizarTabela("SELECT * FROM Curso c WHERE c.nome LIKE '%" + curso.getNome() + "%' ORDER BY c.nome;");
                this.limparCampos();
            } else {
                JOptionPane.showMessageDialog(this, "O curso não foi encontrado!", "Informação", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "ERRO: "+ ex.getMessage());
        }
    }//GEN-LAST:event_btBuscarActionPerformed
    DlgGerenciadorCurso janelaCurso;
    private void tableCursoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableCursoMouseClicked
        if (evt.getClickCount() == 2) {
                int linhaSelecionada = this.tableCurso.getSelectedRow();
                int idCurso = (int) this.tableCurso.getValueAt(linhaSelecionada, 0);
                janelaCurso = new DlgGerenciadorCurso(null, true);
                janelaCurso.recuperarDadosAlterarCurso(idCurso);
                this.dispose();
                janelaCurso.setVisible(true);
        }
    }//GEN-LAST:event_tableCursoMouseClicked

    private void btVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btVoltarActionPerformed
        janelaCurso = new DlgGerenciadorCurso(null, true);
        this.dispose();
        janelaCurso.setVisible(true);
    }//GEN-LAST:event_btVoltarActionPerformed

    private void btEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEnviarActionPerformed
        if (this.tableCurso.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(this, "É nescessário selecionar um curso na tabela!");
        } else {
            int linhaSelecionada = this.tableCurso.getSelectedRow();
            int idCurso = Integer.parseInt(this.tableCurso.getValueAt(linhaSelecionada, 0).toString());
            janelaCurso = new DlgGerenciadorCurso(null, true);
            janelaCurso.recuperarDadosAlterarCurso(idCurso);
            this.dispose();
            janelaCurso.setVisible(true);
        }
    }//GEN-LAST:event_btEnviarActionPerformed

    private void tfItemBuscaCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_tfItemBuscaCaretUpdate
        if(tfItemBusca.getText().isEmpty()) {
            this.atualizarTabela("SELECT * FROM Curso c ORDER BY c.nome;");
            limparCampos();
        }
        
        if (!tfItemBusca.getText().isEmpty()) {
                        atualizarTabela("SELECT * FROM Curso c WHERE c.nome LIKE '%" + tfItemBusca.getText()+ "%' ORDER BY c.nome;");
        }
    }//GEN-LAST:event_tfItemBuscaCaretUpdate

    private void limparCampos(){
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
            java.util.logging.Logger.getLogger(DlgConsultarCurso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DlgConsultarCurso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DlgConsultarCurso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DlgConsultarCurso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DlgConsultarCurso dialog = new DlgConsultarCurso(new javax.swing.JFrame(), true);
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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPopupMenu popupMenuAlterar;
    private javax.swing.JPopupMenu popupMenuRemover;
    private javax.swing.JTable tableCurso;
    private javax.swing.JTextField tfItemBusca;
    // End of variables declaration//GEN-END:variables
}
