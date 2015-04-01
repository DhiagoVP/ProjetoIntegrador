/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.List;

/**
 *
 * @author Ana Paula
 */
public class Pagamento {
    private int id;
    private List<Aluno> alunos;
    private List<Beneficio> benefios;
    private double valorAPagarPorTurma;
    private boolean pagar;
    private int diasLetivos;
    private Turma turma;
    private String mes;
    
    public Pagamento() {
    }

    public Pagamento(List<Aluno> alunos, List<Beneficio> benefios, double valorAPagarTurma, int diasLetivos, String mes,
            Turma turma) {
        this.alunos = alunos;
        this.benefios = benefios;
        this.valorAPagarPorTurma = valorAPagarTurma;
        this.diasLetivos = diasLetivos;
        this.turma = turma;
        this.mes = mes;
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

    public List<Beneficio> getBenefios() {
        return benefios;
    }

    public void setBenefios(List<Beneficio> benefios) {
        this.benefios = benefios;
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
}
