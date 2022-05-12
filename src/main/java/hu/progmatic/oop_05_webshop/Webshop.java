package hu.progmatic.oop_05_webshop;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Webshop {
    private String name;
    private final Set<Product> products = new HashSet<>();
    private final List<Order> orders = new ArrayList<>();

    public Webshop() {
    }

    public Webshop(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void updateProduct(Product product) {
        /*if (products.contains(product)) {
            products.remove(product);
        }*/
        // remove akkor sem okoz hibát, ha nem töröl semmit
        products.remove(product);
        products.add(product);
    }

    public void deleteProduct(Product product) {
        products.remove(product);
    }

    public String getProductsReports() {
        StringBuilder builder = new StringBuilder();

        builder
                .append("******************\n").append(name).append("\n")
                .append("******************\n");

        for (Product product : products) {
            builder.append(product).append("\n");
        }

        return builder.toString();
    }

    public void newOrder(String address, Product product) {
        newOrder(address, product, 1);
    }

    public void newOrder(String address, Product product, int quantity) {
        orders.add(new Order(orders.size() + 1, product, quantity, address));
    }

    public Order[] listOrders() {
        return orders.toArray(new Order[0]);
    }

    public String getOrdersReport() {
        // Gyorsabbá teszi az alábbi műveletet:
        // String report = "...";
        // report += order + "\n";
        StringBuilder builder = new StringBuilder();

        builder
                .append("******************\n").append(name).append("\n")
                .append("******************\n");

        for (Order order : orders) {
            builder.append(order).append("\n");
        }

        return builder.toString();
    }
}
