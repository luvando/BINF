/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ijshockey;

import GUIPackage.Startscherm;

/**
 *
 * @author jornnys
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws DBException {
        //commentaar test push/pull fase 2
        DriverManager dm = new DriverManager();
        dm.getConnection();
         GUIPackage.Startscherm start = new GUIPackage.Startscherm(dm);
  start.setVisible(true); 
    }
    
}
