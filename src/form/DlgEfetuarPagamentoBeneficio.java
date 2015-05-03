/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package form;

import com.itextpdf.text.DocumentException;
import dao.AlunoDAO;
import dao.LoginDAO;
import dao.PagamentoDAO;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import model.Aluno;
import model.Beneficio;
import model.DadosEspecificos;
import model.Login;
import model.Pagamento;
import model.Turma;
import pdf.GeradorPDF;
import table.PagamentoTableModel;

/**
 *
 * @author Acerpc
 */
public class DlgEfetuarPagamentoBeneficio extends javax.swing.JDialog {

    private List<Aluno> listaAlunos;
    private PagamentoTableModel pagamentoTable;
    private Pagamento pagamentoFinal;
    private List<Beneficio> listaBeneficio;
    private Turma turma = new Turma();
    private Pagamento pagamento = new Pagamento();
    private PagamentoTableModel pagamentoModel = new PagamentoTableModel();
    private Login login;
    private boolean consulta;
    private List<Aluno> listaAlunosPagos;

    /**
     * Creates new form DlgEfetuarPagamentoBeneficio
     */
    public DlgEfetuarPagamentoBeneficio(java.awt.Frame parent, boolean modal, boolean isConsulta) {
        super(parent, modal);
        initComponents();
        consulta = isConsulta;
        if (isConsulta) {
            btSalvar.setEnabled(false);
            btCancelar.setText("Voltar");
            btCancelar.setIcon(new ImageIcon("src/icon/Voltar.png"));
            btGerarRelatorio.setEnabled(false);
        } else {
            btSalvar.setEnabled(true);
            btCancelar.setText("Cancelar");
            btCancelar.setIcon(new ImageIcon("src/icon/Cancelar.png"));
            btGerarRelatorio.setEnabled(false);
        }

        tbPagamentoBeneficio.addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
                if (tbPagamentoBeneficio.getRowCount() > 0) {
                    int linha = tbPagamentoBeneficio.getSelectedRow();
                    int faltas = Integer.parseInt(tbPagamentoBeneficio.getValueAt(linha, 6).toString());
                    int dias = pagamento.getDiasLetivos() - faltas;
                    if (dias < 0) {
                        tbPagamentoBeneficio.setValueAt(0.0, linha, 7);
                        tbPagamentoBeneficio.setValueAt(pagamento.getDiasLetivos(), linha, 6);
                    } else {
                        tbPagamentoBeneficio.setValueAt(calcularValorBeneficio(dias), linha, 7);
                    }
                    tbPagamentoBeneficio.updateUI();
                    calcularTotal();
                }
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelGerarPagamento = new javax.swing.JPanel();
        labelOrientador = new javax.swing.JLabel();
        labelTurma = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbPagamentoBeneficio = new javax.swing.JTable();
        labelTotalPagar = new javax.swing.JLabel();
        tfTotalAPagar = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        btSalvar = new javax.swing.JButton();
        btGerarRelatorio = new javax.swing.JButton();
        btCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        panelGerarPagamento.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Gerar Pagamento de Benefício", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 18), new java.awt.Color(0, 102, 204))); // NOI18N

        labelOrientador.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        labelOrientador.setText("Orientador");

        labelTurma.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        labelTurma.setText("Turma");

        tbPagamentoBeneficio.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null,  new Boolean(true)},
                {null, null, null, null, null, null, null, null,  new Boolean(true)},
                {null, null, null, null, null, null, null, null,  new Boolean(true)},
                {null, null, null, null, null, null, null, null,  new Boolean(true)}
            },
            new String [] {
                "CPF", "Nome", "Status", "Banco", "Agência", "Conta", "Faltas", "Valor a pagar", "Pagar"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Double.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, true, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbPagamentoBeneficio.getTableHeader().setReorderingAllowed(false);
        tbPagamentoBeneficio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbPagamentoBeneficioMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbPagamentoBeneficio);
        if (tbPagamentoBeneficio.getColumnModel().getColumnCount() > 0) {
            tbPagamentoBeneficio.getColumnModel().getColumn(0).setResizable(false);
            tbPagamentoBeneficio.getColumnModel().getColumn(1).setResizable(false);
            tbPagamentoBeneficio.getColumnModel().getColumn(2).setResizable(false);
            tbPagamentoBeneficio.getColumnModel().getColumn(3).setResizable(false);
            tbPagamentoBeneficio.getColumnModel().getColumn(4).setResizable(false);
            tbPagamentoBeneficio.getColumnModel().getColumn(5).setResizable(false);
        }

        labelTotalPagar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        labelTotalPagar.setText("Total a pagar");
        labelTotalPagar.setToolTipText("");

        tfTotalAPagar.setEditable(false);

        jPanel2.setLayout(new java.awt.GridLayout(1, 0));

        btSalvar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btSalvar.setText("Salvar");
        btSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSalvarActionPerformed(evt);
            }
        });
        jPanel2.add(btSalvar);

        btGerarRelatorio.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btGerarRelatorio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/MiniImpressora.png"))); // NOI18N
        btGerarRelatorio.setText("Gerar Relatório");
        btGerarRelatorio.setEnabled(false);
        btGerarRelatorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btGerarRelatorioActionPerformed(evt);
            }
        });
        jPanel2.add(btGerarRelatorio);

        btCancelar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Cancelar.png"))); // NOI18N
        btCancelar.setText("Cancelar");
        btCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelarActionPerformed(evt);
            }
        });
        jPanel2.add(btCancelar);

        javax.swing.GroupLayout panelGerarPagamentoLayout = new javax.swing.GroupLayout(panelGerarPagamento);
        panelGerarPagamento.setLayout(panelGerarPagamentoLayout);
        panelGerarPagamentoLayout.setHorizontalGroup(
            panelGerarPagamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(panelGerarPagamentoLayout.createSequentialGroup()
                .addGroup(panelGerarPagamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelGerarPagamentoLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(labelOrientador)
                        .addGap(18, 18, 18)
                        .addComponent(labelTurma)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(panelGerarPagamentoLayout.createSequentialGroup()
                        .addComponent(labelTotalPagar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfTotalAPagar, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 68, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        panelGerarPagamentoLayout.setVerticalGroup(
            panelGerarPagamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelGerarPagamentoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelGerarPagamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelOrientador)
                    .addComponent(labelTurma))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 422, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelGerarPagamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelGerarPagamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(labelTotalPagar)
                        .addComponent(tfTotalAPagar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelGerarPagamento, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addComponent(panelGerarPagamento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btGerarRelatorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btGerarRelatorioActionPerformed
        DlgDadosEspecificosRelatorios dados = new DlgDadosEspecificosRelatorios(null, rootPaneCheckingEnabled);
        dados.setVisible(true);
        DadosEspecificos dadosEspecificos = dados.pegarDadosEspecificos();
        if (dadosEspecificos == null) {
            return;
        }
        try {
            new GeradorPDF().createPdf(dadosEspecificos.getCaminho(), pagamentoFinal, dadosEspecificos);
        } catch (IOException | DocumentException ex) {
            Logger.getLogger(DlgEfetuarPagamentoBeneficio.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }
        JOptionPane.showMessageDialog(this, "Relatório gerado com sucesso");
        this.dispose();
    }//GEN-LAST:event_btGerarRelatorioActionPerformed

    private void btCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btCancelarActionPerformed

    private void btSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSalvarActionPerformed
        List<Aluno> alunos = new ArrayList<>();
        try {
            login = new LoginDAO().pesquisarAtivo();
        } catch (SQLException ex) {
            Logger.getLogger(DlgEfetuarPagamentoBeneficio.class.getName()).log(Level.SEVERE, null, ex);
        }
        for (int linha = 0; linha < tbPagamentoBeneficio.getRowCount(); linha++) {
            if (listaAlunos.get(linha).isRecece()) {
                listaAlunos.get(linha).setFaltas(
                        Integer.parseInt(tbPagamentoBeneficio.getValueAt(linha, 6).toString()));
                listaAlunos.get(linha).setValorRecebido(
                        Double.parseDouble(tbPagamentoBeneficio.getValueAt(linha, 7).toString()));
                listaAlunos.get(linha).setValorDescontado(listaBeneficio);
                alunos.add(listaAlunos.get(linha));
            }
        }
        if (alunos.size() < 1) {
            JOptionPane.showMessageDialog(this, "Favor verificar se há alunos selecionados", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }
        pagamentoFinal = new Pagamento(alunos, listaBeneficio,
                Double.parseDouble(tfTotalAPagar.getText().replace("RS", "")), pagamento.getDiasLetivos(),
                pagamento.getMes(), turma, login);
        try {
            new PagamentoDAO().inserir(pagamentoFinal);
        } catch (SQLException ex) {
            Logger.getLogger(DlgEfetuarPagamentoBeneficio.class
                    .getName()).log(Level.SEVERE, null, ex);
            return;
        }
        btSalvar.setEnabled(false);
        JOptionPane.showMessageDialog(this, "Informações salvas com sucesso!");
        btGerarRelatorio.setEnabled(true);
    }//GEN-LAST:event_btSalvarActionPerformed

    private void tbPagamentoBeneficioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbPagamentoBeneficioMouseClicked
        int row;
        if (tbPagamentoBeneficio.getSelectedColumn() == 8) {
            row = tbPagamentoBeneficio.getSelectedRow();
            Object o = tbPagamentoBeneficio.getValueAt(row, 8);
            if ((Boolean) o == false) {
                tbPagamentoBeneficio.setValueAt(0, row, 6);
                tbPagamentoBeneficio.setValueAt(0.0, row, 7);
            } else {
                tbPagamentoBeneficio.setValueAt(calcularValorBeneficio(
                        pagamento.getDiasLetivos() - Integer.parseInt(tbPagamentoBeneficio.getValueAt(row, 6).toString())), row, 7);
            }
            calcularTotal();
            tbPagamentoBeneficio.updateUI();
        }
    }//GEN-LAST:event_tbPagamentoBeneficioMouseClicked

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
            java.util.logging.Logger.getLogger(DlgEfetuarPagamentoBeneficio.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DlgEfetuarPagamentoBeneficio.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DlgEfetuarPagamentoBeneficio.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DlgEfetuarPagamentoBeneficio.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DlgEfetuarPagamentoBeneficio dialog = new DlgEfetuarPagamentoBeneficio(new javax.swing.JFrame(), true, false);
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

    public JTable getTbPagamentoBeneficio() {
        return tbPagamentoBeneficio;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCancelar;
    private javax.swing.JButton btGerarRelatorio;
    private javax.swing.JButton btSalvar;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelOrientador;
    private javax.swing.JLabel labelTotalPagar;
    private javax.swing.JLabel labelTurma;
    private javax.swing.JPanel panelGerarPagamento;
    private javax.swing.JTable tbPagamentoBeneficio;
    private javax.swing.JTextField tfTotalAPagar;
    // End of variables declaration//GEN-END:variables

    public void carregarLabel(Turma turma) {
        labelTurma.setText("Turma: " + turma.getNome());
        labelOrientador.setText("Orientador: " + turma.getOrientador().getNome());
    }

    public boolean carregarDados(Turma turmaParaPagar, List<Beneficio> beneficios, Pagamento pgmeto) {
        turma = turmaParaPagar;
        listaBeneficio = beneficios;
        pagamento = pgmeto;
        carregarLabel(turma);
        if (buscarTodosOsAlunos(turma)) {
            atualizarTabela();
            if (consulta) {
                getDadosBanco();
            } else {
                calcularTotalPorAluno(pagamento.getDiasLetivos());
                calcularTotal();
            }
        } else {
            JOptionPane.showMessageDialog(DlgEfetuarPagamentoBeneficio.this, "Nenhum aluno encontrado na turma " + turma.getNome(),
                    "Erro!", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        return true;
    }

    private void calcularTotalPorAluno(int diasLetivos) {
        for (int linha = 0; linha < listaAlunos.size(); linha++) {
            if ((Boolean) tbPagamentoBeneficio.getValueAt(linha, 8)) {
                tbPagamentoBeneficio.setValueAt(calcularValorBeneficio(diasLetivos), linha, 7);
            }
        }
    }

    private void atualizarTabela() {
        pagamentoTable = new PagamentoTableModel((ArrayList<Aluno>) listaAlunos);
        tbPagamentoBeneficio.setModel(pagamentoTable);
    }

    private boolean buscarTodosOsAlunos(Turma turma) {
        try {
            listaAlunos = new AlunoDAO().buscarPorTurma(turma.getId());

        } catch (SQLException ex) {
            Logger.getLogger(DlgEfetuarPagamentoBeneficio.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        if (listaAlunos.isEmpty()) {
            return false;
        }
        return true;
    }

    private double calcularValorBeneficio(int diasLetivos) {
        double valorPorAluno = 0;
        for (Beneficio beneficio : listaBeneficio) {
            valorPorAluno += (beneficio.getValor() * diasLetivos);
        }
        return valorPorAluno;
    }

    private void calcularTotal() {
        double totalAPagar = 0.0;
        for (int linha = 0; linha < listaAlunos.size(); linha++) {
            totalAPagar += Double.parseDouble(tbPagamentoBeneficio.getValueAt(linha, 7).toString());
        }
        tfTotalAPagar.setText("RS" + totalAPagar);
    }

    private void getDadosBanco() {
        try {
            listaAlunosPagos = new PagamentoDAO().buscarAlunosPagos(pagamento.getId());
        } catch (SQLException ex) {
            Logger.getLogger(DlgEfetuarPagamentoBeneficio.class.getName()).log(Level.SEVERE, null, ex);
        }
        for (int i = 0; i < listaAlunos.size(); i++) {
            for(Aluno aluno : listaAlunosPagos)
                if (listaAlunos.get(i).getId() == aluno.getId()) {
                    tbPagamentoBeneficio.setValueAt(aluno.getFaltas(), i, 6);
                    tbPagamentoBeneficio.setValueAt(aluno.getValorRecebido(), i, 7);
                    tbPagamentoBeneficio.setValueAt(true, i, 8);
                }else{
                    tbPagamentoBeneficio.setValueAt(false, i, 8);
                }
        }
        tfTotalAPagar.setText("RS " + pagamento.getValorAPagarPorTurma());
    }
}
