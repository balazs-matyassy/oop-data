package hu.progmatic.oop_12_cargo;

public class CargoFactory {
    // "kiszervezett konstruktor"
    // Egy külső metódus / osztály dönti el, hogy az adott sor hatására
    // Cargo vagy TaxedCargo példányt kell létrehozni
    public static Cargo createCargo(String line) {
        // A factory azt dönti el, hogy ki jöjjön létre,
        // a tényleges inicializáció továbbra is a konstruktor feladata.
        if (line.contains("Műszaki cikkek")) {
            return new TaxedCargo(line, 200, 10);
        } else {
            return new Cargo(line);
        }
    }
}
