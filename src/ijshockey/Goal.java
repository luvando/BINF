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

    private int highlightNr_assist;

    public Goal(int highlightNr, int minuut, int lidnr, int wedstrijdNr, int highlightNr_assist) {
        super(highlightNr, minuut, lidnr, wedstrijdNr);
        this.highlightNr_assist = highlightNr_assist;
    }

    public Goal(int highlightNr, int minuut, int lidnr, int wedstrijdNr)
    {
        super(highlightNr, minuut, lidnr, wedstrijdNr);
    }

    public int getHighlightNr_assist() {
        return highlightNr_assist;
    }

    public void setHighlightNr_assist(int highlightNr_assist) {
        this.highlightNr_assist = highlightNr_assist;
    }

    @Override
    public String toString() {
        String s = null;
        
        try {
            s = "Goal" + " in minuut " + super.getMinuut() + " in wedstrijd " + DriverManager.getWedstrijd(super.getWedstrijdNr()).toString();
        } catch (DBException ex) {
            Logger.getLogger(Goal.class.getName()).log(Level.SEVERE, null, ex);
        }
        return s;

    }

}
