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

    private Speler assist;

    public Goal(int minuut, Speler speler, Wedstrijd wedstrijd, Speler assist) {
        super(minuut, speler, wedstrijd);
        this.assist = assist;
    }

    public Goal(int minuut, Speler speler, Wedstrijd wedstrijd) {
        super(minuut, speler, wedstrijd);
    }

    

  /*  public void setLidnr_assist(int lidnr_assist) {
        this.lidnr_assist = lidnr_assist;
    }

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

    public Speler getAssist() {
        return assist;
    }

    public void setAssist(Speler assist) {
        this.assist = assist;
    }

}
