package hu.progmatic.oop_07_countries;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        // -----
        // 1. FELADAT
        // -----
        // 1. Kérjünk be szóközzel elválasztva ország - főváros párokat.
        // 2. Akkor fejezzük be a beolvasást, ha a felhasználó üres sort ad meg.
        // 3. Írjuk ki az adatbázis méretét.
        // 4. Kérjük be egy ország nevét, írjuk ki a fővárosát.
        Scanner scanner = new Scanner(System.in);
        Map<String, String> countries = new TreeMap<>();

        String line;

        do {
            System.out.println("Kérem a következő adatot.");
            line = scanner.nextLine();

            if (!line.isBlank()) {
                String[] parts = line.split(" ");
                countries.put(parts[0], parts[1]);
            }
        } while (!line.isBlank());

        System.out.println("Az adatbázis mérete: " + countries.size());

        System.out.println("Kérek egy országot.");
        String country = scanner.nextLine();

        System.out.println("A megadott ország fővárosa: " + countries.get(country));

        // -----
        // 2. FELADAT
        // -----
        // TÉNYLEGESEN ÉRDEMES LENNE A CITY OSZTÁLYBAN ELMENTENI AZ ORSZÁGOT.
        // NEM SZÉP EZT EGY KÜLÖN MAPBEN TÁROLNI, DE GYAKORLÁS SZEMPONTJÁBÓL JÓ.
        // -----
        // 1. Kérjünk be szóközzel elválasztva id - város - ország párokat.
        // 2. Akkor fejezzük be a beolvasást, ha a felhasználó üres sort ad meg.
        // 3. Írjuk ki az adatbázis méretét.
        // 4. Írjuk ki a különböző nevű városokat növekvő sorrendben.
        // 5. Hozzunk létre egy City osztályt, az osztály a név mellett tartalmazzon egy id mezőt is.
        // 6. Tároljuk el a beolvasott értékeket egy City -> String Map-be. (Amúgy nem ez a legszebb megoldás).
        // 7. Kérjünk be a felhasználótól egy id-t.
        // 8. Hozzunk létre egy egy üres (csak id-t tartalmazó, nevet nem tartalmazó City példányt).
        // 9. Az üres példány segítségével keressük meg a mapben a városhoz tartozó országot.
        Map<City, String> cities = new HashMap<>();
        Set<String> cityNames = new TreeSet<>();

        do {
            System.out.println("Kérem a következő adatot.");
            line = scanner.nextLine();

            if (!line.isBlank()) {
                String[] parts = line.split(" ");
                cityNames.add(parts[1]);
                // a kulcs egy összetett objektum
                // az equals és hashCode alapján lehet a Map-ben keresni
                cities.put(new City(Integer.parseInt(parts[0]), parts[1]), parts[2]);
            }
        } while (!line.isBlank());

        System.out.println("Adatbázis mérete: " + cities.size());

        System.out.println("Különböző városok:");

        for (String cityName : cityNames) {
            System.out.println(cityName);
        }

        System.out.println("Kérem az azonosítót.");
        int id = scanner.nextInt();
        City city = new City(id);

        System.out.println("A megadott városhoz tartozó ország: " + cities.get(city));
    }
}
