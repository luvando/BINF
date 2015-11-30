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
public class Highlight {

    public String highlightId; //PK
    private int tijdstip;
    public String lidId; // LidId meegeven!!

    public Highlight(int tijdstip, String LidId) {
        this.tijdstip = tijdstip;

    }

    public String getHighlightId() {
        return highlightId;
    }

    public void setHighlightId(String highlightId) {
        this.highlightId = highlightId;
    }

    public int getTijdstip() {
        return tijdstip;
    }

    public void setTijdstip(int tijdstip) {
        this.tijdstip = tijdstip;
    }

}
