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

    private int highlightNr;
    private int minuut;
    private Speler speler; 
    private Wedstrijd wedstrijd;
    

    public Highlight(int minuut, Speler speler, Wedstrijd wedstrijd) {
        this.minuut = minuut;
        this.speler=speler;
        this.wedstrijd = wedstrijd;
    }

    public int getHighlightNr() {
        return highlightNr;
    }

    public int getMinuut() {
        return minuut;
    }

    public Speler getSpeler() {
        return speler;
    }

    public void setSpeler(Speler speler) {
        this.speler = speler;
    }

    public Wedstrijd getWedstrijd() {
        return wedstrijd;
    }

    public void setWedstrijd(Wedstrijd wedstrijd) {
        this.wedstrijd = wedstrijd;
    }

    
    public void setHighlightNr(int highlightNr) {
        this.highlightNr = highlightNr;
    }

    public void setMinuut(int minuut) {
        this.minuut = minuut;
    }
    
}

    
