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
 * @author Ana Paula
 */
public class Pagamento {
    private int id;
    private List<Aluno> alunos;
    private List<Beneficio> beneficios;
    private double valorAPagarPorTurma;
    private boolean pagar;
    private int diasLetivos;
    private Turma turma;
    private String mes;
    private Date data;
    private Login login;
    
    public Pagamento() {
    }

    public Pagamento(int id, double valorAPagarPorTurma, Turma turma, String mes, Date data, Login login,
            int diasLetivos) {
        this.id = id;
        this.valorAPagarPorTurma = valorAPagarPorTurma;
        this.turma = turma;
        this.mes = mes;
        this.data = data;
        this.login = login;
        this.diasLetivos = diasLetivos;
    }
    
    public Pagamento(List<Aluno> alunos, List<Beneficio> benefios, double valorAPagarTurma, 
            int diasLetivos, String mes, Turma turma, Login login) {
        this.alunos = alunos;
        this.beneficios = benefios;
        this.valorAPagarPorTurma = valorAPagarTurma;
        this.diasLetivos = diasLetivos;
        this.turma = turma;
        this.mes = mes;
        this.login = login;
    }
    
    public int getId() {
        return id;
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(List<Aluno> alunos) {
        this.alunos = alunos;
    }

    public List<Beneficio> getBeneficios() {
        return beneficios;
    }

    public void setBeneficios(List<Beneficio> benefios) {
        this.beneficios = benefios;
    }

    public double getValorAPagarPorTurma() {
        return valorAPagarPorTurma;
    }

    public void setValorAPagarPorTurma(double valorAPagar) {
        this.valorAPagarPorTurma = valorAPagar;
    }

    public void setPagar(boolean pagar) {
        this.pagar = pagar;
    }
    public boolean isPagar() {
        return pagar;
    }
    
    public void calcularTotalAPagar(){
        if (isPagar()) {
            
        }
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }
    /**
     * @return the diasLetivos
     */
    public int getDiasLetivos() {
        return diasLetivos;
    }

    /**
     * @param diasLetivos the diasLetivos to set
     */
    public void setDiasLetivos(int diasLetivos) {
        this.diasLetivos = diasLetivos;
    }
    public Turma getTurma() {
        return turma;
    }
    
    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Login getUsuario() {
        return login;
    }

    public void setUsuario(Login login) {
        this.login = login;
    }
    
    
}
