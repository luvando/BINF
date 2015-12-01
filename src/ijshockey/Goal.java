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

    private int lidnr_assist ;

    public Goal(int minuut, int lidnr, int wedstrijdNr, int lidnr_assist) {
        super(minuut, lidnr, wedstrijdNr);
        this.lidnr_assist = lidnr_assist;
    }

    public Goal(int minuut, int lidnr, int wedstrijdNr)
    {
        super(minuut, lidnr, wedstrijdNr);
    }

    public int getLidnr_assist() {
        return lidnr_assist;
    }

    public void setLidnr_assist(int lidnr_assist) {
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

}
