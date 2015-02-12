/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;

/**
 *
 * @author Acerpc
 */
public class RealizarMatricula {
    private Aluno aluno;
    private Turma turma;
    private Date dataMatricula;
    private Date dataTermino;

    public RealizarMatricula() {
    }

    public RealizarMatricula(Aluno aluno, Turma turma, Date dataMatricula, Date dataTermino) {
        this.aluno = aluno;
        this.turma = turma;
        this.dataMatricula = dataMatricula;
        this.dataTermino = dataTermino;
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

    public Date getDataMatricula() {
        return dataMatricula;
    }

    public void setDataMatricula(Date dataMatricula) {
        this.dataMatricula = dataMatricula;
    }

    public Date getDataTermino() {
        return dataTermino;
    }

    public void setDataTermino(Date dataTermino) {
        this.dataTermino = dataTermino;
    }
    
    
}
