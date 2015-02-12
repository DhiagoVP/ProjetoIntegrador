/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;
import java.util.List;

/**
 *
 * @author Giseli e Keyve
 */
public class Turma {

    private int id;
    private String cidadeDemandande;
    private String campusOfertante;
    private String nome;
    private String turno;
    private List<String> aulasSemana;
    private Date dataInicioAulas;
    private Date dataTerminoAulas;
    private Endereco endereco;
    private boolean statusTurma;
    private Orientador orientador;
    private Supervisor supervisor;
    private List<Professor> professores;
    private String responsavel;
    private Curso curso;
    private List<Disciplina> disciplinas;

    public Turma(int id, String cidadeDemandande, String campusOfertante, String nome, String turno,
            List<String> aulasSemana, Date dataInicioAulas, Date dataTerminoAulas, Endereco endereco, 
            boolean statusTurma,Orientador orientador, Supervisor supervisor, List<Professor> professores,
            String responsavel, Curso curso, List<Disciplina> disciplinas) {
        this.id = id;
        this.cidadeDemandande = cidadeDemandande;
        this.campusOfertante = campusOfertante;
        this.nome = nome;
        this.turno = turno;
        this.aulasSemana = aulasSemana;
        this.dataInicioAulas = dataInicioAulas;
        this.dataTerminoAulas = dataTerminoAulas;
        this.endereco = endereco;
        this.statusTurma = statusTurma;
        this.orientador = orientador;
        this.supervisor = supervisor;
        this.professores = professores;
        this.responsavel = responsavel;
        this.curso = curso;
        this.disciplinas = disciplinas;
    }

    public Turma(String cidadeDemandande, String campusOfertante, String nome, String turno, List<String> aulasSemana,
            Date dataInicioAulas, Date dataTerminoAulas, Endereco endereco, boolean statusTurma,
            Orientador orientador, Supervisor supervisor, List<Professor> professores, String responsavel,  Curso curso,
            List<Disciplina> disciplinas) {
        this.cidadeDemandande = cidadeDemandande;
        this.campusOfertante = campusOfertante;
        this.nome = nome;
        this.turno = turno;
        this.aulasSemana = aulasSemana;
        this.dataInicioAulas = dataInicioAulas;
        this.dataTerminoAulas = dataTerminoAulas;
        this.endereco = endereco;
        this.statusTurma = statusTurma;
        this.orientador = orientador;
        this.supervisor = supervisor;
        this.professores = professores;
        this.responsavel = responsavel;
        this.curso = curso;
        this.disciplinas = disciplinas;
    }

    public Turma() {
    }
    
    
    public String getCidadeDemandande() {
        return cidadeDemandande;
    }

    public void setCidadeDemandande(String cidadeDemandande) {
        this.cidadeDemandande = cidadeDemandande;
    }

    public String getCampusOfertante() {
        return campusOfertante;
    }

    public void setCampusOfertante(String campusOfertante) {
        this.campusOfertante = campusOfertante;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public Date getDataInicioAulas() {
        return dataInicioAulas;
    }

    public void setDataInicioAulas(Date inicioAulas) {
        this.dataInicioAulas = inicioAulas;
    }

    public Date getDataTerminoAulas() {
        return dataTerminoAulas;
    }

    public void setDataTerminoAulas(Date dataTerminoAulas) {
        this.dataTerminoAulas = dataTerminoAulas;
    }

    public boolean isStatusTurma() {
        return statusTurma;
    }

    public void setStatusTurma(boolean statusTurma) {
        this.statusTurma = statusTurma;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<String> getAulasSemana() {
        return aulasSemana;
    }

    public void setAulasSemana(List<String> aulasSemana) {
        this.aulasSemana = aulasSemana;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Orientador getOrientador() {
        return orientador;
    }

    public void setOrientador(Orientador orientador) {
        this.orientador = orientador;
    }

    public Supervisor getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(Supervisor supervisor) {
        this.supervisor = supervisor;
    }

    public List<Professor> getProfessores() {
        return professores;
    }

    public void setProfessores(List<Professor> professores) {
        this.professores = professores;
    }
    
    public String getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public List<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    public void setDisciplinas(List<Disciplina> disciplinas) {
        this.disciplinas = disciplinas;
    }

    @Override
    public String toString() {
        return nome;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + this.id;
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
        final Turma other = (Turma) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

}
