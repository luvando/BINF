package ijshockey;

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

    private Boolean gescoord;
    public Penalty(int highlightNr, int minuut, int lidnr, int wedstrijdNr, boolean gescoord) 
    {
        super(highlightNr, minuut, lidnr, wedstrijdNr);
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

    public Boolean getGescoord() {
        return gescoord;
    }

    public void setGescoord(Boolean gescoord) {
        this.gescoord = gescoord;
    }
    
    

}
