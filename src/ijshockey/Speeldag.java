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
public class Speeldag {

    private int speeldagNr;
    private Wedstrijd wedstrijd;
    private ArrayList<Wedstrijd> wedstrijden;

//getters en setters
    public int getSpeeldagNr() {
        return speeldagNr;
    }

    public void setSpeeldagNr(int speeldagNr) {
        this.speeldagNr = speeldagNr;
    }

    public ArrayList<Wedstrijd> getWedstrijden() {
        return wedstrijden;
    }

    public void setWedstrijden(ArrayList<Wedstrijd> wedstrijden) {
        this.wedstrijden = wedstrijden;
    }

}
