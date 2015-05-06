package form;

import com.mysql.jdbc.StringUtils;
import dao.AlunoDAO;
import dao.TurmaDAO;
import exceptions.AlunoException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Aluno;
import model.ContaBancaria;
import model.Endereco;
import model.Turma;

/**
 *
 * @author Giseli e Keyve
 */
public class DlgGerenciadorAluno extends javax.swing.JDialog {

    public DlgGerenciadorAluno(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.taObservacao.setLineWrap(true);
        carregarComboBoxTurma();
    }

//    DlgConsultarAluno janelaConsulta = new DlgConsultarAluno(null, true);
    private final AlunoDAO alunoDAO = new AlunoDAO();
    private Aluno aluno;
    private ValidadorDeTeclas validar = new ValidadorDeTeclas();
    private int nivelUsuario;

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroupEscolaridade = new javax.swing.ButtonGroup();
        panelGeral = new javax.swing.JPanel();
        lbSituação = new javax.swing.JLabel();
        panelDadosBancarios = new javax.swing.JPanel();
        lbNomeBanco = new javax.swing.JLabel();
        tfNomeBanco = new javax.swing.JTextField();
        lbAgencia = new javax.swing.JLabel();
        tfAgencia = new javax.swing.JTextField();
        lbNumeroConta = new javax.swing.JLabel();
        tfNumeroConta = new javax.swing.JTextField();
        panelEndereco = new javax.swing.JPanel();
        lbRua = new javax.swing.JLabel();
        tfRua = new javax.swing.JTextField();
        lbBairro = new javax.swing.JLabel();
        tfBairro = new javax.swing.JTextField();
        lbNumero = new javax.swing.JLabel();
        tfNumero = new javax.swing.JTextField();
        lbEstado = new javax.swing.JLabel();
        cbEstado = new javax.swing.JComboBox();
        lbCidade = new javax.swing.JLabel();
        tfCidade = new javax.swing.JTextField();
        panelDadosPessoais = new javax.swing.JPanel();
        lbNome = new javax.swing.JLabel();
        tfNome = new javax.swing.JTextField();
        lbCpf = new javax.swing.JLabel();
        ftfCpf = new javax.swing.JFormattedTextField();
        lbRg = new javax.swing.JLabel();
        lbDataNascimento = new javax.swing.JLabel();
        dtcDataNascimento = new com.toedter.calendar.JDateChooser();
        lbSexo = new javax.swing.JLabel();
        cbSexo = new javax.swing.JComboBox();
        lbEscolaridade = new javax.swing.JLabel();
        cbEscolaridade = new javax.swing.JComboBox();
        lbProfissão = new javax.swing.JLabel();
        tfProfissao = new javax.swing.JTextField();
        lbTelefone = new javax.swing.JLabel();
        ftfTelefone = new javax.swing.JFormattedTextField();
        lbEmail = new javax.swing.JLabel();
        tfEmail = new javax.swing.JTextField();
        ftfRg = new javax.swing.JFormattedTextField();
        cbSituacao = new javax.swing.JComboBox();
        jSeparator1 = new javax.swing.JSeparator();
        panelBotao = new javax.swing.JPanel();
        btCadastrar = new javax.swing.JButton();
        btConsultar = new javax.swing.JButton();
        btAlterar = new javax.swing.JButton();
        btExcluir = new javax.swing.JButton();
        btCancelar = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        taObservacao = new javax.swing.JTextArea();
        labelTurma = new javax.swing.JLabel();
        cbTurma = new javax.swing.JComboBox();
        panelControles = new javax.swing.JPanel();
        panelNavegacao = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Gerenciador de Aluno");
        setResizable(false);

        panelGeral.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Dados do Aluno", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Arial", 1, 18), new java.awt.Color(0, 102, 204))); // NOI18N

        lbSituação.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbSituação.setText("Situação");

        panelDadosBancarios.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Dados Bancários", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 14), new java.awt.Color(0, 102, 255))); // NOI18N

        lbNomeBanco.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbNomeBanco.setText("Banco");

        tfNomeBanco.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        lbAgencia.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbAgencia.setText("Agência");

        tfAgencia.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        tfAgencia.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfAgenciaKeyTyped(evt);
            }
        });

        lbNumeroConta.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbNumeroConta.setText("Conta");

        tfNumeroConta.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        tfNumeroConta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfNumeroContaKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout panelDadosBancariosLayout = new javax.swing.GroupLayout(panelDadosBancarios);
        panelDadosBancarios.setLayout(panelDadosBancariosLayout);
        panelDadosBancariosLayout.setHorizontalGroup(
            panelDadosBancariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDadosBancariosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelDadosBancariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbNomeBanco)
                    .addComponent(lbAgencia))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelDadosBancariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelDadosBancariosLayout.createSequentialGroup()
                        .addComponent(tfAgencia, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbNumeroConta)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfNumeroConta, javax.swing.GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE))
                    .addComponent(tfNomeBanco))
                .addContainerGap())
        );
        panelDadosBancariosLayout.setVerticalGroup(
            panelDadosBancariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDadosBancariosLayout.createSequentialGroup()
                .addGroup(panelDadosBancariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbNomeBanco)
                    .addComponent(tfNomeBanco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelDadosBancariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbAgencia)
                    .addComponent(tfAgencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbNumeroConta)
                    .addComponent(tfNumeroConta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelEndereco.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Endereço", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 14), new java.awt.Color(0, 102, 255))); // NOI18N

        lbRua.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbRua.setText("Rua");

        tfRua.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        lbBairro.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbBairro.setText("Bairro");

        tfBairro.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        lbNumero.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbNumero.setText("Número");

        tfNumero.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        tfNumero.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfNumeroKeyTyped(evt);
            }
        });

        lbEstado.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbEstado.setText("Estado");

        cbEstado.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cbEstado.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "AC", "AL", "AM", "AP", "BA", "CE", "DF", "GO", "ES", "MA", "MG", "MS", "MT", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RO", "RR", "RS", "SE", "SC", "SP", "TO" }));

        lbCidade.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbCidade.setText("Cidade");

        tfCidade.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        javax.swing.GroupLayout panelEnderecoLayout = new javax.swing.GroupLayout(panelEndereco);
        panelEndereco.setLayout(panelEnderecoLayout);
        panelEnderecoLayout.setHorizontalGroup(
            panelEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelEnderecoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbRua)
                    .addComponent(lbBairro)
                    .addComponent(lbEstado))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelEnderecoLayout.createSequentialGroup()
                        .addComponent(tfBairro, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbNumero)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfNumero, javax.swing.GroupLayout.DEFAULT_SIZE, 68, Short.MAX_VALUE))
                    .addComponent(tfRua)
                    .addGroup(panelEnderecoLayout.createSequentialGroup()
                        .addComponent(cbEstado, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lbCidade)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        panelEnderecoLayout.setVerticalGroup(
            panelEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelEnderecoLayout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addGroup(panelEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbRua)
                    .addComponent(tfRua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbBairro)
                    .addComponent(tfBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbNumero)
                    .addComponent(tfNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbEstado)
                    .addComponent(cbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbCidade)
                    .addComponent(tfCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        lbNome.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbNome.setText("Nome");

        tfNome.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        tfNome.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                tfNomeCaretUpdate(evt);
            }
        });
        tfNome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfNomeKeyTyped(evt);
            }
        });

        lbCpf.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbCpf.setText("CPF");

        try {
            ftfCpf.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        ftfCpf.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        ftfCpf.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                ftfCpfCaretUpdate(evt);
            }
        });
        ftfCpf.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                ftfCpfKeyTyped(evt);
            }
        });

        lbRg.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbRg.setText("RG");

        lbDataNascimento.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbDataNascimento.setText("Data de Nascimento");

        dtcDataNascimento.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        dtcDataNascimento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                dtcDataNascimentoKeyTyped(evt);
            }
        });

        lbSexo.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbSexo.setText("Sexo");

        cbSexo.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cbSexo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Masculino", "Feminino" }));
        cbSexo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbSexoItemStateChanged(evt);
            }
        });

        lbEscolaridade.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbEscolaridade.setText("Escolaridade");

        cbEscolaridade.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cbEscolaridade.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Analfabeto", "Ensino fundamental incompleto", "Ensino fundamental completo", "Ensino médio incompleto", "Ensino médio completo", "Ensino superior incompleto", "Ensino superior completo", "Pós-graduação" }));
        cbEscolaridade.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbEscolaridadeItemStateChanged(evt);
            }
        });

        lbProfissão.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbProfissão.setText("Profissão");

        tfProfissao.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        lbTelefone.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbTelefone.setText("Telefone");

        try {
            ftfTelefone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        ftfTelefone.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        ftfTelefone.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                ftfTelefoneCaretUpdate(evt);
            }
        });
        ftfTelefone.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                ftfTelefoneKeyTyped(evt);
            }
        });

        lbEmail.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbEmail.setText("E-mail");

        tfEmail.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        try {
            ftfRg.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#.###.###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        ftfRg.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        ftfRg.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                ftfRgCaretUpdate(evt);
            }
        });

        javax.swing.GroupLayout panelDadosPessoaisLayout = new javax.swing.GroupLayout(panelDadosPessoais);
        panelDadosPessoais.setLayout(panelDadosPessoaisLayout);
        panelDadosPessoaisLayout.setHorizontalGroup(
            panelDadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDadosPessoaisLayout.createSequentialGroup()
                .addGroup(panelDadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelDadosPessoaisLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panelDadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lbEmail)
                            .addComponent(lbDataNascimento)
                            .addComponent(lbCpf)
                            .addComponent(lbSexo)
                            .addComponent(lbEscolaridade)
                            .addComponent(lbProfissão)
                            .addComponent(lbTelefone)
                            .addComponent(lbRg)))
                    .addGroup(panelDadosPessoaisLayout.createSequentialGroup()
                        .addGap(109, 109, 109)
                        .addComponent(lbNome, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelDadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(ftfCpf)
                    .addComponent(tfNome)
                    .addComponent(dtcDataNascimento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cbSexo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cbEscolaridade, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfProfissao)
                    .addComponent(ftfTelefone)
                    .addComponent(tfEmail)
                    .addComponent(ftfRg)))
        );
        panelDadosPessoaisLayout.setVerticalGroup(
            panelDadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDadosPessoaisLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelDadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelDadosPessoaisLayout.createSequentialGroup()
                        .addGroup(panelDadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbNome)
                            .addComponent(tfNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelDadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbCpf)
                            .addComponent(ftfCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelDadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbRg)
                            .addComponent(ftfRg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lbDataNascimento))
                    .addComponent(dtcDataNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelDadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbSexo)
                    .addComponent(cbSexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelDadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbEscolaridade)
                    .addComponent(cbEscolaridade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelDadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbProfissão)
                    .addComponent(tfProfissao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelDadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbTelefone)
                    .addComponent(ftfTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelDadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbEmail)
                    .addComponent(tfEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelDadosPessoaisLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {lbCpf, lbDataNascimento, lbEmail, lbEscolaridade, lbNome, lbProfissão, lbRg, lbSexo, lbTelefone});

        cbSituacao.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cbSituacao.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Em curso", "Cancelado", "Apto", "Não apto" }));
        cbSituacao.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbSituacaoItemStateChanged(evt);
            }
        });

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        panelBotao.setLayout(new java.awt.GridLayout(1, 0));

        btCadastrar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btCadastrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/cadastrar.png"))); // NOI18N
        btCadastrar.setText("Cadastrar");
        btCadastrar.setEnabled(false);
        btCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCadastrarActionPerformed(evt);
            }
        });
        panelBotao.add(btCadastrar);

        btConsultar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btConsultar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Consultar.png"))); // NOI18N
        btConsultar.setText("Consultar");
        btConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btConsultarActionPerformed(evt);
            }
        });
        panelBotao.add(btConsultar);

        btAlterar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btAlterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Alterar.png"))); // NOI18N
        btAlterar.setText("Alterar");
        btAlterar.setEnabled(false);
        btAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAlterarActionPerformed(evt);
            }
        });
        panelBotao.add(btAlterar);

        btExcluir.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Remover.png"))); // NOI18N
        btExcluir.setText("Excluir ");
        btExcluir.setEnabled(false);
        btExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btExcluirActionPerformed(evt);
            }
        });
        panelBotao.add(btExcluir);

        btCancelar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Cancelar.png"))); // NOI18N
        btCancelar.setText("Cancelar");
        btCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelarActionPerformed(evt);
            }
        });
        panelBotao.add(btCancelar);

        taObservacao.setColumns(20);
        taObservacao.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        taObservacao.setRows(5);
        taObservacao.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Observações", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 14), new java.awt.Color(0, 102, 255))); // NOI18N
        jScrollPane3.setViewportView(taObservacao);

        labelTurma.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        labelTurma.setText("Turma");

        cbTurma.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        javax.swing.GroupLayout panelGeralLayout = new javax.swing.GroupLayout(panelGeral);
        panelGeral.setLayout(panelGeralLayout);
        panelGeralLayout.setHorizontalGroup(
            panelGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelGeralLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(panelGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelBotao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 841, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelGeralLayout.createSequentialGroup()
                        .addComponent(panelDadosPessoais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(46, 46, 46)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(panelGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelGeralLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(panelGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(panelEndereco, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(panelDadosBancarios, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(panelGeralLayout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addGroup(panelGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lbSituação)
                                    .addComponent(labelTurma))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panelGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cbTurma, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(panelGeralLayout.createSequentialGroup()
                                        .addComponent(cbSituacao, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE)))))
                        .addContainerGap())))
        );
        panelGeralLayout.setVerticalGroup(
            panelGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelGeralLayout.createSequentialGroup()
                .addGroup(panelGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelGeralLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panelGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbSituação)
                            .addComponent(cbSituacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(panelGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbTurma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelTurma))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(panelDadosBancarios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(panelEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8))
                    .addGroup(panelGeralLayout.createSequentialGroup()
                        .addGroup(panelGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(panelDadosPessoais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelBotao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        panelControles.setLayout(new java.awt.GridLayout(1, 0));

        panelNavegacao.setLayout(new java.awt.GridLayout(1, 0));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(panelGeral, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(panelControles, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelNavegacao, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(panelGeral, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(panelControles, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelNavegacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void cbSituacaoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbSituacaoItemStateChanged
        if (cbSituacao.getSelectedIndex() >= 0) {
            if (cbSituacao.getSelectedItem().toString().equals("Cancelado")) {
                tratarCampos(false);
            } else {
                tratarCampos(true);
            }
        }
    }//GEN-LAST:event_cbSituacaoItemStateChanged

    private void btCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCadastrarActionPerformed
        if (verificarCamposVazios()) {
            int resultado = JOptionPane.showConfirmDialog(this, "Há campos vazios. Deseja continuar?", "Aviso!", JOptionPane.YES_NO_OPTION);
            if (resultado != JOptionPane.YES_OPTION) {
                return;
            }
        }
        try {
            if (aluno == null) {
                aluno = new Aluno();
                this.getDados();
                if (alunoDAO.cadastrar(aluno)) {
//                    janelaConsulta.atualizarTabela("SELECT * FROM Aluno a, Endereco e, ContaBancaria cb "
//                            + "WHERE a.idEndereco = e.idEndereco AND a.idContaBancaria = cb.idContaBancaria;");
                    JOptionPane.showMessageDialog(this, "Cadastro efetuado!");
                    this.limparCampos();
                } else {
                    JOptionPane.showMessageDialog(this, "Já existe aluno cadastrado!", "Cadastro de  Aluno", JOptionPane.ERROR_MESSAGE);
                    aluno = null;
                }
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "ERRO: " + ex.getMessage());
        } catch (ParseException | IllegalArgumentException | AlunoException ex) {
            JOptionPane.showMessageDialog(this, "ERRO!: " + ex.getMessage());
        }
    }//GEN-LAST:event_btCadastrarActionPerformed

    private void btConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btConsultarActionPerformed
        //this.setVisible(false);
        DlgConsultarAluno consultarAluno = new DlgConsultarAluno(null, true);
        consultarAluno.verificarNivel(nivelUsuario);
        this.dispose();
        consultarAluno.setVisible(true);
    }//GEN-LAST:event_btConsultarActionPerformed

    private void btCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelarActionPerformed
        if (nivelUsuario == 3) {
            this.dispose();
            DlgMenuConsultas menu = new DlgMenuConsultas(null, rootPaneCheckingEnabled);
            menu.verificarNivel(nivelUsuario);
            menu.setVisible(true); 
        } else if (!tfNome.getText().isEmpty() && dtcDataNascimento.getDate() != null) {
            this.limparCampos();
            this.tratarControles(false);
        }else {
            this.dispose();
            
        }
    }//GEN-LAST:event_btCancelarActionPerformed

    private void btAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAlterarActionPerformed
        if (aluno != null) {
            try {
                this.getDados();
                alunoDAO.atualizar(aluno);
//                janelaConsulta.atualizarTabela("SELECT * FROM Aluno a, Endereco e, ContaBancaria cb "
//                        + "WHERE a.idEndereco = e.idEndereco AND a.idContaBancaria = cb.idContaBancaria GROUP BY a.nome;");
                JOptionPane.showMessageDialog(this, "Aluno atualizado com sucesso!!");
                this.limparCampos();
                this.tratarControles(false);
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "ERRO!: " + ex.getMessage());
            } catch (ParseException | IllegalArgumentException | AlunoException ex) {
                JOptionPane.showMessageDialog(this, "ERRO!: " + ex.getMessage());
            }
        }
    }//GEN-LAST:event_btAlterarActionPerformed

    private void btExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExcluirActionPerformed
        if (aluno != null) {
            try {
                alunoDAO.remover(aluno);
//                janelaConsulta.atualizarTabela("SELECT * FROM Aluno a, Endereco e, ContaBancaria cb "
//                        + "WHERE a.idEndereco = e.idEndereco AND a.idContaBancaria = cb.idContaBancaria;");
                JOptionPane.showMessageDialog(this, "Este aluno foi removido com sucesso!");
                this.limparCampos();
                this.tratarControles(false);
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "ERRO! " + ex.getMessage());
            }
        }
    }//GEN-LAST:event_btExcluirActionPerformed

    private void ftfCpfKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ftfCpfKeyTyped
        validar.validarSomenteNumeros(evt);
    }//GEN-LAST:event_ftfCpfKeyTyped

    private void ftfTelefoneKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ftfTelefoneKeyTyped
        validar.validarSomenteNumeros(evt);
    }//GEN-LAST:event_ftfTelefoneKeyTyped

    private void tfAgenciaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfAgenciaKeyTyped
        validar.validarSomenteNumeros(evt);
    }//GEN-LAST:event_tfAgenciaKeyTyped

    private void tfNumeroContaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfNumeroContaKeyTyped
        validar.validarSomenteNumeros(evt);
    }//GEN-LAST:event_tfNumeroContaKeyTyped

    private void tfNumeroKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfNumeroKeyTyped
        validar.validarSomenteNumeros(evt);
    }//GEN-LAST:event_tfNumeroKeyTyped

    private void tfNomeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfNomeKeyTyped
        validar.validarSomenteLetras(evt);
    }//GEN-LAST:event_tfNomeKeyTyped

    private void tfNomeCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_tfNomeCaretUpdate
        ativarBotaoConfirmar();
    }//GEN-LAST:event_tfNomeCaretUpdate

    private void ftfCpfCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_ftfCpfCaretUpdate
        ativarBotaoConfirmar();
    }//GEN-LAST:event_ftfCpfCaretUpdate

    private void ftfRgCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_ftfRgCaretUpdate
        ativarBotaoConfirmar();
    }//GEN-LAST:event_ftfRgCaretUpdate

    private void ftfTelefoneCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_ftfTelefoneCaretUpdate
        ativarBotaoConfirmar();
    }//GEN-LAST:event_ftfTelefoneCaretUpdate

    private void cbSexoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbSexoItemStateChanged
        ativarBotaoConfirmar();
    }//GEN-LAST:event_cbSexoItemStateChanged

    private void cbEscolaridadeItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbEscolaridadeItemStateChanged
        ativarBotaoConfirmar();
    }//GEN-LAST:event_cbEscolaridadeItemStateChanged

    private void dtcDataNascimentoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_dtcDataNascimentoKeyTyped
        validar.validarSomenteNumeros(evt);
    }//GEN-LAST:event_dtcDataNascimentoKeyTyped

    private void setDados() {
        this.tfNome.setText(aluno.getNome());
        this.cbSituacao.setSelectedItem(aluno.getSituacao());
        this.ftfCpf.setText(aluno.getCpf());
        this.ftfRg.setText(aluno.getRg());
        this.cbEscolaridade.setSelectedItem(aluno.getEscolaridade());
        tfProfissao.setText(aluno.getProfissao());
        dtcDataNascimento.setDate(aluno.getDataNascimento());
        cbSexo.setSelectedItem(aluno.getSexo());
        this.ftfTelefone.setText(aluno.getTelefone());
        this.tfEmail.setText(aluno.getEmail());
        this.cbEstado.setSelectedItem(aluno.getEndereco().getEstado());
        this.tfCidade.setText(aluno.getEndereco().getCidade());
        this.tfBairro.setText(aluno.getEndereco().getBairro());
        this.tfRua.setText(aluno.getEndereco().getRua());
        this.tfNumero.setText(Long.toString(aluno.getEndereco().getNumero()));
        this.tfNomeBanco.setText(aluno.getContaBancaria().getNomeBanco());
        this.tfAgencia.setText(Integer.toString(aluno.getContaBancaria().getAgencia()));
        this.tfNumeroConta.setText(Integer.toString(aluno.getContaBancaria().getNumeroConta()));
        this.taObservacao.setText(aluno.getObservacoes());
    }

    private void getDados() throws ParseException, AlunoException {
        if (!tfNome.getText().isEmpty()) {
            aluno.setNome(tfNome.getText());
            aluno.setCpf(ftfCpf.getText());
            aluno.setRg(ftfRg.getText());
            aluno.setTelefone(ftfTelefone.getText());
            aluno.setEmail(tfEmail.getText());
            aluno.setEscolaridade(cbEscolaridade.getSelectedItem().toString());
            aluno.setDataNascimento(dtcDataNascimento.getDate());
            aluno.setProfissao(tfProfissao.getText());
            aluno.setSexo(cbSexo.getSelectedItem().toString());
            if (!taObservacao.getText().isEmpty()) {
                aluno.setObservacoes(taObservacao.getText());
            }
            if (cbSituacao.getSelectedIndex() > -1) {
                aluno.setSituacao(cbSituacao.getSelectedItem().toString());
            }
            aluno.setEndereco(
                    new Endereco(
                            tfRua.getText(),
                            StringUtils.isNullOrEmpty(tfNumero.getText()) ? 0 : Integer.parseInt(tfNumero.getText()),
                            tfBairro.getText(),
                            cbEstado.getSelectedItem().toString(),
                            tfCidade.getText()
                    )
            );
            aluno.setContaBancaria(
                    new ContaBancaria(
                            tfNomeBanco.getText(),
                            StringUtils.isNullOrEmpty(tfAgencia.getText()) ? 0 : Integer.parseInt(tfAgencia.getText()),
                            StringUtils.isNullOrEmpty(tfNumeroConta.getText()) ? 0 : Integer.parseInt(tfNumeroConta.getText())
                    )
            );
            aluno.setIdTurma(pegarIdTurma());
        }
        validar();
    }

    private void validar() throws AlunoException {
        if (aluno.getNome().isEmpty()) {
            throw new AlunoException("O campo 'Nome' é obrigatório");
        }
        if (!tfEmail.getText().isEmpty() && !aluno.getEmail().contains("@")) {
            throw new AlunoException("Verifique se o email informado está correto!");
        }
        if (aluno.getTelefone().length() < 13) {
            throw new AlunoException("Verifique se os digitos do telefone estão corretos");
        }
    }

    private void tratarCampos(boolean status) {
        this.tfNome.setEnabled(status);
        this.ftfCpf.setEnabled(status);
        this.ftfRg.setEnabled(status);
        this.dtcDataNascimento.setEnabled(status);
        this.cbSexo.setEnabled(status);
        this.cbEscolaridade.setEnabled(status);
        this.tfProfissao.setEnabled(status);
        this.ftfTelefone.setEnabled(status);
        this.tfEmail.setEnabled(status);
        this.tfNomeBanco.setEnabled(status);
        this.tfAgencia.setEnabled(status);
        this.tfNumeroConta.setEnabled(status);
        this.tfRua.setEnabled(status);
        this.tfNumero.setEnabled(status);
        this.tfBairro.setEnabled(status);
        this.tfCidade.setEnabled(status);
        this.cbEstado.setEnabled(status);
        this.taObservacao.setEnabled(status);
        this.cbTurma.setEnabled(status);
    }

    private void limparCampos() {
        this.tfNome.setText(null);
        this.ftfCpf.setText(null);
        this.ftfRg.setText(null);
        this.dtcDataNascimento.setDate(null);
        this.cbSexo.setSelectedIndex(0);
        this.cbEscolaridade.setSelectedIndex(0);
        this.tfProfissao.setText(null);
        this.ftfTelefone.setText(null);
        this.tfEmail.setText(null);
        this.tfNomeBanco.setText(null);
        this.tfAgencia.setText(null);
        this.tfNumeroConta.setText(null);
        this.tfRua.setText(null);
        this.tfNumero.setText(null);
        this.tfBairro.setText(null);
        this.tfCidade.setText(null);
        this.cbEstado.setSelectedIndex(0);
        this.taObservacao.setText(null);
        this.cbSituacao.setSelectedIndex(0);
        cbTurma.setSelectedIndex(0);
    }

    private void tratarControles(boolean status) {
        this.btCadastrar.setEnabled(status);
        this.btAlterar.setEnabled(status);
        this.btExcluir.setEnabled(status);
        cbSituacao.setEnabled(status);
    }

    public void recuperarDadosAlterarAluno(int idAluno) {
        try {
            aluno = alunoDAO.buscarPorId(idAluno);
            this.setDados();
            this.tratarControles(true);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }

    private void carregarComboBoxTurma() {
        List<Turma> listaTurma = new ArrayList();
        try {
            listaTurma = new TurmaDAO().listarTodos();
            for (Turma turma : listaTurma) {
                cbTurma.addItem(turma);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DlgRealizarMatricula.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

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
            java.util.logging.Logger.getLogger(DlgGerenciadorAluno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                DlgGerenciadorAluno dialog = new DlgGerenciadorAluno(new javax.swing.JFrame(), true);
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
    private javax.swing.ButtonGroup buttonGroupEscolaridade;
    private javax.swing.JComboBox cbEscolaridade;
    private javax.swing.JComboBox cbEstado;
    private javax.swing.JComboBox cbSexo;
    private javax.swing.JComboBox cbSituacao;
    private javax.swing.JComboBox cbTurma;
    private com.toedter.calendar.JDateChooser dtcDataNascimento;
    private javax.swing.JFormattedTextField ftfCpf;
    private javax.swing.JFormattedTextField ftfRg;
    private javax.swing.JFormattedTextField ftfTelefone;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel labelTurma;
    private javax.swing.JLabel lbAgencia;
    private javax.swing.JLabel lbBairro;
    private javax.swing.JLabel lbCidade;
    private javax.swing.JLabel lbCpf;
    private javax.swing.JLabel lbDataNascimento;
    private javax.swing.JLabel lbEmail;
    private javax.swing.JLabel lbEscolaridade;
    private javax.swing.JLabel lbEstado;
    private javax.swing.JLabel lbNome;
    private javax.swing.JLabel lbNomeBanco;
    private javax.swing.JLabel lbNumero;
    private javax.swing.JLabel lbNumeroConta;
    private javax.swing.JLabel lbProfissão;
    private javax.swing.JLabel lbRg;
    private javax.swing.JLabel lbRua;
    private javax.swing.JLabel lbSexo;
    private javax.swing.JLabel lbSituação;
    private javax.swing.JLabel lbTelefone;
    private javax.swing.JPanel panelBotao;
    private javax.swing.JPanel panelControles;
    private javax.swing.JPanel panelDadosBancarios;
    private javax.swing.JPanel panelDadosPessoais;
    private javax.swing.JPanel panelEndereco;
    private javax.swing.JPanel panelGeral;
    private javax.swing.JPanel panelNavegacao;
    private javax.swing.JTextArea taObservacao;
    private javax.swing.JTextField tfAgencia;
    private javax.swing.JTextField tfBairro;
    private javax.swing.JTextField tfCidade;
    private javax.swing.JTextField tfEmail;
    private javax.swing.JTextField tfNome;
    private javax.swing.JTextField tfNomeBanco;
    private javax.swing.JTextField tfNumero;
    private javax.swing.JTextField tfNumeroConta;
    private javax.swing.JTextField tfProfissao;
    private javax.swing.JTextField tfRua;
    // End of variables declaration//GEN-END:variables

    private int pegarIdTurma() {
        Turma turma = ((Turma) cbTurma.getSelectedItem());
        return turma.getId();
    }

    private boolean verificarCamposVazios() {
        return tfNome.getText().isEmpty() || !ftfCpf.getText().contains("1234567890") || !ftfRg.getText().contains("1234567890")
                || dtcDataNascimento.getDate() == null || cbSexo.getSelectedIndex() < 0 || cbEscolaridade.getSelectedIndex() < 0
                || tfProfissao.getText().isEmpty() || !ftfTelefone.getText().contains("1234567890") || tfEmail.getText().isEmpty()
                || tfNomeBanco.getText().isEmpty() || tfAgencia.getText().isEmpty() || tfNumeroConta.getText().isEmpty()
                || tfRua.getText().isEmpty() || tfBairro.getText().isEmpty() || tfNumero.getText().isEmpty()
                || tfCidade.getText().isEmpty() || cbEstado.getSelectedIndex() < 0;
    }

    private void ativarBotaoConfirmar() {
        if (!tfNome.getText().isEmpty() && !ftfRg.getText().contains("1234567890") && !ftfCpf.getText().contains("1234567890")
                && dtcDataNascimento.getDate() != null && cbSexo.getSelectedIndex() > -1 && cbEscolaridade.getSelectedIndex() > -1
                && !ftfTelefone.getText().contains("1234567890")) {
            btCadastrar.setEnabled(true);
        } else {
            btCadastrar.setEnabled(false);
        }
    }

    public void verificarNivel(int nivel) {
        if (nivel == 3) {
            this.nivelUsuario = nivel;
            tratarCampos(false);
            cbSituacao.setEnabled(false);
            btAlterar.setEnabled(false);
            btCadastrar.setEnabled(false);
            btExcluir.setEnabled(false);
        }
    }
}