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
public class Test {
    public static void main(String[] args) throws DBException {
        
        //Test speelminuten berekenen
        DriverManager dm = new DriverManager();
        /*
        int a = dm.playedMinutesGame(2,1);
        System.out.println("Gespeelde minuten van speler 2 in wedstrijd 1 van seizoen 2015: " +a);
        int b = dm.playedMinutesSeason(2);
        System.out.println("Gespeelde minuten van speler 2 in seizoen 2015: " +b);
        */
        
        //Test gegevens toevoegen aan database
        
        Competitie c = new Competitie("BeneLeague");
        dm.add(c);
        Seizoen s = new Seizoen(c.getCompetitienaam(),2015);
        dm.add(s);
        
        /*Opmerking: SQL om rijen terug te verwijderen in phpmyadmin:
         SET FOREIGN_KEY_CHECKS=0; 
         DELETE FROM seizoen
         WHERE competitienaam='BeneLeague';
         DELETE FROM competitie
         WHERE competitienaam='BeneLeague';
         SET FOREIGN_KEY_CHECKS=1; */
        
        //Test database updaten
        
        
    }
}
