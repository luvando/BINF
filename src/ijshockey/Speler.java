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
public class Speler extends Lid {

    private String voorkeurpositie;
    private Team team;

    public Speler(String voornaam, String achternaam, String geboortedatum, String voorkeurpositie, Team team) {
        super(voornaam, achternaam, geboortedatum);
        this.voorkeurpositie = voorkeurpositie;
        this.team = team;
    }

    public Speler(int lidnr, String voornaam, String achternaam, String geboortedatum, String voorkeurpositie, Team team) {
        super(voornaam, achternaam, geboortedatum, lidnr);
        this.voorkeurpositie = voorkeurpositie;
        this.team = team;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public String getVoorkeurpositie() {
        return voorkeurpositie;
    }

    public void setVoorkeurpositie(String voorkeurpositie) {
        this.voorkeurpositie = voorkeurpositie;
    }

}
