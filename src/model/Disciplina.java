/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;

/**
 *
 * @author Ana Paula
 */
public class Disciplina {
    private int id;
    private String nome;
    private Date dataDeInicio;
    private Date dataDeTermino;

    public Disciplina(String nome, Date dataDeInicio, Date dataDeTermino) {
        this.nome = nome;
        this.dataDeInicio = dataDeInicio;
        this.dataDeTermino = dataDeTermino;
    }

    public Disciplina(int id, String nome, Date dataDeInicio, Date dataDeTermino) {
        this.id = id;
        this.nome = nome;
        this.dataDeInicio = dataDeInicio;
        this.dataDeTermino = dataDeTermino;
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

    public Date getDataDeInicio() {
        return dataDeInicio;
    }

    public void setDataDeInicio(Date dataDeInicio) {
        this.dataDeInicio = dataDeInicio;
    }

    public Date getDataDeTermino() {
        return dataDeTermino;
    }

    public void setDataDeTermino(Date dataDeTermino) {
        this.dataDeTermino = dataDeTermino;
    }
    
    
}
