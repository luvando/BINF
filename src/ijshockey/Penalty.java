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
public class Penalty extends Goal {

    private int gescoord;

    public Penalty(int minuut, int lidnr, int wedstrijdNr, int gescoord) {
        super(minuut, lidnr, wedstrijdNr);
        this.gescoord = gescoord;
    }

    //this.highlightId = Integer.toString(tijdstip) + lid.getLidId() + "p" + this.isGescoordIntBoolean(gescoordBoo);
//    public int isGescoordIntString(String gescoordStr) { //penalty gescoord = 1 , als gescoord String is.
//        if (this.gescoordStr.startsWith("j")) {
//            return 1;
//        } else {
//            return 0;
//        }
//    }
    /*public int isGescoordIntBoolean(boolean gescoord) {
     //penalty gescoord = 1 , als gescoord Boolean is.
     if (gescoord) {
     return 1;
     } else {
     return 0;
     }
     }*/
    public int getGescoord() {
        return gescoord;
    }

    public void setGescoord(int gescoord) {
        this.gescoord = gescoord;
    }

    @Override
    public String toString() {
        String s = null;

        try {
            s = "Penalty" + " in minuut " + super.getMinuut() + " in wedstrijd " + (DriverManager.getWedstrijd(super.getWedstrijdNr())).printWedstrijd();
        } catch (DBException ex) {
            Logger.getLogger(Goal.class.getName()).log(Level.SEVERE, null, ex);
        }
        return s;

    }

}
