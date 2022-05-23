package hu.progmatic.oop_15_mt3;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int[] randomNumbers = generateRandomNumber(200000000);

        LocalDateTime now = LocalDateTime.now(); // aktuális idő
        System.out.println(now);

        long sum = 0;

        for (int randomNumber : randomNumbers) {
            sum += randomNumber;
        }

        System.out.println(sum);

        LocalDateTime now2 = LocalDateTime.now();
        System.out.println(now2);
        System.out.println(Duration.between(now, now2).toMillis());

        Thread[] threads = new Thread[10];
        SumProcess[] sumProcesses = new SumProcess[10];

        for (int i = 0; i < 10; i++) {
            sumProcesses[i] = new SumProcess(randomNumbers, i * 20000000, (i + 1) * 20000000);
            threads[i] = new Thread(sumProcesses[i]);
            threads[i].start();
        }

        try {
            for (int i = 0; i < 10; i++) {
                threads[i].join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        sum = 0;

        for (int i = 0; i < 10; i++) {
            sum += sumProcesses[i].getResult();
        }

        System.out.println(sum);

        LocalDateTime now3 = LocalDateTime.now();
        System.out.println(Duration.between(now2, now3).toMillis());


        System.out.println();
    }

    private static int[] generateRandomNumber(int size) {
        Random random = new Random();
        int[] randomNumbers = new int[size];

        for (int i = 0; i < size; i++) {
            randomNumbers[i] = random.nextInt(0, 100);
        }

        return randomNumbers;
    }
}
