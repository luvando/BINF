package ijshockey;

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
    private int speeldagnr;
    private Seizoen seizoen;

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

    public Seizoen getSeizoen() {
        return seizoen;
    }

    public void setSeizoen(Seizoen seizoen) {
        this.seizoen = seizoen;
    }

    public int getSpeeldagnr() {
        return speeldagnr;
    }

}
