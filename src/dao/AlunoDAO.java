package dao;

import connection.DBConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Aluno;
import model.ContaBancaria;
import model.Endereco;

/**
 *
 * @author Giseli e Keyve
 */
public class AlunoDAO {

    public boolean cadastrar(Aluno aluno) throws SQLException {
        int idEndereco = inserirEndereco(aluno);
        int idContaBancaria = inserirContaBancaria(aluno);
        PreparedStatement pstm;
        String sqlAluno = "INSERT INTO aluno "
                + "(nome, cpf, rg, dataNascimento, sexo, escolaridade, profissao,"
                + " telefone, email, situacao, observacao, idEndereco, idContaBancaria, idTurma)"
                + " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
        pstm = DBConnection.getConnection().prepareStatement(sqlAluno);
        pstm.setString(1, aluno.getNome());
        pstm.setString(2, aluno.getCpf());
        pstm.setString(3, aluno.getRg());
        pstm.setDate(4, new java.sql.Date(aluno.getDataNascimento().getTime()));
        pstm.setString(5, aluno.getSexo());
        pstm.setString(6, aluno.getEscolaridade());
        pstm.setString(7, aluno.getProfissao());
        pstm.setString(8, aluno.getTelefone());
        pstm.setString(9, aluno.getEmail());
        pstm.setString(10, aluno.getSituacao());
        pstm.setString(11, aluno.getObservacoes());
        pstm.setInt(12, idEndereco);
        pstm.setInt(13, idContaBancaria);
        pstm.setInt(14, aluno.getIdTurma());
        pstm.execute();
        pstm.close();
        DBConnection.close();
        return true;
    }

    private int inserirEndereco(Aluno aluno) throws SQLException {
        PreparedStatement pstm;
        String sqlEndereco = "INSERT INTO endereco (rua, numero, bairro, estado, cidade)"
                + " VALUES (?, ?, ?, ?, ?);";
        pstm = DBConnection.getConnection().prepareStatement(sqlEndereco);
        pstm.setString(1, aluno.getEndereco().getRua());
        pstm.setInt(2, aluno.getEndereco().getNumero());
        pstm.setString(3, aluno.getEndereco().getBairro());
        pstm.setString(4, aluno.getEndereco().getEstado());
        pstm.setString(5, aluno.getEndereco().getCidade());
        pstm.execute();
        ResultSet rs;
        int id = -1;
        String sqlPesquisa = "SELECT MAX(idEndereco) FROM Endereco;";
        pstm = DBConnection.getConnection().prepareStatement(sqlPesquisa);
        rs = pstm.executeQuery();
        if (rs.next()) {
            id = rs.getInt("MAX(idEndereco)");
        }
        return id;
    }

    private int inserirContaBancaria(Aluno aluno) throws SQLException {
        PreparedStatement pstm;
        String sqlContaBancaria = "INSERT INTO contabancaria (nomeBanco, agencia, numero)"
                + " VALUES (?, ?, ?);";
        pstm = DBConnection.getConnection().prepareStatement(sqlContaBancaria);
        pstm.setString(1, aluno.getContaBancaria().getNomeBanco());
        pstm.setInt(2, aluno.getContaBancaria().getAgencia());
        pstm.setInt(3, aluno.getContaBancaria().getNumeroConta());
        pstm.execute();
        ResultSet rs;
        int id = -1;
        String sqlPesquisa = "SELECT MAX(idContaBancaria) FROM contabancaria;";
        pstm = DBConnection.getConnection().prepareStatement(sqlPesquisa);
        rs = pstm.executeQuery();
        if (rs.next()) {
            id = rs.getInt("MAX(idContaBancaria)");
            return id;
        }
        return id;
    }

    public void atualizar(Aluno aluno) throws SQLException {
        PreparedStatement pstm;
        String sql = "UPDATE aluno a, endereco e, contabancaria cb SET a.nome = ?, "
                + "a.cpf = ?, a.rg = ?, a.dataNascimento = ?,"
                + "a.sexo = ?, a.escolaridade = ?, a.profissao = ?, a.telefone = ?, "
                + "a.email = ?, a.situacao = ?, a.observacao = ?, a.idTurma = ?"
                + "e.rua = ?, e.numero = ?, e.bairro = ?, e.estado = ?, e.cidade = ?, "
                + "cb.nomeBanco = ?, cb.agencia = ?, cb.numero = ? "
                + "WHERE a.idAluno = ? AND a.idEndereco = e.idEndereco AND a.idContaBancaria = cb.idContaBancaria;";

        pstm = DBConnection.getConnection().prepareStatement(sql);
        pstm.setString(1, aluno.getNome());
        pstm.setString(2, aluno.getCpf());
        pstm.setString(3, aluno.getRg());
        pstm.setDate(4, new java.sql.Date(aluno.getDataNascimento().getTime()));
        pstm.setString(5, aluno.getSexo());
        pstm.setString(6, aluno.getEscolaridade());
        pstm.setString(7, aluno.getProfissao());
        pstm.setString(8, aluno.getTelefone());
        pstm.setString(9, aluno.getEmail());
        pstm.setString(10, aluno.getSituacao());
        pstm.setString(11, aluno.getObservacoes());
        pstm.setInt(12, aluno.getIdTurma());

        pstm.setString(13, aluno.getEndereco().getRua());
        pstm.setInt(14, aluno.getEndereco().getNumero());
        pstm.setString(15, aluno.getEndereco().getBairro());
        pstm.setString(16, aluno.getEndereco().getEstado());
        pstm.setString(17, aluno.getEndereco().getCidade());

        pstm.setString(18, aluno.getContaBancaria().getNomeBanco());
        pstm.setInt(19, aluno.getContaBancaria().getAgencia());
        pstm.setInt(20, aluno.getContaBancaria().getNumeroConta());

        pstm.setInt(21, aluno.getId());

        pstm.execute();

        DBConnection.close();
    }

    public void remover(Aluno aluno) throws SQLException {
        PreparedStatement pstm;
        String sql = "DELETE FROM aluno WHERE idAluno = ?";
        pstm = DBConnection.getConnection().prepareStatement(sql);
        pstm.setInt(1, aluno.getId());
        pstm.execute();
        pstm.close();
        DBConnection.close();
    }

    public Aluno buscarPorNome(String nome) throws SQLException {
        PreparedStatement pstm;
        ResultSet rs;
        String sqlPesquisarPorNome = "SELECT * FROM Aluno a, Endereco e, ContaBancaria cb "
                + "WHERE a.Nome LIKE '" + nome + "%' OR a.Nome LIKE '%" + nome + "%' "
                + "AND a.idEndereco = e.idEndereco AND a.idContaBancaria = cb.idContaBancaria;";
        pstm = DBConnection.getConnection().prepareStatement(sqlPesquisarPorNome);
        rs = pstm.executeQuery();
        Aluno aluno;
        while (rs.next()) {
            aluno = transformarResultSet(rs);
            return aluno;
        }
        return null;
    }

    public Aluno buscarPorCpf(String cpf) throws SQLException {
        PreparedStatement pstm;
        ResultSet rs;
        String sqlPesquisarPorCpf = "SELECT * FROM Aluno a, Endereco e, ContaBancaria cb "
                + "WHERE a.cpf = \"" + cpf + "\" "
                + "AND a.idEndereco = e.idEndereco AND a.idContaBancaria = cb.idContaBancaria;";
        pstm = DBConnection.getConnection().prepareStatement(sqlPesquisarPorCpf);
        rs = pstm.executeQuery();
        Aluno aluno;
        while (rs.next()) {
            aluno = transformarResultSet(rs);
            return aluno;
        }
        return null;
    }

    public Aluno buscarPorRg(String rg) throws SQLException {
        PreparedStatement pstm;
        ResultSet rs;
        String sqlPesquisarPorRg = "SELECT * FROM Aluno a, Endereco e, ContaBancaria cb "
                + "WHERE a.rg = \"" + rg + "\" "
                + "AND a.idEndereco = e.idEndereco AND a.idContaBancaria = cb.idContaBancaria;";
        pstm = DBConnection.getConnection().prepareStatement(sqlPesquisarPorRg);
        rs = pstm.executeQuery();
        Aluno aluno;
        while (rs.next()) {
            aluno = transformarResultSet(rs);
            return aluno;
        }
        return null;
    }

    public Aluno buscarPorId(int idAluno) throws SQLException {
        PreparedStatement pstm;
        ResultSet rs;
        String sql = "SELECT * FROM Aluno a, Endereco e, ContaBancaria cb "
                + "WHERE a.idAluno = " + idAluno + " "
                + "AND a.idEndereco = e.idEndereco AND a.idContaBancaria = cb.idContaBancaria;";
         pstm = DBConnection.getConnection().prepareStatement(sql);
         rs = pstm.executeQuery();
        Aluno aluno = null;
        if (rs.first()) 
            aluno = transformarResultSet(rs);
        return aluno;
    }
    
    public List<Aluno> buscarPorTurma(int idTurma) throws SQLException{
        String sql = "SELECT a.idAluno, a.cpf, a.nome, a.situacao FROM aluno a, turma t, aluno_turma al_t "
                + "WHERE al_t.idTurma = ? AND a.idAluno = al_t.idAluno AND t.idTurma = al_t.idTurma";
        List<Aluno> listaAlunos = new ArrayList<>();
        PreparedStatement ps = DBConnection.getConnection().prepareStatement(sql);
        ps.setInt(1, idTurma);
        ResultSet rs = ps.executeQuery();
        Aluno aluno;
        while (rs.next()) {
            aluno =  new Aluno(
                rs.getInt("a.idAluno"),
                rs.getString("a.nome"),
                rs.getString("a.cpf"),
                rs.getString("a.situacao"));
            listaAlunos.add(aluno);
        }
        return listaAlunos;
    }
    
    public List<Aluno> listarTodos() throws SQLException {
        String sql = "SELECT * FROM aluno a, endereco e, contabancaria cb WHERE a.idEndereco = e.idEndereco AND a.idContaBancaria = cb.idContaBancaria ORDER BY a.nome;";
        List<Aluno> listaAluno = new ArrayList<>();
        PreparedStatement ps = DBConnection.getConnection().prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        Aluno aluno;
        while (rs.next()) {
            aluno = transformarResultSet(rs);
            listaAluno.add(aluno);
        }
        return listaAluno;
    }
    
    public List<Aluno> listarTodosSemMatricula() throws SQLException {
        String sql = "SELECT * FROM Aluno a, endereco e, contabancaria cb WHERE a.situacao = 'SemMatricula' AND a.idEndereco = e.idEndereco AND a.idContaBancaria = cb.idContaBancaria ORDER BY a.nome;";
        List<Aluno> listaAluno = new ArrayList<>();
        PreparedStatement ps = DBConnection.getConnection().prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        Aluno aluno;
        while (rs.next()) {
            aluno = transformarResultSet(rs);
            listaAluno.add(aluno);
        }
        return listaAluno;
    }
    
    public void AtualizarSituação(Aluno aluno) throws SQLException {
        PreparedStatement pstm;
        String sql = "UPDATE Aluno SET situacao = 'Em curso' WHERE idAluno = ?;";
        pstm = DBConnection.getConnection().prepareStatement(sql);
        pstm.setInt(1, aluno.getId());
        pstm.execute();
        DBConnection.close();
    }

    public Aluno transformarResultSet(ResultSet rs) throws SQLException {
        Aluno aluno = new Aluno(
                rs.getInt("a.idAluno"),
                rs.getString("a.nome"),
                rs.getString("a.cpf"),
                rs.getString("a.rg"),
                rs.getDate("a.dataNascimento"),
                rs.getString("a.sexo"),
                rs.getString("a.escolaridade"),
                rs.getString("a.profissao"),
                rs.getString("a.telefone"),
                rs.getString("a.email"),
                rs.getString("a.situacao"),
                rs.getString("a.observacao"),
                new Endereco(
                        rs.getInt("e.idEndereco"),
                        rs.getString("e.rua"),
                        rs.getInt("e.numero"),
                        rs.getString("e.bairro"),
                        rs.getString("e.estado"),
                        rs.getString("e.cidade")
                ),
                new ContaBancaria(
                        rs.getInt("cb.idContaBancaria"),
                        rs.getString("cb.nomeBanco"),
                        rs.getInt("cb.agencia"),
                        rs.getInt("cb.numero")
                ),
                rs.getInt("a.idTurma")
        );
        return aluno;
    }

    public List<Aluno> consultarSQL(String sql) throws SQLException {
        PreparedStatement pstm;
        List<Aluno> alunos = new ArrayList<>();
        pstm = DBConnection.getConnection().prepareStatement(sql);
        ResultSet rs = pstm.executeQuery();
        while (rs.next()) {
            Aluno aluno = new Aluno(
                    rs.getInt("a.idAluno"),
                    rs.getString("a.nome"),
                    rs.getString("a.cpf"),
                    rs.getString("a.rg"),
                    rs.getDate("a.dataNascimento"),
                    rs.getString("a.sexo"),
                    rs.getString("a.escolaridade"),
                    rs.getString("a.profissao"),
                    rs.getString("a.telefone"),
                    rs.getString("a.email"),
                    rs.getString("a.situacao"),
                    rs.getString("a.observacao"),
                    new Endereco(
                            rs.getInt("e.idEndereco"),
                            rs.getString("e.rua"),
                            rs.getInt("e.numero"),
                            rs.getString("e.bairro"),
                            rs.getString("e.estado"),
                            rs.getString("e.cidade")
                    ),
                    new ContaBancaria(
                            rs.getInt("cb.idContaBancaria"),
                            rs.getString("cb.nomeBanco"),
                            rs.getInt("cb.agencia"),
                            rs.getInt("cb.numero")
                    ),
                    rs.getInt("a.idTurma")
            );
            alunos.add(aluno);
        }
        pstm.close();
        DBConnection.close();
        return alunos;
    }
}
