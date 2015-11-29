package ijshockey;

import java.util.ArrayList;
import java.util.Collections;
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
public class Seizoen {

    private String competitienaam;
    private int jaar;
    private Speeldag speeldag;
    private ArrayList<Speeldag> speeldagen;
    private ArrayList<Team> teams;

    public Seizoen(String competitienaam, int jaar) {
        this.competitienaam = competitienaam;
        this.jaar = jaar;
    }

    

    public void addTeamEnTrainer(int stamNr, String naam, String arena, String voornaam, String achternaam, Date geboortedatum) {
        Team t = new Team(stamNr, naam, arena);
        t.addTrainer(voornaam, achternaam, geboortedatum);
        teams.add(t);

    }

    public Team searchTeam(int stamNr) { // Viktor 24/11 search methode + setPunten
        for (Team t : teams) {
            if (t.getStamNr() == stamNr) {
                return t;
            }
        }
        return null;
    }

    public void setPuntenATeam(int stamNr) {
        Team t = this.searchTeam(stamNr);
        t.setPunten(t.getAantalGewonnen(), t.getAantalGelijk());

    }

    public void setPuntenAllTeams() {
        for (Team t : teams) {
            this.setPuntenATeam(t.getStamNr());
        }

    }

    public ArrayList<Team> getRankedTeams() {
        Collections.sort(teams);
        return this.getTeams();
    }
//getters en setters

    public String getCompetitienaam() {
        return competitienaam;
    }

    public void setCompetitienaam(String competitienaam) {
        this.competitienaam = competitienaam;
    }

    public Speeldag getSpeeldag() {
        return speeldag;
    }

    public void setSpeeldag(Speeldag speeldag) {
        this.speeldag = speeldag;
    }

    public ArrayList<Team> getTeams() {
        return teams;
    }

    public void setTeams(ArrayList<Team> teams) {
        this.teams = teams;
    }

    public int getJaar() {
        return jaar;
    }

    public void setJaar(int jaar) {
        this.jaar = jaar;
    }

    public ArrayList<Speeldag> getSpeeldagen() {
        return speeldagen;
    }

    public void setSpeeldagen(ArrayList<Speeldag> speeldagen) {
        this.speeldagen = speeldagen;
    }

}
