package ijshockey;

import java.util.ArrayList;
import java.util.Collections;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author favdndor
 */
public class Competitie {

    public String competitienaam; // PK

    public Competitie(String competitienaam) {
        this.competitienaam = competitienaam;
    }

    public Competitie() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getCompetitienaam() {
        return competitienaam;
    }

    public void setCompetitienaam(String competitienaam) {
        this.competitienaam = competitienaam;
    }

}
