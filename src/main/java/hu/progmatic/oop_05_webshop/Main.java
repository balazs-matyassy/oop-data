package hu.progmatic.oop_05_webshop;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        /*
            Collection<T>
            https://docs.oracle.com/javase/8/docs/api/java/util/Collection.html
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
            https://docs.oracle.com/javase/8/docs/api/java/util/List.html
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
            https://docs.oracle.com/javase/8/docs/api/java/util/Set.html
            - az elemeknek nincsen egyértelmű indexe
            - nem lehetnek benne duplikátumok
            -------------------
            add(T) // equals + hashCode (nem lehet duplikátum)
            ha van a setben pl. egy Product(1, "abc", 1000) és hozzá szeretnénk adni egy új
            Product(1, "abc", 2000)-t, akkor nem történik semmi.
            Frissítés esetén először törölni kell a régi elemet.
            contains(T) // equals + hashCode
            clear()
            remove(Object o) // equals + hashCode
            int size()

            for (T element : list) {}
         */
        // Queue<T> (Collection<T>), Deque<T> (Collection<T>) -> szorgalmi
        // List<T> és Set<T>-hez képest ritkábban használt adatszerkezetek.
        // Bizonyos algoritmusokat lehet velük hatékonyan leprogramozni.
        // https://docs.oracle.com/javase/8/docs/api/java/util/Queue.html
        // https://docs.oracle.com/javase/8/docs/api/java/util/Deque.html
        Product product = new Product(1000, "Fából vaskarika", 5000);
        Product product2 = new Product(2000, "Nesze semmi fogd meg jól", 4000);
        Product product3 = new Product(3000, "Termék 3", 4000);
        Product product3_v2 = new Product(3000, "Termék 3", 5500);
        Product product4 = new Product(4000, "Termék 4", 4000);
        Product product5 = new Product(5000, "Termék 5", 4000);
        Product product6 = new Product(6000, "Termék 6", 4000);
        Webshop webshop = new Webshop("Legjobb Webshop");
        webshop.updateProduct(product);
        webshop.updateProduct(product);
        webshop.updateProduct(product2);
        webshop.updateProduct(product3);
        webshop.updateProduct(product3_v2); // frissül, mivel meghívjuk a remove-t
        webshop.updateProduct(product4);
        webshop.updateProduct(product4);
        webshop.updateProduct(product5);
        webshop.updateProduct(product6);
        webshop.newOrder("Nekeresd", product);
        webshop.newOrder("Budapest", product2);

        System.out.println(product.hashCode());
        System.out.println(product2.hashCode());

        System.out.println(webshop.getProductsReports());
        System.out.println(webshop.getOrdersReport());
    }
}
