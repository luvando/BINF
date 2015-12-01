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
        DriverManager.printTeamRanking(); //werkt
        DriverManager.printSpelerRanking(); //werkt
        DriverManager.printTeamRapport(1); //werkt
        DriverManager.printSpelerRapport(3); //werkt

        DriverManager.printSpelerRapport(2);
        Owngoal o = new Owngoal(16, 2, 1);
        DriverManager.addOwngoal(o);

        Straf s = new Straf(15, "heel stout geweest", 10, 2, 1);
        DriverManager.addStraf(s);
        Penalty p = new Penalty(15, 2, 1, 0);
        DriverManager.addPenalty(p);

        Goal g = new Goal(15, 2, 1, 3);
        DriverManager.addGoal(g);

        Team t = DriverManager.getTeam(1);
        Team tt = DriverManager.getTeam(2);
        Scheidsrechter s2 = DriverManager.getScheids(1);
        Speeldag ss = DriverManager.getSpeeldag("National League", 2015, 1);
        Wedstrijd w = new Wedstrijd(t, tt, "Camp Nou", 5, 0, s2, "11/11/2015", ss);
        DriverManager.addWedstrijd(w);

    }
}
