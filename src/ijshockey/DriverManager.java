/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ijshockey;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ekmaes
 */
public class DriverManager {

    private Connection databaseConnection;

    //private String databaseLocatie;
    /**
     * Creates a new instance of Database
     */
    public DriverManager() {
    }

    /*public void start() {
        loadDriver();
        connect();
    }

    private void loadDriver() {
        //TRY LOADING SUN DRIVER
        try {
            //LOAD SUN DRIVER
            Class.forName("com.mysql.jdbc.Driver");
        }//END try
        //DRIVER NOT FOUND, REPORT ERROR
        catch (ClassNotFoundException err) {
            System.out.println("Could not load driver ");
            System.exit(1);
        }//END catch
    }

    private void connect() {
     try {
     //CONNECT TO DATABASE
     String protocol = "jdbc";
     String subProtocol = "mysql";
     String subName = "//mysqlha2.ugent.be/BINFG11?user=BINFG11&password=4v3yfrzt";

     //DB, JAN en RARA vervangen
     String URL = protocol + ":" + subProtocol + ":" + subName;

     databaseConnection = java.sql.DriverManager.getConnection(URL);
     //return dbConnection;
     }//END try
     catch (SQLException error) {
     System.err.println("Error connecting to database: "
     + error.toString());
     }//END catch

     }//END connectDatabase()

     public Connection getDatabaseConnection() {
     return databaseConnection;
     }

     public void closeConnection() {
     try {
     //CLOSE CONNECTED
     databaseConnection.close();
     }//END try
     catch (SQLException error) {
     System.err.println("Cannot disconnect database");
     }//END catch

     }//END closeConnection()*/
    public void addCompetitie() {
        Competitie comp = new Competitie();

    }

    public void addSeizoen() {
    }

    public void addTeam() {
    }

    public void addTrainer() {
    }

    public void addSpeler(String voornaam, String achternaam, Date geboortedatum, String voorkeurspositie) { // hoe date ingeven in gui
        Speler nieuweSpeler = new Speler(voornaam, achternaam, geboortedatum, voorkeurspositie);//aangepast door jorn 23/11
    }
    
    
    
    
    

    public static Opstelling getOpstelling(int wedstrijdnr, int lidnr, int opstellingnr) throws DBException {
        Connection con = null;
        try {
            con = getConnection();
            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);

            String sql = "SELECT tijdstip_in, tijdstip_uit, positie"
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

            String sql = "SELECT wedstrijdnr, lidnr, opstellingnr"
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

            String sql = "SELECT wedstrijdnr, lidnr, opstellingnr"
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

    public int playedMinutesGame(int lidnr, int wedstrijdnr) {
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

    public int playedMinutesSeason(int lidnr) {
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
