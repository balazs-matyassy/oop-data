package hu.progmatic.oop_04_travel;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Travel> travels = new ArrayList<>();

        String data;

        System.out.println("Kérem az utazások adatait, ha végeztél, akkor írjál egy üres sort.");

        do {
            data = scanner.nextLine();
        } while (!data.isBlank());

        System.out.println("A megadott utazások adatai:");

        for (Travel travel : travels) {
            System.out.println(travel);
        }
    }
}
