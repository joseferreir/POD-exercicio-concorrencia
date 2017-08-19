/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.pod.atividade.entyty;

import java.io.Serializable;

/**
 *
 * @author jose2
 */
public class Dados implements Serializable{
    private int ID;
    private String WHO;
    private long CREATED__IN;

    public Dados(int ID, String WHO, long CREATED__IN) {
        this.ID = ID;
        this.WHO = WHO;
        this.CREATED__IN = CREATED__IN;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getWHO() {
        return WHO;
    }

    public void setWHO(String WHO) {
        this.WHO = WHO;
    }

    public long getCREATED__IN() {
        return CREATED__IN;
    }

    public void setCREATED__IN(int CREATED__IN) {
        this.CREATED__IN = CREATED__IN;
    }

    
    
}
