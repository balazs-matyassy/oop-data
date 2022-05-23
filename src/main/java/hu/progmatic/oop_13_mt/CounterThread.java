package hu.progmatic.oop_13_mt;

public class CounterThread extends Thread {
    private final String name;

    public CounterThread(String name) {
        this.name = name;
    }

    // "main" metódus
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
