package ijshockey;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author favdndor
 */
public class Highlight {

    private int highlightNr; //PK
    private int minuut;
    private int lidNr; 
    private int wedstrijdNr;
    

    public Highlight(int minuut, int lidNr, int wedstrijdNr) {
        this.minuut = minuut;
        this.lidNr = lidNr;
        this.wedstrijdNr = wedstrijdNr;
    }

    public int getHighlightNr() {
        return highlightNr;
    }

    public int getMinuut() {
        return minuut;
    }

    public int getLidNr() {
        return lidNr;
    }

    public int getWedstrijdNr() {
        return wedstrijdNr;
    }

    public void setWedstrijdNr(int wedstrijdNr) {
        this.wedstrijdNr = wedstrijdNr;
    }

    
    public void setHighlightNr(int highlightNr) {
        this.highlightNr = highlightNr;
    }

    public void setMinuut(int minuut) {
        this.minuut = minuut;
    }

    public void setLidNr(int lidNr) {
        this.lidNr = lidNr;
    }
    
}

    
