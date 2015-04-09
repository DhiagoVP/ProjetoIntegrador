package form;

import com.mysql.jdbc.StringUtils;
import dao.OrientadorDAO;
import exceptions.OrientadorException;
import java.sql.SQLException;
import java.text.ParseException;
import javax.swing.JOptionPane;
import model.ContaBancaria;
import model.Endereco;
import model.Orientador;

/**
 *
 * @author Giseli e Keyve
 */
public class DlgGerenciadorOrientador extends javax.swing.JDialog {

    public DlgGerenciadorOrientador(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }
    DlgConsultarOrientador janelaConsulta = new DlgConsultarOrientador(null, true);
    private final OrientadorDAO orientadorDAO = new OrientadorDAO();
    private Orientador orientador;
    private ValidadorDeTeclas validar;

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lbNome = new javax.swing.JLabel();
        tfNome = new javax.swing.JTextField();
        lbTitulacao = new javax.swing.JLabel();
        cbTitulacao = new javax.swing.JComboBox();
        lbCpf = new javax.swing.JLabel();
        lbRg = new javax.swing.JLabel();
        lbDataEntrada = new javax.swing.JLabel();
        dtcDataEntrada = new com.toedter.calendar.JDateChooser();
        lbTelefone = new javax.swing.JLabel();
        ftfTelefone = new javax.swing.JFormattedTextField();
        lbEmail = new javax.swing.JLabel();
        tfEmail = new javax.swing.JTextField();
        lbStatus = new javax.swing.JLabel();
        jChStatus = new javax.swing.JCheckBox();
        jSeparator1 = new javax.swing.JSeparator();
        panelDadosBancarios = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        tfBanco = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        tfAgencia = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        tfConta = new javax.swing.JTextField();
        panelEndereco = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        tfRua = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        tfNumero = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        tfBairro = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        tfCidade = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        cbEstado = new javax.swing.JComboBox();
        ftfCpf = new javax.swing.JFormattedTextField();
        ftfRg = new javax.swing.JFormattedTextField();
        panelBotoes = new javax.swing.JPanel();
        btCadastrar = new javax.swing.JButton();
        btConsultar = new javax.swing.JButton();
        btAlterar = new javax.swing.JButton();
        btExcluir = new javax.swing.JButton();
        btCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Gerenciador de Orientadores");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Dados Orientador", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Arial", 1, 18), new java.awt.Color(0, 102, 204))); // NOI18N
        jPanel1.setToolTipText("");

        lbNome.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbNome.setText("Nome");

        tfNome.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        tfNome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfNomeKeyTyped(evt);
            }
        });

        lbTitulacao.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbTitulacao.setText("Titulação");

        cbTitulacao.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cbTitulacao.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Técnico", "Graduação", "Especialização", "MBA", "Mestrado", "Doutorado" }));

        lbCpf.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbCpf.setText("CPF");

        lbRg.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbRg.setText("RG");

        lbDataEntrada.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbDataEntrada.setText("Data de Entrada");

        dtcDataEntrada.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        dtcDataEntrada.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                dtcDataEntradaKeyTyped(evt);
            }
        });

        lbTelefone.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbTelefone.setText("Telefone");

        try {
            ftfTelefone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        ftfTelefone.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        ftfTelefone.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                ftfTelefoneKeyTyped(evt);
            }
        });

        lbEmail.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbEmail.setText("E-mail");

        tfEmail.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        lbStatus.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbStatus.setText("Status");

        jChStatus.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jChStatus.setText("Inativo");
        jChStatus.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jChStatusStateChanged(evt);
            }
        });

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        panelDadosBancarios.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Dados Bancarios", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 14), new java.awt.Color(0, 102, 255))); // NOI18N

        jLabel6.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel6.setText("Banco");

        tfBanco.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel7.setText("Agencia");

        tfAgencia.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        tfAgencia.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfAgenciaKeyTyped(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel8.setText("Conta");

        tfConta.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        tfConta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfContaKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout panelDadosBancariosLayout = new javax.swing.GroupLayout(panelDadosBancarios);
        panelDadosBancarios.setLayout(panelDadosBancariosLayout);
        panelDadosBancariosLayout.setHorizontalGroup(
            panelDadosBancariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDadosBancariosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelDadosBancariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel7)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelDadosBancariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelDadosBancariosLayout.createSequentialGroup()
                        .addComponent(tfAgencia, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfConta, javax.swing.GroupLayout.DEFAULT_SIZE, 217, Short.MAX_VALUE))
                    .addComponent(tfBanco))
                .addContainerGap())
        );
        panelDadosBancariosLayout.setVerticalGroup(
            panelDadosBancariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDadosBancariosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelDadosBancariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfBanco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelDadosBancariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(tfAgencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(tfConta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelEndereco.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Endereço", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 14), new java.awt.Color(0, 102, 255))); // NOI18N

        jLabel9.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel9.setText("Cidade");

        tfRua.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel5.setText("Numero");

        tfNumero.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        tfNumero.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfNumeroKeyTyped(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel10.setText("Rua");

        tfBairro.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        jLabel13.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel13.setText("Bairro");

        tfCidade.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        jLabel14.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel14.setText("Estado");

        cbEstado.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cbEstado.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "AC", "AL", "AM", "AP", "BA", "CE", "DF", "GO", "ES", "MA", "MG", "MS", "MT", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RO", "RR", "RS", "SE", "SC", "SP", "TO" }));
        cbEstado.setToolTipText("");

        javax.swing.GroupLayout panelEnderecoLayout = new javax.swing.GroupLayout(panelEndereco);
        panelEndereco.setLayout(panelEnderecoLayout);
        panelEnderecoLayout.setHorizontalGroup(
            panelEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelEnderecoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10)
                    .addComponent(jLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfCidade)
                    .addComponent(tfRua)
                    .addComponent(tfBairro))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(cbEstado, 0, 78, Short.MAX_VALUE)
                    .addComponent(tfNumero))
                .addGap(20, 20, 20))
        );
        panelEnderecoLayout.setVerticalGroup(
            panelEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelEnderecoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel14)
                    .addComponent(cbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel5)
                    .addComponent(tfNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfRua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(tfBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        try {
            ftfCpf.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        ftfCpf.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        ftfCpf.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                ftfCpfKeyTyped(evt);
            }
        });

        try {
            ftfRg.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#.###.###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        ftfRg.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        ftfRg.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                ftfRgKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbRg)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(lbDataEntrada)
                        .addComponent(lbTelefone, javax.swing.GroupLayout.Alignment.TRAILING))
                    .addComponent(lbCpf)
                    .addComponent(lbTitulacao)
                    .addComponent(lbNome)
                    .addComponent(lbEmail))
                .addGap(0, 0, 0)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbTitulacao, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(dtcDataEntrada, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tfEmail, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(ftfTelefone)
                    .addComponent(ftfCpf)
                    .addComponent(ftfRg)
                    .addComponent(tfNome, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(307, 307, 307)
                        .addComponent(lbStatus)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jChStatus))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(panelDadosBancarios, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(panelEndereco, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(0, 0, 0))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbNome))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbTitulacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbTitulacao))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbCpf)
                    .addComponent(ftfCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbRg)
                    .addComponent(ftfRg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbDataEntrada)
                    .addComponent(dtcDataEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbTelefone)
                    .addComponent(ftfTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbEmail))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jSeparator1))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jChStatus)
                            .addComponent(lbStatus))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panelDadosBancarios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11)
                        .addComponent(panelEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {lbCpf, lbNome, lbRg, lbTitulacao});

        panelBotoes.setLayout(new java.awt.GridLayout(1, 0));

        btCadastrar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btCadastrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/cadastrar.png"))); // NOI18N
        btCadastrar.setText("Cadastrar");
        btCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCadastrarActionPerformed(evt);
            }
        });
        panelBotoes.add(btCadastrar);

        btConsultar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btConsultar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/consultar.png"))); // NOI18N
        btConsultar.setText("Consultar");
        btConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btConsultarActionPerformed(evt);
            }
        });
        panelBotoes.add(btConsultar);

        btAlterar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btAlterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/alterar.png"))); // NOI18N
        btAlterar.setText("Alterar");
        btAlterar.setEnabled(false);
        btAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAlterarActionPerformed(evt);
            }
        });
        panelBotoes.add(btAlterar);

        btExcluir.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/remover.png"))); // NOI18N
        btExcluir.setText("Excluir");
        btExcluir.setEnabled(false);
        btExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btExcluirActionPerformed(evt);
            }
        });
        panelBotoes.add(btExcluir);

        btCancelar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Cancelar.png"))); // NOI18N
        btCancelar.setText("Cancelar");
        btCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelarActionPerformed(evt);
            }
        });
        panelBotoes.add(btCancelar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelBotoes, javax.swing.GroupLayout.PREFERRED_SIZE, 954, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelBotoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCadastrarActionPerformed
        if (verificarCamposVazios()) {
            int resultado = JOptionPane.showConfirmDialog(this, "Há campos vazios. Deseja continuar?", "Aviso!", JOptionPane.YES_NO_OPTION);
            if (resultado != JOptionPane.YES_OPTION) {
                return;
            }
        }
        try {
            if (orientador == null) {
                orientador = new Orientador();
                this.getDados();
                if (orientadorDAO.cadastrar(orientador)) {
                    janelaConsulta.atualizarTabela("SELECT * FROM Orientador o, Endereco e, ContaBancaria cb "
                            + "WHERE o.idEndereco = e.idEndereco AND o.idContaBancaria = cb.idContaBancaria;");
                    JOptionPane.showMessageDialog(this, "Este orientador foi inserido com sucesso!");
                    this.limparCampos();
                } else {
                    JOptionPane.showMessageDialog(this, "Já existe orientador cadastrado!",
                            "Cadastro de  Orientador", JOptionPane.ERROR_MESSAGE);
                    orientador = null;
                }
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "ERRO: " + ex.getMessage());
        } catch (ParseException | IllegalArgumentException | OrientadorException ex) {
            JOptionPane.showMessageDialog(this, "ERRO!: " + ex.getMessage());
        }
    }//GEN-LAST:event_btCadastrarActionPerformed

    private void jChStatusStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jChStatusStateChanged
        if (this.jChStatus.isSelected()) {
            tratarCampos(false);
        } else {
            tratarCampos(true);
        }
    }//GEN-LAST:event_jChStatusStateChanged

    private void btConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btConsultarActionPerformed
        this.setVisible(false);
        janelaConsulta.setVisible(true);
    }//GEN-LAST:event_btConsultarActionPerformed

    private void btAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAlterarActionPerformed
        if (orientador != null) {
            try {
                this.getDados();
                orientadorDAO.atualizar(orientador);
                janelaConsulta.atualizarTabela("SELECT * FROM Orientador o, Endereco e, ContaBancaria cb "
                        + "WHERE o.idEndereco = e.idEndereco AND o.idContaBancaria = cb.idContaBancaria;");
                JOptionPane.showMessageDialog(this, "Orientador atualizado com sucesso!!");
                this.limparCampos();
                this.tratarControles(false);
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "ERRO!: " + ex.getMessage());
            } catch (ParseException | IllegalArgumentException | OrientadorException ex) {
                JOptionPane.showMessageDialog(this, "ERRO!: " + ex.getMessage());
            }
        }
    }//GEN-LAST:event_btAlterarActionPerformed

    private void btExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExcluirActionPerformed
        if (orientador != null) {
            try {
                orientadorDAO.remover(orientador);
                janelaConsulta.atualizarTabela("SELECT * FROM Orientador o, Endereco e, ContaBancaria cb "
                        + "WHERE o.idEndereco = e.idEndereco AND o.idContaBancaria = cb.idContaBancaria;");
                JOptionPane.showMessageDialog(this, "Este orientador foi removido com sucesso!");
                this.limparCampos();
                this.tratarControles(false);
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "ERRO! " + ex.getMessage());
            }
        }
    }//GEN-LAST:event_btExcluirActionPerformed

    private void btCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelarActionPerformed
        if (tfNome.getText().isEmpty()){
            this.dispose();
        } else {
            this.limparCampos();
            this.tratarControles(false);
        }    
    }//GEN-LAST:event_btCancelarActionPerformed

    private void ftfCpfKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ftfCpfKeyTyped
        validar.validarSomenteNumeros(evt);
    }//GEN-LAST:event_ftfCpfKeyTyped

    private void ftfTelefoneKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ftfTelefoneKeyTyped
        validar.validarSomenteNumeros(evt);
    }//GEN-LAST:event_ftfTelefoneKeyTyped

    private void dtcDataEntradaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_dtcDataEntradaKeyTyped
        validar.validarSomenteNumeros(evt);
    }//GEN-LAST:event_dtcDataEntradaKeyTyped

    private void tfAgenciaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfAgenciaKeyTyped
        validar.validarSomenteNumeros(evt);
    }//GEN-LAST:event_tfAgenciaKeyTyped

    private void tfContaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfContaKeyTyped
        validar.validarSomenteNumeros(evt);
    }//GEN-LAST:event_tfContaKeyTyped

    private void tfNumeroKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfNumeroKeyTyped
        validar.validarSomenteNumeros(evt);
    }//GEN-LAST:event_tfNumeroKeyTyped

    private void ftfRgKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ftfRgKeyTyped
        validar.validarSomenteNumeros(evt);
    }//GEN-LAST:event_ftfRgKeyTyped

    private void tfNomeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfNomeKeyTyped
        validar.validarSomenteLetras(evt);
    }//GEN-LAST:event_tfNomeKeyTyped

    private void setDados() {
        this.tfNome.setText(orientador.getNome());
        this.jChStatus.setSelected(orientador.isStatus());
        this.ftfCpf.setText(orientador.getCpf());
        this.ftfRg.setText(orientador.getRg());
        this.cbTitulacao.setSelectedItem(orientador.getTitulacao());
        this.dtcDataEntrada.setDate(orientador.getDataEntrada());
        this.ftfTelefone.setText(orientador.getTelefone());
        this.tfEmail.setText(orientador.getEmail());
        this.cbEstado.setSelectedItem(orientador.getEndereco().getEstado());
        this.tfCidade.setText(orientador.getEndereco().getCidade());
        this.tfBairro.setText(orientador.getEndereco().getBairro());
        this.tfRua.setText(orientador.getEndereco().getRua());
        this.tfNumero.setText(Long.toString(orientador.getEndereco().getNumero()));
        this.tfBanco.setText(orientador.getContaBancaria().getNomeBanco());
        this.tfAgencia.setText(Integer.toString(orientador.getContaBancaria().getAgencia()));
        this.tfConta.setText(Integer.toString(orientador.getContaBancaria().getNumeroConta()));
    }

    private void getDados() throws ParseException, OrientadorException {
        if (!tfNome.getText().isEmpty()) {
            orientador.setNome(tfNome.getText());
            orientador.setCpf(ftfCpf.getText());
            orientador.setRg(ftfRg.getText());
            orientador.setDataEntrada(dtcDataEntrada.getDate());
            orientador.setTitulacao(cbTitulacao.getSelectedItem().toString());
            orientador.setStatus(jChStatus.isSelected());
            orientador.setTelefone(ftfTelefone.getText());
            orientador.setEmail(tfEmail.getText());
            orientador.setEndereco(
                    new Endereco(
                            tfRua.getText(),
                            StringUtils.isNullOrEmpty(tfNumero.getText()) ? 0 : Integer.parseInt(tfNumero.getText()),
                            tfBairro.getText(),
                            cbEstado.getSelectedItem().toString(),
                            tfCidade.getText()
                    )
            );
            orientador.setContaBancaria(
                    new ContaBancaria(
                            tfBanco.getText(),
                            StringUtils.isNullOrEmpty(tfAgencia.getText()) ? 0 : Integer.parseInt(tfAgencia.getText()),
                            StringUtils.isNullOrEmpty(tfConta.getText()) ? 0 : Integer.parseInt(tfConta.getText())
                    )
            );
        }
        validar();
    }

    private void validar() throws OrientadorException {
        if (orientador.getNome().isEmpty()) {
            throw new OrientadorException("O campo 'Nome' é obrigatório");
        }
        if (!tfEmail.getText().isEmpty() && !orientador.getEmail().contains("@")) {
            throw new OrientadorException("Verifique se o email informado está correto!");
        }
        if (orientador.getTelefone().length() < 13) {
            throw new OrientadorException("Verifique se os digitos do telefone estão corretos");
        }
    }

    private void tratarCampos(boolean status) {
        this.tfNome.setEnabled(status);
        this.cbTitulacao.setEnabled(status);
        this.ftfCpf.setEnabled(status);
        this.ftfRg.setEnabled(status);
        this.dtcDataEntrada.setEnabled(status);
        this.ftfTelefone.setEnabled(status);
        this.tfEmail.setEnabled(status);
        this.tfBanco.setEnabled(status);
        this.tfAgencia.setEnabled(status);
        this.tfConta.setEnabled(status);
        this.tfRua.setEnabled(status);
        this.tfNumero.setEnabled(status);
        this.tfBairro.setEnabled(status);
        this.tfCidade.setEnabled(status);
        this.cbEstado.setEnabled(status);
    }

    private void tratarControles(boolean status) {
        this.btCadastrar.setEnabled(!status);
        this.btAlterar.setEnabled(status);
        this.btExcluir.setEnabled(status);
    }

    private void limparCampos() {
        this.tfNome.setText(null);
        this.cbTitulacao.setSelectedIndex(0);
        this.ftfCpf.setText(null);
        this.ftfRg.setText(null);
        this.dtcDataEntrada.setDate(null);
        this.ftfTelefone.setText(null);
        this.tfEmail.setText(null);
        this.tfBanco.setText(null);
        this.tfAgencia.setText(null);
        this.tfConta.setText(null);
        this.tfRua.setText(null);
        this.tfNumero.setText(null);
        this.tfBairro.setText(null);
        this.tfCidade.setText(null);
        this.cbEstado.setSelectedIndex(0);
    }

    public void recuperarDadosAlterarOrientador(int idOrientador) {
        try {
            orientador = orientadorDAO.buscarPorId(idOrientador);
            this.setDados();
            this.tratarControles(true);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }

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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DlgConsultarOrientador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                DlgGerenciadorOrientador dialog = new DlgGerenciadorOrientador(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btConsultar;
    private javax.swing.JButton btExcluir;
    private javax.swing.JComboBox cbEstado;
    private javax.swing.JComboBox cbTitulacao;
    private com.toedter.calendar.JDateChooser dtcDataEntrada;
    private javax.swing.JFormattedTextField ftfCpf;
    private javax.swing.JFormattedTextField ftfRg;
    private javax.swing.JFormattedTextField ftfTelefone;
    private javax.swing.JCheckBox jChStatus;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lbCpf;
    private javax.swing.JLabel lbDataEntrada;
    private javax.swing.JLabel lbEmail;
    private javax.swing.JLabel lbNome;
    private javax.swing.JLabel lbRg;
    private javax.swing.JLabel lbStatus;
    private javax.swing.JLabel lbTelefone;
    private javax.swing.JLabel lbTitulacao;
    private javax.swing.JPanel panelBotoes;
    private javax.swing.JPanel panelDadosBancarios;
    private javax.swing.JPanel panelEndereco;
    private javax.swing.JTextField tfAgencia;
    private javax.swing.JTextField tfBairro;
    private javax.swing.JTextField tfBanco;
    private javax.swing.JTextField tfCidade;
    private javax.swing.JTextField tfConta;
    private javax.swing.JTextField tfEmail;
    private javax.swing.JTextField tfNome;
    private javax.swing.JTextField tfNumero;
    private javax.swing.JTextField tfRua;
    // End of variables declaration//GEN-END:variables

    private boolean verificarCamposVazios() {
        return tfNome.getText().isEmpty() || cbTitulacao.getSelectedIndex() < 0 || !ftfCpf.getText().contains("123456789")
                || !ftfRg.getText().contains("123456789") || dtcDataEntrada.getDate() == null || !ftfTelefone.getText().contains("123456789")
                || tfBanco.getText().isEmpty() || tfAgencia.getText().isEmpty() || tfConta.getText().isEmpty()
                || tfCidade.getText().isEmpty() || tfRua.getText().isEmpty() || tfBairro.getText().isEmpty()
                || tfNumero.getText().isEmpty();
    }
}
