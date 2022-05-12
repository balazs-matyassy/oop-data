package hu.progmatic.oop_06_webshop;

import java.util.Objects;

public class Product implements Comparable<Product> {
    private final String name;
    private int price;

    public Product(String name) {
        this.name = name;
    }

    public Product(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return name.equals(product.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "Product{" +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    @Override
    // 5.compareTo(3) -> 5 - 3
    // ha ez nagyobb, akkor +
    // ha egyenlő, akkor 0
    // ha kisebb, akkor -
    public int compareTo(Product o) {
        // Stringek esetében pl. "alma" < "banán"
        return name.compareTo(o.name);
    }
}
