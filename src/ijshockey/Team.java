package ijshockey;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author favdndor
 */
public class Team {

    private int stamNr; //PK
    private String naam;
    private String thuisArena;
    private Trainer trainer;
    

    public Team(int stamNr, String naam, String thuisArena, Trainer trainer) {
        this.stamNr = stamNr;
        this.naam = naam;
        this.thuisArena = thuisArena;
        
    }

    public Team(int stamnummer, String teamNaam, String thuisArena) {
        this.stamNr = stamnummer;
        this.naam = teamNaam;
        this.thuisArena = thuisArena;

    }

    
    public int getStamNr() {
        return stamNr;
    }

    public void setStamNr(int stamNr) {
        this.stamNr = stamNr;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public String getThuisArena() {
        return thuisArena;
    }

    public void setThuisArena(String thuisArena) {
        this.thuisArena = thuisArena;
    }

    public Trainer getTrainer() {
        return trainer;
    }

    public void setTrainer(Trainer trainer) {
        this.trainer = trainer;
    }

   

    
}
