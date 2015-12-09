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
public class Penalty extends Highlight {

    private int gescoord;

    public Penalty(int minuut, Speler speler, Wedstrijd wedstrijd, int gescoord) {
        super(minuut, speler, wedstrijd);
        this.gescoord = gescoord;
    }

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
