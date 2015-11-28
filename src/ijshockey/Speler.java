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

    private ArrayList<Goal> goals;
    private ArrayList<Assist> assists;
    private ArrayList<Penalty> penaltys;
    //geen int maar arraylists toch? //Jorn 24/11
    
    private String voorkeurspositie;
    private int speelMinuten;
    private Team team;//jorn 23/11
    
    
    public Speler(String voornaam, String achternaam, Date geboortedatum, String voorkeurspositie) {
        super(voornaam, achternaam, geboortedatum);
        this.voorkeurspositie = voorkeurspositie;
        this.lidId = voornaam.substring(0, 1).toUpperCase() 
                + achternaam.substring(0, 1).toUpperCase() + "s" /* + geboortedatum + nr*/ ;        
    }

//getters en setters
//    public int getGoals() {
//        return goals;
//    }
//
//    public void setGoals(int goals) {
//        this.goals = goals;
//    }
//
//    public int getAssists() {
//        return assists;
//    }
//
//    public void setAssists(int assists) {
//        this.assists = assists;
//    }
//
//    public int getPenaltys() {
//        return penaltys;
//    }
//
//    public void setPenaltys(int penaltys) {
//        this.penaltys = penaltys;
//    }

    public String getVoorkeurspositie() {
        return voorkeurspositie;
    }

    public void setVoorkeurspositie(String voorkeurspositie) {
        this.voorkeurspositie = voorkeurspositie;
    }

    public int getSpeelMinuten() {
        return speelMinuten;
    }

    public void setSpeelMinuten(int speelMinuten) {
        this.speelMinuten = speelMinuten;
    }

    //Jorn 23/11
    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public String getLidId() {
        return lidId;
    }

    public void setLidId(String lidId) {
        this.lidId = lidId;
    }
    
    
}
