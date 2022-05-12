package hu.progmatic.oop_05_webshop;

public class Main {
    public static void main(String[] args) {
        Product product = new Product(1, "Fából vaskarika", 5000);
        Product product2 = new Product(2, "Nesze semmi fogd meg jól", 4000);
        Webshop webshop = new Webshop("Legjobb Webshop");
        webshop.newOrder("Nekeresd", product);
        webshop.newOrder("Budapest", product2);

        System.out.println(webshop.getOrdersReport());
    }
}
