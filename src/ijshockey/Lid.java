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

    public String lidId; // PK of nummer
    private String voornaam;
    private String achternaam;
    private Date geboortedatum;
//    private Seizoen seizoen;
//    private int year = this.seizoen.getJaar();

    public Lid(String voornaam, String achternaam, Date geboortedatum) {
        this.voornaam = voornaam;
        this.achternaam = achternaam;
        this.geboortedatum = geboortedatum;

    }

//    public int setLeeftijd(Date geboortedatum) {
//        return year - geboortedatum.getYear();
//    }
    //  private void duplicateCheck(String voornaam, String achternaam) {
    //}
//getters en setters
    public String getLidId() {
        return this.lidId;
    }
//
//    public void setLidId(String LidId) {
//        this.LidId = LidId;
//    }

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

    public Date getGeboortedatum() {
        return geboortedatum;
    }

    public void setGeboortedatum(Date geboortedatum) {
        this.geboortedatum = geboortedatum;
    }

}
