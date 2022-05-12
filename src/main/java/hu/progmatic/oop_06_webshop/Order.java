package hu.progmatic.oop_06_webshop;

import java.time.LocalDate;
import java.util.Objects;

public class Order {
    private final int id;
    private Product product;
    private int quantity;
    private String address;

    private LocalDate date;

    public Order(int id) {
        this.id = id;
    }

    public Order(int id, Product product, int quantity, String address) {
        this.id = id;
        this.product = product;
        this.quantity = quantity;
        this.address = address;
        this.date = LocalDate.now();
    }

    public Order(int id, Product product, int quantity, String address, LocalDate date) {
        this.id = id;
        this.product = product;
        this.quantity = quantity;
        this.address = address;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPrice() {
        return product.getPrice() * quantity;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return id == order.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", product=" + product +
                ", quantity=" + quantity +
                ", address='" + address + '\'' +
                ", date=" + date +
                ", price=" + getPrice() +
                '}';
    }
}
