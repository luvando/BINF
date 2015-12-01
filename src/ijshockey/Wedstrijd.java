package ijshockey;
import java.util.ArrayList;
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
public class Wedstrijd {

    private int wedstrijdNr;
    private Team thuisTeam;
    private Team uitTeam;
    private String arena;
    private int scoreThuisTeam;
    private int scoreUitTeam;
    private Scheidsrechter scheidsrechter;
    private Date datum;
    private Boolean gespeeld; 
    //private ArrayList<Opstelling> opstelling;

    public Wedstrijd(int wedstrijdNr, Team thuisTeam, Team uitTeam, String arena, int scoreThuisTeam, int scoreUitTeam, Scheidsrechter scheidsrechter, Date datum, Boolean gespeeld) {
        this.wedstrijdNr = wedstrijdNr;
        this.thuisTeam = thuisTeam;
        this.uitTeam = uitTeam;
        this.arena = arena;
        this.scoreThuisTeam = scoreThuisTeam;
        this.scoreUitTeam = scoreUitTeam;
        this.scheidsrechter = scheidsrechter;
        this.datum = datum;
        this.gespeeld = gespeeld;
        //this.opstelling = opstelling;
    }
    
    public int getWedstrijdNr() {
        return wedstrijdNr;
    }

    public void setWedstrijdNr(int wedstrijdNr) {
        this.wedstrijdNr = wedstrijdNr;
    }

    public Team getThuisTeam() {
        return thuisTeam;
    }

    public void setThuisTeam(Team thuisTeam) {
        this.thuisTeam = thuisTeam;
    }

    public Team getUitTeam() {
        return uitTeam;
    }

    public void setUitTeam(Team uitTeam) {
        this.uitTeam = uitTeam;
    }

    public String getArena() {
        return arena;
    }

    public void setArena(String arena) {
        this.arena = arena;
    }

    public int getScoreThuisTeam() {
        return scoreThuisTeam;
    }

    public void setScoreThuisTeam(int scoreThuisTeam) {
        this.scoreThuisTeam = scoreThuisTeam;
    }

    public int getScoreUitTeam() {
        return scoreUitTeam;
    }

    public void setScoreUitTeam(int scoreUitTeam) {
        this.scoreUitTeam = scoreUitTeam;
    }

    public Scheidsrechter getScheidsrechter() {
        return scheidsrechter;
    }

    public void setScheidsrechter(Scheidsrechter scheidsrechter) {
        this.scheidsrechter = scheidsrechter;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public Boolean getGespeeld() {
        return gespeeld;
    }

    public void setGespeeld(Boolean gespeeld) {
        this.gespeeld = gespeeld;
    }

    @Override
    public String toString() {
        return thuisTeam + " - " + uitTeam + " " + datum;
    }

}
