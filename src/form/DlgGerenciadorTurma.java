package form;

import dao.CursoDAO;
import dao.OrientadorDAO;
import dao.ProfessorDAO;
import dao.SupervisorDAO;
import dao.TurmaDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
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
    List<Professor> listaDeProfessores = new ArrayList<>();
    DisciplinaTurmaTableModel disciplinaTableModel = new DisciplinaTurmaTableModel();
    DefaultListModel lmDiasDeAula;
    ProfessorTurmaTableModel professorTableModel = new ProfessorTurmaTableModel();
    Turma turma;

    public DlgGerenciadorTurma(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        initComboBox();
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        tfNomeTurma = new javax.swing.JTextField();
        cbCurso = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        cbProfessor = new javax.swing.JComboBox();
        cbOrientador = new javax.swing.JComboBox();
        cbSupervisor = new javax.swing.JComboBox();
        btNovoOrientador = new javax.swing.JButton();
        btNovoSupervisor = new javax.swing.JButton();
        btNovoProfessor = new javax.swing.JButton();
        btNovoCurso = new javax.swing.JButton();
        jScrollPane7 = new javax.swing.JScrollPane();
        tbProfessor = new javax.swing.JTable();
        btAdicionarProfessor = new javax.swing.JButton();
        btRemoverProfessor = new javax.swing.JButton();
        tfCidadeDemandante = new javax.swing.JTextField();
        tfCampusOfertante = new javax.swing.JTextField();
        tfResponsavel = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel11 = new javax.swing.JLabel();
        dateInicioTurma = new com.toedter.calendar.JDateChooser();
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
        jLabel12 = new javax.swing.JLabel();
        cbTurno = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        listDiasDaSemana = new javax.swing.JList();
        jLabel9 = new javax.swing.JLabel();
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
        jScrollPane3 = new javax.swing.JScrollPane();
        tbDisciplinas = new javax.swing.JTable();
        btAdicionarDisciplina = new javax.swing.JButton();
        btRemoverDisciplina = new javax.swing.JButton();
        jLabel23 = new javax.swing.JLabel();
        dateTerminoTurma = new com.toedter.calendar.JDateChooser();
        jLabel13 = new javax.swing.JLabel();
        tfEixoTecnologico = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        btCancelarTurma = new javax.swing.JButton();
        btCadastrarTurma = new javax.swing.JButton();
        btConsultarTurma = new javax.swing.JButton();
        btAlterarTurma = new javax.swing.JButton();
        btExcluirTurma = new javax.swing.JButton();

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

        jLabel1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel1.setText("Curso:");

        jLabel2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel2.setText("Nome da Turma:");

        jLabel3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel3.setText("Cidade Demandante:");

        jLabel4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel4.setText("Campus Ofertante:");

        jLabel7.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel7.setText("Orientador:");

        jLabel8.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel8.setText("Supervisor:");

        jLabel5.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel5.setText("Responsável:");

        tfNomeTurma.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        cbCurso.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel6.setText("Professor:");

        cbProfessor.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        cbOrientador.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        cbSupervisor.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

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

        btNovoCurso.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btNovoCurso.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/MiniCurso.png"))); // NOI18N
        btNovoCurso.setText("Novo Curso");
        btNovoCurso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btNovoCursoActionPerformed(evt);
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

        tfCidadeDemandante.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        tfCampusOfertante.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        tfResponsavel.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jLabel11.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel11.setText("Inicio Turma:");

        dateInicioTurma.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Endereço", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 14), new java.awt.Color(0, 102, 255))); // NOI18N

        jLabel14.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel14.setText("Rua:");

        jLabel15.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel15.setText("Bairro:");

        jLabel19.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel19.setText("Cidade:");

        tfRua.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        jLabel20.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel20.setText("Numero:");

        tfNumero.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        tfBairro.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        tfCidade.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        jLabel18.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel18.setText("Estado:");

        cbEstado.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cbEstado.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Acre", "Alagoas", "Amapá", "Amazonas", "Bahia", "Ceará", "Distrito Federal", "Goiás", "Espírito Santo", "Maranhão", "Mato Grosso", "Mato Grosso do Sul", "Minas Gerais", "Pará", "Paraiba", "Paraná", "Pernambuco", "Piauí", "Rio de Janeiro", "Rio Grande do Norte", "Rio Grande do Sul", "Rondônia", "Rorâima", "São Paulo", "Santa Catarina", "Sergipe", "Tocantins" }));
        cbEstado.setSelectedIndex(-1);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel19)
                    .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tfRua)
                            .addComponent(tfBairro, javax.swing.GroupLayout.DEFAULT_SIZE, 231, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel20)
                        .addGap(18, 18, 18)
                        .addComponent(tfNumero))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(tfCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel18)
                        .addGap(18, 18, 18)
                        .addComponent(cbEstado, 0, 163, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(tfRua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20)
                    .addComponent(tfNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(tfBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(tfCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18)
                    .addComponent(cbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel12.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel12.setText("Turno:");

        cbTurno.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cbTurno.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Matutino", "Vespertino", "Noturno", "Integral" }));
        cbTurno.setSelectedIndex(-1);

        listDiasDaSemana.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        listDiasDaSemana.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Segunda-Feira", "Terça-Feira", "Quarta-Feira", "Quinta-Feira", "Sexta-Feira", "Sábado", "Domingo" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(listDiasDaSemana);

        jLabel9.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel9.setText("Dias De Aula:");

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

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Disciplinas", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 14), new java.awt.Color(0, 102, 255))); // NOI18N

        jLabel10.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel10.setText("Nome:");

        jLabel21.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel21.setText("Data Inicio:");

        jLabel22.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel22.setText("Data Término:");

        tfNomeDisciplina.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        dateInicioDisciplina.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        dateTerminoDisciplina.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        tbDisciplinas.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        tbDisciplinas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome", "Data de Início", "Data de Término"
            }
        ));
        jScrollPane3.setViewportView(tbDisciplinas);

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

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel22)
                            .addComponent(jLabel21, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(dateInicioDisciplina, javax.swing.GroupLayout.DEFAULT_SIZE, 221, Short.MAX_VALUE)
                            .addComponent(tfNomeDisciplina)
                            .addComponent(dateTerminoDisciplina, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(btAdicionarDisciplina)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 147, Short.MAX_VALUE)
                        .addComponent(btRemoverDisciplina)))
                .addContainerGap())
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
                        .addGap(18, 18, 18)
                        .addComponent(jLabel21))
                    .addComponent(dateInicioDisciplina, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel22)
                    .addComponent(dateTerminoDisciplina, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btAdicionarDisciplina)
                    .addComponent(btRemoverDisciplina))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel23.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel23.setText("Término Turma:");

        dateTerminoTurma.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        jLabel13.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel13.setText("Eixo Técnológico:");

        tfEixoTecnologico.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        jPanel2.setLayout(new java.awt.GridLayout(1, 0));

        jPanel3.setLayout(new java.awt.GridLayout(1, 0));

        btCancelarTurma.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btCancelarTurma.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Cancelar.png"))); // NOI18N
        btCancelarTurma.setText("Cancelar");
        btCancelarTurma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelarTurmaActionPerformed(evt);
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

        btAlterarTurma.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btAlterarTurma.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Alterar.png"))); // NOI18N
        btAlterarTurma.setText("Alterar");
        btAlterarTurma.setEnabled(false);
        btAlterarTurma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAlterarTurmaActionPerformed(evt);
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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(tfCidadeDemandante, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel8)
                            .addComponent(jLabel6)
                            .addComponent(jLabel2)
                            .addComponent(jLabel13)
                            .addComponent(jLabel1)
                            .addComponent(jLabel7))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tfEixoTecnologico, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tfNomeTurma, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbProfessor, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(btNovoProfessor, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(tfResponsavel, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfCampusOfertante, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(cbCurso, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btNovoCurso, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(cbOrientador, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btNovoOrientador, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(cbSupervisor, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btNovoSupervisor))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btAdicionarProfessor)
                            .addComponent(btRemoverProfessor)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel23)
                            .addComponent(jLabel11))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(dateInicioTurma, javax.swing.GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE)
                            .addComponent(dateTerminoTurma, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(btExcluirTurma, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btCancelarTurma, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 411, Short.MAX_VALUE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btCadastrarTurma, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(btConsultarTurma, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btAlterarTurma, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cbTurno, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel9)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btAdicionarDiaDaSemana))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btRemoverDiaDaSemana)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSeparator1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel1)
                                    .addComponent(cbCurso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btNovoCurso))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel13)
                                    .addComponent(tfEixoTecnologico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel2)
                                    .addComponent(tfNomeTurma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel3)
                                    .addComponent(tfCidadeDemandante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4)
                                    .addComponent(tfCampusOfertante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel5)
                                    .addComponent(tfResponsavel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel7)
                                    .addComponent(cbOrientador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btNovoOrientador))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel8)
                                    .addComponent(cbSupervisor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btNovoSupervisor))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel6)
                                    .addComponent(cbProfessor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btNovoProfessor))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(btAdicionarProfessor)
                                        .addGap(46, 46, 46)
                                        .addComponent(btRemoverProfessor))
                                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(dateInicioTurma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel11))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(dateTerminoTurma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel23)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(cbTurno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel12))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel9)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(20, 20, 20)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(btAdicionarDiaDaSemana)
                                            .addComponent(btRemoverDiaDaSemana))
                                        .addGap(18, 18, 18)))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(btCadastrarTurma)
                                                .addComponent(btConsultarTurma))
                                            .addComponent(btAlterarTurma, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(btCancelarTurma)
                                            .addComponent(btExcluirTurma, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(170, 170, 170)
                                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLabel1, jLabel2, jLabel3, jLabel4, jLabel5, jLabel7, jLabel8});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1322, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 673, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btNovoCursoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNovoCursoActionPerformed
        new DlgGerenciadorCurso(null, true).setVisible(true);
        initComboBox();
    }//GEN-LAST:event_btNovoCursoActionPerformed

    private void btNovoOrientadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNovoOrientadorActionPerformed
        new DlgGerenciadorOrientador(null, true).setVisible(true);
        initComboBox();
    }//GEN-LAST:event_btNovoOrientadorActionPerformed

    private void btNovoSupervisorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNovoSupervisorActionPerformed
        new DlgGerenciadorSupervisor(null, true).setVisible(true);
        initComboBox();
    }//GEN-LAST:event_btNovoSupervisorActionPerformed

    private void btNovoProfessorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNovoProfessorActionPerformed
        new DlgGerenciadorProfessor(null, true).setVisible(true);
        initComboBox();
    }//GEN-LAST:event_btNovoProfessorActionPerformed

    private void btCancelarTurmaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelarTurmaActionPerformed
        limparTodosCampos();
        estadoInicial();
    }//GEN-LAST:event_btCancelarTurmaActionPerformed

    private void btAdicionarProfessorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAdicionarProfessorActionPerformed
        if (cbProfessor.getSelectedIndex() >= 0) {
            Professor professor = (Professor) cbProfessor.getSelectedItem();
            listaDeProfessores.add(professor);
            atualizarTabelaProfessor(professorTableModel);
            removerProfessorDoCombo(professor);
        } else {
            JOptionPane.showMessageDialog(this, "Escolha um professor na relação de professores para poder adicioná-lo!!");
        }
    }//GEN-LAST:event_btAdicionarProfessorActionPerformed

    private void btRemoverProfessorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btRemoverProfessorActionPerformed
        if (tbProfessor.getSelectedRow() < 0) {
            JOptionPane.showMessageDialog(this, "Selecione um professor da tabela antes de remover!");
        } else {
            int resposta = JOptionPane.showConfirmDialog(null, "Deseja remover este professor da turma?", "Aviso", JOptionPane.YES_NO_OPTION);
            if (resposta == JOptionPane.YES_OPTION) {
                professorTableModel = new ProfessorTurmaTableModel(listaDeProfessores);
                Professor professor = professorTableModel.getProfessor(tbProfessor.getSelectedRow());
                listaDeProfessores.remove(professor);
                atualizarTabelaProfessor(professorTableModel);
                adicionarProfessorAoCombo(professor);
            } else {
                tbProfessor.clearSelection();
            }
        }
    }//GEN-LAST:event_btRemoverProfessorActionPerformed

    private void btAdicionarDiaDaSemanaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAdicionarDiaDaSemanaActionPerformed
        if (listDiasDaSemana.getSelectedIndex() < 0) {
            JOptionPane.showMessageDialog(this, "Por favor, selecione um dia da semana antes de adicionar!");
        } else {
            verificarDiaRepetido(listDiasDaSemana.getSelectedValue());
        }
    }//GEN-LAST:event_btAdicionarDiaDaSemanaActionPerformed

    private void btRemoverDiaDaSemanaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btRemoverDiaDaSemanaActionPerformed
        if (listDiasDeAulaDaTurma.getSelectedIndex() < 0) {
            JOptionPane.showMessageDialog(this, "Por favor, selecione um dia de aula antes de remover!");
        } else {
            String diaDeAula = listDiasDeAulaDaTurma.getSelectedValue().toString();
            listaDeDiasDeAulaDaTurma.remove(diaDeAula);
            atualizarListaDeAulasDaTurma();
        }
    }//GEN-LAST:event_btRemoverDiaDaSemanaActionPerformed

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

    private void btCadastrarTurmaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCadastrarTurmaActionPerformed
        getDados();
        TurmaDAO turmaDAO = new TurmaDAO();
        boolean resultado = false;
        try {
            resultado = turmaDAO.cadastrar(turma);
        } catch (SQLException ex) {
            Logger.getLogger(DlgGerenciadorTurma.class.getName()).log(Level.SEVERE, null, ex);
        } 
        if (resultado) 
            JOptionPane.showMessageDialog(this, "Turma cadastrada com sucesso!");
        else JOptionPane.showMessageDialog(this, "Ocorreu um erro!");
        limparTodosCampos();
    }//GEN-LAST:event_btCadastrarTurmaActionPerformed

    private void btConsultarTurmaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btConsultarTurmaActionPerformed
        this.setVisible(false);
        new DlgConsultarTurma(null, true).setVisible(true); 
    }//GEN-LAST:event_btConsultarTurmaActionPerformed

    private void btAlterarTurmaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAlterarTurmaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btAlterarTurmaActionPerformed

    private void btExcluirTurmaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExcluirTurmaActionPerformed
        
    }//GEN-LAST:event_btExcluirTurmaActionPerformed

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
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JSeparator jSeparator1;
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
        dateInicioDisciplina.setToolTipText(null);
        dateInicioTurma.setToolTipText(null);
        dateTerminoDisciplina.setToolTipText(null);
        dateTerminoTurma.setToolTipText(null);
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

        tbProfessor.removeAll();

        listaDeDiasDeAulaDaTurma = new ArrayList<>();
        listaDeDisciplinas = new ArrayList<>();
        listaDeProfessores = new ArrayList<>();
        lmDiasDeAula = new DefaultListModel();
        listDiasDeAulaDaTurma.setModel(lmDiasDeAula);
    }

    private void initComboBox() {
        cbCurso.removeAllItems();
        cbOrientador.removeAllItems();
        cbProfessor.removeAllItems();
        cbSupervisor.removeAllItems();
        List<Curso> listaDeCursos = new ArrayList();
        List<Orientador> listaDeOrientadores = new ArrayList();
        List<Professor> listaProfessores = new ArrayList();
        List<Supervisor> listaDeSupervisores = new ArrayList();
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
            listaProfessores = new ProfessorDAO().listarTodos();
        } catch (SQLException ex) {
            Logger.getLogger(DlgGerenciadorTurma.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (tbProfessor.getRowCount() == 0) {
            for (Professor professor : listaProfessores) {
                cbProfessor.addItem(professor);
            }
        
        } else {
            for (Professor professor : listaProfessores) {
                int cont = 0;
                    for (int i = 0; i < tbProfessor.getRowCount(); i++) {
                        Object o = tbProfessor.getValueAt(i, 0);
                        if (professor.getNome().equals(o)) {
                            cont++;
                            break;
                        }
                    }
                    if (cont == 0) 
                        cbProfessor.addItem(professor);
                }
            }
        cbProfessor.setSelectedIndex(-1);
        ordenarListaDeProfessores();
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
        professorTable = new ProfessorTurmaTableModel((ArrayList<Professor>) listaDeProfessores);
        tbProfessor.setModel(professorTable);
    }

    private void removerProfessorDoCombo(Professor professor) {
        // o professor que for adicionado na tabela será removido da lista do combo de professores
        cbProfessor.removeItem(professor);

    }

    private void adicionarProfessorAoCombo(Professor professor) {
        // o professor que for adicionado na tabela será adicionado novamente à lista do combo de professores
        cbProfessor.addItem(professor);
    }

    private void ordenarListaDeProfessores() {
        Collections.sort(listaDeProfessores, new Comparator() {
            public int compare(Object o1, Object o2) {
                Professor p1 = (Professor) o1;
                Professor p2 = (Professor) o2;
                return p1.getNome().compareToIgnoreCase(p2.getNome());
            }
        });
    }

    private void getDados() {
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
                (Orientador)cbOrientador.getSelectedItem(), 
                (Supervisor) cbSupervisor.getSelectedItem(), 
                listaDeProfessores, 
                tfResponsavel.getText(),
                (Curso) cbCurso.getSelectedItem(), 
                listaDeDisciplinas);
        
    }

    void recuperarDadosDeTurmaParaEdicao(int idTurma) {
        //faz a pesquisa da turma passando um id
        //atribui ao objeto de turma instanciado globalmente nesse domínio
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
    }

    private void estadoInicial() {
        btCadastrarTurma.setEnabled(true);
        btCancelarTurma.setEnabled(true);
        btConsultarTurma.setEnabled(true);
        btAlterarTurma.setEnabled(false);
        btExcluirTurma.setEnabled(false);
    }
}