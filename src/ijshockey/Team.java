package ijshockey;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author favdndor
 */
public class Team {

    private int stamNr; //PK
    private String naam;
    private String thuisArena;
    private int punten; // Berekenen uit gewonnen verloren?
    private int aantalGespeeld;
    private int aantalGewonnen;
    private int aantalVerloren;
    private int aantalGelijk;
    private int doelpuntenVoor;
    private int doelpuntenTegen;
    private int lidnr_trainer;
    private int penaltys;

    public Team(int stamNr, String naam, String thuisArena, int punten, int aantalGespeeld, int aantalGewonnen, int aantalVerloren, int aantalGelijk, int doelpuntenVoor, int doelpuntenTegen, int penaltys, int lidnr_trainer) {
        this.stamNr = stamNr;
        this.naam = naam;
        this.thuisArena = thuisArena;
        this.punten = punten;
        this.aantalGespeeld = aantalGespeeld;
        this.aantalGewonnen = aantalGewonnen;
        this.aantalVerloren = aantalVerloren;
        this.aantalGelijk = aantalGelijk;
        this.doelpuntenVoor = doelpuntenVoor;
        this.doelpuntenTegen = doelpuntenTegen;
        this.lidnr_trainer = lidnr_trainer;
    }

    public Team(int stamnummer, String thuisArena, String teamNaam) {
      this.stamNr = stamnummer;
      this.naam = naam;
      this.thuisArena = thuisArena;
              
    }

    public void setPunten() { // Viktor 24//11 , zou dit werken? /aangepast door Jorn
        this.punten = 2 * this.getAantalGewonnen() + 1 * this.getAantalGelijk();
    }

    public int getAantalVerloren() {
        return aantalVerloren;
    }

    public int getAantalGewonnen() {
        return aantalGewonnen;
    }

    public void setAantalGelijk(int aantalGelijk) {
        this.aantalGelijk = aantalGelijk;
    }

    public int getStamNr() {
        return stamNr;
    }

    public void setStamNr(int stamNr) {
        this.stamNr = stamNr;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public String getThuisArena() {
        return thuisArena;
    }

    public void setThuisArena(String thuisArena) {
        this.thuisArena = thuisArena;
    }

    public int getPunten() {
        return punten;
    }

    public void setAantalGewonnen(int aantalGewonnen) {
        this.aantalGewonnen = aantalGewonnen;
    }

    public void setAantalVerloren(int aantalVerloren) {
        this.aantalVerloren = aantalVerloren;
    }

    public int getAantalGelijk() {
        return aantalGelijk;
    }

    //hulpmethodes voor ranking en rapport
    public String toStringTeamRanking() {
        return naam + ": " + punten + " punten (" + aantalGespeeld + " wedstrijden)";
    }

    public String toStringTeamRapport() {
        int doelpuntenSaldo = doelpuntenVoor - doelpuntenTegen;
        int goalsPerGame;
        int penaltysPerGame;
        if (aantalGespeeld == 0) {
            goalsPerGame = 0;
            penaltysPerGame = 0;
        } else {
            goalsPerGame = (doelpuntenVoor - aantalGespeeld);
            penaltysPerGame = (penaltys - aantalGespeeld);
        }

        return naam + "\n"
                + "---------------------" + "\n"
                + "aantal gespeelde wedstrijden: " + aantalGespeeld + "\n"
                + "aantal punten: " + punten + "\n"
                + "aantal gewonnen wedstrijden: " + aantalGewonnen + "\n"
                + "aantal gelijkgespeelde wedstrijden: " + aantalGelijk + "\n"
                + "aantal verloren wedstrijden: " + aantalVerloren + "\n"
                + "doelpuntensaldo: " + doelpuntenSaldo + "\n"
                + "totaal aantal penalty's: " + penaltys + "\n"
                + "aantal doelpunten per wedstrijd: " + goalsPerGame + "\n"
                + "aantal penalty's per wedstrijd: " + penaltysPerGame;

    }

}
