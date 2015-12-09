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
public class Opstelling {

    private String positie;
    private int tijdstipIn;
    private int tijdstipUit;
    private int wedstrijdnr;
    private int lidnr;
    private int opstellingNr;
    private Wedstrijd wedstrijd;
    private Speler speler;

    public Opstelling(int wedstrijdnr, int lidnr, int onr, String positie, int tijdstipIn, int tijdstipUit) {
        this.opstellingNr = onr;
        this.positie = positie;
        this.tijdstipIn = tijdstipIn;
        this.tijdstipUit = tijdstipUit;
        this.wedstrijdnr = wedstrijdnr;
        this.lidnr = lidnr;
    }

    public Opstelling(Wedstrijd wedstrijd, Speler speler, String positie, int tijdstipIn, int tijdstipUit) {
        this.wedstrijd = wedstrijd;
        this.positie = positie;
        this.tijdstipIn = tijdstipIn;
        this.tijdstipUit = tijdstipUit;
        this.speler = speler;
    }

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

    public int getWedstrijdnr() {
        return wedstrijdnr;
    }

    public void setWedstrijdnr(int wedstrijdnr) {
        this.wedstrijdnr = wedstrijdnr;
    }

    public int getLidnr() {
        return lidnr;
    }

    public void setLidnr(int lidnr) {
        this.lidnr = lidnr;
    }

    public int getOpstellingNr() {
        return opstellingNr;
    }

    public void setOpstellingNr(int opstellingNr) {
        this.opstellingNr = opstellingNr;
    }

    public Wedstrijd getWedstrijd() {
        return wedstrijd;
    }

    public Speler getSpeler() {
        return speler;
    }

    @Override
    public String toString() {
        return "Opstelling{" + "positie=" + positie + ", tijdstipIn=" + tijdstipIn + ", tijdstipUit=" + tijdstipUit + '}';
    }

}
