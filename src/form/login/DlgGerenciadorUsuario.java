/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package form.login;

import dao.LoginDAO;
import java.awt.FontMetrics;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.security.auth.login.LoginException;
import javax.swing.JOptionPane;
import model.Login;
import table.LoginColumnModel;
import table.LoginTableModel;

/**
 *
 * @author Acerpc
 */
public class DlgGerenciadorUsuario extends javax.swing.JDialog {

    /**
     * Creates new form DlgGerenciadorUsuario
     */
    public DlgGerenciadorUsuario(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        atualizarTabela();
    }

    List<Login> listaLogin = new ArrayList<>();
    Login login;
    LoginDAO loginDAO = new LoginDAO();

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableUsuarios = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        tfLogin = new javax.swing.JTextField();
        spinnerNivel = new javax.swing.JSpinner();
        pfSenha = new javax.swing.JPasswordField();
        jPanel3 = new javax.swing.JPanel();
        btCadastrar = new javax.swing.JButton();
        btAlterar = new javax.swing.JButton();
        btExcluir = new javax.swing.JButton();
        btCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Gerenciador de Usuários", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 12))); // NOI18N

        tableUsuarios.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tableUsuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Login", "Nível"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tableUsuarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableUsuariosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableUsuarios);

        jLabel1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel1.setText("Login");

        jLabel2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel2.setText("Senha");

        jLabel3.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel3.setText("Nível de acesso");

        tfLogin.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                tfLoginCaretUpdate(evt);
            }
        });

        spinnerNivel.setModel(new javax.swing.SpinnerNumberModel(1, 1, 3, 1));

        pfSenha.setEnabled(false);
        pfSenha.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                pfSenhaCaretUpdate(evt);
            }
        });

        jPanel3.setLayout(new java.awt.GridLayout(2, 2));

        btCadastrar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btCadastrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Cadastrar.png"))); // NOI18N
        btCadastrar.setText("Cadastrar");
        btCadastrar.setEnabled(false);
        btCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCadastrarActionPerformed(evt);
            }
        });
        jPanel3.add(btCadastrar);

        btAlterar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btAlterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Alterar.png"))); // NOI18N
        btAlterar.setText("Alterar");
        btAlterar.setEnabled(false);
        btAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAlterarActionPerformed(evt);
            }
        });
        jPanel3.add(btAlterar);

        btExcluir.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Remover.png"))); // NOI18N
        btExcluir.setText("Excluir");
        btExcluir.setEnabled(false);
        btExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btExcluirActionPerformed(evt);
            }
        });
        jPanel3.add(btExcluir);

        btCancelar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Cancelar.png"))); // NOI18N
        btCancelar.setText("Cancelar");
        btCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelarActionPerformed(evt);
            }
        });
        jPanel3.add(btCancelar);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(pfSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(spinnerNivel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(tfLogin)))
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(pfSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(spinnerNivel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCadastrarActionPerformed
        if (login == null) {
            try {
                login = new Login();
                getDados();
                validar();
                try {
                    if (loginDAO.cadastrar(login)) {
                        JOptionPane.showMessageDialog(this, "Cadastro de usuário efetuado com sucesso!");
                    } else {
                        JOptionPane.showMessageDialog(this, "Nome de usuário já existe!");
                    }
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(this, "ERRO: " + ex.getMessage());
                }
            } catch (LoginException ex) {
                JOptionPane.showMessageDialog(this, "ERRO: " + ex.getMessage());
            }
        }
        atualizarTabela();
        estadoInicial();
    }//GEN-LAST:event_btCadastrarActionPerformed

    private void btAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAlterarActionPerformed
        if (login == null) {
            login = new Login();
            getDados();
            try {
                loginDAO.atualizar(loginDAO.pesquisarPorNome(login.getUsuario()));
                    JOptionPane.showMessageDialog(this, "Usuário atualizado!");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "ERRO: " + ex.getMessage());
            }
        }
        atualizarTabela();
        estadoInicial();
    }//GEN-LAST:event_btAlterarActionPerformed

    private void btExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExcluirActionPerformed
        if (login == null) {
            login = new Login();
            getDados();
            try {
                if (loginDAO.remover(loginDAO.pesquisarPorNome(login.getUsuario()).getId())) {
                    JOptionPane.showMessageDialog(this, "Usuário removido!");
                } else {
                    JOptionPane.showMessageDialog(this, "Usuário não foi removido");
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "ERRO: " + ex.getMessage());
            }
        }
        atualizarTabela();
        estadoInicial();
    }//GEN-LAST:event_btExcluirActionPerformed

    private void btCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelarActionPerformed
        if (tfLogin.getText().isEmpty()) {
            this.dispose();
        } else {
            limparCampos();
        }
    }//GEN-LAST:event_btCancelarActionPerformed

    private void tfLoginCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_tfLoginCaretUpdate
        if (tfLogin.getText().isEmpty()) {
            pfSenha.setEnabled(false);
        } else {
            pfSenha.setEnabled(true);
        }
        habilitarBotaoCadastrar();
    }//GEN-LAST:event_tfLoginCaretUpdate

    private void pfSenhaCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_pfSenhaCaretUpdate
        habilitarBotaoCadastrar();
    }//GEN-LAST:event_pfSenhaCaretUpdate

    private void tableUsuariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableUsuariosMouseClicked
        if (evt.getClickCount() == 2) {
            int linhaSelecionada = this.tableUsuarios.getSelectedRow();
            String nomeUsuario = this.tableUsuarios.getValueAt(linhaSelecionada, 0).toString();
            recuperarDados(nomeUsuario);
            estadoAlterar();
        }
    }//GEN-LAST:event_tableUsuariosMouseClicked

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
            java.util.logging.Logger.getLogger(DlgGerenciadorUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DlgGerenciadorUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DlgGerenciadorUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DlgGerenciadorUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DlgGerenciadorUsuario dialog = new DlgGerenciadorUsuario(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btAlterar;
    private javax.swing.JButton btCadastrar;
    private javax.swing.JButton btCancelar;
    private javax.swing.JButton btExcluir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPasswordField pfSenha;
    private javax.swing.JSpinner spinnerNivel;
    private javax.swing.JTable tableUsuarios;
    private javax.swing.JTextField tfLogin;
    // End of variables declaration//GEN-END:variables

    private void atualizarTabela() {
        try {
            listaLogin = loginDAO.recuperarTodos();
            if (listaLogin != null) {
                tableUsuarios.setModel(new LoginTableModel(listaLogin));
                FontMetrics fm = tableUsuarios.getFontMetrics(tableUsuarios.getFont());
                tableUsuarios.setColumnModel(new LoginColumnModel(fm));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "ERRO: " + ex.getMessage());
        }
    }

    private void recuperarDados(String nome) {
        try {
            login = loginDAO.pesquisarPorNome(nome);
            tfLogin.setText(login.getUsuario());
            spinnerNivel.setValue(login.getNivel());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "ERRO: " + ex.getMessage());
        }
    }

    private void getDados() {
        try {
            login.setUsuario(tfLogin.getText());
            login.setSenha(criptografar(new String(pfSenha.getPassword())));
            login.setNivel(Integer.parseInt(spinnerNivel.getValue().toString()));
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException ex) {
            JOptionPane.showMessageDialog(this, "ERRO: " + ex.getMessage());
        }

    }

    public static String criptografar(String valor) throws NoSuchAlgorithmException, UnsupportedEncodingException {

        //Note que o Algoritmo de criptografia é fornecido por parâmetro.
        //Nesse caso 'MD5' poderia ser 'SHA1'.
        MessageDigest md = MessageDigest.getInstance("MD5");

        //A instância de MessageDigest foi atualizada com o valor da String 
        //fornecida como parâmetro, neste caso foi fornecida a codificação 
        //para obtenção dos bytes da String, mas esse parâmetro é opcional.
        md.update(valor.getBytes("UTF8"));

        //É nesse ponto que é gerado um array de bytes contendo o resultado 
        //da criptografia utilizando o Algoritmo fornecido.
        byte[] s = md.digest();

        //Como precisamos do hash em String precisamos executar os seguintes
        //três passos básicos para tal necessidade:
        BigInteger hash1 = new BigInteger(1, s);
        String hash = hash1.toString(16);
        while (hash.length() < 32) {
            hash = "0" + hash;
        }

        return hash;
    }

    private void limparCampos() {
        tfLogin.setText(null);
        pfSenha.setText(null);
        spinnerNivel.setValue(1);
        estadoInicial();
    }

    private void estadoInicial() {
        btCadastrar.setEnabled(false);
        btAlterar.setEnabled(false);
        btExcluir.setEnabled(false);
        btCancelar.setEnabled(true);

    }

    private void estadoAlterar() {
        btAlterar.setEnabled(true);
        btExcluir.setEnabled(true);
        btCancelar.setEnabled(true);
        btCadastrar.setEnabled(false);
    }

    private void habilitarBotaoCadastrar() {
        if (new String(pfSenha.getPassword()).isEmpty() || tfLogin.getText().isEmpty()) {
            btCadastrar.setEnabled(false);
        } else {
            btCadastrar.setEnabled(true);
        }
    }

    private void validar() throws LoginException {
        if (new String(pfSenha.getPassword()).isEmpty()) {
            throw new LoginException("Senha obrigatória!");
        }

        if (tfLogin.getText().isEmpty()) {
            throw new LoginException("Login obrigatório!");
        }

        if (tfLogin.getText().length() < 6) {
            throw new LoginException("O login deve conter no mínimo 6 caracteres.");
        }

        if (new String(pfSenha.getPassword()).length() < 8) {
            throw new LoginException("A senha deve conter no mínimo 8 caracteres.");
        }
    }
}
