/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;

/**
 *
 * @author Ana Paula, Dhiago.
 */
public class Matricula {
    private int id;
    private Aluno aluno;
    private Turma turma;
    private Date dataInicio;
    private Date dataTermino;

    public Matricula(int id, Aluno aluno, Turma turma, Date dataInicio, Date dataTermino) {
        this.id = id;
        this.aluno = aluno;
        this.turma = turma;
        this.dataInicio = dataInicio;
        this.dataTermino = dataTermino;
    }

    public Matricula(Aluno aluno, Turma turma, Date dataInicio, Date dataTermino) {
        this.aluno = aluno;
        this.turma = turma;
        this.dataInicio = dataInicio;
        this.dataTermino = dataTermino;
    }

    public Matricula() {
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public Turma getTurma() {
        return turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Date getDataTermino() {
        return dataTermino;
    }

    public void setDataTermino(Date dataTermino) {
        this.dataTermino = dataTermino;
    }
    
    
}
