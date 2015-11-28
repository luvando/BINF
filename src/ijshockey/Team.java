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
public class Team implements Comparable {

    private int stamNr; //PK
    private String naam;
    private String thuisArena;
    private int punten; // Berekenen uit gewonnen verloren?
    private int aantalGespeeld;
    private int aantalGewonnen;
    private int aantalVerloren;
    private int aantalGelijk;
    private HashMap<Integer, String> resultaten; // wedstrijdnummer,gewonnen/verloren/gelijk
    private ArrayList<Speler> spelers;
    private ArrayList<Lid> leden;
    private Trainer trainer;
    private int doelpuntenVoor;
    private int doelpuntenTegen;
    private int doelpuntenSaldo = doelpuntenVoor - doelpuntenTegen;
    private int goalsperwedstrijd;
    private int penaltysperwedstrijd;

    public Team(int stamNr, String naam, String arena) {
        this.thuisArena = arena;
        this.naam = naam;
        this.stamNr = stamNr;
        spelers = new ArrayList<>();
    }

    public void addTrainer(String voornaam, String achternaam, Date geboortedatum) {
        Trainer tr = new Trainer(voornaam, achternaam, geboortedatum);
        this.setTrainer(tr);
    }

    public void setPunten(int aantalGewonnen, int aantalGelijk) { // Viktor 24//11 , zou dit werken?

        this.punten = 2 * aantalGewonnen + 1 * aantalGelijk;
    }

    @Override
    public int compareTo(Object o) { // VIktor 24/ 11 compareTo adhv punten of aantal gewonnen of doelpuntensaldo
        if (o != null) {
            if (o.getClass() == this.getClass()) {
                Team other = (Team) o;
                if (other.getStamNr() != this.getStamNr()) {
                    if (this.getPunten() > other.getPunten()) {
                        return 1;

                    }
                    if (this.getPunten() == other.getPunten()) {
                        if (this.getAantalGewonnen() > other.getPunten()) {
                            return 1;
                        }
                        if (this.getAantalGewonnen() == other.getPunten()) {
                            if (this.getDoelpuntenSaldo() > other.getDoelpuntenSaldo()) {
                                return 1;
                            } else {
                                return -1;
                            }
                        }

                    }
                    if (this.getPunten() < other.getPunten()) {
                        return -1;
                    }
                }

            }

        }
        return 0;
    }

    public Lid searchLid(String LidId) { // Viktor 24/11 kan ook voor spelers etc gebruikt worden
        for (Lid l : leden) {
            if (l.getLidId().equals(LidId)) {
                return l;
            }
        }
        return null;

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
//getters en setters

    public int getDoelpuntenSaldo() {
        return doelpuntenSaldo;
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

    public HashMap<Integer, String> getResultaten() {
        return resultaten;
    }

    public void setResultaten(HashMap<Integer, String> resultaten) {
        this.resultaten = resultaten;
    }

    public ArrayList<Speler> getSpelers() {
        return spelers;
    }

    public void setSpelers(ArrayList<Speler> spelers) {
        this.spelers = spelers;
    }

    public Trainer getTrainer() {
        return trainer;
    }

    public void setTrainer(Trainer trainer) {
        this.trainer = trainer;
    }

}
