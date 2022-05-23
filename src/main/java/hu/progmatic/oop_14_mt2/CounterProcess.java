package hu.progmatic.oop_14_mt2;

// Runnable egy sokkal könnyebb megvalósítás, mint a Thread.
// Ez csak annyit definiál, hogy mi fusson külön szálon.
// counter.run() NEM indít új szálat
public class CounterProcess implements Runnable {
    private final String name;

    public CounterProcess(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        try {
            for (int i = 1; i <= 10; i++) {
                System.out.println(name + " - " + i);
                Thread.sleep(1000); // időnként megfelelő megoldás
                // fix idejű várakozáshoz ok
                // ha valamire várunk (pl. elérhető adat) nem ok
            }

            System.out.println(name + " - vége");
        } catch (InterruptedException e) {
            // Thread.sleep sokáig várakozik
            // lehetőség van kívülről megszakítani ("felébreszteni") a várakozást
            System.out.println("Várakozás megszakítva rendszer által.");
        }
    }
}
