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

    Competitie c;
    private int jaar;
    /*private Speeldag speeldag;
    private ArrayList<Speeldag> speeldagen;
    private ArrayList<Team> teams;*/

    public Seizoen(Competitie c, int jaar) {
        this.c = c;
        this.jaar = jaar;
    }

    /*public Team searchTeam(int stamNr) { // Viktor 24/11 search methode + setPunten
        for (Team t : teams) {
            if (t.getStamNr() == stamNr) {
                return t;
            }
        }
        return null;
    }

    public void setPuntenATeam(int stamNr) {
        Team t = this.searchTeam(stamNr);
        t.setPunten(); //hier ook aangepast
    }

    public void setPuntenAllTeams() {
        for (Team t : teams) {
            this.setPuntenATeam(t.getStamNr());
        }
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
    }*/

    public int getJaar() {
        return jaar;
    }

    public void setJaar(int jaar) {
        this.jaar = jaar;
    }

    /*public ArrayList<Speeldag> getSpeeldagen() {
        return speeldagen;
    }

    public void setSpeeldagen(ArrayList<Speeldag> speeldagen) {
        this.speeldagen = speeldagen;
    }*/
    
    

}
