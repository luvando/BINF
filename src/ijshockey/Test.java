/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ijshockey;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Jasper
 */
public class Test {

    public static void main(String[] args) throws DBException {
        DriverManager dm = new DriverManager();
        DriverManager.printTeamRanking();
        DriverManager.printSpelerRanking();
        DriverManager.printTeamRapport(1);
        
    }
}
