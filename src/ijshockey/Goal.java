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

    private Assist assist ;

    public Goal(int highlightNr, int minuut, int lidnr, int wedstrijdNr, Assist assist) {
        super(highlightNr, minuut, lidnr, wedstrijdNr);
        this.assist = assist;
    }

    public Goal(int highlightNr, int minuut, int lidnr, int wedstrijdNr)
    {
        super(highlightNr, minuut, lidnr, wedstrijdNr);
    }

    public Assist getAssist() {
        return assist;
    }

    public void setAssist(Assist assist) {
        this.assist = assist;
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

}
