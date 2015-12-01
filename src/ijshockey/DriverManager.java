/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ijshockey;

import GUIPackage.*;
import java.util.*;
import java.util.Date;
import java.io.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

/**
 *
 * @author ekmaes
 */
public class DriverManager {

    public static ResultSet FillLijstCompetities() throws SQLException {
        Connection con = null;
        try {
            con = getConnection();
            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

            String sql = "SELECT * FROM competitie";

            ResultSet srs = stmt.executeQuery(sql);
            return srs;

        } catch (DBException ex) {
            Logger.getLogger(DriverManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }
//    public static ResultSet FillLijstCompetitiesSeizoen(JList LijstCompetities){
//        Connection con = null;
//            con = getConnection();
//            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
//
//            String sql = "SELECT jaar FROM seizoen WHERE competitienaam = " + "'" + LijstCompetities.getSelectedValue() + "'";
//
//            ResultSet srs = stmt.executeQuery(sql);
//    }

    public static ResultSet FillLijstSpeeldagen(String competitienaam, int jaar) throws SQLException {
        Connection con = null;

        try {
            con = getConnection();
            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

            String sql = "SELECT speeldagnr FROM speeldag "
                    + "WHERE competitienaam = '"+competitienaam+"' AND jaar = '"+jaar+"'";

            ResultSet srs = stmt.executeQuery(sql);
            return srs;

        } catch (DBException ex) {
            Logger.getLogger(DriverManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }

    public static ResultSet FillLijstScheids() throws SQLException {
        Connection con = null;

        try {
            con = getConnection();
            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

            String sql = "SELECT * FROM scheidsrechter ";

            ResultSet srs = stmt.executeQuery(sql);
            return srs;

        } catch (DBException ex) {
            Logger.getLogger(DriverManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }

    public DriverManager() {
    }

    public static void main(String[] args) throws DBException { // Start programma methode!!
        DriverManager dm = new DriverManager();
        Startscherm st = new Startscherm(dm);
        st.setVisible(true);

//        //Test speelminuten berekenen
//       
//        int a = DriverManager.playedMinutesGame(2,1);
//        System.out.println("Gespeelde minuten van speler 2 in wedstrijd 1 van seizoen 2015: " +a);
//        int b = DriverManager.playedMinutesSeason(2);
//        System.out.println("Gespeelde minuten van speler 2 in seizoen 2015: " +b);
//        
//        
//        //Test gegevens toevoegen aan database
//        
//        Competitie c = new Competitie("BeneLeague");
//        DriverManager.add(c);
//        Seizoen s = new Seizoen(c.getCompetitienaam(),2015);
//        DriverManager.add(s);
//        
//        /*Opmerking: SQL om rijen terug te verwijderen in phpmyadmin:
//         SET FOREIGN_KEY_CHECKS=0; 
//         DELETE FROM seizoen
//         WHERE competitienaam='BeneLeague';
//         DELETE FROM competitie
//         WHERE competitienaam='BeneLeague';
//         SET FOREIGN_KEY_CHECKS=1; */
//        
//        //Test database updaten
    }

    public static void updateDB() {
        //gegevens spelers en teams berekenen en in database steken na elke speeldag
    }

//competitie
    public static void addComp(Competitie c) throws DBException {
        Connection con = null;
        try {
            con = getConnection();
            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);

            String sql = "INSERT into competitie "
                    + "(competitienaam) "
                    + "VALUES ('" + c.getCompetitienaam() + "')";
            stmt.executeUpdate(sql);

            closeConnection(con);
        } catch (Exception ex) {
            ex.printStackTrace();
            closeConnection(con);
            throw new DBException(ex);
        }
    }

    public static Competitie getCompetitie(String competitienaam){
        Competitie c = new Competitie(competitienaam);
        return c;
    }

//seizoen
    //addSeizoen
    public static Seizoen getSeizoen(int jaar, String competitienaam){
        Seizoen s = new Seizoen(DriverManager.getCompetitie(competitienaam),jaar);
        return s;
    }

//speeldag   
    //addSpeeldag
    public static Speeldag getSpeeldag(String competitienaam, int jaar, int speeldagnr){
        Speeldag s = new Speeldag(DriverManager.getCompetitie(competitienaam), DriverManager.getSeizoen(jaar, competitienaam), speeldagnr);
        return s;
    }

    public static void addSpeeldag(Speeldag sp) throws DBException {
        Connection con = null;
        try {
            con = getConnection();
            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);

            String sql = "INSERT into speeldag "
                    + "(competitienaam, jaar, speeldagnr)"
                    + "VALUES ('" + sp.getCompetitie() + "','" + sp.getJaar() + "','" + sp.getSpeeldagnr() + "')";
            stmt.executeUpdate(sql);

            closeConnection(con);
        } catch (Exception ex) {
            ex.printStackTrace();
            closeConnection(con);
            throw new DBException(ex);
        }
    }

    public static void addWedstrijd(Wedstrijd w, Speeldag sp) throws DBException {
        Connection con = null;
        try {
            con = getConnection();
            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);

            String sql = "INSERT into wedstrijd "
                    + "(competitienaam, jaar, wedstrijdnr, arena, datum, gespeeld, score_thuis, score_uit, "
                    + "lidnr_scheidsrechter, speeldagnr, stamnr_thuis, stamnr_uit) ; "
                    + "VALUES ('" +sp.getCompetitienaam()+ "', '" +sp.getJaar()+ "', '" +w.getWedstrijdNr()+ "', '" +w.getArena()+ "', '"
                    +w.getDatum()+ "', '"+w.getGespeeld()+ "', '" +w.getScoreThuisTeam()+ "', '"+w.getScoreUitTeam()+ "', '" +w.getLidNrScheids()+ "', '"
                    + sp.getSpeeldagnr()+ "', '" +w.getThuisTeam().getStamNr()+ "', '"+w.getUitTeam().getStamNr()+"')";
            
            stmt.executeUpdate(sql);

            closeConnection(con);
        } catch (Exception ex) {
            ex.printStackTrace();
            closeConnection(con);
            throw new DBException(ex);
        }
    }
    public static Wedstrijd getWedstrijd(int wnr) throws DBException {
        Connection con = null;
        try {
            con = getConnection();
            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);

            String sql = "SELECT * "
                    + "FROM wedstrijd "
                    + "WHERE wedstrijdnr = " + wnr;

            ResultSet srs = stmt.executeQuery(sql);

            Competitie c;
            int jaar;
            String arena;
            String datum;
            boolean gespeeld;
            int score_thuis;
            int score_uit;
            Scheidsrechter scheidsrechter;
            Speeldag s;
            Team thuis;
            Team uit;

            if (srs.next()) {
                c = getCompetitie(srs.getString("competitienaam"));
                jaar = srs.getInt("jaar");
                arena = srs.getString("arena");
                datum = srs.getString("datum");
                gespeeld = srs.getBoolean("gespeeld");
                score_thuis = srs.getInt("score_thuis");
                score_uit = srs.getInt("score_uit");
                scheidsrechter = getScheids(srs.getInt("lidnr_scheidsrechter"));
                s = getSpeeldag(srs.getString("competitienaam"), srs.getInt("jaar"), srs.getInt("speeldagnr"));
                thuis = getTeam(srs.getInt("stamnr_thuis"));
                uit = getTeam(srs.getInt("stamnr_uit"));

            } else {
                closeConnection(con);
                return null;
            }
            Wedstrijd w = new Wedstrijd(wnr, thuis, uit, arena, score_thuis, score_uit, scheidsrechter, datum, gespeeld);
            closeConnection(con);
            return w;
        } catch (Exception ex) {
            ex.printStackTrace();
            closeConnection(con);
            throw new DBException(ex);
        }
    }

//highlight
    //getGoal
    //getAssist
    //getOwngoal
    //getPenalty
    //addPenalty
    public static void addAssist(Assist a) throws DBException {
        Connection con = null;
        try {
            con = getConnection();
            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            
            String sql = "SELECT assists "+
                         "FROM speler "+
                         "WHERE lidnr = " + a.getLidNr();
            ResultSet srs = stmt.executeQuery(sql);
            
            if (srs.next()) {//waarvoor dient next() methode???
            
            sql = "UPDATE speler "+
                  "SET assists = assists + 1 "+
                  "WHERE lidnr = " + a.getLidNr();
                      
            stmt.executeUpdate(sql);
            sql = "INSERT into assist "
                    + "(minuut, lidnr, wedstrijdnr) "
                    + "VALUES ('" + a.getMinuut() + "', '" + a.getLidNr() + "', '" + a.getWedstrijdNr() + "')";
            stmt.executeUpdate(sql);
            }
            
            closeConnection(con);
        } catch (Exception ex) {
            ex.printStackTrace();
            closeConnection(con);
            throw new DBException(ex);
        }
    }

    public static void addGoal(Goal g) throws DBException {
        Connection con = null;
        try {
            con = getConnection();
            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);

            String sql = "SELECT goals "+
                         "FROM speler "+
                         "WHERE lidnr = " + g.getLidNr();
            ResultSet srs = stmt.executeQuery(sql);
            
            if (srs.next()) {//waarvoor dient next() methode???
            
            sql = "UPDATE speler "+
                  "SET goals = goals + 1 "+
                  "WHERE lidnr = " + g.getLidNr();
                      
            stmt.executeUpdate(sql);
          
            sql = "INSERT into goal "
                    + "(minuut, lidnr, wedstrijdnr, lidnr_assist) "
                    + "VALUES ('" + g.getMinuut() + "', '" + g.getLidNr() + "', '" + g.getWedstrijdNr() + "', '" + g.getLidnr_assist() + "')";
            stmt.executeUpdate(sql);
            }
            
            closeConnection(con);
        }  catch (Exception ex) {
            ex.printStackTrace();
            closeConnection(con);
            throw new DBException(ex);
        }
    }
    
    
    
    public static void addOwngoal(Owngoal o) throws DBException {
        Connection con = null;
        try {
            con = getConnection();
            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);

            
            String sql = "SELECT owngoals "+
                         "FROM speler "+
                         "WHERE lidnr = " + o.getLidNr();
            ResultSet srs = stmt.executeQuery(sql);
            
            if (srs.next()) {//waarvoor dient next() methode???
            
            sql = "UPDATE speler "+
                  "SET owngoals = owngoals + 1 "+
                  "WHERE lidnr = " + o.getLidNr();
                      
            stmt.executeUpdate(sql);
          
            sql = "INSERT into owngoal "
                    + "(minuut, lidnr, wedstrijdnr) "
                    + "VALUES ('" + o.getMinuut() + "', '" + o.getLidNr() + "', '" + o.getWedstrijdNr() + "')";
            stmt.executeUpdate(sql);
            }
            
            closeConnection(con);
        } catch (Exception ex) {
            ex.printStackTrace();
            closeConnection(con);
            throw new DBException(ex);
        }
    }

    public static void addPenalty(Penalty p) throws DBException {
        Connection con = null;
        try {
             con = getConnection();
            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                                                 ResultSet.CONCUR_READ_ONLY);

            String sql = "SELECT penaltys "+
                         "FROM speler "+
                         "WHERE lidnr = " + p.getLidNr();
            ResultSet srs = stmt.executeQuery(sql);
            
            if (srs.next()) {//waarvoor dient next() methode???
            
            sql = "UPDATE speler "+
                  "SET penaltys = penaltys + 1 "+
                  "WHERE lidnr = " + p.getLidNr();
                      
            stmt.executeUpdate(sql);
          
            sql = "INSERT into penalty "
                    + "(minuut, gescoord, lidnr, wedstrijdnr) "
                    + "VALUES ('" + p.getMinuut() + "', '" + p.getGescoord() + "', '" + p.getLidNr() + "', '" + p.getWedstrijdNr() + "')";
            stmt.executeUpdate(sql);
            }
            
            closeConnection(con);
        } catch (Exception ex) {
            ex.printStackTrace();
            closeConnection(con);
            throw new DBException(ex);
        }
    }

    public static void addStraf(Straf s) throws DBException {
        Connection con = null;
        try {
            con = getConnection();
            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);

            String sql = "SELECT straffen "+
                         "FROM speler "+
                         "WHERE lidnr = " + s.getLidNr();
            ResultSet srs = stmt.executeQuery(sql);
            
            if (srs.next()) {//waarvoor dient next() methode???
            
            sql = "UPDATE speler "+
                  "SET straffen = straffen + 1 "+
                  "WHERE lidnr = " + s.getLidNr();
                   
            stmt.executeUpdate(sql);
        
            sql = "INSERT into straf "
                    + "(minuut, reden, aantal_minuten, lidnr, wedstrijdnr) "
                    + "VALUES ('" + s.getMinuut() + "', '" + s.getReden() + "', '" + s.getAantalMinuten() + "', '" + s.getLidNr() + "', '" + s.getWedstrijdNr() + "')";
            stmt.executeUpdate(sql);
            }
            closeConnection(con);
        } catch (Exception ex) {
            ex.printStackTrace();
            closeConnection(con);
            throw new DBException(ex);
        }
    }

//scheidsrechter    
    public static void addScheids(Scheidsrechter sch) throws DBException {
        Connection con = null;
        try {
            con = getConnection();
            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);

            String sql = "INSERT into scheidsrechter "
                    + "(voornaam, achternaam, geboortedatum) "
                    + "VALUES ('" + sch.getVoornaam() + "', '" + sch.getAchternaam() + "','" + sch.getGeboortedatum() + "')";
            stmt.executeUpdate(sql);

            closeConnection(con);
        } catch (Exception ex) {
            ex.printStackTrace();
            closeConnection(con);
            throw new DBException(ex);
        }
    }

    public static Scheidsrechter getScheids(int lidnr) throws DBException {
        Connection con = null;
        try {
            con = getConnection();
            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);

            String sql = "SELECT * "
                    + "FROM scheidsrechter "
                    + "WHERE lidnr = " + lidnr;

            ResultSet srs = stmt.executeQuery(sql);

            String voornaam;
            String achternaam;
            String geboortedatum;

            if (srs.next()) {
                voornaam = srs.getString("voornaam");
                achternaam = srs.getString("achternaam");
                geboortedatum = srs.getString("geboortedatum");

            } else {
                closeConnection(con);
                return null;
            }
            Scheidsrechter s = new Scheidsrechter(voornaam, achternaam, geboortedatum);
            closeConnection(con);
            return s;
        } catch (Exception ex) {
            ex.printStackTrace();
            closeConnection(con);
            throw new DBException(ex);
        }
    }

//speler
    public static void addSpeler(Speler s) throws DBException {
        Connection con = null;
        try {
            con = getConnection();
            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);

            String sql = "INSERT into speler "
                    + "(lidnr, voornaam, achternaam, geboortedatum, voorkeurspositie, goals, assists, penaltys, speelminuten, team) "
                    + "VALUES ('" + s.getVoornaam() + "', '" + s.getAchternaam() + "', '" + s.getGeboortedatum() + "', '" + s.getVoorkeurpositie() + "', '" + s.getGoals()
                    + "', '" + s.getAssists() + "', '" + s.getPenaltys() + "', '" + s.getSpeelminuten() + "', '" + s.getTeam() + "')";
            stmt.executeUpdate(sql);

            closeConnection(con);
        } catch (Exception ex) {
            ex.printStackTrace();
            closeConnection(con);
            throw new DBException(ex);
        }
    }

    public static Speler getSpeler(int lidnr) throws DBException {
        Connection con = null;
        try {
            con = getConnection();
            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);

            String sql = "SELECT * "
                    + "FROM speler "
                    + "WHERE lidnr = " + lidnr;

            ResultSet srs = stmt.executeQuery(sql);

            String voornaam;
            String achternaam;
            String geboortedatum;
            String voorkeurpositie;
            int goals;
            int assists;
            int penaltys;
            int speelminuten;
            Team team;

            if (srs.next()) {
                voornaam = srs.getString("voornaam");
                achternaam = srs.getString("achternaam");
                geboortedatum = srs.getString("geboortedatum");
                voorkeurpositie = srs.getString("voorkeurpositie");
                goals = srs.getInt("goals");
                assists = srs.getInt("assists");
                penaltys = srs.getInt("penaltys");
                speelminuten = srs.getInt("speelminuten");
                team = getTeam(srs.getInt("stamnr"));

            } else {
                closeConnection(con);
                return null;
            }
            Speler s = new Speler(voornaam, achternaam, geboortedatum, voorkeurpositie, goals, assists, penaltys, speelminuten, team);
            closeConnection(con);
            return s;
        } catch (Exception ex) {
            ex.printStackTrace();
            closeConnection(con);
            throw new DBException(ex);
        }
    }

    public static void printSpelerRanking() throws DBException {
        Connection con = null;
        try {
            con = getConnection();
            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);

            String sql = "SELECT lidnr "
                    + "FROM speler "
                    + "ORDER BY goals DESC";
            ResultSet srs = stmt.executeQuery(sql);

            ArrayList<Speler> rankedplayers = new ArrayList<Speler>();
            while (srs.next()) {
                rankedplayers.add(getSpeler(srs.getInt("lidnr")));
            }

            closeConnection(con);
            for (Speler s : rankedplayers) {
                System.out.println(s.toStringSpelerRanking());
            }
        } catch (DBException dbe) {
            dbe.printStackTrace();
            closeConnection(con);
            throw dbe;
        } catch (Exception ex) {
            ex.printStackTrace();
            closeConnection(con);
            throw new DBException(ex);
        }
    }

    public static void printSpelerRapport(int lidnr) throws DBException {

        Speler s = DriverManager.getSpeler(lidnr);
        if (s.getPenaltys() == 0) {
            System.out.println(getSpeler(lidnr).toStringSpelerRapport());
        } else {
            System.out.println(getSpeler(lidnr).toStringSpelerRapport());
            DriverManager.printGoals(lidnr);
            DriverManager.printPenaltys(lidnr);
            DriverManager.printAssist(lidnr);
        }

    }

    public static int playedMinutesGame(int lidnr, int wedstrijdnr) {
        int playedMinutesGame = 0;
        try {
            ArrayList<Opstelling> opstellingen = getOpstellingenGame(wedstrijdnr, lidnr);
            for (Opstelling opstelling : opstellingen) {
                playedMinutesGame += opstelling.getTijdstipUit() - opstelling.getTijdstipIn();
            }
        } catch (DBException ex) {
            Logger.getLogger(DriverManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return playedMinutesGame;
    }

    public static int playedMinutesSeason(int lidnr) {
        int playedMinutesSeason = 0;
        try {
            ArrayList<Opstelling> opstellingen = getOpstellingenSeason(lidnr);
            for (Opstelling opstelling : opstellingen) {
                playedMinutesSeason += opstelling.getTijdstipUit() - opstelling.getTijdstipIn();
            }
        } catch (DBException ex) {
            Logger.getLogger(DriverManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return playedMinutesSeason;

    }
//trainer

    public static void addTrainer(Trainer s) throws DBException {
        Connection con = null;
        try {
            con = getConnection();
            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);

            String sql = "INSERT into trainer "
                    + "(voornaam, achternaam, geboortedatum) "
                    + "VALUES ('" + s.getVoornaam() + "', '" + s.getAchternaam() + "', '" + s.getGeboortedatum() + "')";
            stmt.executeUpdate(sql);

            closeConnection(con);
        } catch (Exception ex) {
            ex.printStackTrace();
            closeConnection(con);
            throw new DBException(ex);
        }
    }

//team
    public static void addTeam(Team t, String competitie, int seizoen) throws DBException {
        Connection con = null;
        try {
            con = getConnection();
            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);

            String sql = "INSERT into team "
                    + "(stamnr, naam, thuisarena) "
                    + "VALUES ('" + t.getStamNr() + "', '" + t.getNaam() + "', '" + t.getThuisArena() + "')";
            stmt.executeUpdate(sql);
            String sql2 = "INSERT into deelname "
                    + "(competitienaam,seizoen, stamnr) "
                    + "VALUES ('" + competitie + "', '" + seizoen + "', '" + t.getStamNr() + "')";
            stmt.executeUpdate(sql2);

            closeConnection(con);
        } catch (Exception ex) {
            ex.printStackTrace();
            closeConnection(con);
            throw new DBException(ex);
        }
    }

    public static Team getTeam(int stamnr) throws DBException {
        Connection con = null;
        try {
            con = getConnection();
            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);

            String sql = "SELECT * "
                    + "FROM team "
                    + "WHERE stamnr = " + stamnr;

            ResultSet srs = stmt.executeQuery(sql);

            String naam;
            String thuisarena;
            int punten;
            int gespeeld;
            int gewonnen;
            int gelijk;
            int verloren;
            int goalsvoor;
            int goalstegen;
            int penaltys;
            int lidnr_trainer;

            if (srs.next()) {
                naam = srs.getString("naam");
                thuisarena = srs.getString("thuisarena");
                punten = srs.getInt("punten");
                gespeeld = srs.getInt("gespeeld");
                gewonnen = srs.getInt("gewonnen");
                gelijk = srs.getInt("gespeeld");
                verloren = srs.getInt("verloren");
                goalsvoor = srs.getInt("goalsvoor");
                goalstegen = srs.getInt("goalstegen");
                penaltys = srs.getInt("penaltys");
                lidnr_trainer = srs.getInt("lidnr_trainer");

            } else {
                closeConnection(con);
                return null;
            }
            Team t = new Team(stamnr, naam, thuisarena, punten, gespeeld, gewonnen, verloren, gelijk, goalsvoor, goalstegen, penaltys, lidnr_trainer);

            closeConnection(con);
            return t;
        } catch (Exception ex) {
            ex.printStackTrace();
            closeConnection(con);
            throw new DBException(ex);
        }
    }

    public static void printTeamRanking() throws DBException {
        Connection con = null;
        try {
            con = getConnection();
            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);

            String sql = "SELECT stamnr, (goalsvoor - goalstegen) "
                    + "FROM team "
                    + "ORDER BY punten DESC, (goalsvoor - goalstegen) DESC ";
            ResultSet srs = stmt.executeQuery(sql);

            ArrayList<Team> rankedteams = new ArrayList<Team>();
            while (srs.next()) {
                rankedteams.add(getTeam(srs.getInt("stamnr")));
            }

            closeConnection(con);
            for (Team t : rankedteams) {
                System.out.println(t.toStringTeamRanking());
            }
        } catch (DBException dbe) {
            dbe.printStackTrace();
            closeConnection(con);
            throw dbe;
        } catch (Exception ex) {
            ex.printStackTrace();
            closeConnection(con);
            throw new DBException(ex);
        }
    }

    public static void printTeamRapport(int stamNr) throws DBException {
        System.out.println(getTeam(stamNr).toStringTeamRapport());
    }

//goal
    public static Goal getGoal(int highlightnr) throws DBException {
        Connection con = null;
        try {
            con = getConnection();
            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);

            String sql = "SELECT minuut, lidnr, wedstrijdnr "
                    + "FROM goal "
                    + "WHERE highlightnr = " + highlightnr;

            ResultSet srs = stmt.executeQuery(sql);

            int minuut;
            int lidnr;
            int wedstrijdnr;

            if (srs.next()) {
                minuut = srs.getInt("minuut");
                lidnr = srs.getInt("lidnr");
                wedstrijdnr = srs.getInt("wedstrijdnr");

            } else {
                closeConnection(con);
                return null;
            }
            Goal g = new Goal(minuut, lidnr, wedstrijdnr);

            closeConnection(con);
            return g;
        } catch (Exception ex) {
            ex.printStackTrace();
            closeConnection(con);
            throw new DBException(ex);
        }
    }

    public static void printGoals(int lidnr) throws DBException {
        Connection con = null;
        try {
            con = getConnection();
            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);

            String sql = "SELECT highlightnr "
                    + "FROM goal "
                    + "WHERE lidnr = " + lidnr ;
            ResultSet srs = stmt.executeQuery(sql);

            ArrayList<Goal> goals = new ArrayList<>();
            while (srs.next()) {
                goals.add(getGoal(srs.getInt("highlightnr")));
            }

            closeConnection(con);
            for (Goal g : goals) {
                System.out.println(g.toString());
            }
        } catch (DBException dbe) {
            dbe.printStackTrace();
            closeConnection(con);
            throw dbe;
        } catch (Exception ex) {
            ex.printStackTrace();
            closeConnection(con);
            throw new DBException(ex);
        }
    }
    
    public static void printAssist(int lidnr) throws DBException {
        Connection con = null;
        try {
            con = getConnection();
            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);

            String sql = "SELECT highlightnr "
                    + "FROM goal "
                    + "WHERE lidnr_assist = " + lidnr ;
            ResultSet srs = stmt.executeQuery(sql);

            ArrayList<Goal> goals = new ArrayList<>();
            while (srs.next()) {
                goals.add(getGoal(srs.getInt("highlightnr")));
            }

            closeConnection(con);
            for (Goal g : goals) {
                System.out.println(g.toStringAssist());
            }
        } catch (DBException dbe) {
            dbe.printStackTrace();
            closeConnection(con);
            throw dbe;
        } catch (Exception ex) {
            ex.printStackTrace();
            closeConnection(con);
            throw new DBException(ex);
        }
    }

//penalty
    public static Penalty getPenalty(int highlightnr) throws DBException {
        Connection con = null;
        try {
            con = getConnection();
            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);

            String sql = "SELECT minuut, lidnr, wedstrijdnr, gescoord "
                    + "FROM penalty "
                    + "WHERE highlightnr = " + highlightnr;

            ResultSet srs = stmt.executeQuery(sql);

            int minuut;
            int lidnr;
            int wedstrijdnr;
            int gescoord;

            if (srs.next()) {
                minuut = srs.getInt("minuut");
                lidnr = srs.getInt("lidnr");
                wedstrijdnr = srs.getInt("wedstrijdnr");
                gescoord = srs.getInt("gescoord");

            } else {
                closeConnection(con);
                return null;
            }
            Penalty p = new Penalty(minuut, lidnr, wedstrijdnr, gescoord);

            closeConnection(con);
            return p;
        } catch (Exception ex) {
            ex.printStackTrace();
            closeConnection(con);
            throw new DBException(ex);
        }
    }

    public static void printPenaltys(int lidnr) throws DBException {
        Connection con = null;
        try {
            con = getConnection();
            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);

            String sql = "SELECT highlightnr "
                    + "FROM penalty "
                    + "WHERE lidnr = " + lidnr;
            ResultSet srs = stmt.executeQuery(sql);

            ArrayList<Penalty> penaltys = new ArrayList<>();
            while (srs.next()) {
                penaltys.add(getPenalty(srs.getInt("highlightnr")));
            }

            closeConnection(con);
            for (Penalty p : penaltys) {
                System.out.println(p.toString());
            }
        } catch (DBException dbe) {
            dbe.printStackTrace();
            closeConnection(con);
            throw dbe;
        } catch (Exception ex) {
            ex.printStackTrace();
            closeConnection(con);
            throw new DBException(ex);
        }
    }
//opstelling

    public static Opstelling getOpstelling(int wedstrijdnr, int lidnr, int opstellingnr) throws DBException {
        Connection con = null;
        try {
            con = getConnection();
            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);

            String sql = "SELECT tijdstip_in, tijdstip_uit, positie "
                    + "FROM opstelling "
                    + "WHERE wedstrijdnr = " + wedstrijdnr + " AND lidnr = " + lidnr + " AND opstellingnr = " + opstellingnr;

            ResultSet srs = stmt.executeQuery(sql);

            int tijdstip_in;
            int tijdstip_uit;
            String positie;

            if (srs.next()) {
                tijdstip_in = srs.getInt("tijdstip_in");
                tijdstip_uit = srs.getInt("tijdstip_uit");
                positie = srs.getString("positie");

            } else {
                closeConnection(con);
                return null;
            }
            Opstelling opstelling = new Opstelling(positie, tijdstip_in, tijdstip_uit);

            closeConnection(con);
            return opstelling;
        } catch (Exception ex) {
            ex.printStackTrace();
            closeConnection(con);
            throw new DBException(ex);
        }
    }

    public static ArrayList<Opstelling> getOpstellingenGame(int wedstrijdnr, int lidnr) throws DBException {
        Connection con = null;
        try {
            con = getConnection();
            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);

            String sql = "SELECT wedstrijdnr, lidnr, opstellingnr "
                    + "FROM opstelling "
                    + "WHERE wedstrijdnr = " + wedstrijdnr + " AND lidnr = " + lidnr;

            ResultSet srs = stmt.executeQuery(sql);

            ArrayList<Opstelling> opstellingen = new ArrayList<Opstelling>();
            while (srs.next()) {
                opstellingen.add(getOpstelling(srs.getInt("wedstrijdnr"), srs.getInt("lidnr"), srs.getInt("opstellingnr")));
            }

            closeConnection(con);
            return opstellingen;
        } catch (Exception ex) {
            ex.printStackTrace();
            closeConnection(con);
            throw new DBException(ex);
        }
    }

    public static ArrayList<Opstelling> getOpstellingenSeason(int lidnr) throws DBException {
        Connection con = null;
        try {
            con = getConnection();
            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);

            String sql = "SELECT wedstrijdnr, lidnr, opstellingnr "
                    + "FROM opstelling "
                    + "WHERE lidnr = " + lidnr;

            ResultSet srs = stmt.executeQuery(sql);

            ArrayList<Opstelling> opstellingen = new ArrayList<Opstelling>();
            while (srs.next()) {
                opstellingen.add(getOpstelling(srs.getInt("wedstrijdnr"), srs.getInt("lidnr"), srs.getInt("opstellingnr")));
            }

            closeConnection(con);
            return opstellingen;
        } catch (Exception ex) {
            ex.printStackTrace();
            closeConnection(con);
            throw new DBException(ex);
        }
    }

//DBconnection
    public static Connection getConnection() throws DBException {
        Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");

            String protocol = "jdbc";
            String subProtocol = "mysql";
            String subName = "//mysqlha2.ugent.be/BINFG11?user=BINFG11&password=4v3yfrzt";
            String URL = protocol + ":" + subProtocol + ":" + subName;
// wat met meerdere connecties? bestaande connectie herbruiken
            con = java.sql.DriverManager.getConnection(URL);
            return con;
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            closeConnection(con);
            throw new DBException(sqle);
        } catch (ClassNotFoundException cnfe) {
            cnfe.printStackTrace();
            closeConnection(con);
            throw new DBException(cnfe);
        } catch (Exception ex) {
            ex.printStackTrace();
            closeConnection(con);
            throw new DBException(ex);
        }
    }

    public static void closeConnection(Connection con) {
        try {
            con.close();
        } catch (SQLException sqle) {
            //do nothing
        }
    }

}
