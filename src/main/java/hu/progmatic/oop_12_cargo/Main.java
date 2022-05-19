package hu.progmatic.oop_12_cargo;

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
    }
}
