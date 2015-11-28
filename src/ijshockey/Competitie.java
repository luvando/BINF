package ijshockey;
import java.util.ArrayList;
import java.util.Collections;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author favdndor
 */
public class Competitie {

    public String competitienaam; // PK
    private ArrayList<Competitie> competities;

    private ArrayList<Seizoen> seizoenen;

    public ArrayList<Team> getTeamsSeizoen(int jaar) { // Viktor 24/11 getTeam adhv seizoen jaar
        for (Seizoen s : seizoenen) {
            if (s.getJaar() == jaar) {
                return s.getTeams();

            }

        }
        return null;
    }

    public ArrayList<Team> rankedTeamsSeizoen(int jaar) { // Viktor 24/11 Gerankte teams voor een bepaalde seizoen
        ArrayList<Team> ranked = null;
        for (Seizoen s : seizoenen) {
            if (s.getJaar() == jaar) {
                s.setPuntenAllTeams();

                ranked = s.getRankedTeams();
            }
            return ranked;
        }
        return null;
    }
    

    public ArrayList<Competitie> getCompetities() {
        return competities;
    }

    public void setCompetities(ArrayList<Competitie> competities) {
        this.competities = competities;
    }

    public ArrayList<Seizoen> getSeizoenen() {
        return seizoenen;
    }

    public void setSeizoenen(ArrayList<Seizoen> seizoenen) {
        this.seizoenen = seizoenen;
    }


 
    
}