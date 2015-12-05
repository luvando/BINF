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
public class Speler extends Lid {

    private String voorkeurpositie;
    private Team team; //waarom team en niet stamnr?
 


    
    public Speler(String voornaam, String achternaam, String geboortedatum, String voorkeurpositie, Team team) {
        super(voornaam, achternaam, geboortedatum);
        this.voorkeurpositie = voorkeurpositie;
        this.team = team;
    }
     public Speler(int lidnr, String voornaam, String achternaam, String geboortedatum, String voorkeurpositie, Team team) {
        super(voornaam, achternaam, geboortedatum, lidnr);
        this.voorkeurpositie = voorkeurpositie;
        this.team = team;
    }
    

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public String getVoorkeurpositie() {
        return voorkeurpositie;
    }

    /*public int getGoals() {
        return goals;
    }

    public int getAssists() {
        return assists;
    }

    public int getPenaltys() {
        return penaltys;
    }

    public int getSpeelminuten() {
        return speelminuten;
    }*/

    public void setVoorkeurpositie(String voorkeurpositie) {
        this.voorkeurpositie = voorkeurpositie;
    }

   /* public void setGoals(int goals) {
        this.goals = goals;
    }

    public void setAssists(int assists) {
        this.assists = assists;
    }

    public void setPenaltys(int penaltys) {
        this.penaltys = penaltys;
    }

    public void setSpeelminuten(int speelminuten) {
        this.speelminuten = speelminuten;
    }

    public String toStringSpelerRanking() {
        return super.getVoornaam() + " " + super.getAchternaam() + ": " + goals + " goals";
    }

    
*/

    
}
