/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ijshockey;

import GUIPackage.Startscherm;

/**
 *
 * @author Jasper
 */
public class Main {

    public static void main(String[] args) throws DBException { // Start programma methode!!
        DriverManager dm = new DriverManager();
        Startscherm st = new Startscherm(dm);
        st.setVisible(true);

//        //Test speelminuten berekenen
//       
//        int a = DriverManager.playedMinutesGame(2,1);
//        System.out.println("Gespeelde minuten van speler 2 in wedstrijd 1 van seizoen 2015: " +a);
//        int b = DriverManager.playedMinutesSeason(2);
//        System.out.println("Gespeelde minuten van speler 2 in seizoen 2015: " +b);
//        
//        
//        //Test gegevens toevoegen aan database
//        
//        Competitie c = new Competitie("BeneLeague");
//        DriverManager.add(c);
//        Seizoen s = new Seizoen(c.getCompetitienaam(),2015);
//        DriverManager.add(s);
//        
//        /*Opmerking: SQL om rijen terug te verwijderen in phpmyadmin:
//         SET FOREIGN_KEY_CHECKS=0; 
//         DELETE FROM seizoen
//         WHERE competitienaam='BeneLeague';
//         DELETE FROM competitie
//         WHERE competitienaam='BeneLeague';
//         SET FOREIGN_KEY_CHECKS=1; */
//        
//        //Test database updaten
    }
}
