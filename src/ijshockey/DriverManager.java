/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ijshockey;

import static GUIPackage.KeuzeSchermBestaandeCompetitie.dManager;
import GUIPackage.Startscherm;
import java.util.*;
import java.io.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import java.util.Date;
import javax.swing.DefaultListModel;
import javax.swing.JList;

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
    
     public static Speeldag getSpeeldag(String competitienaam, int jaar, int speeldagnr) throws DBException {
        Connection con = null;
        try {
            con = getConnection();
            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);

            String sql = "SELECT * "
                    + "FROM speeldag "
                    + "WHERE competitienaam = " + competitienaam + " AND jaar = " + jaar + " AND speeldagnr = " + speeldagnr;

            ResultSet srs = stmt.executeQuery(sql);
            
            Competitie c = getCompetitie(competitienaam);
            Seizoen seizoen = getSeizoen(jaar);
            
            Speeldag s = new Speeldag(c, seizoen, speeldagnr);
            closeConnection(con);
            return s;
        } catch (Exception ex) {
            ex.printStackTrace();
            closeConnection(con);
            throw new DBException(ex);
        }
    }

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
    
    public static void addWedstrijd(Wedstrijd w) throws DBException {
        Connection con = null;
        try {
            con = getConnection();
            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);

            String sql = "INSERT into wedstrijd "
                    + "(competitienaam, jaar, wedstrijdnr, arena, datum, gespeeld, score_thuis, score_uit, lidnr_scheidsrechter, speeldagnr, stamnr_thuis, stamnr_uit) ; "
                    + "VALUES ('" w "')";
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
            Date datum;
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
                arena = srs.getString("voornaam");
                datum = srs.getDate("datum");
                gespeeld = srs.getBoolean("gespeeld");
                score_thuis = srs.getInt("score_thuis");
                score_uit = srs.getInt("score_uit");
                scheidsrechter = getScheids(srs.getInt("lidnr_scheidsrechter"));
                s = getSpeeldag(srs.getInt("speeldagnr"));
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
    
    public static void addSpeler(Speler s) throws DBException {
        Connection con = null;
        try {
            con = getConnection();
            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);

            String sql = "INSERT into speler "
                    + "(lidnr, voornaam, achternaam, geboortedatum, voorkeurspositie, goals, assists, penaltys, speelminuten, team) "
                    + "VALUES ('" + s.getVoornaam() + "', '" + s.getAchternaam() + "', '" + s.getGeboortedatum() + "', '" + s.getVoorkeurpositie() + "', '" + s.getGoals()
                    + "', '" + s.getAssists()+ "', '" + s.getPenaltys()+ "', '" + s.getSpeelminuten()+ "', '" + s.getTeam()+ "')";
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
        System.out.println(getSpeler(lidnr).toStringSpelerRapport());
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

            String sql = "SELECT stamnr "
                    + "FROM team "
                    + "ORDER BY punten DESC";
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
