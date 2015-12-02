package ijshockey;

//import java.time.Instant;
import java.util.Calendar;
import java.util.Date;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author favdndor
 */
public class Lid {

    public int lidnr; //nodig?
    private String voornaam;
    private String achternaam;
    private String geboortedatum;

    public Lid(String voornaam, String achternaam, String geboortedatum) {
        this.voornaam = voornaam;
        this.achternaam = achternaam;
        this.geboortedatum = geboortedatum;
    }

    public Lid(String voornaam, String achternaam, String geboortedatum, int lidnr) {
        this.voornaam = voornaam;
        this.achternaam = achternaam;
        this.geboortedatum = geboortedatum;
        this.lidnr = lidnr;
    }

    public String getVoornaam() {
        return voornaam;
    }

    public void setVoornaam(String voornaam) {
        this.voornaam = voornaam;
    }

    public String getAchternaam() {
        return achternaam;
    }

    public void setAchternaam(String achternaam) {
        this.achternaam = achternaam;
    }

    public String getGeboortedatum() {
        return geboortedatum;
    }

    public void setGeboortedatum(String geboortedatum) {
        this.geboortedatum = geboortedatum;
    }

    public int getLidnr() {
        return lidnr;
    }

    public void setLidnr(int lidnr) {
        this.lidnr = lidnr;
    }

}
