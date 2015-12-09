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
public class Goal extends Highlight {

    private Speler assistgever;

    public Goal(int minuut, Speler speler, Wedstrijd wedstrijd, Speler assistgever) {
        super(minuut, speler, wedstrijd);
        if (assistgever != null) {
            this.assistgever = assistgever;
        } else {
            this.assistgever = null;
        }
    }

    public Speler getAssistgever() {
        return assistgever;
    }

    public void setAssistgever(Speler assistgever) {
        this.assistgever = assistgever;
    }

    @Override
    public String toString() {
        String s;

        return s = "Goal in minuut " + super.getMinuut() + " in wedstrijd " + super.getWedstrijd().printWedstrijd();

    }
}
