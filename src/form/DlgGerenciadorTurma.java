package form;

import dao.CursoDAO;
import dao.OrientadorDAO;
import dao.ProfessorDAO;
import dao.SupervisorDAO;
import dao.TurmaDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import model.Comparador;
import model.Curso;
import model.Disciplina;
import model.Endereco;
import model.Orientador;
import model.Professor;
import model.Supervisor;
import model.Turma;
import table.DisciplinaTurmaTableModel;
import table.ProfessorTurmaTableModel;

/**
 *
 * @author Ana e Dhiago
 */
public class DlgGerenciadorTurma extends javax.swing.JDialog {

    List<String> listaDeDiasDeAulaDaTurma = new ArrayList<>();
    List<Disciplina> listaDeDisciplinas = new ArrayList<>();
    List<Professor> listaProfessoresTabela = new ArrayList<>();
    DisciplinaTurmaTableModel disciplinaTableModel = new DisciplinaTurmaTableModel();
    DefaultListModel lmDiasDeAula;
    ProfessorTurmaTableModel professorTableModel = new ProfessorTurmaTableModel();
    Turma turma;
    List<Curso> listaDeCursos;
    List<Orientador> listaDeOrientadores;
    List<Professor> listaProfessoresCombo;
    List<Supervisor> listaDeSupervisores;
    List<String> listaDeEstados = new ArrayList<>();

    public DlgGerenciadorTurma(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        initComboBox();
        estadoInicial();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane4 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jScrollPane6 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        btNovoCurso = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        tfNomeTurma = new javax.swing.JTextField();
        tfEixoTecnologico = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        tfCidadeDemandante = new javax.swing.JTextField();
        tfCampusOfertante = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        cbProfessor = new javax.swing.JComboBox();
        cbSupervisor = new javax.swing.JComboBox();
        cbOrientador = new javax.swing.JComboBox();
        btNovoOrientador = new javax.swing.JButton();
        btNovoSupervisor = new javax.swing.JButton();
        btNovoProfessor = new javax.swing.JButton();
        btAdicionarProfessor = new javax.swing.JButton();
        btRemoverProfessor = new javax.swing.JButton();
        jScrollPane7 = new javax.swing.JScrollPane();
        tbProfessor = new javax.swing.JTable();
        cbCurso = new javax.swing.JComboBox();
        tfResponsavel = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        btAlterarTurma = new javax.swing.JButton();
        btCancelarTurma = new javax.swing.JButton();
        btExcluirTurma = new javax.swing.JButton();
        btCadastrarTurma = new javax.swing.JButton();
        btConsultarTurma = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel6 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        tfRua = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        tfNumero = new javax.swing.JTextField();
        tfBairro = new javax.swing.JTextField();
        tfCidade = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        cbEstado = new javax.swing.JComboBox();
        jPanel4 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        cbTurno = new javax.swing.JComboBox();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listDiasDaSemana = new javax.swing.JList();
        jScrollPane2 = new javax.swing.JScrollPane();
        listDiasDeAulaDaTurma = new javax.swing.JList();
        btAdicionarDiaDaSemana = new javax.swing.JButton();
        btRemoverDiaDaSemana = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        tfNomeDisciplina = new javax.swing.JTextField();
        dateInicioDisciplina = new com.toedter.calendar.JDateChooser();
        dateTerminoDisciplina = new com.toedter.calendar.JDateChooser();
        btAdicionarDisciplina = new javax.swing.JButton();
        btRemoverDisciplina = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbDisciplinas = new javax.swing.JTable();
        dateTerminoTurma = new com.toedter.calendar.JDateChooser();
        dateInicioTurma = new com.toedter.calendar.JDateChooser();
        jLabel11 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane4.setViewportView(jTable1);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane5.setViewportView(jTable2);

        jList1.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane6.setViewportView(jList1);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Gerenciador De Turma");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Dados Da Turma", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Arial", 1, 14), new java.awt.Color(0, 102, 204))); // NOI18N

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btNovoCurso.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btNovoCurso.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/MiniCurso.png"))); // NOI18N
        btNovoCurso.setText("Novo Curso");
        btNovoCurso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btNovoCursoActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel1.setText("Curso");

        jLabel13.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel13.setText("Eixo Técnológico");

        tfNomeTurma.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        tfEixoTecnologico.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel3.setText("Cidade Demandante");

        jLabel2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel2.setText("Nome da Turma");

        tfCidadeDemandante.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        tfCampusOfertante.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel4.setText("Campus Ofertante");

        jLabel5.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel5.setText("Responsável");

        jLabel7.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel7.setText("Orientador");

        jLabel8.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel8.setText("Supervisor");

        jLabel6.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel6.setText("Professor");

        cbProfessor.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        cbSupervisor.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        cbOrientador.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        btNovoOrientador.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btNovoOrientador.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/MiniOrientador.png"))); // NOI18N
        btNovoOrientador.setText("Novo Orientador");
        btNovoOrientador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btNovoOrientadorActionPerformed(evt);
            }
        });

        btNovoSupervisor.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btNovoSupervisor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/MiniSupervisor.png"))); // NOI18N
        btNovoSupervisor.setText("Novo Supervisor");
        btNovoSupervisor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btNovoSupervisorActionPerformed(evt);
            }
        });

        btNovoProfessor.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btNovoProfessor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/MiniProfessor.png"))); // NOI18N
        btNovoProfessor.setText("Novo Professor");
        btNovoProfessor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btNovoProfessorActionPerformed(evt);
            }
        });

        btAdicionarProfessor.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btAdicionarProfessor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/AddProfessor.png"))); // NOI18N
        btAdicionarProfessor.setText("Adicionar");
        btAdicionarProfessor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAdicionarProfessorActionPerformed(evt);
            }
        });

        btRemoverProfessor.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btRemoverProfessor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/RemoverProfessor.png"))); // NOI18N
        btRemoverProfessor.setText("Remover");
        btRemoverProfessor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btRemoverProfessorActionPerformed(evt);
            }
        });

        tbProfessor.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        tbProfessor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Professor"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane7.setViewportView(tbProfessor);

        cbCurso.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        tfResponsavel.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfCidadeDemandante, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btRemoverProfessor)
                            .addComponent(btAdicionarProfessor)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel8)
                            .addComponent(jLabel6)
                            .addComponent(jLabel2)
                            .addComponent(jLabel13)
                            .addComponent(jLabel1)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(cbOrientador, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btNovoOrientador, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(cbSupervisor, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btNovoSupervisor))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(cbProfessor, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btNovoProfessor, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(cbCurso, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btNovoCurso, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(tfEixoTecnologico, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfNomeTurma, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfCampusOfertante, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfResponsavel, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(45, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(btNovoCurso)
                    .addComponent(cbCurso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(tfEixoTecnologico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tfNomeTurma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(tfCidadeDemandante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(tfCampusOfertante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(tfResponsavel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(cbOrientador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btNovoOrientador))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(cbSupervisor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btNovoSupervisor))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(cbProfessor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btNovoProfessor))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btAdicionarProfessor)
                        .addGap(46, 46, 46)
                        .addComponent(btRemoverProfessor))
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLabel1, jLabel2, jLabel3, jLabel4, jLabel5, jLabel7, jLabel8});

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btAlterarTurma.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btAlterarTurma.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Alterar.png"))); // NOI18N
        btAlterarTurma.setText("Alterar");
        btAlterarTurma.setEnabled(false);
        btAlterarTurma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAlterarTurmaActionPerformed(evt);
            }
        });

        btCancelarTurma.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btCancelarTurma.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Cancelar.png"))); // NOI18N
        btCancelarTurma.setText("Cancelar");
        btCancelarTurma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelarTurmaActionPerformed(evt);
            }
        });

        btExcluirTurma.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btExcluirTurma.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Remover.png"))); // NOI18N
        btExcluirTurma.setText("Excluir");
        btExcluirTurma.setEnabled(false);
        btExcluirTurma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btExcluirTurmaActionPerformed(evt);
            }
        });

        btCadastrarTurma.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btCadastrarTurma.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Cadastrar.png"))); // NOI18N
        btCadastrarTurma.setText("Cadastrar");
        btCadastrarTurma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCadastrarTurmaActionPerformed(evt);
            }
        });

        btConsultarTurma.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btConsultarTurma.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Consultar.png"))); // NOI18N
        btConsultarTurma.setText("Consultar");
        btConsultarTurma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btConsultarTurmaActionPerformed(evt);
            }
        });

        jTabbedPane1.setName("Endereço"); // NOI18N

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 14), new java.awt.Color(0, 102, 255))); // NOI18N

        jLabel14.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel14.setText("Rua");

        jLabel15.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel15.setText("Bairro");

        jLabel19.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel19.setText("Cidade");

        tfRua.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        jLabel20.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel20.setText("Número");

        tfNumero.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        tfBairro.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        tfCidade.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        jLabel18.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel18.setText("Estado");

        cbEstado.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cbEstado.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "AC", "AL", "AM", "AP", "BA", "CE", "DF", "GO", "ES", "MA", "MG", "MS", "MT", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RO", "RR", "RS", "SE", "SC", "SP", "TO" }));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(91, 91, 91)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel15)
                            .addComponent(jLabel14)))
                    .addComponent(jLabel19, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfRua, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfBairro, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 5, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel20)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel18)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(72, 72, 72))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(tfCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18)
                    .addComponent(cbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(tfRua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20)
                    .addComponent(tfNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(tfBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(65, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Endereço", jPanel6);

        jLabel12.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel12.setText("Turno");

        cbTurno.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cbTurno.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Matutino", "Vespertino", "Noturno", "Integral" }));
        cbTurno.setSelectedIndex(-1);

        jLabel9.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel9.setText("Dias De Aula:");

        listDiasDaSemana.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        listDiasDaSemana.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Segunda-Feira", "Terça-Feira", "Quarta-Feira", "Quinta-Feira", "Sexta-Feira", "Sábado", "Domingo" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(listDiasDaSemana);

        listDiasDeAulaDaTurma.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jScrollPane2.setViewportView(listDiasDeAulaDaTurma);

        btAdicionarDiaDaSemana.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btAdicionarDiaDaSemana.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Add.png"))); // NOI18N
        btAdicionarDiaDaSemana.setText("Adicionar");
        btAdicionarDiaDaSemana.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAdicionarDiaDaSemanaActionPerformed(evt);
            }
        });

        btRemoverDiaDaSemana.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btRemoverDiaDaSemana.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Remove.png"))); // NOI18N
        btRemoverDiaDaSemana.setText("Remover");
        btRemoverDiaDaSemana.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btRemoverDiaDaSemanaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(109, 109, 109)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btAdicionarDiaDaSemana))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(btRemoverDiaDaSemana)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbTurno, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(104, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbTurno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addGap(11, 11, 11)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(btAdicionarDiaDaSemana)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btRemoverDiaDaSemana)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Aulas", jPanel4);

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 14), new java.awt.Color(0, 102, 255))); // NOI18N

        jLabel10.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel10.setText("Nome");

        jLabel21.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel21.setText("Início");

        jLabel22.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel22.setText("Término");

        tfNomeDisciplina.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        dateInicioDisciplina.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        dateTerminoDisciplina.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        btAdicionarDisciplina.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btAdicionarDisciplina.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Add.png"))); // NOI18N
        btAdicionarDisciplina.setText("Adicionar");
        btAdicionarDisciplina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAdicionarDisciplinaActionPerformed(evt);
            }
        });

        btRemoverDisciplina.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btRemoverDisciplina.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Remove.png"))); // NOI18N
        btRemoverDisciplina.setText("Remover");
        btRemoverDisciplina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btRemoverDisciplinaActionPerformed(evt);
            }
        });

        tbDisciplinas.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        tbDisciplinas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome", "Data de Início", "Data de Término"
            }
        ));
        jScrollPane3.setViewportView(tbDisciplinas);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(71, 71, 71)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 442, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(jLabel21))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(dateInicioDisciplina, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel22)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(dateTerminoDisciplina, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(tfNomeDisciplina)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(btAdicionarDisciplina)
                        .addGap(190, 190, 190)
                        .addComponent(btRemoverDisciplina)))
                .addGap(69, 81, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(tfNomeDisciplina, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addComponent(jLabel21))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(dateTerminoDisciplina, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel22)))))
                    .addComponent(dateInicioDisciplina, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btAdicionarDisciplina)
                    .addComponent(btRemoverDisciplina))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Disciplina", jPanel5);

        dateTerminoTurma.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        dateInicioTurma.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        jLabel11.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel11.setText("Inicio Turma");

        jLabel23.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel23.setText("Término Turma");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(23, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(btCadastrarTurma, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(btConsultarTurma, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btAlterarTurma, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(96, 96, 96)
                        .addComponent(btExcluirTurma, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btCancelarTurma, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel23, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(dateInicioTurma, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(dateTerminoTurma, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 603, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dateInicioTurma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dateTerminoTurma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel23))
                .addGap(46, 46, 46)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btCadastrarTurma)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btConsultarTurma)
                        .addComponent(btAlterarTurma)))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btCancelarTurma)
                    .addComponent(btExcluirTurma, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jTabbedPane1.getAccessibleContext().setAccessibleName("Endereço");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(73, 73, 73))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1311, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btAlterarTurmaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAlterarTurmaActionPerformed
        try {
            getDados();
            new TurmaDAO().atualizar(turma);
        } catch (SQLException ex) {
            Logger.getLogger(DlgGerenciadorTurma.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btAlterarTurmaActionPerformed

    private void btRemoverDisciplinaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btRemoverDisciplinaActionPerformed
        if (tbDisciplinas.getSelectedRow() < 0) {
            JOptionPane.showMessageDialog(this, "Por favor, selecione uma disciplina antes de remover!");
        } else {
            int resposta = JOptionPane.showConfirmDialog(null, "Deseja remover esta disciplina?", "Aviso", JOptionPane.YES_NO_OPTION);
            if (resposta == JOptionPane.YES_OPTION) {
                disciplinaTableModel = new DisciplinaTurmaTableModel(listaDeDisciplinas);
                Disciplina disciplina = disciplinaTableModel.getDisciplina(tbDisciplinas.getSelectedRow());
                listaDeDisciplinas.remove(disciplina);
                atualizarTabelaDisciplinas(disciplinaTableModel);
            } else {
                tbDisciplinas.clearSelection();
            }
        }
    }//GEN-LAST:event_btRemoverDisciplinaActionPerformed

    private void btAdicionarDisciplinaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAdicionarDisciplinaActionPerformed
        String nomeDisciplina = tfNomeDisciplina.getText();
        Date dataInicio = dateInicioDisciplina.getDate();
        Date dataTermino = dateTerminoDisciplina.getDate();
        if (campoVazio()) {
            JOptionPane.showMessageDialog(this, "Atenção! Todos os campos referentes à disciplina devem ser preenchidos.");
        } else if (dateTerminoDisciplina.getDate().compareTo(dateInicioDisciplina.getDate()) < 0) {
            JOptionPane.showMessageDialog(this, "A data de término não pode ser menor que a data de início!");
            dateTerminoDisciplina.setDate(null);

        } else {
            Disciplina novaDisciplina = new Disciplina(nomeDisciplina, dataInicio, dataTermino);
            listaDeDisciplinas.add(novaDisciplina);
            atualizarTabelaDisciplinas(disciplinaTableModel);
            limparCamposDisciplina();
        }
    }//GEN-LAST:event_btAdicionarDisciplinaActionPerformed

    private void btRemoverDiaDaSemanaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btRemoverDiaDaSemanaActionPerformed
        if (listDiasDeAulaDaTurma.getSelectedIndex() < 0) {
            JOptionPane.showMessageDialog(this, "Por favor, selecione um dia de aula antes de remover!");
        } else {
            String diaDeAula = listDiasDeAulaDaTurma.getSelectedValue().toString();
            listaDeDiasDeAulaDaTurma.remove(diaDeAula);
            atualizarListaDeAulasDaTurma();
        }
    }//GEN-LAST:event_btRemoverDiaDaSemanaActionPerformed

    private void btAdicionarDiaDaSemanaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAdicionarDiaDaSemanaActionPerformed
        if (listDiasDaSemana.getSelectedIndex() < 0) {
            JOptionPane.showMessageDialog(this, "Por favor, selecione um dia da semana antes de adicionar!");
        } else {
            verificarDiaRepetido(listDiasDaSemana.getSelectedValue());
        }
    }//GEN-LAST:event_btAdicionarDiaDaSemanaActionPerformed

    private void btExcluirTurmaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExcluirTurmaActionPerformed
        int resposta = JOptionPane.showConfirmDialog(this, "Deseja realmente excluir esta turma?", "Aviso", JOptionPane.YES_NO_OPTION);
        try {
            if (resposta == JOptionPane.YES_OPTION) {
                if (new TurmaDAO().remover(turma)) {
                    JOptionPane.showMessageDialog(this, "Turma excluída com sucesso!");
                    estadoInicial();
                    limparTodosCampos();
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(DlgGerenciadorTurma.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btExcluirTurmaActionPerformed

    private void btConsultarTurmaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btConsultarTurmaActionPerformed
        this.setVisible(false);
        new DlgConsultarTurma(null, true).setVisible(true);
    }//GEN-LAST:event_btConsultarTurmaActionPerformed

    private void btCadastrarTurmaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCadastrarTurmaActionPerformed
        boolean resultado = false;
        try {
            getDados();
            resultado = new TurmaDAO().cadastrar(turma);
        } catch (SQLException ex) {
            Logger.getLogger(DlgGerenciadorTurma.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (resultado) {
            JOptionPane.showMessageDialog(this, "Turma cadastrada com sucesso!");
        } else {
            JOptionPane.showMessageDialog(this, "Ocorreu um erro!");
        }
        limparTodosCampos();
    }//GEN-LAST:event_btCadastrarTurmaActionPerformed

    private void btCancelarTurmaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelarTurmaActionPerformed
        limparTodosCampos();
        estadoInicial();
    }//GEN-LAST:event_btCancelarTurmaActionPerformed

    private void btRemoverProfessorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btRemoverProfessorActionPerformed
        if (tbProfessor.getSelectedRow() < 0) {
            JOptionPane.showMessageDialog(this, "Selecione um professor da tabela antes de remover!");
        } else {
            professorTableModel = new ProfessorTurmaTableModel(listaProfessoresTabela);
            Professor professor = professorTableModel.getProfessor(tbProfessor.getSelectedRow());
            listaProfessoresTabela.remove(professor);
            listaProfessoresCombo.add(professor);
            ordenarListaDeProfessorComboETabela();
            atualizarComboProfessor();
            atualizarTabelaProfessor(professorTableModel);
        }
    }//GEN-LAST:event_btRemoverProfessorActionPerformed

    private void btAdicionarProfessorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAdicionarProfessorActionPerformed
        if (cbProfessor.getSelectedIndex() >= 0) {
            Professor professor = (Professor) cbProfessor.getSelectedItem();
            listaProfessoresTabela.add(professor);
            listaProfessoresCombo.remove(professor);
            removerProfessorDoCombo(professor);
            ordenarListaDeProfessorComboETabela();
            atualizarTabelaProfessor(professorTableModel);
        } else {
            JOptionPane.showMessageDialog(this, "Escolha um professor na relação de professores para poder adicioná-lo!!");
        }
    }//GEN-LAST:event_btAdicionarProfessorActionPerformed

    private void btNovoCursoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNovoCursoActionPerformed
        new DlgGerenciadorCurso(null, true).setVisible(true);
        initComboBox();
    }//GEN-LAST:event_btNovoCursoActionPerformed

    private void btNovoProfessorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNovoProfessorActionPerformed
        new DlgGerenciadorProfessor(null, true).setVisible(true);
        initComboBox();
    }//GEN-LAST:event_btNovoProfessorActionPerformed

    private void btNovoSupervisorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNovoSupervisorActionPerformed
        new DlgGerenciadorSupervisor(null, true).setVisible(true);
        initComboBox();
    }//GEN-LAST:event_btNovoSupervisorActionPerformed

    private void btNovoOrientadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNovoOrientadorActionPerformed
        new DlgGerenciadorOrientador(null, true).setVisible(true);
        initComboBox();
    }//GEN-LAST:event_btNovoOrientadorActionPerformed

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
            java.util.logging.Logger.getLogger(DlgGerenciadorTurma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DlgGerenciadorTurma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DlgGerenciadorTurma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DlgGerenciadorTurma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                DlgGerenciadorTurma dialog = new DlgGerenciadorTurma(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btAdicionarDiaDaSemana;
    private javax.swing.JButton btAdicionarDisciplina;
    private javax.swing.JButton btAdicionarProfessor;
    private javax.swing.JButton btAlterarTurma;
    private javax.swing.JButton btCadastrarTurma;
    private javax.swing.JButton btCancelarTurma;
    private javax.swing.JButton btConsultarTurma;
    private javax.swing.JButton btExcluirTurma;
    private javax.swing.JButton btNovoCurso;
    private javax.swing.JButton btNovoOrientador;
    private javax.swing.JButton btNovoProfessor;
    private javax.swing.JButton btNovoSupervisor;
    private javax.swing.JButton btRemoverDiaDaSemana;
    private javax.swing.JButton btRemoverDisciplina;
    private javax.swing.JButton btRemoverProfessor;
    private javax.swing.JComboBox cbCurso;
    private javax.swing.JComboBox cbEstado;
    private javax.swing.JComboBox cbOrientador;
    private javax.swing.JComboBox cbProfessor;
    private javax.swing.JComboBox cbSupervisor;
    private javax.swing.JComboBox cbTurno;
    private com.toedter.calendar.JDateChooser dateInicioDisciplina;
    private com.toedter.calendar.JDateChooser dateInicioTurma;
    private com.toedter.calendar.JDateChooser dateTerminoDisciplina;
    private com.toedter.calendar.JDateChooser dateTerminoTurma;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JList jList1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JList listDiasDaSemana;
    private javax.swing.JList listDiasDeAulaDaTurma;
    private javax.swing.JTable tbDisciplinas;
    private javax.swing.JTable tbProfessor;
    private javax.swing.JTextField tfBairro;
    private javax.swing.JTextField tfCampusOfertante;
    private javax.swing.JTextField tfCidade;
    private javax.swing.JTextField tfCidadeDemandante;
    private javax.swing.JTextField tfEixoTecnologico;
    private javax.swing.JTextField tfNomeDisciplina;
    private javax.swing.JTextField tfNomeTurma;
    private javax.swing.JTextField tfNumero;
    private javax.swing.JTextField tfResponsavel;
    private javax.swing.JTextField tfRua;
    // End of variables declaration//GEN-END:variables

    private void limparTodosCampos() {
        tfBairro.setText(null);
        tfCampusOfertante.setText(null);
        tfCidade.setText(null);
        tfCidadeDemandante.setText(null);
        tfEixoTecnologico.setText(null);
        tfNomeDisciplina.setText(null);
        tfNomeTurma.setText(null);
        tfNumero.setText(null);
        tfRua.setText(null);
        tfResponsavel.setText(null);
        dateInicioDisciplina.setDate(null);
        dateInicioTurma.setDate(null);
        dateTerminoDisciplina.setDate(null);
        dateTerminoTurma.setDate(null);
        listDiasDaSemana.clearSelection();
        listDiasDeAulaDaTurma.clearSelection();
        tbDisciplinas.clearSelection();
        tbProfessor.clearSelection();
        cbCurso.setSelectedIndex(-1);
        cbEstado.setSelectedIndex(-1);
        cbOrientador.setSelectedIndex(-1);
        cbProfessor.setSelectedIndex(-1);
        cbSupervisor.setSelectedIndex(-1);
        cbTurno.setSelectedIndex(-1);
        
        disciplinaTableModel = new DisciplinaTurmaTableModel();
        tbDisciplinas.setModel(disciplinaTableModel);
        professorTableModel = new ProfessorTurmaTableModel();
        tbProfessor.setModel(professorTableModel);
        listaProfessoresTabela.clear();
        listaDeDiasDeAulaDaTurma.clear();
        listaDeDisciplinas.clear();
        listaProfessoresTabela.clear();
        lmDiasDeAula = new DefaultListModel();
        listDiasDeAulaDaTurma.setModel(lmDiasDeAula);
        initComboBox();
    }

    private void initComboBox() {
        cbCurso.removeAllItems();
        cbOrientador.removeAllItems();
        cbProfessor.removeAllItems();
        cbSupervisor.removeAllItems();
        listaDeCursos = new ArrayList();
        listaDeOrientadores = new ArrayList();
        listaProfessoresCombo = new ArrayList();
        listaDeSupervisores = new ArrayList();
        try {
            listaDeCursos = new CursoDAO().listarTodos();
        } catch (SQLException ex) {
            Logger.getLogger(DlgGerenciadorTurma.class.getName()).log(Level.SEVERE, null, ex);
        }
        for (Curso curso : listaDeCursos) {
            cbCurso.addItem(curso);
        }

        try {
            listaDeOrientadores = new OrientadorDAO().listarTodos();
        } catch (SQLException ex) {
            Logger.getLogger(DlgGerenciadorTurma.class.getName()).log(Level.SEVERE, null, ex);
        }
        for (Orientador orientador : listaDeOrientadores) {
            cbOrientador.addItem(orientador);
        }

        try {
            listaDeSupervisores = new SupervisorDAO().listarTodos();
        } catch (SQLException ex) {
            Logger.getLogger(DlgGerenciadorTurma.class.getName()).log(Level.SEVERE, null, ex);
        }
        for (Supervisor supervisor : listaDeSupervisores) {
            cbSupervisor.addItem(supervisor);
        }

        cbCurso.setSelectedIndex(-1);
        cbOrientador.setSelectedIndex(-1);
        cbSupervisor.setSelectedIndex(-1);
        cbEstado.setSelectedIndex(-1);
        cbTurno.setSelectedIndex(-1);

        try {
            listaProfessoresCombo = new ProfessorDAO().listarTodos();
        } catch (SQLException ex) {
            Logger.getLogger(DlgGerenciadorTurma.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (tbProfessor.getRowCount() == 0) {
            for (Professor professor : listaProfessoresCombo) {
                cbProfessor.addItem(professor);
            }

        } else {
            for (Professor professor : listaProfessoresCombo) {
                int cont = 0;
                for (int i = 0; i < tbProfessor.getRowCount(); i++) {
                    Object o = tbProfessor.getValueAt(i, 0);
                    if (professor.getNome().equals(o)) {
                        cont++;
                        break;
                    }
                }
                if (cont == 0) {
                    cbProfessor.addItem(professor);
                }
            }
        }
        cbProfessor.setSelectedIndex(-1);
        //ordenarListaDeProfessores();
    }

    private void atualizarListaDeAulasDaTurma() {
        DefaultListModel lmDiasDeAula = new DefaultListModel();

        for (String d : listaDeDiasDeAulaDaTurma) {
            lmDiasDeAula.addElement(d);
        }
        listDiasDeAulaDaTurma.setModel(lmDiasDeAula);
    }

    private void verificarDiaRepetido(Object dia) {
        if (!listaDeDiasDeAulaDaTurma.isEmpty()) {
            for (String diaAdicionado : listaDeDiasDeAulaDaTurma) {
                if (diaAdicionado.equals(dia)) {
                    JOptionPane.showMessageDialog(this, "Desculpe, esse dia da semana já foi adicionado!");
                    return;
                }
            }
        }
        listaDeDiasDeAulaDaTurma.add(dia.toString());
        atualizarListaDeAulasDaTurma();
    }

    private void limparCamposDisciplina() {
        tfNomeDisciplina.setText(null);
        dateInicioDisciplina.setDate(null);
        dateTerminoDisciplina.setDate(null);
        tfNomeDisciplina.requestFocus();
    }

    private void atualizarTabelaDisciplinas(DisciplinaTurmaTableModel disciplinaTable) {
        disciplinaTable = new DisciplinaTurmaTableModel((ArrayList<Disciplina>) listaDeDisciplinas);
        tbDisciplinas.setModel(disciplinaTable);
    }

    private boolean campoVazio() {
        return tfNomeDisciplina.getText() == null
                || tfNomeDisciplina.getText().equals("")
                || dateInicioDisciplina.getDate() == null
                || dateTerminoDisciplina.getDate() == null;
    }

    private void atualizarTabelaProfessor(ProfessorTurmaTableModel professorTable) {
        professorTable = new ProfessorTurmaTableModel((ArrayList<Professor>) listaProfessoresTabela);
        tbProfessor.setModel(professorTable);
    }

    private void removerProfessorDoCombo(Professor professor) {
        // o professor que for adicionado na tabela será removido da lista do combo de professores
        cbProfessor.removeItem(professor);
        
    }

    private void atualizarComboProfessor() {
        // o professor que for adicionado na tabela será adicionado novamente à lista do combo de professores
        cbProfessor.removeAllItems();
        for(Professor professor : listaProfessoresCombo){
            cbProfessor.addItem(professor);
        }
    }

    private void getDados() throws SQLException {
        turma = new Turma(tfCidadeDemandante.getText(),
                tfCampusOfertante.getText(),
                tfNomeTurma.getText(),
                cbTurno.getSelectedItem().toString(),
                listaDeDiasDeAulaDaTurma,
                dateInicioTurma.getDate(),
                dateTerminoTurma.getDate(),
                new Endereco(tfRua.getText(),
                        Integer.parseInt(tfNumero.getText()),
                        tfBairro.getText(),
                        cbEstado.getSelectedItem().toString(),
                        tfCidade.getText()),
                true,
                new OrientadorDAO().buscarPorNome(cbOrientador.getSelectedItem().toString()),
                new SupervisorDAO().buscarPorNome(cbSupervisor.getSelectedItem().toString()),
                listaProfessoresTabela,
                tfResponsavel.getText(),
                new CursoDAO().buscarPorNome(cbCurso.getSelectedItem().toString()),
                listaDeDisciplinas);

    }

    void recuperarDadosDeTurmaParaEdicao(int idTurma) throws SQLException {
        turma = new Turma();
        turma = new TurmaDAO().buscarPorId(idTurma);

        setDados();
        estadoEditarExcluir();
    }

    private void estadoEditarExcluir() {
        btExcluirTurma.setEnabled(true);
        btAlterarTurma.setEnabled(true);
        btCadastrarTurma.setEnabled(false);
        btConsultarTurma.setEnabled(false);
        btCancelarTurma.setEnabled(true);
    }

    private void setDados() {
        tfNomeTurma.setText(turma.getNome());
        tfCampusOfertante.setText(turma.getCampusOfertante());
        tfCidadeDemandante.setText(turma.getCidadeDemandande());
        tfEixoTecnologico.setText(turma.getCurso().getEixoTecnologico());
        tfCidade.setText(turma.getEndereco().getCidade());
        tfBairro.setText(turma.getEndereco().getBairro());
        tfNumero.setText(Integer.toString(turma.getEndereco().getNumero()));
        tfResponsavel.setText(turma.getResponsavel());
        tfRua.setText(turma.getEndereco().getRua());
        dateInicioTurma.setDate(turma.getDataInicioAulas());
        dateTerminoTurma.setDate(turma.getDataTerminoAulas());
        cbEstado.setSelectedItem(turma.getEndereco().getEstado());
        cbCurso.setSelectedItem(turma.getCurso());
        cbOrientador.setSelectedItem(turma.getOrientador());
        cbSupervisor.setSelectedItem(turma.getSupervisor());
        cbTurno.setSelectedItem(turma.getTurno());
        listaDeDiasDeAulaDaTurma = turma.getAulasSemana();
        atualizarListaDeAulasDaTurma();
        if (!turma.getProfessores().isEmpty()) {
            for (Professor professor : turma.getProfessores()) {
                listaProfessoresCombo.remove(professor);
            }
            cbProfessor.removeAllItems();
            for (Professor professor : listaProfessoresCombo) {
                cbProfessor.addItem(professor);
            }
            listaProfessoresTabela = turma.getProfessores();
            atualizarTabelaProfessor(professorTableModel);
        }

        listaDeDisciplinas = turma.getDisciplinas();
        atualizarTabelaDisciplinas(disciplinaTableModel);
    }

    private void estadoInicial() {
        btCadastrarTurma.setEnabled(true);
        btCancelarTurma.setEnabled(true);
        btConsultarTurma.setEnabled(true);
        btAlterarTurma.setEnabled(false);
        btExcluirTurma.setEnabled(false);
    }

    private void ordenarListaDeProfessorComboETabela() {
        Collections.sort(listaProfessoresCombo, new Comparador());
        Collections.sort(listaProfessoresTabela, new Comparador());
    }
}
