package hu.progmatic.oop_11_quartals;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // 1. Hozzunk létre egy Quartal osztályt.
        // 2. Az osztály rendelkezzen egy income és egy expenditure mezővel.
        // 3. Legyen egy számított profit mező (income - expenditure)
        // 4. Hozzuk létre a gettereket + settereket + toStringet
        // 5. Legyen 3 konstruktor:
        //      - default
        //      - income és expenditure
        //      - egy szóközzel elválasztott sort váró
        // 6. Olvassuk be a quartals.txt tartalmát és tároljuk el egy List<Quartal> adatstruktúrába.
        // 7. Írjuk ki az adatok számát.
        // 8. Határozzuk meg a legnagyobb nyereséget.
        // 9. Határozzuk meg a legnagyobb veszteséget.
        // 10. Hány veszteséges negyedév volt?
        // 11. Mennyi volt az összes bevétel?
        try {
            // 6. feladat
            List<Quartal> quartals = new ArrayList<>();

            try (BufferedReader reader = new BufferedReader(new FileReader("quartals.txt"))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    Quartal quartal = new Quartal(line);
                    quartals.add(quartal);
                }
            }

            // 7. feladat
            System.out.println("Az adatok száma: " + quartals.size());

            // 8. feladat
            int maxProfit = Integer.MIN_VALUE;

            for (Quartal quartal : quartals) {
                if (quartal.getProfit() > maxProfit) {
                    maxProfit = quartal.getProfit();
                }
            }

            System.out.println("Legnagyobb nyereség: " + maxProfit);

            // 9. feladat
            int minProfit = Integer.MAX_VALUE;

            for (Quartal quartal : quartals) {
                if (quartal.getProfit() < minProfit) {
                    minProfit = quartal.getProfit();
                }
            }

            System.out.println("Legnagyobb veszteség: " + minProfit);

            // 10. feladat
            int counter = 0;

            for (Quartal quartal : quartals) {
                if (quartal.getProfit() < 0) {
                    counter++;
                }
            }

            System.out.println("Veszteséges negyedévek száma: " + counter);

            // 11. feladat
            int totalIncome = 0;

            for (Quartal quartal : quartals) {
                totalIncome += quartal.getIncome();
            }

            System.out.println("Összes bevétel: " + totalIncome);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
