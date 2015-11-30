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

    private int aantalMinAf;
    private String reden;

    public Straf(int tijdstip, String LidId) {
        super(tijdstip, LidId);
    }

    public int getAantalMinAf() {
        return aantalMinAf;
    }

    public void setAantalMinAf(int aantalMinAf) {
        this.aantalMinAf = aantalMinAf;
    }

    public String getReden() {
        return reden;
    }

    public void setReden(String reden) {
        this.reden = reden;
    }

}
