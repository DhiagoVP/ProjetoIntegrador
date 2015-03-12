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
    int id;
    Aluno aluno;
    Beneficio benefio;
    double valorAPagar;
    boolean pagar;

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
        if (pagar) {
            
        }
    }
}
