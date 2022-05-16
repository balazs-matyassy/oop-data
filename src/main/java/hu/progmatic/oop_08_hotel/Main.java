package hu.progmatic.oop_08_hotel;

public class Main {
    public static void main(String[] args) {
        // 1. Hozzunk létre egy Booking osztályt
        //  id, date (LocalDate, String), citizenship, numberOfGuests, numberOfNights, price
        // 2. Az osztály rendelkezzen 3 konstruktorral
        //  - csak id-t beállító
        //  - minden mezőt beállító
        //  - minden mezőt egy szóközökkel elválasztott értékeket tartalmazó sorból beállító
        // 3. getterek + setterek, equals + hashCode, Comparable<Booking>
        // 4. Kérjünk be a felhasználótól a foglalások adatait,
        // a megadott adatok alapján példányosítsuk a foglalást.
        // 5. Tároljuk el az adatokat egy TreeSet-be (rendezett!), ha újra megadjuk egy létező foglalás adatait,
        // akkor írjuk felül a régit.
        // 6. Tároljuk el az adatokat egy Listbe (napló). Ebben a hibás verziók is szerepeljenek.
        // 7. Írjuk ki a javítások számát (napló mérete - adatbázis mérete).
        // 8. Írjuk ki állampolgárságonként csoportosítva a vendégek számát.
    }
}
