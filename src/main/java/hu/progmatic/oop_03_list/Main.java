package hu.progmatic.oop_03_list;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        CrewMember[] crewMembers = {
                new CrewMember(1, "Kovács József", Role.ACTOR),
                new CrewMember(2, "Kiss István", Role.ACTOR),
                new CrewMember(3, "Nagy Anna", Role.DIRECTOR),
                new CrewMember(4, "Mekk Elek", Role.TECHNICIAN)
        };
        // java.util
        // List<T>, ArrayList<T>, LinkedList<T>
        // List<T>: interfész, leírja, hogy hogyan működik egy lista
        // ArrayList<T>, LinkedList<T>: implementációk
        //      viselkedésben nem nagyon van különbség, viszont bizonyos műveletek
        //      az egyik típusnál gyorsabban, más műveletek pedig a másiknál
        List<CrewMember> actors = new ArrayList<>();

        for (CrewMember crewMember : crewMembers) {
            if (crewMember.getRole() == Role.ACTOR) {
                actors.add(crewMember);
            }
        }

        // actors.set(0, null); actors[0] = null; -nak felelne meg (ha tömb lenne)
        // actors.remove(0); nincs megfelelője
        // System.out.println(actors.get(0)); Systems.out.println(actors[0]); -nak felelne meg
        // actors.clear();

        actors.add(2, new CrewMember(5, "Szép Elvira", Role.ACTOR));

        for (CrewMember actor : actors) {
            System.out.println(actor);
        }

        // általában nem érdemes használni,
        // pl. LinkedList esetében eléggé lassú,
        // mivel mindig a 0-ás indextől újra elkezdi bejárni a listát
        // n * n
        /* for (int i = 0; i < actors.size(); i++) {
            System.out.println(actors.get(i));
        } */

        // EQUALS (ebben az esetben csak equals) + HASHCODE!!!
        System.out.println(actors.contains(new CrewMember(5, "Kovács Elvira", null)));
        System.out.println(actors.indexOf(new CrewMember(5, "Kovács Elvira", null)));
    }
}
