package hu.progmatic.oop_16_dangers;

public class Main {
    private static int counter = 0;

    public static void main(String[] args) {
        Thread[] threads = new Thread[3];

        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(new CounterProcess("p" + (i + 1)));
            threads[i].start();
        }

        try {
            for (Thread thread : threads) {
                thread.join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Vége");
    }

    public static int getCounter() {
        return counter;
    }

    public static void setCounter(int counter) {
        Main.counter = counter;
    }
}
