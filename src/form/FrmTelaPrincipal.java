package form;

import form.pagamento.DlgGerarPagamento;
import dao.LoginDAO;
import form.login.DlgGerenciadorUsuario;
import form.login.FrmLogin;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.plaf.FontUIResource;
import model.Login;

/**
 *
 * @author Giseli e Keyve
 */
public class FrmTelaPrincipal extends javax.swing.JFrame implements ActionListener {
    
    public FrmTelaPrincipal() {
        timer = new Timer(500, this);
        timer.setRepeats(true);
        timer.start();
        UIManager.put("OptionPane.messageFont", new FontUIResource(new Font("Arial", Font.PLAIN, 18)));
        initComponents();
        this.setExtendedState(MAXIMIZED_BOTH);
    }
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy   "
            + "HH:mm");
    Timer timer;
    private int nivelUsuario;
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource().equals(timer)) {
            this.lbRelogio.setText(sdf.format(new Date(System.currentTimeMillis())));
            this.lbRelogio.setFont(new Font("Arial", Font.PLAIN, 24));
            this.lbRelogio.setForeground(Color.BLACK);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btGerenciadorCurso = new javax.swing.JButton();
        btGerenciadoOrientador = new javax.swing.JButton();
        btGerenciadorSupervisor = new javax.swing.JButton();
        btGerenciadorProfessor = new javax.swing.JButton();
        btGerenciadorAluno = new javax.swing.JButton();
        btGerenciadorTurma = new javax.swing.JButton();
        btGerenciadorBeneficio = new javax.swing.JButton();
        btEfetuarPagamento = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        lbRelogio = new javax.swing.JLabel();
        btSair = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        menuGerenciadores = new javax.swing.JMenu();
        menuItemGerenciadorAluno = new javax.swing.JMenuItem();
        menuItemGerenciadorCurso = new javax.swing.JMenuItem();
        menuItemGerenciadorOrientador = new javax.swing.JMenuItem();
        menuItemGerenciadorSupervisor = new javax.swing.JMenuItem();
        menuItemGerenciadorProfessor = new javax.swing.JMenuItem();
        menuItemGerenciadorBeneficio = new javax.swing.JMenuItem();
        menuItemEfetuarPagamento = new javax.swing.JMenuItem();
        menuGerenciadorUsuario = new javax.swing.JMenu();
        menuConsultas = new javax.swing.JMenu();
        menuLogout = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Software Gerenciador de Curso Profissionalizantes");

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 204), 2));

        btGerenciadorCurso.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btGerenciadorCurso.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Curso.png"))); // NOI18N
        btGerenciadorCurso.setText("Gerenciador De Curso          ");
        btGerenciadorCurso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btGerenciadorCursoActionPerformed(evt);
            }
        });

        btGerenciadoOrientador.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btGerenciadoOrientador.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Orientador.png"))); // NOI18N
        btGerenciadoOrientador.setText("Gerenciador De Orientador");
        btGerenciadoOrientador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btGerenciadoOrientadorActionPerformed(evt);
            }
        });

        btGerenciadorSupervisor.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btGerenciadorSupervisor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Supervisor.png"))); // NOI18N
        btGerenciadorSupervisor.setText("Gerenciador De Supervisor");
        btGerenciadorSupervisor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btGerenciadorSupervisorActionPerformed(evt);
            }
        });

        btGerenciadorProfessor.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btGerenciadorProfessor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Professor.png"))); // NOI18N
        btGerenciadorProfessor.setText("Gerenciador De Professor");
        btGerenciadorProfessor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btGerenciadorProfessorActionPerformed(evt);
            }
        });

        btGerenciadorAluno.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btGerenciadorAluno.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Aluno.png"))); // NOI18N
        btGerenciadorAluno.setText("Gerenciador de Alunos        ");
        btGerenciadorAluno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btGerenciadorAlunoActionPerformed(evt);
            }
        });

        btGerenciadorTurma.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btGerenciadorTurma.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Turma.png"))); // NOI18N
        btGerenciadorTurma.setText("Gerenciador de Turma        ");
        btGerenciadorTurma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btGerenciadorTurmaActionPerformed(evt);
            }
        });

        btGerenciadorBeneficio.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btGerenciadorBeneficio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Cofrinho-Beneficio-Cifrao.png"))); // NOI18N
        btGerenciadorBeneficio.setText("Gerenciar Benefício             ");
        btGerenciadorBeneficio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btGerenciadorBeneficioActionPerformed(evt);
            }
        });

        btEfetuarPagamento.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btEfetuarPagamento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Pagamento.png"))); // NOI18N
        btEfetuarPagamento.setText("Efetuar Pagamento                ");
        btEfetuarPagamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEfetuarPagamentoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btEfetuarPagamento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btGerenciadorCurso, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btGerenciadoOrientador, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btGerenciadorSupervisor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btGerenciadorProfessor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btGerenciadorAluno, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btGerenciadorTurma, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btGerenciadorBeneficio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btGerenciadorCurso, javax.swing.GroupLayout.DEFAULT_SIZE, 78, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btGerenciadoOrientador, javax.swing.GroupLayout.DEFAULT_SIZE, 78, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btGerenciadorSupervisor, javax.swing.GroupLayout.DEFAULT_SIZE, 78, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btGerenciadorProfessor, javax.swing.GroupLayout.DEFAULT_SIZE, 78, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btGerenciadorAluno, javax.swing.GroupLayout.DEFAULT_SIZE, 78, Short.MAX_VALUE)
                .addGap(3, 3, 3)
                .addComponent(btGerenciadorTurma, javax.swing.GroupLayout.DEFAULT_SIZE, 78, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btGerenciadorBeneficio, javax.swing.GroupLayout.DEFAULT_SIZE, 78, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btEfetuarPagamento, javax.swing.GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/IFSC.png"))); // NOI18N

        lbRelogio.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        lbRelogio.setText("Relógio");
        lbRelogio.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbRelogio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbRelogioMouseClicked(evt);
            }
        });

        btSair.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Sair.png"))); // NOI18N
        btSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSairActionPerformed(evt);
            }
        });

        menuGerenciadores.setText("Gerenciadores");
        menuGerenciadores.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        menuItemGerenciadorAluno.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        menuItemGerenciadorAluno.setText("Gerenciador de Aluno");
        menuItemGerenciadorAluno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemGerenciadorAlunoActionPerformed(evt);
            }
        });
        menuGerenciadores.add(menuItemGerenciadorAluno);

        menuItemGerenciadorCurso.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        menuItemGerenciadorCurso.setText("Gerenciador de Curso");
        menuItemGerenciadorCurso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemGerenciadorCursoActionPerformed(evt);
            }
        });
        menuGerenciadores.add(menuItemGerenciadorCurso);

        menuItemGerenciadorOrientador.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        menuItemGerenciadorOrientador.setText("Gerenciador de Orientador");
        menuItemGerenciadorOrientador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemGerenciadorOrientadorActionPerformed(evt);
            }
        });
        menuGerenciadores.add(menuItemGerenciadorOrientador);

        menuItemGerenciadorSupervisor.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        menuItemGerenciadorSupervisor.setText("Gerenciador de Supervisor");
        menuItemGerenciadorSupervisor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemGerenciadorSupervisorActionPerformed(evt);
            }
        });
        menuGerenciadores.add(menuItemGerenciadorSupervisor);

        menuItemGerenciadorProfessor.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        menuItemGerenciadorProfessor.setText("Gerenciador de Professor");
        menuItemGerenciadorProfessor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemGerenciadorProfessorActionPerformed(evt);
            }
        });
        menuGerenciadores.add(menuItemGerenciadorProfessor);

        menuItemGerenciadorBeneficio.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        menuItemGerenciadorBeneficio.setText("Gerenciador de Benefício");
        menuItemGerenciadorBeneficio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemGerenciadorBeneficioActionPerformed(evt);
            }
        });
        menuGerenciadores.add(menuItemGerenciadorBeneficio);

        menuItemEfetuarPagamento.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        menuItemEfetuarPagamento.setText("Efetuar Pagamento");
        menuItemEfetuarPagamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemEfetuarPagamentoActionPerformed(evt);
            }
        });
        menuGerenciadores.add(menuItemEfetuarPagamento);

        jMenuBar1.add(menuGerenciadores);

        menuGerenciadorUsuario.setText("Gerenciador de Usuários");
        menuGerenciadorUsuario.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        menuGerenciadorUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuGerenciadorUsuarioMouseClicked(evt);
            }
        });
        jMenuBar1.add(menuGerenciadorUsuario);

        menuConsultas.setText("Consultas");
        menuConsultas.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        menuConsultas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuConsultasMouseClicked(evt);
            }
        });
        jMenuBar1.add(menuConsultas);

        menuLogout.setText("Logout");
        menuLogout.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        menuLogout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuLogoutMouseClicked(evt);
            }
        });
        jMenuBar1.add(menuLogout);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 705, Short.MAX_VALUE)
                        .addComponent(lbRelogio)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btSair, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(31, 31, 31))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(122, 122, 122)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btSair, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(lbRelogio)
                                .addGap(14, 14, 14)))))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btGerenciadorCursoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btGerenciadorCursoActionPerformed
        DlgGerenciadorCurso gerenciadorCurso = new DlgGerenciadorCurso(this, true);
        gerenciadorCurso.setVisible(true);
    }//GEN-LAST:event_btGerenciadorCursoActionPerformed

    private void menuItemGerenciadorCursoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemGerenciadorCursoActionPerformed
        DlgGerenciadorCurso gerenciadorCurso = new DlgGerenciadorCurso(this, true);
        gerenciadorCurso.setVisible(true);
    }//GEN-LAST:event_menuItemGerenciadorCursoActionPerformed

    private void menuItemGerenciadorSupervisorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemGerenciadorSupervisorActionPerformed
        DlgGerenciadorSupervisor gerenciadorSupervisor = new DlgGerenciadorSupervisor(this, true);
        gerenciadorSupervisor.setVisible(true);
    }//GEN-LAST:event_menuItemGerenciadorSupervisorActionPerformed

    private void btGerenciadoOrientadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btGerenciadoOrientadorActionPerformed
        DlgGerenciadorOrientador gerenciadorOrientador = new DlgGerenciadorOrientador(this, true);
        gerenciadorOrientador.setVisible(true);
    }//GEN-LAST:event_btGerenciadoOrientadorActionPerformed

    private void menuItemGerenciadorOrientadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemGerenciadorOrientadorActionPerformed
        DlgGerenciadorOrientador gerenciadorOrientador = new DlgGerenciadorOrientador(this, true);
        gerenciadorOrientador.setVisible(true);
    }//GEN-LAST:event_menuItemGerenciadorOrientadorActionPerformed

    private void btGerenciadorSupervisorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btGerenciadorSupervisorActionPerformed
        DlgGerenciadorSupervisor gerenciadorSupervisor = new DlgGerenciadorSupervisor(this, true);
        gerenciadorSupervisor.setVisible(true);
    }//GEN-LAST:event_btGerenciadorSupervisorActionPerformed

    private void menuItemGerenciadorProfessorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemGerenciadorProfessorActionPerformed
        DlgGerenciadorProfessor gerenciadorProfessor = new DlgGerenciadorProfessor(this, true);
        gerenciadorProfessor.setVisible(true);
    }//GEN-LAST:event_menuItemGerenciadorProfessorActionPerformed

    private void btGerenciadorProfessorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btGerenciadorProfessorActionPerformed
        DlgGerenciadorProfessor gerenciadorProfessor = new DlgGerenciadorProfessor(this, true);
        gerenciadorProfessor.setVisible(true);
    }//GEN-LAST:event_btGerenciadorProfessorActionPerformed

    private void btSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSairActionPerformed
        int resposta = JOptionPane.showConfirmDialog(this, "Deseja sair?", "Aviso", JOptionPane.YES_NO_OPTION);
        if (resposta == 0) {
            try {
                new LoginDAO().setDesativado();
            } catch (SQLException ex) {
                Logger.getLogger(FrmTelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
            new FrmLogin().setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_btSairActionPerformed

    private void menuConsultasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuConsultasMouseClicked
        DlgMenuConsultas telaConsultas = new DlgMenuConsultas(this, true);
        telaConsultas.verificarNivel(nivelUsuario);
        telaConsultas.setVisible(true);
    }//GEN-LAST:event_menuConsultasMouseClicked

    private void btGerenciadorAlunoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btGerenciadorAlunoActionPerformed
        DlgGerenciadorAluno gerenciadorAluno = new DlgGerenciadorAluno(this, true);
        gerenciadorAluno.setVisible(true);
    }//GEN-LAST:event_btGerenciadorAlunoActionPerformed

    private void btGerenciadorTurmaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btGerenciadorTurmaActionPerformed
        DlgGerenciadorTurma gerenciadorTurma = new DlgGerenciadorTurma(this, true);
        gerenciadorTurma.setVisible(true);
    }//GEN-LAST:event_btGerenciadorTurmaActionPerformed

    private void lbRelogioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbRelogioMouseClicked
        JOptionPane.showMessageDialog(this, "Esperamos que tenha um ótimo dia!");
    }//GEN-LAST:event_lbRelogioMouseClicked

    private void btGerenciadorBeneficioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btGerenciadorBeneficioActionPerformed
        new DlgGerenciadorBeneficio(this, rootPaneCheckingEnabled).setVisible(true);
    }//GEN-LAST:event_btGerenciadorBeneficioActionPerformed

    private void menuItemGerenciadorBeneficioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemGerenciadorBeneficioActionPerformed
        new DlgGerenciadorBeneficio(this, rootPaneCheckingEnabled).setVisible(true);
    }//GEN-LAST:event_menuItemGerenciadorBeneficioActionPerformed

    private void btEfetuarPagamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEfetuarPagamentoActionPerformed
        new DlgGerarPagamento(this, rootPaneCheckingEnabled).setVisible(true);
    }//GEN-LAST:event_btEfetuarPagamentoActionPerformed

    private void menuItemEfetuarPagamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemEfetuarPagamentoActionPerformed
        btEfetuarPagamentoActionPerformed(evt);
    }//GEN-LAST:event_menuItemEfetuarPagamentoActionPerformed

    private void menuItemGerenciadorAlunoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemGerenciadorAlunoActionPerformed
        btGerenciadorAlunoActionPerformed(evt);
    }//GEN-LAST:event_menuItemGerenciadorAlunoActionPerformed

    private void menuGerenciadorUsuarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuGerenciadorUsuarioMouseClicked
        new DlgGerenciadorUsuario(this, rootPaneCheckingEnabled).setVisible(true);
    }//GEN-LAST:event_menuGerenciadorUsuarioMouseClicked

    private void menuLogoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuLogoutMouseClicked
        int resposta = JOptionPane.showConfirmDialog(this, "Deseja sair?", "Aviso", JOptionPane.YES_NO_OPTION);
        if (resposta == 0) {
            new FrmLogin().setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_menuLogoutMouseClicked
    
    public static void main(String args[]) {

        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Liquid".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmTelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmTelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmTelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmTelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmTelaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btEfetuarPagamento;
    private javax.swing.JButton btGerenciadoOrientador;
    private javax.swing.JButton btGerenciadorAluno;
    private javax.swing.JButton btGerenciadorBeneficio;
    private javax.swing.JButton btGerenciadorCurso;
    private javax.swing.JButton btGerenciadorProfessor;
    private javax.swing.JButton btGerenciadorSupervisor;
    private javax.swing.JButton btGerenciadorTurma;
    private javax.swing.JButton btSair;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbRelogio;
    private javax.swing.JMenu menuConsultas;
    private javax.swing.JMenu menuGerenciadorUsuario;
    private javax.swing.JMenu menuGerenciadores;
    private javax.swing.JMenuItem menuItemEfetuarPagamento;
    private javax.swing.JMenuItem menuItemGerenciadorAluno;
    private javax.swing.JMenuItem menuItemGerenciadorBeneficio;
    private javax.swing.JMenuItem menuItemGerenciadorCurso;
    private javax.swing.JMenuItem menuItemGerenciadorOrientador;
    private javax.swing.JMenuItem menuItemGerenciadorProfessor;
    private javax.swing.JMenuItem menuItemGerenciadorSupervisor;
    private javax.swing.JMenu menuLogout;
    // End of variables declaration//GEN-END:variables
public void verificarNivel(int nivel) {
        if (nivel == 1) {
            menuGerenciadorUsuario.setVisible(true);
            this.nivelUsuario = nivel;
        }
        if (nivel == 2) {
            menuGerenciadorUsuario.setVisible(false);
            this.nivelUsuario = nivel;
        }
    }
}
