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
public class Seizoen {

    private Competitie c;
    private int jaar;

    public Seizoen(Competitie c, int jaar) {
        this.c = c;
        this.jaar = jaar;
    }

    public int getJaar() {
        return jaar;
    }

    public void setJaar(int jaar) {
        this.jaar = jaar;
    }

    public Competitie getC() {
        return c;
    }

    public void setC(Competitie c) {
        this.c = c;
    }

}
