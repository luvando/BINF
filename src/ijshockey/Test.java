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
     // DriverManager dm = new DriverManager();
       // DriverManager.printTeamRanking(); //werkt
      //  DriverManager.printSpelerRanking(); //werkt
        //DriverManager.printTeamRapport(1); //werkt
        DriverManager.printSpelerRapport(3); //werkt
        
        
        //DriverManager.printSpelerRapport(2);
        /*Owngoal o = new Owngoal(2, 16, 2, 1);
        DriverManager.addOwngoal(o);
        
        Straf s = new Straf(2, 15, "heel stout geweest", 10, 2, 1);
        DriverManager.addStraf(s);
        Penalty p = new Penalty(1, 15, 2, 1, 0);
        DriverManager.addPenalty(p);*/
        
        //Goal g = new Goal(15, 2, 1, 3);
        //DriverManager.addGoal(g);
        

        
    }
}
