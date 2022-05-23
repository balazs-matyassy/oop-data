package hu.progmatic.oop_14_mt2;

public class Main {
    public static void main(String[] args) {
        Thread counter1 = new Thread(new CounterProcess("counter1"));
        Thread counter2 = new Thread(new CounterProcess("counter2"));
        counter1.start();
        counter2.start();

        System.out.println("Várakozás");

        try {
            counter1.join(); // várakozás counter1 befejeződésére
            counter2.join(); // várakozás counter2 befejeződésére
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Vége");
    }
}
