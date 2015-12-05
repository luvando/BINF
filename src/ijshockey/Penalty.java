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
public class Penalty extends Highlight {

    private int gescoord; //waarom is dit een integer? 

    public Penalty(int minuut, Speler speler, Wedstrijd wedstrijd, int gescoord) {
        super(minuut, speler, wedstrijd);
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
        String s;
        return s = "Penalty in minuut " + super.getMinuut() + " in wedstrijd " + super.getWedstrijd().printWedstrijd();

    }

}
