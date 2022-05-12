package hu.progmatic.oop_05_webshop;

import java.util.ArrayList;
import java.util.List;

public class Webshop {
    private String name;
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
