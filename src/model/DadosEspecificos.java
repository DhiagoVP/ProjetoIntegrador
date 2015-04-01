/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Acerpc
 */
public class DadosEspecificos {
    private String nroPanilha;
    private String sistec;
    private String lc;

    public DadosEspecificos(String nroPanilha, String sistec, String lc) {
        this.nroPanilha = nroPanilha;
        this.sistec = sistec;
        this.lc = lc;
    }

    public DadosEspecificos() {
    }

    public String getLc() {
        return lc;
    }

    public void setLc(String lc) {
        this.lc = lc;
    }

    public String getNroPanilha() {
        return nroPanilha;
    }

    public void setNroPanilha(String nroPanilha) {
        this.nroPanilha = nroPanilha;
    }

    public String getSistec() {
        return sistec;
    }

    public void setSistec(String sistec) {
        this.sistec = sistec;
    }
}
