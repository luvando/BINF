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

    private int gescoordInt;
    private Boolean gescoordBoo;

    public Penalty(int tijdsstip, int lidnr, Boolean gescoordBoo) { // Viktor 24/11
        super(tijdsstip, lidnr);
        this.gescoordInt = this.isGescoordIntBoolean(gescoordBoo);
    }

    //this.highlightId = Integer.toString(tijdstip) + lid.getLidId() + "p" + this.isGescoordIntBoolean(gescoordBoo);
//    public int isGescoordIntString(String gescoordStr) { //penalty gescoord = 1 , als gescoord String is.
//        if (this.gescoordStr.startsWith("j")) {
//            return 1;
//        } else {
//            return 0;
//        }
//    }
    public int isGescoordIntBoolean(Boolean gescoordBoo) { //penalty gescoord = 1 , als gescoord Boolean is.
        if (gescoordBoo) {
            return 1;
        } else {
            return 0;
        }
    }

}
