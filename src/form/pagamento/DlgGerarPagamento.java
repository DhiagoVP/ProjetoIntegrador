/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package form.pagamento;

import dao.BeneficioDAO;
import dao.TurmaDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import model.Beneficio;
import model.Pagamento;
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
    List<String> listaBeneficiosParaPagar = new ArrayList<>();
    List<Turma> listaTurma;
    SpinnerModel modelo = null;
    Pagamento pagamento = new Pagamento();

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
        btAvançar = new javax.swing.JButton();
        btCancelar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        listBeneficiosCadastrados = new javax.swing.JList();
        jScrollPane2 = new javax.swing.JScrollPane();
        listBeneficiosParaPagar = new javax.swing.JList();
        btAdicionarBeneficioAPagar = new javax.swing.JButton();
        btRemoverBeneficioAPagar = new javax.swing.JButton();
        labelMes = new javax.swing.JLabel();
        labelDiasLetivos = new javax.swing.JLabel();
        cbMes = new javax.swing.JComboBox();
        spinnerDiasLetivos = new javax.swing.JSpinner();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Efetuar Pagamento");
        setResizable(false);

        panelPagamento.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Gerar Pagamento", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 18), new java.awt.Color(0, 153, 204))); // NOI18N

        labelTurma.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        labelTurma.setText("Turma");

        cbTurma.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        btAvançar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btAvançar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/MiniPagamento.png"))); // NOI18N
        btAvançar.setText("Avançar");
        btAvançar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAvançarActionPerformed(evt);
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

        cbMes.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cbMes.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro" }));
        cbMes.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbMesItemStateChanged(evt);
            }
        });

        spinnerDiasLetivos.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        spinnerDiasLetivos.setModel(new javax.swing.SpinnerNumberModel(1, 1, 31, 1));

        javax.swing.GroupLayout panelPagamentoLayout = new javax.swing.GroupLayout(panelPagamento);
        panelPagamento.setLayout(panelPagamentoLayout);
        panelPagamentoLayout.setHorizontalGroup(
            panelPagamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPagamentoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelPagamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelPagamentoLayout.createSequentialGroup()
                        .addComponent(btAvançar, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                                .addComponent(cbMes, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(14, 14, 14)
                                .addComponent(labelDiasLetivos)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(spinnerDiasLetivos, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(17, Short.MAX_VALUE))
        );
        panelPagamentoLayout.setVerticalGroup(
            panelPagamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPagamentoLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(panelPagamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelTurma)
                    .addComponent(cbTurma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelPagamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelMes)
                    .addComponent(cbMes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelDiasLetivos)
                    .addComponent(spinnerDiasLetivos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(panelPagamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelPagamentoLayout.createSequentialGroup()
                        .addGap(18, 21, Short.MAX_VALUE)
                        .addGroup(panelPagamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panelPagamentoLayout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addComponent(btAdicionarBeneficioAPagar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btRemoverBeneficioAPagar)
                        .addGap(22, 22, 22)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addGroup(panelPagamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btCancelar)
                    .addComponent(btAvançar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                .addGap(0, 14, Short.MAX_VALUE))
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
        if (listBeneficiosParaPagar.getSelectedIndex() != -1) {
            cbTurma.setSelectedIndex(0);
            cbMes.setSelectedIndex(0);
            listBeneficiosCadastrados.setSelectedIndex(0);
            listBeneficiosParaPagar.setSelectionModel(null);
            spinnerDiasLetivos.setValue(1);
        } else {
            this.dispose();
        }
    }//GEN-LAST:event_btCancelarActionPerformed

    private void btAvançarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAvançarActionPerformed
        if (listBeneficiosParaPagar.getLastVisibleIndex() <0)
            JOptionPane.showMessageDialog(this, "Selecione no minímo um beneficio");
        else{
            DlgEfetuarPagamentoBeneficio beneficio = new DlgEfetuarPagamentoBeneficio(null, rootPaneCheckingEnabled, false);
            Turma turma = listaTurma.get(cbTurma.getSelectedIndex());
            pagamento.setDiasLetivos(Integer.parseInt(spinnerDiasLetivos.getValue().toString()));
            pagamento.setMes(cbMes.getSelectedItem().toString());
            if(beneficio.carregarDados(turma, buscarBeneficio(), pagamento)){
                //this.dispose();
                beneficio.setVisible(true);
            }
            else{
                cbTurma.setSelectedIndex(0);
            }
        }
    }//GEN-LAST:event_btAvançarActionPerformed

    private void cbMesItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbMesItemStateChanged
        quantidadeDiasMes(cbMes.getSelectedItem().toString());
    }//GEN-LAST:event_cbMesItemStateChanged

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
    private javax.swing.JButton btAvançar;
    private javax.swing.JButton btCancelar;
    private javax.swing.JButton btRemoverBeneficioAPagar;
    private javax.swing.JComboBox cbMes;
    private javax.swing.JComboBox cbTurma;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel labelDiasLetivos;
    private javax.swing.JLabel labelMes;
    private javax.swing.JLabel labelTurma;
    private javax.swing.JList listBeneficiosCadastrados;
    private javax.swing.JList listBeneficiosParaPagar;
    private javax.swing.JPanel panelPagamento;
    private javax.swing.JSpinner spinnerDiasLetivos;
    // End of variables declaration//GEN-END:variables

    private void carregarComboBoxTurma() {
        listaTurma = new ArrayList();
        try {
            listaTurma = new TurmaDAO().listarTodos();
            for (Turma turma : listaTurma) {
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
    
    private void atualizarListaParaPagar() {
       DefaultListModel modeloListaBeneficio = new DefaultListModel();
        for (String beneficio : listaBeneficiosParaPagar) {
            modeloListaBeneficio.addElement(beneficio);
        }
        listBeneficiosParaPagar.setModel(modeloListaBeneficio);
    }

    private void adicionarListaParaPagar(Object beneficio) {
        listaBeneficiosParaPagar.add(beneficio.toString());
        atualizarListaParaPagar();
        removerBeneficioCadastrado();
    }

    private void removerBeneficioCadastrado() {
        listaBeneficio.remove(listBeneficiosCadastrados.getSelectedIndex());
        listBeneficiosCadastrados.setModel(atualizarList(listaBeneficio));
    }

    private List<Beneficio> buscarBeneficio() {
        listaBeneficio.clear();
        for (String beneficio : listaBeneficiosParaPagar) {
            try {
                listaBeneficio.add(new BeneficioDAO().recuperarPorNome(beneficio));
            } catch (SQLException ex) {
                Logger.getLogger(DlgGerarPagamento.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return listaBeneficio;
    }

    private void quantidadeDiasMes(String mes) {
        if (mes.equals("Fevereiro")) {
            modelo = new SpinnerNumberModel(1, 1, 28, 1);
        } else if (mes.equals("Janeiro") || mes.equals("Março")
                || mes.equals("Maio") || mes.equals("Julho")
                || mes.equals("Agosto") || mes.equals("Outubro") || mes.equals("Dezembro")) {
            modelo = new SpinnerNumberModel(1, 1, 31, 1);
        } else {
            modelo = new SpinnerNumberModel(1, 1, 30, 1);
        }
        spinnerDiasLetivos.setModel(modelo);
    }
}
