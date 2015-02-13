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

    List<Turma> turmasEncontradas;
    TurmaTableModel turmaTable;

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

        jLabel1 = new javax.swing.JLabel();
        cbItensDeBusca = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbTurmasEncontradas = new javax.swing.JTable();
        tfItemDeBusca = new javax.swing.JTextField();
        btBuscarTurma = new javax.swing.JButton();
        btEnviar = new javax.swing.JButton();
        btVoltar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Consultar Turma");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel1.setText("Buscar turma por:");

        cbItensDeBusca.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cbItensDeBusca.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Curso", "Nome", "Orientador", "Professor", "Supervisor", " ", " " }));

        tbTurmasEncontradas.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        tbTurmasEncontradas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome", "Orientador", "Supervisor", "Cidade Demandante", "Campus Ofertante", "Turno"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tbTurmasEncontradas);

        tfItemDeBusca.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        btBuscarTurma.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btBuscarTurma.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Consultar.png"))); // NOI18N
        btBuscarTurma.setText("Buscar");
        btBuscarTurma.setMaximumSize(new java.awt.Dimension(125, 41));
        btBuscarTurma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btBuscarTurmaActionPerformed(evt);
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(134, 134, 134)
                .addComponent(btEnviar, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btVoltar)
                .addGap(95, 95, 95))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbItensDeBusca, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfItemDeBusca)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btBuscarTurma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(26, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 828, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfItemDeBusca, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btBuscarTurma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbItensDeBusca))
                .addGap(28, 28, 28)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btEnviar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btVoltar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btBuscarTurmaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBuscarTurmaActionPerformed
        String busca = cbItensDeBusca.getSelectedItem().toString();
        String nome = tfItemDeBusca.getText();
        Curso curso;
        Orientador orientador;
        Professor professor;
        Supervisor supervisor;
        turmasEncontradas = new ArrayList<>();
        switch (busca) {
            case "Curso":
                try {
                    curso = new CursoDAO().buscarPorNome(nome);
                    turmasEncontradas = new TurmaDAO().buscarPorCurso(curso);
                } catch (SQLException ex) {
                    Logger.getLogger(DlgConsultarTurma.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
            case "Nome":
                try {
                    turmasEncontradas = new TurmaDAO().buscarPorNome(busca);
                } catch (SQLException ex) {
                    Logger.getLogger(DlgConsultarTurma.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
            case "Orientador": {
                try {
                    orientador = new OrientadorDAO().buscarPorNome(nome);
                    turmasEncontradas = new TurmaDAO().buscarPorOrientador(orientador);
                } catch (SQLException ex) {
                    Logger.getLogger(DlgConsultarTurma.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            break;
            case "Professor":
                try {
                    professor = new ProfessorDAO().buscarPorNome(nome);
                    turmasEncontradas = new TurmaDAO().buscarPorProfessor(professor);
                } catch (SQLException ex) {
                    Logger.getLogger(DlgConsultarTurma.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
            case "Supervisor":
                try {
                    supervisor = new SupervisorDAO().buscarPorNome(nome);
                    turmasEncontradas = new TurmaDAO().buscarPorSupervisor(supervisor);
                } catch (SQLException ex) {
                    Logger.getLogger(DlgConsultarTurma.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
        }
        atualizarTabela();
    }//GEN-LAST:event_btBuscarTurmaActionPerformed

    private void btEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEnviarActionPerformed
        int indice = tbTurmasEncontradas.getSelectedRow();
        if (indice > 0) {
            Turma turma = turmasEncontradas.get(indice);
            DlgGerenciadorTurma dlgTurma = new DlgGerenciadorTurma(null,true);
            dlgTurma.recuperarDadosDeTurmaParaEdicao(turma.getId());
            this.dispose();
            dlgTurma.setVisible(true);
        }
    }//GEN-LAST:event_btEnviarActionPerformed

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
    private javax.swing.JButton btBuscarTurma;
    private javax.swing.JButton btEnviar;
    private javax.swing.JButton btVoltar;
    private javax.swing.JComboBox cbItensDeBusca;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbTurmasEncontradas;
    private javax.swing.JTextField tfItemDeBusca;
    // End of variables declaration//GEN-END:variables

    private void atualizarTabela() {
        turmaTable = new TurmaTableModel((ArrayList<Turma>)turmasEncontradas);
        tbTurmasEncontradas.setModel(turmaTable);
    }

    private void iniciarTabela() {
        try {
            turmasEncontradas = new TurmaDAO().listarTodos();
            atualizarTabela();
        } catch (SQLException ex) {
            Logger.getLogger(DlgConsultarTurma.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
