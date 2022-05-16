package hu.progmatic.oop_08_hotel;

import java.awt.print.Book;
import java.time.LocalDate;
import java.util.*;
import java.util.Map.Entry;

public class Main {
    public static void main(String[] args) {
        // 1. Hozzunk létre egy Booking osztályt
        //  id, date (LocalDate, String), citizenship, numberOfGuests, numberOfNights, price
        // 2. Az osztály rendelkezzen 3 konstruktorral
        //  - csak id-t beállító
        //  - minden mezőt beállító
        //  - minden mezőt egy szóközökkel elválasztott értékeket tartalmazó sorból beállító
        // 3. getterek + setterek, equals + hashCode, Comparable<Booking>
        // 4. Kérjük be a felhasználótól a foglalások adatait,
        // a megadott adatok alapján példányosítsuk a foglalásokat.
        // 5. Tároljuk el az adatokat egy TreeSet-be (rendezett!), ha újra megadjuk egy létező foglalás adatait,
        // akkor írjuk felül a régit.
        // 6. Tároljuk el az adatokat egy Listbe (napló). Ebben a hibás verziók is szerepeljenek.
        // 7. Írjuk ki a javítások számát (napló mérete - adatbázis mérete).
        // 8. Írjuk ki állampolgárságonként csoportosítva a vendégek számát.
        // + Buborék rendezéssel rendezzünk egy Booking[] tömböt.
        //  Használjuk a compareTo metódust.
        // 9. Ellenőrzést kapunk. A főnökünk megbíz minket, hogy töröljünk a historyból minden németekre vonatkozó adatot.

        System.out.println("A mai dátum: " + LocalDate.now());

        Scanner scanner = new Scanner(System.in);
        List<Booking> history = new ArrayList<>();
        Set<Booking> bookings = new TreeSet<>();
        String line;

        // 1-6. feladat
        do {
            System.out.println("Kérem a következő foglalás adatait.");
            line = scanner.nextLine();

            if (!line.isBlank()) {
                Booking booking = new Booking(line);
                history.add(booking);

                bookings.remove(booking);
                bookings.add(booking);
            }
        } while (!line.isBlank());

        // 7. feladat
        System.out.println("Javítások száma: " + (history.size() - bookings.size()));

        // 8. feladat
        Map<String, Integer> bookingsByCitizenship = new TreeMap<>();

        for (Booking booking : bookings) {
            String citizenship = booking.getCitizenship();

            // Java 7
            /*if (!bookingsByCitizenship.containsKey(citizenship)) {
                bookingsByCitizenship.put(citizenship, 0);
            }
            int total = bookingsByCitizenship.get(citizenship) + booking.getNumberOfGuests();*/

            // Java 8+
            int total = bookingsByCitizenship.getOrDefault(citizenship, 0) + booking.getNumberOfGuests();

            bookingsByCitizenship.put(citizenship, total);
        }

        // 1. kulcsok szerinti bejárás (összes állampolgárság bejárása)
        /* for (String citizenShip : bookingsByCitizenship.keySet()) {

        } */

        // 2. értékek szerinti bejárás (összes vendégek számának bejárása)
        // nem érdekel minket a kulcs, csak az értékeket szeretnénk feldolgozni
        /* for (int numberOfGuest : bookingsByCitizenship.values()) {

        } */

        // 3. kulcs-érték páronkénti bejárás
        for (Entry<String, Integer> entry : bookingsByCitizenship.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        // 9. feladat
        // 1. (rossz) megoldás
        /* for (Booking booking : history) {
            if (booking.getCitizenship().equals("DE")) {
                history.remove(booking); // többet is törölhet, ahol equals == true
                // https://docs.oracle.com/javase/7/docs/api/java/util/ConcurrentModificationException.html
                // Nem mindig keletkezik, de alapvetően hibás megközelítés a ciklusban törölni.
            }
        } */

        // kicsit olyan, mint a láncolt listák, csak a következő tud lépni
        Iterator<Booking> iterator = history.iterator();

        while (iterator.hasNext()) {
            Booking booking = iterator.next();

            if (booking.getCitizenship().equals("DE")) {
                iterator.remove(); // utolsó visszaadott értéket törli
            }
        }

        for (Booking booking : history) {
            System.out.println(booking);
        }
    }
}
