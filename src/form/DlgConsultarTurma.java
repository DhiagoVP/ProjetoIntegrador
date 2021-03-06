/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package form;

import dao.CursoDAO;
import dao.OrientadorDAO;
import dao.ProfessorDAO;
import dao.SupervisorDAO;
import dao.TurmaDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Curso;
import model.Orientador;
import model.Professor;
import model.Supervisor;
import model.Turma;
import table.TurmaTableModel;

/**
 *
 * @author Ana Paula e Dhiago
 */
public class DlgConsultarTurma extends javax.swing.JDialog {

    List<Turma> totalTurmasEncontradas;
    TurmaTableModel turmaTable;
    DlgGerenciadorTurma dlgTurma = new DlgGerenciadorTurma(null, true);
    private int nivelUsuario;

    /**
     * Creates new form DlgConsultarTurma
     */
    public DlgConsultarTurma(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        iniciarTabela();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cbItensDeBusca = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbTurmasEncontradas = new javax.swing.JTable();
        tfItemDeBusca = new javax.swing.JTextField();
        btEnviar = new javax.swing.JButton();
        btVoltar = new javax.swing.JButton();
        lbPesquisar = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Consultar Turma");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setResizable(false);

        cbItensDeBusca.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        cbItensDeBusca.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Curso", "Nome", "Orientador", "Professor", "Supervisor" }));
        cbItensDeBusca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbItensDeBuscaActionPerformed(evt);
            }
        });

        tbTurmasEncontradas.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        tbTurmasEncontradas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Turma", "Curso", "Orientador", "Supervisor", "Cidade Demandante", "Campus Ofertante", "Turno"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tbTurmasEncontradas.getTableHeader().setReorderingAllowed(false);
        tbTurmasEncontradas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbTurmasEncontradasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbTurmasEncontradas);

        tfItemDeBusca.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        tfItemDeBusca.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                tfItemDeBuscaCaretUpdate(evt);
            }
        });

        btEnviar.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        btEnviar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Enviar.png"))); // NOI18N
        btEnviar.setText("Enviar");
        btEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEnviarActionPerformed(evt);
            }
        });

        btVoltar.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        btVoltar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Voltar.png"))); // NOI18N
        btVoltar.setText("Voltar");
        btVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btVoltarActionPerformed(evt);
            }
        });

        lbPesquisar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbPesquisar.setText("Pesquisar por");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lbPesquisar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbItensDeBusca, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfItemDeBusca))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btEnviar, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 885, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfItemDeBusca, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbItensDeBusca)
                    .addComponent(lbPesquisar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btEnviar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEnviarActionPerformed
        int indice = tbTurmasEncontradas.getSelectedRow();
        int id = totalTurmasEncontradas.get(indice).getId();
        if (indice >= 0) {
            try {
                dlgTurma.recuperarDadosDeTurmaParaEdicao(id);
            } catch (SQLException ex) {
                Logger.getLogger(DlgConsultarTurma.class.getName()).log(Level.SEVERE, null, ex);
            }
            dlgTurma.verificarNivel(nivelUsuario);
            this.dispose();
            dlgTurma.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "Nenhuma turma selecionada!", "Aviso", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btEnviarActionPerformed

    private void tfItemDeBuscaCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_tfItemDeBuscaCaretUpdate
        if (tfItemDeBusca.getText().isEmpty()) {
            iniciarTabela();
        } else {
            String busca = cbItensDeBusca.getSelectedItem().toString();
            String nome = tfItemDeBusca.getText();
            List<Curso> cursos;
            List<Turma> turmasEncontradas;
            List<Orientador> orientadores;
            List<Professor> professores;
            List<Supervisor> supervisores;
            switch (busca) {
                case "Curso":
                    try {
                        cursos = new CursoDAO().buscarPorNome(nome);
                        totalTurmasEncontradas.clear();
                        if (cursos != null) {
                            for (Curso curso : cursos) {
                                turmasEncontradas = new TurmaDAO().buscarPorCurso(curso);
                                for (Turma turma : turmasEncontradas) {
                                    totalTurmasEncontradas.add(turma);
                                }
                            }
                        }
                    } catch (SQLException ex) {
                        Logger.getLogger(DlgConsultarTurma.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break;
                case "Nome":
                    try {
                        totalTurmasEncontradas.clear();
                        totalTurmasEncontradas = new TurmaDAO().buscarPorNome(nome);
                    } catch (SQLException ex) {
                        Logger.getLogger(DlgConsultarTurma.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break;
                case "Orientador": {
                    try {
                        orientadores = new OrientadorDAO().buscarPorNomeRetornandoAtributosSimples(nome);
                        totalTurmasEncontradas.clear();
                        if (orientadores != null) {
                            for (Orientador orientador : orientadores) {
                                turmasEncontradas = new TurmaDAO().buscarPorOrientador(orientador);
                                for (Turma turma : turmasEncontradas) {
                                    totalTurmasEncontradas.add(turma);
                                }
                            }
                        }
                    } catch (SQLException ex) {
                        Logger.getLogger(DlgConsultarTurma.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break;
                }
                case "Professor":
                    try {
                        professores = new ProfessorDAO().buscarPorNomeRetornandoAtributosSimples(nome);
                        totalTurmasEncontradas.clear();
                        if (professores != null) {
                            for (Professor professor : professores) {
                                turmasEncontradas = new TurmaDAO().buscarPorProfessor(professor);
                                for (Turma turma : turmasEncontradas) {
                                    totalTurmasEncontradas.add(turma);
                                }
                            }
                        }
                    } catch (SQLException ex) {
                        Logger.getLogger(DlgConsultarTurma.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break;
                case "Supervisor":
                    try {
                        supervisores = new SupervisorDAO().buscarPorNomeRetornandoAtributosSimples(nome);
                        totalTurmasEncontradas.clear();
                        if (supervisores != null) {
                            for (Supervisor supervisor : supervisores) {
                                turmasEncontradas = new TurmaDAO().buscarPorSupervisor(supervisor);
                                for (Turma turma : turmasEncontradas) {
                                    totalTurmasEncontradas.add(turma);
                                }
                            }
                        }
                    } catch (SQLException ex) {
                        Logger.getLogger(DlgConsultarTurma.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break;
            }
            atualizarTabela();
        }
    }//GEN-LAST:event_tfItemDeBuscaCaretUpdate

    private void btVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btVoltarActionPerformed
        if (nivelUsuario == 3) {
            DlgMenuConsultas menu = new DlgMenuConsultas(null, true);
            menu.verificarNivel(nivelUsuario);
            this.dispose();
            menu.setVisible(true);
        } else {
            this.dispose();
            dlgTurma.setVisible(true);
        }
    }//GEN-LAST:event_btVoltarActionPerformed

    private void tbTurmasEncontradasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbTurmasEncontradasMouseClicked
        if (evt.getClickCount() == 2) {
            btEnviarActionPerformed(null);
        }
    }//GEN-LAST:event_tbTurmasEncontradasMouseClicked

    private void cbItensDeBuscaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbItensDeBuscaActionPerformed
        tfItemDeBusca.setText(null);
    }//GEN-LAST:event_cbItensDeBuscaActionPerformed

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
            java.util.logging.Logger.getLogger(DlgConsultarTurma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DlgConsultarTurma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DlgConsultarTurma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DlgConsultarTurma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DlgConsultarTurma dialog = new DlgConsultarTurma(new javax.swing.JFrame(), true);
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
    private javax.swing.JComboBox cbItensDeBusca;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbPesquisar;
    private javax.swing.JTable tbTurmasEncontradas;
    private javax.swing.JTextField tfItemDeBusca;
    // End of variables declaration//GEN-END:variables

    private void atualizarTabela() {
        turmaTable = new TurmaTableModel((ArrayList<Turma>) totalTurmasEncontradas);
        tbTurmasEncontradas.setModel(turmaTable);
    }

    private void iniciarTabela() {
        try {
            totalTurmasEncontradas = new TurmaDAO().listarTodos();
            atualizarTabela();
        } catch (SQLException ex) {
            Logger.getLogger(DlgConsultarTurma.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void verificarNivel(int nivel) {
        this.nivelUsuario = nivel;
    }
}
