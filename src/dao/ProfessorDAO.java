package dao;

import connection.DBConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.ContaBancaria;
import model.Endereco;
import model.Professor;

/**
 *
 * @author Giseli e Keyve
 */
public class ProfessorDAO {

    public boolean cadastrar(Professor professor) throws SQLException {
        int idEndereco = inserirEndereco(professor);
        int idContaBancaria = inserirContaBancaria(professor);
        PreparedStatement pstm;
        String sqlProfessor = "INSERT INTO professor "
                + "(nome, cpf, rg, titulacao, telefone, email, dataEntrada, status, idEndereco, idContaBancaria)"
                + " VALUES (?, ?, ?, ?, ?, ?,?,?, ?, ?);";
        pstm = DBConnection.getConnection().prepareStatement(sqlProfessor);
        pstm.setString(1, professor.getNome());
        pstm.setString(2, professor.getCpf());
        pstm.setString(3, professor.getRg());
        pstm.setString(4, professor.getTitulacao());
        pstm.setString(5, professor.getTelefone());
        pstm.setString(6, professor.getEmail());
        pstm.setDate(7, new java.sql.Date(professor.getDataEntrada().getTime()));
        pstm.setBoolean(8, professor.isStatus());
        pstm.setInt(9, idEndereco);
        pstm.setInt(10, idContaBancaria);
        pstm.execute();
        pstm.close();
        DBConnection.close();
        return true;
    }

    private int inserirEndereco(Professor professor) throws SQLException {
        PreparedStatement pstm;
        String sqlEndereco = "INSERT INTO endereco (rua, numero, bairro, estado, cidade)"
                + " VALUES (?, ?, ?, ?, ?);";
        pstm = DBConnection.getConnection().prepareStatement(sqlEndereco);
        pstm.setString(1, professor.getEndereco().getRua());
        pstm.setInt(2, professor.getEndereco().getNumero());
        pstm.setString(3, professor.getEndereco().getBairro());
        pstm.setString(4, professor.getEndereco().getEstado());
        pstm.setString(5, professor.getEndereco().getCidade());
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

    private int inserirContaBancaria(Professor professor) throws SQLException {
        PreparedStatement pstm;
        String sqlContaBancaria = "INSERT INTO contabancaria (nomeBanco, agencia, numero)"
                + " VALUES (?, ?, ?);";
        pstm = DBConnection.getConnection().prepareStatement(sqlContaBancaria);
        pstm.setString(1, professor.getContaBancaria().getNomeBanco());
        pstm.setInt(2, professor.getContaBancaria().getAgencia());
        pstm.setInt(3, professor.getContaBancaria().getNumeroConta());
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

    public void atualizar(Professor professor) throws SQLException {
        PreparedStatement pstm;
        String sql;
        sql = "UPDATE professor p, endereco e, contabancaria cb SET p.nome = ?, p.cpf = ?, p.rg = ?, p.titulacao = ?, "
                + "p.telefone = ?, p.email = ?, p.dataEntrada = ?, p.status = ?, "
                + "e.rua = ?, e.numero = ?, e.bairro = ?, e.estado = ?, e.cidade = ?, "
                + "cb.nomeBanco = ?, cb.agencia = ?, cb.numero = ? "
                + "WHERE p.idProfessor = ? AND p.idEndereco = e.idEndereco AND p.idContaBancaria = cb.idContaBancaria;";

        pstm = DBConnection.getConnection().prepareStatement(sql);
        pstm.setString(1, professor.getNome());
        pstm.setString(2, professor.getCpf());
        pstm.setString(3, professor.getRg());
        pstm.setString(4, professor.getTitulacao());
        pstm.setString(5, professor.getTelefone());
        pstm.setString(6, professor.getEmail());
        pstm.setDate(7, new java.sql.Date(professor.getDataEntrada().getTime()));
        pstm.setBoolean(8, professor.isStatus());

        pstm.setString(9, professor.getEndereco().getRua());
        pstm.setInt(10, professor.getEndereco().getNumero());
        pstm.setString(11, professor.getEndereco().getBairro());
        pstm.setString(12, professor.getEndereco().getEstado());
        pstm.setString(13, professor.getEndereco().getCidade());

        pstm.setString(14, professor.getContaBancaria().getNomeBanco());
        pstm.setInt(15, professor.getContaBancaria().getAgencia());
        pstm.setInt(16, professor.getContaBancaria().getNumeroConta());

        pstm.setInt(17, professor.getId());
        pstm.execute();

        DBConnection.close();
    }

    public void remover(Professor professor) throws SQLException {
        PreparedStatement pstm;
        String sql = "DELETE FROM professor WHERE idProfessor = ?";
        pstm = DBConnection.getConnection().prepareStatement(sql);
        pstm.setInt(1, professor.getId());
        pstm.execute();
        pstm.close();
        DBConnection.close();
    }

    public Professor buscarPorNome(String nome) throws SQLException {
        PreparedStatement pstm;
        ResultSet rs;
        String sqlPesquisarPorNome = "SELECT * FROM Professor p, Endereco e, ContaBancaria cb WHERE p.Nome LIKE '%" + nome + "%' AND p.idEndereco = e.idEndereco AND p.idContaBancaria = cb.idContaBancaria;";
        pstm = DBConnection.getConnection().prepareStatement(sqlPesquisarPorNome);
        rs = pstm.executeQuery();
        Professor professor;
        while (rs.next()) {
            professor = transformarResultSet(rs);
            return professor;
        }
        return null;
    }
    
    public List<Professor> buscarPorNomeRetornandoAtributosSimples(String nome) throws SQLException{
        PreparedStatement pstm;
        ResultSet rs;
        String sqlPesquisarPorNome = "SELECT * FROM Professor p, Endereco e, ContaBancaria cb WHERE p.Nome "
                + "LIKE '%" + nome + "%' AND p.idEndereco = e.idEndereco AND p.idContaBancaria = "
                + "cb.idContaBancaria;";
        pstm = DBConnection.getConnection().prepareStatement(sqlPesquisarPorNome);        
        pstm.setString(1, nome);
        rs = pstm.executeQuery();
        List<Professor> professores =null;
        while (rs.next()) {
            Professor professor = new Professor(
                    rs.getInt("p.idProfessor"),
                    rs.getString("nome")
            );
            professores.add(professor);
        }
        return professores;
    }

    public Professor buscarPorCpf(String cpf) throws SQLException {
        PreparedStatement pstm;
        ResultSet rs;
        String sqlPesquisarPorCpf = "SELECT * FROM Professor p, Endereco e, ContaBancaria cb WHERE p.cpf = '" + cpf + "' AND p.idEndereco = e.idEndereco AND p.idContaBancaria = cb.idContaBancaria;";
        pstm = DBConnection.getConnection().prepareStatement(sqlPesquisarPorCpf);
        rs = pstm.executeQuery();
        Professor professor;
        while (rs.next()) {
            professor = transformarResultSet(rs);
            return professor;
        }
        return null;
    }

    public Professor buscarPorRg(String rg) throws SQLException {
        PreparedStatement pstm;
        ResultSet rs;
        String sqlPesquisarPorRg = "SELECT * FROM Professor p, Endereco e, ContaBancaria cb WHERE p.rg = '" + rg + "' AND p.idEndereco = e.idEndereco AND p.idContaBancaria = cb.idContaBancaria;";
        pstm = DBConnection.getConnection().prepareStatement(sqlPesquisarPorRg);
        rs = pstm.executeQuery();
        Professor professor;
        while (rs.next()) {
            professor = transformarResultSet(rs);
            return professor;
        }
        return null;
    }

    public Professor buscarPorId(int idProfessor) throws SQLException {
        String sql = "SELECT * FROM Professor p, Endereco e, ContaBancaria cb "
                + "WHERE p.idProfessor = ? "
                + "AND p.idEndereco = e.idEndereco AND p.idContaBancaria = cb.idContaBancaria;";
        PreparedStatement pstm = DBConnection.getConnection().prepareStatement(sql);
        pstm.setInt(1, idProfessor);
        pstm.execute();
        ResultSet rs = pstm.getResultSet();
        Professor professor;
        if (rs.first()) {
            professor = transformarResultSet(rs);
            return professor;
        } else {
            return null;
        }
    }

    public List<Professor> listarTodos() throws SQLException {
        String sql = "SELECT * FROM professor p, endereco e, contabancaria cb where p.idEndereco = e.idEndereco and p.idContaBancaria = cb.idContaBancaria ORDER BY p.nome";
        List<Professor> listaProfessor = new ArrayList<>();
        PreparedStatement ps = DBConnection.getConnection().prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        Professor professor;
        while (rs.next()) {
            professor = transformarResultSet(rs);
            listaProfessor.add(professor);
        }
        return listaProfessor;
    }

    public List<Professor> listarTodosComRelacaoAUmaTurma(int idTurma) throws SQLException {
        String sql = "SELECT  p.idprofessor, p.nome, p.cpf,  p.rg, p.email, p.telefone, p.titulacao, p.dataEntrada, "
                + "p.status FROM professor p, turma t, turma_professor tp where t.idTurma = ? AND "
                + "t.idTurma = tp.Turma_idTurma AND p.idprofessor = tp.Professor_idprofessor ORDER BY p.nome";
        List<Professor> listaProfessor = new ArrayList<>();
        PreparedStatement ps = DBConnection.getConnection().prepareStatement(sql);
        ps.setInt(1, idTurma);
        ResultSet rs = ps.executeQuery();
        Professor professor;
        while (rs.next()) {
            professor =  new Professor(
                rs.getInt("p.idProfessor"),
                rs.getString("p.nome"),
                rs.getString("p.cpf"),
                rs.getString("p.rg"),
                rs.getString("p.titulacao"),
                rs.getString("p.telefone"),
                rs.getString("p.email"),
                rs.getBoolean("p.status"),
                rs.getDate("p.dataEntrada"),null, null);
            listaProfessor.add(professor);
        }
        return listaProfessor;
    }
    
    public void assossiarATurma(List<Professor> listaProfessores,int idTurma) throws SQLException {
        if(listaProfessores.isEmpty())
            return;
        PreparedStatement pstm;
        String sqlTurmaEDisciplina = "INSERT INTO turma_professor (Turma_idTurma, Professor_idProfessor)"
                + "VALUES (?,?)";
        pstm = DBConnection.getConnection().prepareStatement(sqlTurmaEDisciplina);
        for (Professor professor : listaProfessores) {
            pstm.setInt(1, idTurma);
            pstm.setInt(2, professor.getId());
            pstm.execute();
        }
        pstm.close();
        DBConnection.close();
    }
    
    public void desassossiarATurma(List<Professor> listaProfessores,int idTurma) throws SQLException {
        if(listaProfessores.isEmpty())
            return;
        PreparedStatement pstm;
        String sqlTurmaEDisciplina = "DELETE FROM turma_professor WHERE Turma_idTurma = ? and Professor_idProfessor = ?";
        pstm = DBConnection.getConnection().prepareStatement(sqlTurmaEDisciplina);
        for (Professor professor : listaProfessores) {
            pstm.setInt(1, idTurma);
            pstm.setInt(2, professor.getId());
            pstm.execute();
        }
        pstm.close();
        DBConnection.close();
    }
    
    public Professor transformarResultSet(ResultSet rs) throws SQLException {
        Professor professor = new Professor(
                rs.getInt("p.idProfessor"),
                rs.getString("p.nome"),
                rs.getString("p.cpf"),
                rs.getString("p.rg"),
                rs.getString("p.titulacao"),
                rs.getString("p.telefone"),
                rs.getString("p.email"),
                rs.getBoolean("p.status"),
                rs.getDate("p.dataEntrada"),
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
                    )
        );
        return professor;
    }

    public List<Professor> consultarSQL(String sql) throws SQLException {
        PreparedStatement pstm;
        List<Professor> professores = new ArrayList<>();
        pstm = DBConnection.getConnection().prepareStatement(sql);
        ResultSet rs = pstm.executeQuery();
        while (rs.next()) {
            Professor professor = new Professor(
                    rs.getInt("p.idProfessor"),
                    rs.getString("p.nome"),
                    rs.getString("p.cpf"),
                    rs.getString("p.rg"),
                    rs.getString("p.titulacao"),
                    rs.getString("p.telefone"),
                    rs.getString("p.email"),
                    rs.getBoolean("p.status"),
                    rs.getDate("p.dataEntrada"),
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
                    )
            );
            professores.add(professor);
        }
        pstm.close();
        DBConnection.close();
        return professores;
    }
}
