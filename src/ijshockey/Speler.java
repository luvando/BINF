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
    private int goals;
    private int assists;
    private int penaltys;
    private int speelminuten;
    private Team team;

    public Speler(int lidnr, String voornaam, String achternaam, Date geboortedatum, String voorkeurpositie, int goals, int assists, int penaltys, int speelminuten, Team team) {
        super(lidnr, voornaam, achternaam, geboortedatum);
        this.voorkeurpositie = voorkeurpositie;
        this.goals = goals;
        this.assists = assists;
        this.penaltys = penaltys;
        this.speelminuten = DriverManager.playedMinutesSeason(lidnr);
        this.team = team;
    }

    public Team getTeam() {
        return team;
    }

    @Override
    public String toString() {
        return super.getVoornaam() + " " + super.getAchternaam() + ": " + goals + " goals";
    }
    
    
    
    
}
