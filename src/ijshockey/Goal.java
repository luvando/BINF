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

    private Assist assist;

    public Goal(int tijdstip, int lidnr) {
        super(tijdstip, lidnr);
    }

    public Assist getAssist() {
        return assist;
    }

    public void setAssist(Assist assist) {
        this.assist = assist;
    }
}
