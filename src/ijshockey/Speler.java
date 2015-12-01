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
    private Team team; //waarom team en niet stamnr?

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

    public String toStringSpelerRanking() {
        return super.getVoornaam() + " " + super.getAchternaam() + ": " + goals + " goals";
    }

    public String toStringSpelerRapport() { //gewoon spelersrapport voor alle spelers, ongeacht of speler penalty gezet heeft
        return super.getVoornaam() + " " + super.getAchternaam() + "\n"
                + "---------------------" + "\n"
                + "aantal doelpunten: " + goals + "\n"
                + "aantal assists: " + assists + "\n"
                + "aantal penalty's: " + penaltys + "\n"
                + "aantal speelminuten: " + speelminuten + "\n";

    }
    
    public String toStringSpelerRapportPenalty() { //extra rapport als speler minstens één penalty heeft genomen
        String s = null;
        return s;  
    }

}
