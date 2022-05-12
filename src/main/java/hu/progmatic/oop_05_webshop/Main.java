package hu.progmatic.oop_05_webshop;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        /*
            Collection<T>
            - alapvető kollekció, a List<T> és a Set<T> közös "ősosztálya" (interfész)
            - be lehet járni for-each szerkezettel
            - Pl. egy termékeket kiíró jelentésnél teljesen mindegy, hogy halmazról vagy listáról van szó
            (Ha ez a paraméter, azzal azt mondjuk, hogy nem érdekel minket, hogy van-e duplikátum,
            valamint az sem érdekel minket, hogy van-e index.
            Ami nagyjából érdekel minket, az a gyűjteményszerű viselkedés (lehet új elemet hozzáadni, meglévő elemeket törölni)
            és be lehet járni for-each szerkezettel.)
            -------------------
            add(T) // equals + hashCode (nem lehet duplikátum)
            contains(T) // equals + hashCode
            clear()
            remove(Object o) // equals + hashCode
            int size()

            for (T element : list) {}
         */

        /*
            List<T> extends Collection<T>
            - minden elemnek van egyértelmű sorrendje (indexe)
            - lehetnek duplikátumok
            -------------------
            add(T)
            add(int index, T)
            contains(T) // equals + hashCode
            clear()
            T get(int index)
            int indexOf(T) // equals + hashCode
            remove(int index)
            remove(Object o) // equals + hashCode
            set(int index, T)
            int size()

            for (T element : list) {}
         */

        /*
            Set<T> extends Collection<T>
            - az elemeknek nincsen egyértelmű indexe
            - nem lehetnek benne duplikátumok
            -------------------
            add(T) // equals + hashCode (nem lehet duplikátum)
            contains(T) // equals + hashCode
            clear()
            remove(Object o) // equals + hashCode
            int size()

            for (T element : list) {}
         */
        // Queue<T> (Collection<T>), Deque<T> (Collection<T>) -> szorgalmi

        Collection<Product> products = new HashSet<>();

        for (Product product : products) {

        }


        Product product = new Product(1, "Fából vaskarika", 5000);
        Product product2 = new Product(2, "Nesze semmi fogd meg jól", 4000);
        Webshop webshop = new Webshop("Legjobb Webshop");
        webshop.newOrder("Nekeresd", product);
        webshop.newOrder("Budapest", product2);

        System.out.println(webshop.getOrdersReport());
    }
}
