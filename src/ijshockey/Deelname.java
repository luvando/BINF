/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ijshockey;

/**
 *
 * @author Jasper
 */
public class Deelname {
    private String competitienaam;
    private int jaar;
    private int stamnr;
    private int punten;
    private int aantalGespeeld;
    private int aantalGewonnen;
    private int aantalVerloren;
    private int aantalGelijk;
    private int doelpuntenVoor;
    private int doelpuntenTegen;
    private int penaltys;
    
    private int dps = doelpuntenVoor - doelpuntenTegen;

    public Deelname(String competitienaam, int jaar, int stamnr, int punten, int aantalGespeeld, int aantalGewonnen, int aantalVerloren, int aantalGelijk, int doelpuntenVoor, int doelpuntenTegen, int penaltys) {
        this.competitienaam = competitienaam;
        this.jaar = jaar;
        this.stamnr = stamnr;
        this.punten = punten;
        this.aantalGespeeld = aantalGespeeld;
        this.aantalGewonnen = aantalGewonnen;
        this.aantalVerloren = aantalVerloren;
        this.aantalGelijk = aantalGelijk;
        this.doelpuntenVoor = doelpuntenVoor;
        this.doelpuntenTegen = doelpuntenTegen;
        this.penaltys = penaltys;
    }
    
    //hulpmethodes voor ranking en rapport
    public String toStringTeamRanking() throws DBException {
        return DriverManager.getTeam(stamnr).getNaam() + ": " + punten + " punten (" + aantalGespeeld + " wedstrijden, doelpuntensaldo: " + dps + ")";
    }

    public String toStringTeamRapport() throws DBException {
        int goalsPerGame;
        int penaltysPerGame;
        if (aantalGespeeld == 0) {
            goalsPerGame = 0;
            penaltysPerGame = 0;
        } else {
            goalsPerGame = (doelpuntenVoor / aantalGespeeld);
            penaltysPerGame = (penaltys / aantalGespeeld);
        }

        return DriverManager.getTeam(stamnr).getNaam() + "\n"
                + "---------------------" + "\n"
                + "aantal gespeelde wedstrijden: " + aantalGespeeld + "\n"
                + "aantal punten: " + punten + "\n"
                + "aantal gewonnen wedstrijden: " + aantalGewonnen + "\n"
                + "aantal gelijkgespeelde wedstrijden: " + aantalGelijk + "\n"
                + "aantal verloren wedstrijden: " + aantalVerloren + "\n"
                + "doelpuntensaldo: " + dps + "\n"
                + "totaal aantal penalty's: " + penaltys + "\n"
                + "aantal doelpunten per wedstrijd: " + goalsPerGame + "\n"
                + "aantal penalty's per wedstrijd: " + penaltysPerGame;

    }
    
    
    
}