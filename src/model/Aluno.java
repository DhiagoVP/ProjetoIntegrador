package model;

import java.util.Date;

/**
 *
 * @author Giseli e Keyve
 */
public class Aluno {

    private int id;
    private String nome;
    private String cpf;
    private String rg;
    private Date dataNascimento;
    private String sexo;
    private String escolaridade;
    private String profissao;
    private String telefone;
    private String email;
    private String situacao;
    private String observacoes;
    private Endereco endereco;
    private ContaBancaria contaBancaria;
    private int faltas;

    public int getFaltas() {
        return faltas;
    }

    public void setFaltas(int faltas) {
        this.faltas = faltas;
    }

    public Aluno(int id, String nome, String cpf, String rg, Date dataNascimento, String sexo, String escolaridade,
            String profissao, String telefone, String email, String situacao,
            String observacoes, Endereco endereco, ContaBancaria contaBancaria) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.rg = rg;
        this.dataNascimento = dataNascimento;
        this.sexo = sexo;
        this.escolaridade = escolaridade;
        this.profissao = profissao;
        this.telefone = telefone;
        this.email = email;
        this.situacao = situacao;
        this.observacoes = observacoes;
        this.endereco = endereco;
        this.contaBancaria = contaBancaria;
    }

    public Aluno(String nome, String cpf, String rg, Date dataNascimento, String sexo, String escolaridade, String profissao, String telefone, String email, String situacao, String observacoes, Endereco endereco, ContaBancaria contaBancaria) {
        this.nome = nome;
        this.cpf = cpf;
        this.rg = rg;
        this.dataNascimento = dataNascimento;
        this.sexo = sexo;
        this.escolaridade = escolaridade;
        this.profissao = profissao;
        this.telefone = telefone;
        this.email = email;
        this.situacao = situacao;
        this.observacoes = observacoes;
        this.endereco = endereco;
        this.contaBancaria = contaBancaria;
    }

    public Aluno() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getEscolaridade() {
        return escolaridade;
    }

    public void setEscolaridade(String escolaridade) {
        this.escolaridade = escolaridade;
    }

    public String getProfissao() {
        return profissao;
    }

    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public ContaBancaria getContaBancaria() {
        return contaBancaria;
    }

    public void setContaBancaria(ContaBancaria contaBancaria) {
        this.contaBancaria = contaBancaria;
    }

    @Override
    public String toString() {
        return nome;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Aluno other = (Aluno) obj;
        return this.id == other.id;
    }

}
