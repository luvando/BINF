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
public class Straf extends Highlight {

    private int aantalMinuten;
    private String reden;

    public Straf(int minuut, String reden, int aantalMinuten, int lidnr, int wedstrijdNr) {
        super(minuut, lidnr, wedstrijdNr);
        this.reden = reden;
        this.aantalMinuten = aantalMinuten;
        
    }

    public int getAantalMinuten() {
        return aantalMinuten;
    }

    public String getReden() {
        return reden;
    }

    public void setAantalMinuten(int aantalMinuten) {
        this.aantalMinuten = aantalMinuten;
    }

    public void setReden(String reden) {
        this.reden = reden;
    }

    

}
