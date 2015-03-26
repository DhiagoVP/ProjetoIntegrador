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
    private List<Aluno> aluno;
    private List<Beneficio> benefio;
    private double valorAPagar;
    private boolean pagar;
    private int diasLetivos;

    public Pagamento() {
    }

    public Pagamento(List<Aluno> aluno, List<Beneficio> benefio, double valorAPagar, int diasLetivos) {
        this.aluno = aluno;
        this.benefio = benefio;
        this.valorAPagar = valorAPagar;
        this.diasLetivos = diasLetivos;
    }
    
    public int getId() {
        return id;
    }

    public List<Aluno> getAluno() {
        return aluno;
    }

    public void setAluno(List<Aluno> aluno) {
        this.aluno = aluno;
    }

    public List<Beneficio> getBenefio() {
        return benefio;
    }

    public void setBenefio(List<Beneficio> benefio) {
        this.benefio = benefio;
    }

    public double getValorAPagar() {
        return valorAPagar;
    }

    public void setValorAPagar(double valorAPagar) {
        this.valorAPagar = valorAPagar;
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
}
