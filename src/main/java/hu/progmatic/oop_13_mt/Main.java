package hu.progmatic.oop_13_mt;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Scanner scanner = new Scanner(System.in); // nem szép megoldás

        CounterThread counter1 = new CounterThread("counter1");
        CounterThread counter2 = new CounterThread("counter2");
        counter1.start(); // a szál run() metódusát egy külön szálban indítja el
        // ha közvetlenül a run()-t hívnánk meg, akkor nem indulna el új szál
        counter2.start();

        // counter1.run(); // blokkolódik
        // counter2.run(); // blokkolódik

        System.out.println("Várakozás");

        try {
            counter1.join(); // várakozás counter1 befejeződésére
            counter2.join(); // várakozás counter2 befejeződésére
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Kiegészítő anyagok:
        // eseményre várakozás:
        // Object.wait
        // Object.notify

        // fork-join framework
        // concurrent (pl. Lock...)
        // stream (Java 8+)

        System.out.println("Vége");

        // scanner.nextLine();
    }
}
