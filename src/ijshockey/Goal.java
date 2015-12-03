package ijshockey;

import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author favdndor
 */
public class Goal extends Highlight {

    private Speler assistgever;

    public Goal(int minuut, Speler speler, Wedstrijd wedstrijd, Speler assistgever) {
        super(minuut, speler, wedstrijd);
        this.assistgever = assistgever;
    }


    public Speler getAssistgever() {
        return assistgever;
    }

    public void setAssistgever(Speler assistgever) {
        this.assistgever = assistgever;
    }
    /*
     @Override
     public String toString() {
     String s = null;

     try {
     s = "Goal" + " in minuut " + super.getMinuut() + " in wedstrijd " + (DriverManager.getWedstrijd(super.getWedstrijdNr())).printWedstrijd();
     } catch (DBException ex) {
     Logger.getLogger(Goal.class.getName()).log(Level.SEVERE, null, ex);
     }
     return s;

     }

     public String toStringAssist() {
     String s = null;

     try {
     s = "Assist" + " in minuut " + super.getMinuut() + " in wedstrijd " + (DriverManager.getWedstrijd(super.getWedstrijdNr())).printWedstrijd();
     } catch (DBException ex) {
     Logger.getLogger(Goal.class.getName()).log(Level.SEVERE, null, ex);
     }
     return s;

     }*/

}
