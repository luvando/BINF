package ijshockey;

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
    private String datum;
    private int gespeeld;
    private Speeldag sp;
    private Seizoen seizoen;

// GESPEELDE MATCHEN    
    public Wedstrijd(Seizoen seizoen, Team thuisTeam, Team uitTeam, String arena, int scoreThuisTeam, int scoreUitTeam, Scheidsrechter scheidsrechter, String datum, Speeldag sp) {
        this.seizoen = seizoen;
        this.thuisTeam = thuisTeam;
        this.uitTeam = uitTeam;
        this.arena = arena;
        this.scoreThuisTeam = scoreThuisTeam;
        this.scoreUitTeam = scoreUitTeam;
        this.datum = datum;
        this.scheidsrechter = scheidsrechter;
        this.gespeeld = 1;
        this.sp = sp;
    }

//NIET GESPEELDE MATCHEN    
    public Wedstrijd(Seizoen seizoen, Team thuisTeam, Team uitTeam, String arena, Scheidsrechter scheidsrechter, String datum, Speeldag sp) {
        this.seizoen = seizoen;
        this.thuisTeam = thuisTeam;
        this.uitTeam = uitTeam;
        this.arena = arena;
        this.seizoen = seizoen;
        this.datum = datum;
        this.scheidsrechter = scheidsrechter;
        this.gespeeld = 0;
        this.sp = sp;
    }

//SEARCH GESPEELDE MATCH    
    Wedstrijd(int wnr, Seizoen s, Team thuis, Team uit, String arena, int score_thuis, int score_uit, Scheidsrechter scheidsrechter, String datum, Speeldag speeldag, int gespeeld) {
        this.seizoen = s;
        this.wedstrijdNr = wnr;
        this.thuisTeam = thuis;
        this.uitTeam = uit;
        this.arena = arena;
        this.scoreThuisTeam = score_thuis;
        this.scoreUitTeam = score_uit;
        this.scheidsrechter = scheidsrechter;
        this.datum = datum;
        this.gespeeld = gespeeld;
        this.sp = speeldag;
    }

//SEARCH NIET GESPEELDE MATCH
    Wedstrijd(int wnr, Seizoen s, Team thuis, Team uit, String arena, Scheidsrechter scheidsrechter, String datum, Speeldag speeldag, int gespeeld) {
        this.seizoen = s;
        this.wedstrijdNr = wnr;
        this.thuisTeam = thuis;
        this.uitTeam = uit;
        this.arena = arena;
        this.scheidsrechter = scheidsrechter;
        this.datum = datum;
        this.gespeeld = gespeeld;
        this.sp = speeldag;
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

    public Seizoen getSeizoen() {
        return seizoen;
    }

    public void setSeizoen(Seizoen seizoen) {
        this.seizoen = seizoen;
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

    public String getDatum() {
        return datum;
    }

    public void setDatum(String datum) {
        this.datum = datum;
    }

    public int getGespeeld() {
        return gespeeld;
    }

    public void setGespeeld(int gespeeld) {
        this.gespeeld = gespeeld;
    }

    public Speeldag getSp() {
        return sp;
    }

    public void setSp(Speeldag sp) {
        this.sp = sp;
    }

    public String printWedstrijd() {
        return "  " + thuisTeam.getNaam() + "  -  " + uitTeam.getNaam() + "  (" + datum + ")";
    }

    @Override
    public String toString() {
        return "  " + thuisTeam + "  -  " + uitTeam + "  (" + datum + ")";
    }

}
