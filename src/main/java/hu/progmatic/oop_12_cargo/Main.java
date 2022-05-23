package hu.progmatic.oop_12_cargo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        // 1. Hozzunk létre egy Cargo osztályt.
        // 2. Az osztály rendelkezzen date, source, destination, type, value mezőkkel.
        // 4. Hozzuk létre a gettereket + settereket + toStringet
        // 5. Legyen 3 konstruktor:
        //      - default
        //      - minden mezőt beállító
        //      - egy pontosveszzőkkel elválasztott sort váró (CSV)
        // 6. Olvassuk be a cargo.csv tartalmát és tároljuk el egy List<Cargo> adatstruktúrába.
        // 7. Írjuk ki az adatok számát.
        // 8. Határozzuk meg a legnagyobb értékű rakományt.
        // 9. Határozzuk meg a legkisebb értékű rakományt.
        // 10. Volt-e legalább 900 értékű Műszaki cikkek rakomány?
        // 11. Készítsünk bolygónkénti kimutatást az exportált rakományok értékéről.
        // 12. Készítsünk kategóriánkénti kimutatást a rakományok értékéről.
        // 13. Adjunk hozzá a Cargo osztályhoz egy getGrossValue számított értéket visszaadó gettert.
        // 14. Hozzunk létre egy TaxedCargo osztályt.
        //          Az osztálynak legyen egy százalékot és egy limitet tároló további mezője.
        //          Ha a nettó érték nagyobb a limitnél,
        //          akkor a bruttó érték legyen a limit és a limit feletti rész százalékkal növelt értékének az összege.
        // 15. Jelenleg csak a Műszaki cikkekre vetnek ki adót (200 galaktikus kredit fölött 10%)
        //      pl. nettó 200 -> bruttó 200
        //      pl. nettó 300 -> bruttó 210 (200 + (300 - 200) * 0.1)
        //      Hozzunk létre egy faktory metódust, amelyik egy sort kap paraméterként.
        //      Ha a szorban szerepel a Műszaki cikkek érték, akkor adjon vissza egy TaxedCargo osztályt,
        //      egyébként egy Cargo osztályt.
        // 16. Írjon ki a földről induló szállítmányok után fizetett összes adót.

        try {
            List<Cargo> cargos = new ArrayList<>();

            // 6. feladat
            // try-finally "testvére"
            try (BufferedReader reader = new BufferedReader(new FileReader("cargo.csv"))) {
                // Ha lenne fejléc:
                // reader.readLine(); // 1. sor kihagyása

                String line;
                while ((line = reader.readLine()) != null) {
                    // Cargo cargo = new Cargo(line);
                    // A factory elrejti a new operátort
                    Cargo cargo = CargoFactory.createCargo(line);
                    cargos.add(cargo);
                }
            }

            // itt már lezárásra került a fájl (felesleges tovább nyitva tartani)
            // 7. feladat
            System.out.println("Adatok száma: " + cargos.size());

            // 8. feladat
            System.out.println("Legnagyobb értékű rakomány: ");
            System.out.println(getMaxCargo(cargos));

            // 9. feladat
            System.out.println("Legkisebb értékű rakomány: ");
            System.out.println(getMinCargo(cargos));

            // 10. feladat
            boolean found = false;

            for (Cargo cargo : cargos) {
                if (cargo.getType().equals("Műszaki cikkek") && cargo.getValue() >= 900) {
                    found = true;
                    break; // spóroljunk a CPU-val
                }
            }

            if (found) {
                System.out.println("Volt legalább 900 értékű műszaki cikkek rakomány.");
            } else {
                System.out.println("Nem volt legalább 900 értékű műszaki cikkek rakomány.");
            }

            // 11. feladat
            Map<String, Integer> totalsByPlanet = new TreeMap<>();

            for (Cargo cargo : cargos) {
                // ha még nem volt bejegyzés, akkor 0 + új érték
                // ha volt bejegyzés, akkor régi érték + új érték
                int total = totalsByPlanet.getOrDefault(cargo.getSource(), 0)
                        + cargo.getValue();
                totalsByPlanet.put(cargo.getSource(), total);
            }

            // kulcsok szerinti bejárás
            for (String planet : totalsByPlanet.keySet()) {
                System.out.println(planet + ": " + totalsByPlanet.get(planet));
            }

            // 12. feladat
            Map<String, Integer> totalsByType = new TreeMap<>();

            for (Cargo cargo : cargos) {
                // ha még nem volt bejegyzés, akkor 0 + új érték
                // ha volt bejegyzés, akkor régi érték + új érték
                int total = totalsByType.getOrDefault(cargo.getType(), 0)
                        + cargo.getValue();
                totalsByType.put(cargo.getType(), total);
            }

            // kulcsok szerinti bejárás
            for (String type : totalsByType.keySet()) {
                System.out.println(type + ": " + totalsByType.get(type));
            }

            // 16. feladat
            int taxTotal = 0;

            for (Cargo cargo : cargos) {
                if (cargo.getSource().equals("Föld")) {
                    taxTotal += cargo.getTax();
                }
            }

            System.out.println("Az összes adó: " + taxTotal);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Cargo getMinCargo(List<Cargo> cargos) {
        Cargo minCargo = null;

        for (Cargo cargo : cargos) {
            // 1. iterációban vizsgálat nélkül felül kell írni az aktuális minimumot
            // short-circuit evaluation
            if (minCargo == null || cargo.getValue() < minCargo.getValue()) {
                minCargo = cargo;
            }
        }

        return minCargo;
    }

    private static Cargo getMaxCargo(List<Cargo> cargos) {
        Cargo maxCargo = null;

        for (Cargo cargo : cargos) {
            if (maxCargo == null || cargo.getValue() > maxCargo.getValue()) {
                maxCargo = cargo;
            }
        }

        return maxCargo;
    }
}
