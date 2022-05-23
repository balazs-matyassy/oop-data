package hu.progmatic.oop_16_dangers;

import java.util.Random;

public class CounterProcess implements Runnable {
    private final String name;

    public CounterProcess(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 25; i++) {
                // érték kiolvasása és írása között alszunk 10 ms-t
                Random random = new Random();
                int sleep = random.nextInt(1, 25);
                updateCounter(sleep);
                System.out.println(name + " - " + Main.getCounter());
                Thread.sleep(1000 - sleep);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // statikus metódusból csak 1 példány van
    // synchronized nem engedi, hogy több szál egyszerre használja a metódust,
    // amíg az egyik nem fejeződött be, addik blokkolja a többi szálat
    private synchronized static void updateCounter(int sleep) throws InterruptedException {
        int counter = Main.getCounter();
        Thread.sleep(sleep); // késleltetés miatt hibásan felülírják egymás eredményét
        Main.setCounter(counter + 1);
    }
}
