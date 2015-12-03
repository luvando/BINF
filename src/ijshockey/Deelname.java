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
    
    private Competitie competitie;
    private Seizoen seizoen;
    private Team team;

    public Deelname(Competitie competitie, Seizoen seizoen, Team team) {
       this.competitie=competitie;
       this.seizoen= seizoen;
       this.team=team;
       
    }
   /* //hulpmethodes voor ranking en rapport
    public String toStringTeamRanking() throws DBException {
        return DriverManager.getTeam(stamnr).getNaam() + ": " + punten + " punten (" + team.get + " wedstrijden, doelpuntensaldo: " + dps + ")";
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

    }*/
    
    
    
}
