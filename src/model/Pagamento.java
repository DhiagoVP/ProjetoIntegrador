/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Ana Paula
 */
public class Pagamento {
    private int id;
    private Aluno aluno;
    private Beneficio benefio;
    private double valorAPagar;
    private boolean pagar;
    private int diasLetivos;

    public int getId() {
        return id;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public Beneficio getBenefio() {
        return benefio;
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
