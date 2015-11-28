package ijshockey;

import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author favdndor
 */
public class Opstelling {

    private String positie;
    private int tijdstipIn;
    private int tijdstipUit;
 

    public Opstelling(String positie, int tijdstipIn, int tijdstipUit) {
        this.positie = positie;
        this.tijdstipIn = tijdstipIn;
        this.tijdstipUit = tijdstipUit;
    }

//getters en setters
    public String getPositie() {
        return positie;
    }

    public void setPositie(String positie) {
        this.positie = positie;
    }

    public int getTijdstipIn() {
        return tijdstipIn;
    }

    public void setTijdstipIn(int tijdstipIn) {
        this.tijdstipIn = tijdstipIn;
    }

    public int getTijdstipUit() {
        return tijdstipUit;
    }

    public void setTijdstipUit(int tijdstipUit) {
        this.tijdstipUit = tijdstipUit;
    }

    
}
