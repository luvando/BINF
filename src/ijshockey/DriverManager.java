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

//FillLijsten
    public static DefaultListModel FillLijstCompetities(DefaultListModel DLM) throws SQLException {
        Connection con = null;
        DLM = new DefaultListModel();
        try {
            con = getConnection();
            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

            String sql = "SELECT competitienaam FROM competitie";

            ResultSet srs = stmt.executeQuery(sql);
            String competitienaam;
            while (srs.next()) {
                competitienaam = srs.getString("competitienaam");
                DLM.addElement(competitienaam);
            }
            closeConnection(con);
            return DLM;

        } catch (Exception ex) {
            Logger.getLogger(DriverManager.class.getName()).log(Level.SEVERE, null, ex);
            closeConnection(con);
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
//FillLijsten!!

    public static DefaultListModel FillLijstSpeeldagen(DefaultListModel DLM, Competitie competitie, Seizoen seizoen) throws SQLException {
        Connection con = null;
        DLM = new DefaultListModel();
        try {
            con = getConnection();
            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

            String sql = "SELECT speeldagnr FROM speeldag "
                    + "WHERE competitienaam = '" + competitie.getCompetitienaam() + "' AND jaar = " + seizoen.getJaar();

            ResultSet srs = stmt.executeQuery(sql);
            int speeldagnr;
            while (srs.next()) {
                speeldagnr = srs.getInt("speeldagnr");
                DLM.addElement(speeldagnr);
            }
            closeConnection(con);
            return DLM;

        } catch (Exception ex) {
            Logger.getLogger(DriverManager.class.getName()).log(Level.SEVERE, null, ex);
            closeConnection(con);
        }
        return null;
    }

    public static DefaultListModel FillLijstScheids(DefaultListModel DLM) throws SQLException {
        Connection con = null;
        DLM = new DefaultListModel();

        try {
            con = getConnection();
            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

            String sql = "SELECT * FROM scheidsrechter ";

            ResultSet srs = stmt.executeQuery(sql);

            int lidnr;
            String voornaam;
            String achternaam;

            while (srs.next()) {
                lidnr = srs.getInt("lidnr");
                voornaam = srs.getString("voornaam");
                achternaam = srs.getString("achternaam");
                DLM.addElement(voornaam + " " + achternaam + " - " + lidnr);
            }
            closeConnection(con);
            return DLM;

        } catch (Exception ex) {
            Logger.getLogger(DriverManager.class.getName()).log(Level.SEVERE, null, ex);
            closeConnection(con);
        }
        return null;
    }

    public static DefaultListModel FillLijstTeam(DefaultListModel DLM, Competitie c, Seizoen s) throws SQLException {
        Connection con = null;
        DLM = new DefaultListModel();

        try {
            con = getConnection();
            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

            String sql = "SELECT naam, stamnr\n"
                    + "FROM\n"
                    + "(\n"
                    + "SELECT team.stamnr, team.naam, deelname.competitienaam, deelname.jaar\n"
                    + "FROM team\n"
                    + "JOIN deelname\n"
                    + "ON team.stamnr = deelname.stamnr\n"
                    + ") AS tabel\n"
                    + "WHERE tabel.competitienaam = '" + c.getCompetitienaam() + "' AND tabel.jaar = " + s.getJaar();

            ResultSet srs = stmt.executeQuery(sql);
            int stamnr;
            String naam;
            while (srs.next()) {
                stamnr = srs.getInt("stamnr");
                naam = srs.getString("naam");
                DLM.addElement(naam + " - " + stamnr);
            }
            closeConnection(con);
            return DLM;

        } catch (Exception ex) {
            Logger.getLogger(DriverManager.class.getName()).log(Level.SEVERE, null, ex);
            closeConnection(con);
        }
        return null;
    }

    public static DefaultListModel FillLijstTeamAll(DefaultListModel DLM) throws SQLException {
        Connection con = null;
        DLM = new DefaultListModel();

        try {
            con = getConnection();
            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

            String sql = "SELECT naam, stamnr FROM team ";

            ResultSet srs = stmt.executeQuery(sql);

            while (srs.next()) {
                int stamnr = srs.getInt("stamnr");
                String naam = srs.getString("naam");
                DLM.addElement(naam + " - " + stamnr);

            }
            closeConnection(con);
            return DLM;

        } catch (Exception ex) {
            Logger.getLogger(DriverManager.class.getName()).log(Level.SEVERE, null, ex);
            closeConnection(con);
        }
        return null;
    }

    public static DefaultListModel FillLijstSpelers(DefaultListModel DLM, int stamnr) throws SQLException {
        Connection con = null;
        DLM = new DefaultListModel();
        try {
            con = getConnection();
            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

            String sql = "SELECT voornaam, achternaam, lidnr FROM speler "
                    + "WHERE stamnr = '" + stamnr + "'";

            ResultSet srs = stmt.executeQuery(sql);

            while (srs.next()) {
                int lidnr = srs.getInt("lidnr");
                String voornaam = srs.getString("voornaam");
                String achternaam = srs.getString("achternaam");
                DLM.addElement(voornaam + " " + achternaam + " - " + lidnr);

            }
            closeConnection(con);
            return DLM;

        } catch (Exception ex) {
            Logger.getLogger(DriverManager.class.getName()).log(Level.SEVERE, null, ex);
            closeConnection(con);
        }
        return null;

    }

    public static DefaultListModel FillLijstSpelers(DefaultListModel DLM, Competitie c, Seizoen s) throws SQLException {
        Connection con = null;
        DLM = new DefaultListModel();
        try {
            con = getConnection();
            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

            String sql = "SELECT voornaam, achternaam, lidnr\n"
                    + "FROM \n"
                    + "(SELECT speler.lidnr, speler.voornaam, speler.achternaam, deelname.competitienaam, deelname.jaar\n"
                    + "FROM speler\n"
                    + "JOIN team\n"
                    + "ON speler.stamnr = team.stamnr\n"
                    + "JOIN deelname\n"
                    + "ON team.stamnr = deelname.stamnr\n"
                    + ") AS tabel\n"
                    + "WHERE tabel.competitienaam = '" + c.getCompetitienaam() + "' AND tabel.jaar = " + s.getJaar();

            ResultSet srs = stmt.executeQuery(sql);

            while (srs.next()) {
                int lidnr = srs.getInt("lidnr");
                String voornaam = srs.getString("voornaam");
                String achternaam = srs.getString("achternaam");
                DLM.addElement(voornaam + " " + achternaam + " - " + lidnr);

            }
            closeConnection(con);
            return DLM;

        } catch (Exception ex) {
            Logger.getLogger(DriverManager.class.getName()).log(Level.SEVERE, null, ex);
            closeConnection(con);
        }
        return null;

    }

    public static DefaultListModel FillLijstSpelers(DefaultListModel DLM, Team team) throws SQLException {
        Connection con = null;
        DLM = new DefaultListModel();
        try {
            con = getConnection();
            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

            String sql = "SELECT * FROM speler WHERE stamnr = " + team.getStamNr();

            ResultSet srs = stmt.executeQuery(sql);

            while (srs.next()) {
                int lidnr = srs.getInt("lidnr");
                String voornaam = srs.getString("voornaam");
                String achternaam = srs.getString("achternaam");
                DLM.addElement(voornaam + " " + achternaam + " - " + lidnr);

            }
            closeConnection(con);
            return DLM;

        } catch (Exception ex) {
            Logger.getLogger(DriverManager.class.getName()).log(Level.SEVERE, null, ex);
            closeConnection(con);
        }
        return null;

    }

    public static DefaultListModel FillLijstWedstrijden(DefaultListModel DLM, Competitie c, Seizoen s) throws SQLException, DBException {
        Connection con = null;
        try {
            con = getConnection();
            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            String sql = "SELECT wedstrijdnr, arena, datum , gespeeld, lidnr_scheidsrechter, competitienaam, jaar , speeldagnr, stamnr_thuis, stamnr_uit\n"
                    + "FROM wedstrijd \n"
                    + "WHERE competitienaam = '" + c.getCompetitienaam() + "' AND jaar = " + s.getJaar();

            ResultSet srs = stmt.executeQuery(sql);

            int wnr;
            String arena;
            String datum;

            Scheidsrechter scheidsrechter;
            Speeldag speeldag;
            Team thuis;
            Team uit;

            while (srs.next()) {

                wnr = srs.getInt("wedstrijdnr");
                arena = srs.getString("arena");
                datum = srs.getString("datum");

                scheidsrechter = getScheids(srs.getInt("lidnr_scheidsrechter"));
                speeldag = getSpeeldag(srs.getString("competitienaam"), srs.getInt("jaar"), srs.getInt("speeldagnr"));
                thuis = getTeam(srs.getInt("stamnr_thuis"));
                uit = getTeam(srs.getInt("stamnr_uit"));

                DLM.addElement(thuis.getNaam() + " - " + uit.getNaam() + "( " + datum + " )" + " - " + wnr);

            }
            closeConnection(con);
            return DLM;

        } catch (Exception ex) {
            ex.getMessage();
            ex.printStackTrace();
            closeConnection(con);
            throw new DBException(ex);
        }

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

    public static Competitie getCompetitie(String competitienaam) {
        Competitie c = new Competitie(competitienaam);
        return c;
    }

//seizoen
    //addSeizoen
    public static Seizoen getSeizoen(int jaar, String competitienaam) {
        Seizoen s = new Seizoen(DriverManager.getCompetitie(competitienaam), jaar);
        return s;
    }

//speeldag
    public static Speeldag getSpeeldag(String competitienaam, int jaar, int speeldagnr) {
        Speeldag s = new Speeldag(DriverManager.getCompetitie(competitienaam), DriverManager.getSeizoen(jaar, competitienaam), speeldagnr);
        return s;
    }

    public static void addSpeeldag(Speeldag sp) throws DBException {
        Connection con = null;
        try {
            con = getConnection();
            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);

            String sql = "INSERT INTO speeldag "
                    + "(competitienaam, jaar, speeldagnr)"
                    + "VALUES ('" + sp.getCompetitie().getCompetitienaam() + "','" + sp.getSeizoen().getJaar() + "','" + sp.getSpeeldagnr() + "')";
            stmt.executeUpdate(sql);

            closeConnection(con);
        } catch (Exception ex) {
            ex.printStackTrace();
            closeConnection(con);
            throw new DBException(ex);
        }
    }

//wedstrijd
    public static void addNoScoreWedstrijd(Wedstrijd w) throws DBException {
        Connection con = null;
        try {
            con = getConnection();
            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);

            String sql = "INSERT INTO wedstrijd "
                    + "(competitienaam ,jaar, arena, datum, gespeeld, "
                    + "lidnr_scheidsrechter, speeldagnr, stamnr_thuis, stamnr_uit)"
                    + "VALUES ('" + w.getSeizoen().getC().getCompetitienaam() + "','"
                    + w.getSeizoen().getJaar() + "','"
                    + w.getArena() + "','"
                    + w.getDatum() + "','"
                    + w.getGespeeld() + "','"
                    + w.getScheidsrechter().getLidnr() + "','"
                    + w.getSp().getSpeeldagnr() + "','"
                    + w.getThuisTeam().getStamNr() + "','"
                    + w.getUitTeam().getStamNr() + "')";

            stmt.executeUpdate(sql);

            closeConnection(con);
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

            String sql = "INSERT INTO wedstrijd "
                    + "(competitienaam ,jaar, arena, datum, gespeeld, score_thuis, score_uit, "
                    + "lidnr_scheidsrechter, speeldagnr, stamnr_thuis, stamnr_uit)"
                    + "VALUES ('" + w.getSeizoen().getC().getCompetitienaam() + "','"
                    + w.getSeizoen().getJaar() + "','"
                    + w.getArena() + "','"
                    + w.getDatum() + "','"
                    + w.getGespeeld() + "','"
                    + w.getScoreThuisTeam() + "','"
                    + w.getScoreUitTeam() + "','"
                    + w.getScheidsrechter().getLidnr() + "','"
                    + w.getSp().getSpeeldagnr() + "','"
                    + w.getThuisTeam().getStamNr() + "','"
                    + w.getUitTeam().getStamNr() + "')";

            stmt.executeUpdate(sql);

            closeConnection(con);
        } catch (Exception ex) {
            ex.printStackTrace();
            closeConnection(con);
            throw new DBException(ex);
        }
    }

    public static void bewerkWedstrijd(Wedstrijd w) throws DBException {
        Connection con = null;
        try {
            con = getConnection();
            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);

            String sql = "UPDATE wedstrijd\n"
                    + "SET datum = " + w.getDatum() + ", score_thuis = " + w.getScoreThuisTeam() + ", score_uit = " + w.getScoreUitTeam() + ",lidnr_scheidsrechter = " + w.getScheidsrechter().getLidnr() + "\n"
                    + "WHERE competitienaam = '" + w.getSeizoen().getC().getCompetitienaam() + "' AND jaar = " + w.getSeizoen().getJaar() + " AND wedstrijdnr = " + w.getWedstrijdNr();
            stmt.executeUpdate(sql);

            closeConnection(con);
        } catch (Exception ex) {
            ex.printStackTrace();
            closeConnection(con);
            throw new DBException(ex);
        }
    }

    public static void addOpstelling(Opstelling o) throws DBException {
        Connection con = null;
        try {
            con = getConnection();
            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);

            String sql = "INSERT INTO opstelling "
                    + "(wedstrijdnr, lidnr, tijdstip_in, tijdstip_uit, positie)"
                    + "VALUES ('" + o.getWedstrijd().getWedstrijdNr() + "','" + o.getSpeler().getLidnr() + "','" + o.getTijdstipIn() + "','"
                    + o.getTijdstipUit() + "', '" + o.getPositie() + "')";

            stmt.executeUpdate(sql);

            closeConnection(con);
        } catch (Exception ex) {
            ex.printStackTrace();
            closeConnection(con);
            throw new DBException(ex);
        }
    }

    /*public static void updateScore(Wedstrijd w) throws DBException {
     Connection con = null;
     try {
     con = getConnection();
     Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
     ResultSet.CONCUR_READ_ONLY);
     int scoreWinner;
     int scoreLoser;
     Team winner;
     Team loser;

     if (w.getScoreThuisTeam() > w.getScoreUitTeam()) {
     winner = w.getThuisTeam();
     loser = w.getUitTeam();
     scoreWinner = w.getScoreThuisTeam();
     scoreLoser = w.getScoreUitTeam();
     } else {
     winner = w.getUitTeam();
     loser = w.getThuisTeam();
     scoreWinner = w.getScoreUitTeam();
     scoreLoser = w.getScoreThuisTeam();
     }

     if (w.getScoreThuisTeam() == w.getScoreUitTeam()) {
     String sqlthuis = "UPDATE deelname "
     + "SET gespeeld = gespeeld + 1, "
     + "punten = punten + 1, "
     + "gelijk = gelijk + 1, "
     + "goalsvoor = goalsvoor + " + w.getScoreThuisTeam() + ","
     + " goalstegen = goalstegen + " + w.getScoreUitTeam()
     + " WHERE stamnr = '" + w.getThuisTeam().getStamNr() + "' AND competitienaam = '" + w.getSp().getCompetitienaam()
     + "' AND jaar = '" + w.getSp().getJaar() + "'";

     stmt.executeUpdate(sqlthuis);
     String sqluit = "UPDATE deelname "
     + "SET gespeeld = gespeeld + 1, "
     + "punten = punten + 1, "
     + "gelijk = gelijk + 1, "
     + "goalsvoor = goalsvoor + " + w.getScoreUitTeam() + ","
     + " goalstegen = goalstegen + " + w.getScoreThuisTeam()
     + " WHERE stamnr = '" + w.getUitTeam().getStamNr() + "' AND competitienaam = '" + w.getSp().getCompetitienaam()
     + "' AND jaar = '" + w.getSp().getJaar() + "'";

     stmt.executeUpdate(sqluit);
     } else {
     String sqlwinner = "UPDATE deelname "
     + "SET gespeeld = gespeeld + 1, "
     + "punten = punten + 3, "
     + "gewonnen = gewonnen + 1, "
     + "goalsvoor = goalsvoor + " + scoreWinner + ","
     + " goalstegen = goalstegen + " + scoreLoser
     + " WHERE stamnr = '" + winner.getStamNr() + "' AND competitienaam = '" + w.getSp().getCompetitienaam()
     + "' AND jaar = '" + w.getSp().getJaar() + "'";
     stmt.executeUpdate(sqlwinner);

     String sqlloser = "UPDATE deelname "
     + "SET gespeeld = gespeeld + 1, "
     + "verloren = verloren + 1, "
     + "goalsvoor = goalsvoor + " + scoreLoser + ","
     + " goalstegen = goalstegen + " + scoreWinner
     + " WHERE stamnr = '" + loser.getStamNr() + "' AND competitienaam = '" + w.getSp().getCompetitienaam()
     + "' AND jaar = '" + w.getSp().getJaar() + "'";

     stmt.executeUpdate(sqlloser);
     }
     } catch (Exception ex) {
     ex.printStackTrace();
     closeConnection(con);
     throw new DBException(ex);
     }

     }*/
    public static int getRecentWedstrijdNr() throws DBException {
        Connection con = null;
        try {
            con = getConnection();
            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);

            String sql = "SELECT MAX(wedstrijdnr) AS wedstrijdnr " + " FROM wedstrijd ";

            ResultSet srs = stmt.executeQuery(sql);

            int wnrfinal = 0;
            while (srs.next()) {
                wnrfinal = srs.getInt("wedstrijdnr");
            }

            closeConnection(con);
            return wnrfinal;
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
            int gespeeld;
            int score_thuis;
            int score_uit;
            Scheidsrechter scheidsrechter;
            Speeldag speeldag;
            Team thuis;
            Team uit;

            if (srs.next()) {
                c = getCompetitie(srs.getString("competitienaam"));
                jaar = srs.getInt("jaar");
                arena = srs.getString("arena");
                datum = srs.getString("datum");
                gespeeld = srs.getInt("gespeeld");
                score_thuis = srs.getInt("score_thuis");
                score_uit = srs.getInt("score_uit");
                scheidsrechter = getScheids(srs.getInt("lidnr_scheidsrechter"));
                speeldag = getSpeeldag(srs.getString("competitienaam"), srs.getInt("jaar"), srs.getInt("speeldagnr"));
                thuis = getTeam(srs.getInt("stamnr_thuis"));
                uit = getTeam(srs.getInt("stamnr_uit"));

            } else {
                closeConnection(con);
                return null;
            }
            Seizoen s = new Seizoen(c, jaar);
            Wedstrijd w = new Wedstrijd(wnr, s, thuis, uit, arena, score_thuis, score_uit, scheidsrechter, datum, speeldag, gespeeld);
            closeConnection(con);
            return w;
        } catch (Exception ex) {
            ex.printStackTrace();
            closeConnection(con);
            throw new DBException(ex);
        }
    }

    public static int getRecentLidnrTrainer() throws DBException {
        Connection con = null;
        try {
            con = getConnection();
            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);

            String sql = "SELECT MAX(lidnr) AS lidnr " + " FROM trainer ";

            ResultSet srs = stmt.executeQuery(sql);

            int lidnrfinal = 0;
            while (srs.next()) {
                lidnrfinal = srs.getInt("lidnr");
            }

            closeConnection(con);
            return lidnrfinal;
        } catch (Exception ex) {
            ex.printStackTrace();
            closeConnection(con);
            throw new DBException(ex);
        }
    }
//assist
    /*public static void printAssist(int lidnr) throws DBException {
     Connection con = null;
     try {
     con = getConnection();
     Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
     ResultSet.CONCUR_READ_ONLY);

     String sql = "SELECT highlightnr "
     + "FROM goal "
     + "WHERE lidnr_assist = " + lidnr;
     ResultSet srs = stmt.executeQuery(sql);

     ArrayList<Goal> goals = new ArrayList<>();
     while (srs.next()) {
     goals.add(getGoal(srs.getInt("highlightnr")));
     }

     closeConnection(con);
     for (Goal g : goals) {
     System.out.println(g.toStringAssist()); //naar waar is deze methode verzet?
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
     }*/

    /*public static void addAssist(Assist a) throws DBException {
     Connection con = null;
     try {
     con = getConnection();
     Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
     ResultSet.CONCUR_READ_ONLY);

     /*String sql = "SELECT assists "+
     "FROM speler "+
     "WHERE lidnr = " + a.getLidNr();
     ResultSet srs = stmt.executeQuery(sql);

     if (srs.next()) {//waarvoor dient next() methode???

     String sql = "UPDATE speler "+
     "SET assists = assists + 1 "+
     "WHERE lidnr = " + a.getLidNr();

     stmt.executeUpdate(sql);
     sql = "INSERT into assist "
     + "(minuut, lidnr, wedstrijdnr) "
     + "VALUES ('" + a.getMinuut() + "', '" + a.getLidNr() + "', '" + a.getWedstrijdNr() + "')";
     stmt.executeUpdate(sql);


     closeConnection(con);
     } catch (Exception ex) {
     ex.printStackTrace();
     closeConnection(con);
     throw new DBException(ex);
     }
     }*/
//goal
    public static void addGoal(Goal g) throws DBException {
        Connection con = null;
        try {
            con = getConnection();
            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);

            /*String sql = "UPDATE speler "
             + "SET goals = goals + 1 "
             + "WHERE lidnr = " + g.getLidNr();

             stmt.executeUpdate(sql);*/
            if (g.getAssistgever() != null) {
                String sql = "INSERT into goal "
                        + "(minuut, lidnr, wedstrijdnr, lidnr_assist) "
                        + "VALUES ('" + g.getMinuut() + "', '" + g.getSpeler().getLidnr() + "', '" + g.getWedstrijd().getWedstrijdNr() + "', '" + g.getAssistgever().getLidnr() + "')";
                stmt.executeUpdate(sql);

                closeConnection(con);
            }
            if (g.getAssistgever() == null) {
                String sql1 = "INSERT into goal "
                        + "(minuut, lidnr, wedstrijdnr) "
                        + "VALUES ('" + g.getMinuut() + "', '" + g.getSpeler().getLidnr() + "', '" + g.getWedstrijd().getWedstrijdNr() + "')";
                stmt.executeUpdate(sql1);

                closeConnection(con);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
            closeConnection(con);
            throw new DBException(ex);
        }
    }

    public static Goal getGoal(int highlightnr) throws DBException {
        Connection con = null;
        try {
            con = getConnection();
            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);

            String sql = "SELECT minuut, lidnr, wedstrijdnr, lidnr_assist "
                    + "FROM goal "
                    + "WHERE highlightnr = " + highlightnr;

            ResultSet srs = stmt.executeQuery(sql);

            int minuut;
            Speler speler;
            Wedstrijd wedstrijd;
            Speler assistgever;

            if (srs.next()) {
                minuut = srs.getInt("minuut");
                speler = getSpeler(srs.getInt("lidnr"));
                wedstrijd = getWedstrijd(srs.getInt("wedstrijdnr"));
                assistgever = getSpeler(srs.getInt("lidnr_assist"));

            } else {
                closeConnection(con);
                return null;
            }
            Goal g = new Goal(minuut, speler, wedstrijd, assistgever);

            closeConnection(con);
            return g;
        } catch (Exception ex) {
            ex.printStackTrace();
            closeConnection(con);
            throw new DBException(ex);
        }
    }

    public static void printGoals(int lidnr, String competitienaam, int jaar) throws DBException {
        Connection con = null;
        try {
            con = getConnection();
            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);

            String sql = "SELECT tabel.highlightnr "
                    + "FROM "
                    + "(SELECT goal.highlightnr, goal.wedstrijdnr, goal.lidnr, wedstrijd.competitienaam, wedstrijd.jaar "
                    + "FROM goal "
                    + "JOIN wedstrijd "
                    + "ON wedstrijd.wedstrijdnr = goal.wedstrijdnr) "
                    + "AS tabel "
                    + "WHERE tabel.lidnr = " + lidnr + " AND tabel.competitienaam = '" + competitienaam + "' AND tabel.jaar = " + jaar;

            ResultSet srs = stmt.executeQuery(sql);

            ArrayList<Goal> goals = new ArrayList<>();
            while (srs.next()) {
                goals.add(getGoal(srs.getInt("tabel.highlightnr")));
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

//owngoal
    public static void addOwngoal(Owngoal o) throws DBException {
        Connection con = null;
        try {
            con = getConnection();
            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);

            /*String sql = "SELECT owngoals "+
             "FROM speler "+
             "WHERE lidnr = " + o.getLidNr();
             ResultSet srs = stmt.executeQuery(sql);

             if (srs.next()) {//waarvoor dient next() methode???
             String sql = "UPDATE speler "
             + "SET owngoals = owngoals + 1 "
             + "WHERE lidnr = " + o.getLidNr();

             stmt.executeUpdate(sql);*/
            String sql = "INSERT into owngoal "
                    + "(minuut, lidnr, wedstrijdnr) "
                    + "VALUES ('" + o.getMinuut() + "', '" + o.getSpeler().getLidnr() + "', '" + o.getWedstrijd().getWedstrijdNr() + "')";
            stmt.executeUpdate(sql);

            closeConnection(con);
        } catch (Exception ex) {
            ex.printStackTrace();
            closeConnection(con);
            throw new DBException(ex);
        }
    }

//penalty
    public static void addPenalty(Penalty p) throws DBException {
        Connection con = null;
        try {
            con = getConnection();
            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);

            /*String sql = "SELECT penaltys "+
             "FROM speler "+
             "WHERE lidnr = " + p.getLidNr();
             ResultSet srs = stmt.executeQuery(sql);

             if (srs.next()) {//waarvoor dient next() methode???
             String sql = "UPDATE speler "
             + "SET penaltys = penaltys + 1 "
             + "WHERE lidnr = " + p.getLidNr();*/
            //stmt.executeUpdate(sql);
            String sql = "INSERT into penalty "
                    + "(minuut, gescoord, lidnr, wedstrijdnr) "
                    + "VALUES ('" + p.getMinuut() + "', '" + p.getGescoord() + "', '" + p.getSpeler().getLidnr() + "', '" + p.getWedstrijd().getWedstrijdNr() + "')";
            stmt.executeUpdate(sql);

            closeConnection(con);
        } catch (Exception ex) {
            ex.printStackTrace();
            closeConnection(con);
            throw new DBException(ex);
        }
    }

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
            Speler speler;
            Wedstrijd wedstrijd;
            int gescoord;

            if (srs.next()) {
                minuut = srs.getInt("minuut");
                speler = getSpeler(srs.getInt("lidnr"));
                wedstrijd = getWedstrijd(srs.getInt("wedstrijdnr"));
                gescoord = srs.getInt("gescoord");

            } else {
                closeConnection(con);
                return null;
            }
            Penalty p = new Penalty(minuut, speler, wedstrijd, gescoord);

            closeConnection(con);
            return p;
        } catch (Exception ex) {
            ex.printStackTrace();
            closeConnection(con);
            throw new DBException(ex);
        }
    }

    public static int getNumberOfPenaltys(int lidnr, String competitienaam, int jaar) throws DBException {
        Connection con = null;
        try {
            con = getConnection();
            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);

            String sql = "SELECT COUNT(*) AS penaltys "
                    + "FROM "
                    + "(SELECT penalty.lidnr, penalty.wedstrijdnr, wedstrijd.competitienaam, wedstrijd.jaar "
                    + "FROM penalty "
                    + "JOIN wedstrijd "
                    + "ON wedstrijd.wedstrijdnr = penalty.wedstrijdnr) "
                    + "AS tabel "
                    + "WHERE tabel.lidnr = " + lidnr + " AND tabel.competitienaam = '" + competitienaam + "' AND tabel.jaar = " + jaar;

            ResultSet srs = stmt.executeQuery(sql);

            int numberOfPenaltys = 0;

            while (srs.next()) {
                numberOfPenaltys = srs.getInt("penaltys");

            }

            closeConnection(con);
            return numberOfPenaltys;
        } catch (Exception ex) {
            ex.printStackTrace();
            closeConnection(con);
            throw new DBException(ex);
        }
    }

    public static void printPenaltys(int lidnr, String competitienaam, int jaar) throws DBException {
        Connection con = null;
        try {
            con = getConnection();
            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);

            String sql = "SELECT tabel.highlightnr "
                    + "FROM "
                    + "(SELECT penalty.highlightnr, penalty.wedstrijdnr, penalty.lidnr, wedstrijd.competitienaam, wedstrijd.jaar "
                    + "FROM penalty "
                    + "JOIN wedstrijd "
                    + "ON wedstrijd.wedstrijdnr = penalty.wedstrijdnr) "
                    + "AS tabel "
                    + "WHERE tabel.lidnr = " + lidnr + " AND tabel.competitienaam = '" + competitienaam + "' AND tabel.jaar = " + jaar;

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

//straf
    public static void addStraf(Straf s) throws DBException {
        Connection con = null;
        try {
            con = getConnection();
            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);

            /*String sql = "SELECT straffen "+
             "FROM speler "+
             "WHERE lidnr = " + s.getLidNr();
             ResultSet srs = stmt.executeQuery(sql);

             if (srs.next()) {//waarvoor dient next() methode???
             String sql = "UPDATE speler "
             + "SET straffen = straffen + 1 "
             + "WHERE lidnr = " + s.getLidNr();

             stmt.executeUpdate(sql);*/
            String sql = "INSERT into straf "
                    + "(minuut, reden, aantal_minuten, lidnr, wedstrijdnr) "
                    + "VALUES ('" + s.getMinuut() + "', '" + s.getReden() + "', '" + s.getAantalMinuten() + "', '" + s.getSpeler().getLidnr() + "', '" + s.getWedstrijd().getWedstrijdNr() + "')";
            stmt.executeUpdate(sql);

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
            int lidnrscheids;

            if (srs.next()) {
                lidnrscheids = srs.getInt("lidnr");
                voornaam = srs.getString("voornaam");
                achternaam = srs.getString("achternaam");
                geboortedatum = srs.getString("geboortedatum");

            } else {
                closeConnection(con);
                return null;
            }
            Scheidsrechter s = new Scheidsrechter(voornaam, achternaam, geboortedatum, lidnrscheids);
            closeConnection(con);
            return s;
        } catch (Exception ex) {
            ex.printStackTrace();
            closeConnection(con);
            throw new DBException(ex);
        }
    }

    public static Scheidsrechter getScheids1(Connection con, int lidnr) throws DBException {
        try {
            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);

            String sql = "SELECT * "
                    + "FROM scheidsrechter "
                    + "WHERE lidnr = " + lidnr;

            ResultSet srs = stmt.executeQuery(sql);

            String voornaam;
            String achternaam;
            String geboortedatum;
            int lidnrscheids;

            if (srs.next()) {
                lidnrscheids = srs.getInt("lidnr");
                voornaam = srs.getString("voornaam");
                achternaam = srs.getString("achternaam");
                geboortedatum = srs.getString("geboortedatum");

            } else {
                return null;
            }
            Scheidsrechter s = new Scheidsrechter(voornaam, achternaam, geboortedatum, lidnrscheids);
            return s;
        } catch (Exception ex) {
            ex.printStackTrace();
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
                    + "(voornaam, achternaam, geboortedatum, voorkeurpositie,  stamnr) "
                    + "VALUES ('" + s.getVoornaam() + "', '" + s.getAchternaam() + "', '"
                    + s.getGeboortedatum() + "', '" + s.getVoorkeurpositie() + "', '"
                    + s.getTeam().getStamNr() + "')";
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
            Team team;

            if (srs.next()) {
                voornaam = srs.getString("voornaam");
                achternaam = srs.getString("achternaam");
                geboortedatum = srs.getString("geboortedatum");
                voorkeurpositie = srs.getString("voorkeurpositie");
                team = getTeam(srs.getInt("stamnr"));

            } else {
                closeConnection(con);
                return null;
            }
            Speler s = new Speler(lidnr, voornaam, achternaam, geboortedatum, voorkeurpositie, team);
            closeConnection(con);
            return s;
        } catch (Exception ex) {
            ex.printStackTrace();
            closeConnection(con);
            throw new DBException(ex);
        }
    }

    public static Speler getSpeler1(Connection con, int lidnr) throws DBException {
        try {
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
            Team team;

            if (srs.next()) {
                voornaam = srs.getString("voornaam");
                achternaam = srs.getString("achternaam");
                geboortedatum = srs.getString("geboortedatum");
                voorkeurpositie = srs.getString("voorkeurpositie");
                team = getTeam(srs.getInt("stamnr"));

            } else {
                return null;
            }
            Speler s = new Speler(voornaam, achternaam, geboortedatum, voorkeurpositie, team);
            return s;
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new DBException(ex);
        }
    }

    public static void bewerkSpeler(Speler s) throws DBException {
        Connection con = null;
        try {
            con = getConnection();
            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);

            String sql = "UPDATE speler\n"
                    + "SET voorkeurpositie = '" + s.getVoorkeurpositie() + "', stamnr = " + s.getTeam().getStamNr() + "\n"
                    + "WHERE lidnr = " + s.getLidnr();
            stmt.executeUpdate(sql);

            closeConnection(con);
        } catch (Exception ex) {
            ex.printStackTrace();
            closeConnection(con);
            throw new DBException(ex);
        }
    }

    public static void printSpelerRanking(Competitie c, Seizoen s) throws DBException {
        Connection con = null;
        try {
            con = getConnection();
            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);

            String sql = "SELECT voornaam, achternaam,\n"
                    + "(\n"
                    + "SELECT COUNT(*)\n"
                    + "FROM \n"
                    + "(\n"
                    + "SELECT goal.lidnr, competitienaam, jaar\n"
                    + "FROM goal\n"
                    + "JOIN wedstrijd\n"
                    + "ON wedstrijd.wedstrijdnr = goal.wedstrijdnr\n"
                    + "JOIN speler\n"
                    + "ON goal.lidnr = speler.lidnr\n"
                    + "\n"
                    + ") AS tabel\n"
                    + "WHERE tabel.competitienaam = '" + c.getCompetitienaam() + "' AND tabel.jaar = " + s.getJaar() + " AND tabel1.lidnr = tabel.lidnr\n"
                    + ")\n"
                    + "AS goals\n"
                    + "\n"
                    + "FROM \n"
                    + "(SELECT speler.lidnr, speler.voornaam, speler.achternaam, deelname.competitienaam, deelname.jaar\n"
                    + "FROM speler\n"
                    + "JOIN team\n"
                    + "ON speler.stamnr = team.stamnr\n"
                    + "JOIN deelname\n"
                    + "ON team.stamnr = deelname.stamnr\n"
                    + "WHERE deelname.competitienaam = '" + c.getCompetitienaam() + "' AND deelname.jaar = " + s.getJaar() + "\n"
                    + ") AS tabel1\n"
                    + "\n"
                    + "GROUP BY lidnr\n"
                    + "ORDER BY goals DESC";

            ResultSet srs = stmt.executeQuery(sql);
            String voornaam = null;
            String achternaam = null;
            int goals = 0;

            while (srs.next()) {
                voornaam = srs.getString("voornaam");
                achternaam = srs.getString("achternaam");
                goals = srs.getInt("goals");
                System.out.println(voornaam + " " + achternaam + " " + goals);
            }

            closeConnection(con);

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

    public static void printSpelerRapport(Speler s, Competitie c, Seizoen seizoen) throws DBException {
        int lidnr = s.getLidnr();
        String competitienaam = c.getCompetitienaam();
        int jaar = seizoen.getJaar();
        if (getNumberOfPenaltys(lidnr, competitienaam, jaar) == 0) {
            printSpelerRapportBasic(lidnr, competitienaam, jaar);
        } else {
            printSpelerRapportBasic(lidnr, competitienaam, jaar);
            printGoals(lidnr, competitienaam, jaar);
            printPenaltys(lidnr, competitienaam, jaar);
        }
    }

    private static void printSpelerRapportBasic(int lidnr, String competitienaam, int jaar) throws DBException {
        Connection con = null;
        try {
            con = getConnection();
            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);

            String sql
                    = "SELECT voornaam, achternaam,\n"
                    + "(SELECT COUNT(*) "
                    + "FROM "
                    + "(SELECT goal.lidnr, goal.wedstrijdnr, wedstrijd.competitienaam, wedstrijd.jaar "
                    + "FROM goal "
                    + "JOIN wedstrijd "
                    + "ON wedstrijd.wedstrijdnr = goal.wedstrijdnr) "
                    + "AS tabel "
                    + "WHERE tabel.lidnr = " + lidnr + " AND tabel.competitienaam = '" + competitienaam + "' AND tabel.jaar = " + jaar + ")"
                    + "AS goals, "
                    + "(SELECT COUNT(DISTINCT tabel.wedstrijdnr)\n"
                    + "FROM \n"
                    + "(SELECT goal.lidnr, goal.wedstrijdnr, wedstrijd.competitienaam, wedstrijd.jaar\n"
                    + "FROM goal\n"
                    + "JOIN wedstrijd\n"
                    + "ON goal.wedstrijdnr = wedstrijd.wedstrijdnr\n"
                    + ")AS tabel\n"
                    + "WHERE tabel.lidnr = " + lidnr + " AND tabel.competitienaam = '" + competitienaam + "' AND tabel.jaar = " + jaar + "\n"
                    + ") AS 'wedstrijden gespeeld',"
                    + "(SELECT COUNT(*) "
                    + "FROM \n"
                    + "(SELECT goal.lidnr_assist, goal.wedstrijdnr, wedstrijd.competitienaam, wedstrijd.jaar "
                    + "FROM goal "
                    + "JOIN wedstrijd "
                    + "ON wedstrijd.wedstrijdnr = goal.wedstrijdnr) "
                    + "AS tabel "
                    + "WHERE tabel.lidnr_assist = " + lidnr + " AND tabel.competitienaam = '" + competitienaam + "' AND tabel.jaar = " + jaar + ")"
                    + "AS assists,"
                    + "(SELECT COUNT(*) "
                    + "FROM \n"
                    + "(SELECT penalty.lidnr, penalty.wedstrijdnr, wedstrijd.competitienaam, wedstrijd.jaar, penalty.gescoord "
                    + "FROM penalty \n"
                    + "JOIN wedstrijd \n"
                    + "ON wedstrijd.wedstrijdnr = penalty.wedstrijdnr) \n"
                    + "AS tabel \n"
                    + "WHERE tabel.lidnr = " + lidnr + " AND tabel.competitienaam = '" + competitienaam + "' AND tabel.jaar = " + jaar + " AND tabel.gescoord = 1)"
                    + "AS penaltysgescoord,"
                    + "(SELECT COUNT(*) "
                    + "FROM \n"
                    + "(SELECT owngoal.lidnr, owngoal.wedstrijdnr, wedstrijd.competitienaam, wedstrijd.jaar "
                    + "FROM owngoal \n"
                    + "JOIN wedstrijd \n"
                    + "ON wedstrijd.wedstrijdnr = owngoal.wedstrijdnr) \n"
                    + "AS tabel \n"
                    + "WHERE tabel.lidnr = " + lidnr + " AND tabel.competitienaam = '" + competitienaam + "' AND tabel.jaar = " + jaar + ")"
                    + "AS owngoals, "
                    + "(SELECT SUM(tabel.tijdstip_uit - tabel.tijdstip_in) "
                    + "FROM "
                    + "(SELECT opstelling.tijdstip_in, opstelling.tijdstip_uit, opstelling.lidnr, opstelling.wedstrijdnr, wedstrijd.competitienaam, wedstrijd.jaar "
                    + "FROM opstelling "
                    + "JOIN wedstrijd "
                    + "ON wedstrijd.wedstrijdnr = opstelling.wedstrijdnr) "
                    + "AS tabel "
                    + "WHERE tabel.lidnr = " + lidnr + " AND tabel.competitienaam = '" + competitienaam + "' AND tabel.jaar = " + jaar + ")"
                    + " AS speelminuten "
                    + "FROM speler \n"
                    + "WHERE speler.lidnr = " + lidnr;

            ResultSet srs = stmt.executeQuery(sql);

            String voornaam;
            String achternaam;
            int goals;
            int assists;
            int owngoals;
            int penaltys = getNumberOfPenaltys(lidnr, competitienaam, jaar);
            int penaltysgescoord;
            int speelminuten;
            int aantalwedstrijden;

            while (srs.next()) {
                voornaam = srs.getString("voornaam");
                achternaam = srs.getString("achternaam");
                goals = srs.getInt("goals");
                assists = srs.getInt("assists");
                owngoals = srs.getInt("owngoals");
                penaltysgescoord = srs.getInt("penaltysgescoord");
                speelminuten = srs.getInt("speelminuten");
                aantalwedstrijden = srs.getInt("wedstrijden gespeeld");

                String rapport;
                rapport = voornaam + " " + achternaam + "\n"
                        + "----------------------" + "\n"
                        + speelminuten + " minuten gespeeld in " + aantalwedstrijden + " wedstrijd(en)" + "\n"
                        + goals + " goal(s)" + "\n"
                        + owngoals + " owngoal(s)" + "\n"
                        + penaltys + " penalty(s), waarvan " + penaltysgescoord + " gescoord" + "\n"
                        + assists + " assist(s)";
                System.out.println(rapport);
            }

            closeConnection(con);
        } catch (Exception ex) {
            ex.printStackTrace();
            closeConnection(con);
            throw new DBException(ex);
        }
    }

    /*public String toStringSpelerRapport() { //gewoon spelersrapport voor alle spelers, ongeacht of speler penalty gezet heeft
     return super.getVoornaam() + " " + super.getAchternaam() + "\n"
     + "---------------------" + "\n"
     + "aantal doelpunten: " + goals + "\n"
     + "aantal assists: " + assists + "\n"
     + "aantal penalty's: " + penaltys + "\n"
     + "aantal speelminuten: " + speelminuten + "\n";*/
    /*public static int playedMinutesGame(int lidnr, int wedstrijdnr) {
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

     }*/
//trainer
    public static void addTrainer(Trainer s) throws DBException {
        Connection con = null;
        try {
            con = getConnection();
            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);

            String sql = "INSERT into trainer "
                    + "(voornaam, achternaam, geboortedatum) "
                    + "VALUES ('"
                    + s.getVoornaam() + "', '"
                    + s.getAchternaam() + "', '"
                    + s.getGeboortedatum() + "')";
            stmt.executeUpdate(sql);

            closeConnection(con);
        } catch (Exception ex) {
            ex.printStackTrace();
            closeConnection(con);
            throw new DBException(ex);
        }
    }

    public static Trainer getTrainer(int lidnr) throws DBException {
        Connection con = null;
        try {
            con = getConnection();
            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);

            String sql = "SELECT * "
                    + "FROM trainer "
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
            Trainer t = new Trainer(voornaam, achternaam, geboortedatum, lidnr);

            closeConnection(con);
            return t;
        } catch (Exception ex) {
            ex.printStackTrace();
            closeConnection(con);
            throw new DBException(ex);
        }
    }

    public static void bewerkTrainer(Team t) throws DBException {
        Connection con = null;
        try {
            con = getConnection();
            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);

            String sql = "UPDATE team\n"
                    + "SET lidnr_trainer = " + t.getTrainer().getLidnr() + "\n"
                    + "WHERE stamnr = " + t.getStamNr();
            stmt.executeUpdate(sql);

            closeConnection(con);
        } catch (Exception ex) {
            ex.printStackTrace();
            closeConnection(con);
            throw new DBException(ex);
        }
    }

//team
    public static void addTeam(Team t, Trainer tr) throws DBException {
        Connection con = null;
        try {
            con = getConnection();
            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);

            String sql = "INSERT into team "
                    + "(stamnr, naam, thuisarena, lidnr_trainer) "
                    + "VALUES ('" + t.getStamNr() + "', '" + t.getNaam() + "', '" + t.getThuisArena() + "', '" + tr.getLidnr() + "')";
            stmt.executeUpdate(sql);

            closeConnection(con);
        } catch (Exception ex) {
            ex.printStackTrace();
            closeConnection(con);
            throw new DBException(ex);
        }
    }

    public static void addDeelname(Team t, Competitie competitie, Seizoen seizoen) throws DBException {
        Connection con = null;
        try {
            con = getConnection();
            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);

            String sql2 = "INSERT into deelname "
                    + "(competitienaam,jaar, stamnr) "
                    + "VALUES ('" + competitie.getCompetitienaam() + "', '" + seizoen.getJaar() + "', '" + t.getStamNr() + "')";
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
            int lidnr_trainer;

            if (srs.next()) {
                naam = srs.getString("naam");
                thuisarena = srs.getString("thuisarena");
                lidnr_trainer = srs.getInt("lidnr_trainer");

            } else {
                closeConnection(con);
                return null;
            }
            Team t = new Team(stamnr, naam, thuisarena, getTrainer(lidnr_trainer));

            closeConnection(con);
            return t;
        } catch (Exception ex) {
            ex.printStackTrace();
            closeConnection(con);
            throw new DBException(ex);
        }
    }

    public static Team getTeam1(Connection con, int stamnr) throws DBException {
        try {
            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);

            String sql = "SELECT * "
                    + "FROM team "
                    + "WHERE stamnr = " + stamnr;

            ResultSet srs = stmt.executeQuery(sql);

            String naam;
            String thuisarena;
            int lidnr_trainer;

            if (srs.next()) {
                naam = srs.getString("naam");
                thuisarena = srs.getString("thuisarena");
                lidnr_trainer = srs.getInt("lidnr_trainer");

            } else {
                return null;
            }
            Team t = new Team(stamnr, naam, thuisarena, getTrainer(lidnr_trainer));

            return t;
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new DBException(ex);
        }
    }

    public static void printTeamRanking(Competitie c, Seizoen s) throws DBException {
        Connection con = null;
        try {
            con = getConnection();
            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);

            String sql
                    = "SELECT naam, \n"
                    + "(\n"
                    + "(SELECT 2*COUNT(*)\n"
                    + "FROM wedstrijd\n"
                    + "WHERE ((stamnr_uit = stamnr AND score_uit > score_thuis)\n"
                    + "OR (stamnr_thuis = stamnr AND score_thuis > score_uit)) AND wedstrijd.competitienaam = '" + c.getCompetitienaam()
                    + "' AND wedstrijd.jaar = " + s.getJaar() + "\n"
                    + ")\n"
                    + "+\n"
                    + "(SELECT COUNT(*)\n"
                    + "FROM wedstrijd\n"
                    + "WHERE score_thuis = score_uit AND (stamnr_thuis = stamnr OR stamnr_uit = stamnr) AND wedstrijd.competitienaam = '" + c.getCompetitienaam()
                    + "' AND wedstrijd.jaar = " + s.getJaar() + "\n"
                    + ")\n"
                    + ")\n"
                    + "AS punten\n"
                    + "FROM\n"
                    + "(\n"
                    + "SELECT team.stamnr, team.naam, deelname.competitienaam, deelname.jaar\n"
                    + "FROM team\n"
                    + "JOIN deelname\n"
                    + "ON team.stamnr = deelname.stamnr\n"
                    + ") AS tabel\n"
                    + "WHERE tabel.competitienaam = '" + c.getCompetitienaam() + "' AND tabel.jaar = " + s.getJaar() + "\n"
                    + "GROUP BY stamnr\n"
                    + "ORDER BY punten DESC";

            ResultSet srs = stmt.executeQuery(sql);
            String naam;
            int punten;

            while (srs.next()) {
                naam = srs.getString("naam");
                punten = srs.getInt("punten");

                System.out.println(naam + " - " + punten);
            }

            closeConnection(con);
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

    public static void printTeamRapport(Competitie c, Seizoen s, Team t) throws DBException {
        Connection con = null;
        try {
            con = getConnection();
            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);

            String sql = "SELECT\n"
                    + "(SELECT naam\n"
                    + "FROM team\n"
                    + "WHERE (stamnr = deelname.stamnr))\n"
                    + "AS naam,\n"
                    + "\n"
                    + "(SELECT COUNT(*)\n"
                    + "FROM wedstrijd\n"
                    + "WHERE (stamnr_uit=deelname.stamnr OR stamnr_thuis=deelname.stamnr) AND wedstrijd.competitienaam = deelname.competitienaam AND wedstrijd.jaar = deelname.jaar)\n"
                    + "AS gespeeld,\n"
                    + "\n"
                    + "(SELECT COUNT(*)\n"
                    + "FROM wedstrijd\n"
                    + "WHERE ((stamnr_uit = deelname.stamnr AND score_uit > score_thuis) OR (stamnr_thuis = deelname.stamnr AND score_thuis > score_uit)) AND wedstrijd.competitienaam = deelname.competitienaam AND wedstrijd.jaar = deelname.jaar)\n"
                    + "AS gewonnen,\n"
                    + "\n"
                    + "(SELECT COUNT(*)\n"
                    + "FROM wedstrijd\n"
                    + "WHERE ((stamnr_uit = deelname.stamnr AND score_uit < score_thuis) OR (stamnr_thuis = deelname.stamnr AND score_thuis < score_uit)) AND wedstrijd.competitienaam = deelname.competitienaam AND wedstrijd.jaar = deelname.jaar)\n"
                    + "AS verloren,\n"
                    + "\n"
                    + "(SELECT COUNT(*)\n"
                    + "FROM wedstrijd\n"
                    + "WHERE score_thuis = score_uit AND (stamnr_thuis = deelname.stamnr OR stamnr_uit = deelname.stamnr) AND wedstrijd.competitienaam = deelname.competitienaam AND wedstrijd.jaar = deelname.jaar)\n"
                    + "AS gelijk,\n"
                    + "\n"
                    + "(SELECT  \n"
                    + "\n"
                    + "(SELECT 2*COUNT(*)\n"
                    + "FROM wedstrijd\n"
                    + "WHERE (stamnr_uit = deelname.stamnr AND score_uit > score_thuis AND wedstrijd.competitienaam = deelname.competitienaam AND wedstrijd.jaar = deelname.jaar)\n"
                    + "OR (stamnr_thuis = deelname.stamnr AND score_thuis > score_uit))\n"
                    + "+\n"
                    + "(SELECT COUNT(*)\n"
                    + "FROM wedstrijd\n"
                    + "WHERE score_thuis = score_uit AND (stamnr_thuis = deelname.stamnr OR stamnr_uit = deelname.stamnr)) \n"
                    + ")\n"
                    + "AS punten,\n"
                    + "\n"
                    + "(SELECT  \n"
                    + "\n"
                    + "(SELECT SUM(score_uit)\n"
                    + "FROM wedstrijd\n"
                    + "WHERE (stamnr_uit = deelname.stamnr) AND wedstrijd.competitienaam = deelname.competitienaam AND wedstrijd.jaar = deelname.jaar)\n"
                    + "+\n"
                    + "(SELECT SUM(score_thuis)\n"
                    + "FROM wedstrijd\n"
                    + "WHERE (stamnr_thuis = deelname.stamnr) AND wedstrijd.competitienaam = deelname.competitienaam AND wedstrijd.jaar = deelname.jaar)\n"
                    + "-\n"
                    + "(SELECT SUM(score_thuis)\n"
                    + "FROM wedstrijd\n"
                    + "WHERE (stamnr_uit = deelname.stamnr) AND wedstrijd.competitienaam = deelname.competitienaam AND wedstrijd.jaar = deelname.jaar)\n"
                    + "-\n"
                    + "(SELECT SUM(score_uit)\n"
                    + "FROM wedstrijd\n"
                    + "WHERE (stamnr_thuis = deelname.stamnr) AND wedstrijd.competitienaam = deelname.competitienaam AND wedstrijd.jaar = deelname.jaar)\n"
                    + ")\n"
                    + "AS doelpuntensaldo,\n"
                    + "\n"
                    + "(SELECT  \n"
                    + "\n"
                    + "(SELECT SUM(score_uit)\n"
                    + "FROM wedstrijd\n"
                    + "WHERE stamnr_uit = deelname.stamnr AND wedstrijd.competitienaam = deelname.competitienaam AND wedstrijd.jaar = deelname.jaar)\n"
                    + "/\n"
                    + "(SELECT COUNT(*)\n"
                    + "FROM wedstrijd\n"
                    + "WHERE stamnr_uit = deelname.stamnr AND wedstrijd.competitienaam = deelname.competitienaam AND wedstrijd.jaar = deelname.jaar)\n"
                    + ") AS 'goals per uitgame',\n"
                    + "\n"
                    + "(SELECT  \n"
                    + "\n"
                    + "(SELECT SUM(score_thuis)\n"
                    + "FROM wedstrijd\n"
                    + "WHERE stamnr_thuis = deelname.stamnr AND wedstrijd.competitienaam = deelname.competitienaam AND wedstrijd.jaar = deelname.jaar)\n"
                    + "/\n"
                    + "(SELECT COUNT(*)\n"
                    + "FROM wedstrijd\n"
                    + "WHERE stamnr_thuis= deelname.stamnr AND wedstrijd.competitienaam = deelname.competitienaam AND wedstrijd.jaar = deelname.jaar)\n"
                    + ") AS 'goals per thuisgame',\n"
                    + "\n"
                    + "(SELECT  \n"
                    + "\n"
                    + "((SELECT SUM(score_thuis)\n"
                    + "FROM wedstrijd\n"
                    + "WHERE stamnr_thuis = deelname.stamnr AND wedstrijd.competitienaam = deelname.competitienaam AND wedstrijd.jaar = deelname.jaar)\n"
                    + "+\n"
                    + "(SELECT SUM(score_uit)\n"
                    + "FROM wedstrijd\n"
                    + "WHERE stamnr_uit= deelname.stamnr AND wedstrijd.competitienaam = deelname.competitienaam AND wedstrijd.jaar = deelname.jaar))\n"
                    + "/\n"
                    + "(SELECT COUNT(*)\n"
                    + "FROM wedstrijd\n"
                    + "WHERE stamnr_thuis= deelname.stamnr OR stamnr_uit=deelname.stamnr AND wedstrijd.competitienaam = deelname.competitienaam AND wedstrijd.jaar = deelname.jaar)\n"
                    + ") AS 'goals per game',\n"
                    + "\n"
                    + "(\n"
                    + "SELECT COUNT(*)\n"
                    + "FROM \n"
                    + "(\n"
                    + "SELECT penalty.wedstrijdnr, penalty.gescoord, wedstrijd.competitienaam, wedstrijd.jaar, speler.stamnr\n"
                    + "FROM penalty\n"
                    + "JOIN wedstrijd\n"
                    + "ON penalty.wedstrijdnr = wedstrijd.wedstrijdnr\n"
                    + "JOIN speler\n"
                    + "ON penalty.lidnr = speler.lidnr\n"
                    + ") AS tabel\n"
                    + "WHERE tabel.competitienaam = deelname.competitienaam AND tabel.jaar = deelname.jaar AND tabel.stamnr = deelname.stamnr\n"
                    + ") AS 'penaltys',\n"
                    + "\n"
                    + "(\n"
                    + "SELECT COUNT(*)\n"
                    + "FROM \n"
                    + "(\n"
                    + "SELECT penalty.wedstrijdnr, penalty.gescoord, wedstrijd.competitienaam, wedstrijd.jaar, speler.stamnr\n"
                    + "FROM penalty\n"
                    + "JOIN wedstrijd\n"
                    + "ON penalty.wedstrijdnr = wedstrijd.wedstrijdnr\n"
                    + "JOIN speler\n"
                    + "ON penalty.lidnr = speler.lidnr\n"
                    + ") AS tabel\n"
                    + "WHERE tabel.competitienaam = deelname.competitienaam AND tabel.jaar = deelname.jaar AND tabel.stamnr = deelname.stamnr AND tabel.gescoord = 1\n"
                    + ") AS 'penaltys gescoord'\n"
                    + "\n"
                    + "\n"
                    + "FROM deelname "
                    + "WHERE (stamnr = " + t.getStamNr()
                    + " AND competitienaam = '" + c.getCompetitienaam() + "' AND jaar = " + s.getJaar() + ")";

            ResultSet srs = stmt.executeQuery(sql);

            String naam;
            int punten;
            int gewonnen;
            int verloren;
            int gelijk;
            int gespeeld;
            int doelpuntensaldo;
            int goalsperuitgame;
            int goalsperthuisgame;
            int goalspergame;
            int penaltys;
            int penaltysgescoord;

            while (srs.next()) {
                naam = srs.getString("naam");
                punten = srs.getInt("punten");
                gewonnen = srs.getInt("gewonnen");
                verloren = srs.getInt("verloren");
                gelijk = srs.getInt("gelijk");
                gespeeld = srs.getInt("gespeeld");
                doelpuntensaldo = srs.getInt("doelpuntensaldo");
                goalsperuitgame = srs.getInt("goals per uitgame");
                goalsperthuisgame = srs.getInt("goals per thuisgame");
                goalspergame = srs.getInt("goals per game");
                penaltys = srs.getInt("penaltys");
                penaltysgescoord = srs.getInt("penaltys gescoord");

                String rapport;
                rapport = naam + "\n"
                        + "---------------------" + "\n"
                        + punten + " punten in " + gespeeld + " matchen (" + gewonnen + "/" + gelijk + "/" + verloren + ")" + "\n"
                        + "doelpuntensaldo: " + doelpuntensaldo + "\n"
                        + goalsperthuisgame + " goals per thuiswedstrijd\n"
                        + goalsperuitgame + " goals per uitwedstrijd\n"
                        + goalspergame + " goals per wedstrijd\n"
                        + penaltys + " penaltys gegeven\n"
                        + penaltysgescoord + " penaltys gescoord";
                System.out.println(rapport);
            }

            closeConnection(con);
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

//deelname
    public static Deelname getDeelname(Competitie c, Seizoen s, Team t) {

        Deelname d = new Deelname(c, s, t);
        return d;

    }

//opstelling
    public static Opstelling getOpstelling(int wedstrijdnr, int lidnr, int opstellingnr) throws DBException {
        Connection con = null;
        try {
            con = getConnection();
            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);

            String sql = "SELECT tijdstip_in, tijdstip_uit, positie, wedstrijdnr, lidnr "
                    + "FROM opstelling "
                    + "WHERE wedstrijdnr = " + wedstrijdnr + " AND lidnr = " + lidnr + " AND opstellingnr = " + opstellingnr;

            ResultSet srs = stmt.executeQuery(sql);

            int tijdstip_in;
            int tijdstip_uit;
            String positie;
            Wedstrijd wedstrijd;
            Speler speler;

            if (srs.next()) {
                tijdstip_in = srs.getInt("tijdstip_in");
                tijdstip_uit = srs.getInt("tijdstip_uit");
                positie = srs.getString("positie");
                speler = getSpeler(srs.getInt("lidnr"));
                wedstrijd = getWedstrijd(srs.getInt("wedstrijdnr"));

            } else {
                closeConnection(con);
                return null;
            }
            Opstelling opstelling = new Opstelling(wedstrijd, speler, positie, tijdstip_in, tijdstip_uit);

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
