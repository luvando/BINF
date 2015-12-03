package ijshockey;

import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author jornys
 */
public class Speeldag {

    private Competitie competitie;
    private int jaar;
    private int speeldagnr;
    private Seizoen seizoen;

    public Speeldag(Competitie competitie, int jaar, int speeldagnr) {
        this.competitie=competitie;
        this.jaar = jaar;
        this.speeldagnr = speeldagnr;
    }

    public Speeldag(Competitie competitie, Seizoen seizoen, int speeldagnr) {
        this.competitie = competitie;
        this.seizoen = seizoen;
        this.speeldagnr = speeldagnr;
    }

    public Competitie getCompetitie() {
        return competitie;
    }

    public void setCompetitie(Competitie competitie) {
        this.competitie = competitie;
    }


    public int getJaar() {
        return jaar;
    }

    public int getSpeeldagnr() {
        return speeldagnr;
    }

}
