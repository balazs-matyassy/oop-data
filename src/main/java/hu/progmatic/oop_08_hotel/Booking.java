package hu.progmatic.oop_08_hotel;

import java.time.LocalDate;
import java.util.Objects;

public class Booking implements Comparable<Booking> {
    private final int id;
    private LocalDate date;
    private String citizenship;
    private int numberOfGuests;
    private int numberOfNights;
    private int price;

    public Booking(int id) {
        this.id = id;
    }

    public Booking(int id, LocalDate date, String citizenship, int numberOfGuests, int numberOfNights, int price) {
        this.id = id;
        this.date = date;
        this.citizenship = citizenship;
        this.numberOfGuests = numberOfGuests;
        this.numberOfNights = numberOfNights;
        this.price = price;
    }

    public Booking(String line) {
        String[] parts = line.split(" ");
        this.id = Integer.parseInt(parts[0]);
        this.date = LocalDate.parse(parts[1]);
        this.citizenship = parts[2];
        this.numberOfGuests = Integer.parseInt(parts[3]);
        this.numberOfNights = Integer.parseInt(parts[4]);
        this.price = Integer.parseInt(parts[5]);
    }

    public int getId() {
        return id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getCitizenship() {
        return citizenship;
    }

    public void setCitizenship(String citizenship) {
        this.citizenship = citizenship;
    }

    public int getNumberOfGuests() {
        return numberOfGuests;
    }

    public void setNumberOfGuests(int numberOfGuests) {
        this.numberOfGuests = numberOfGuests;
    }

    public int getNumberOfNights() {
        return numberOfNights;
    }

    public void setNumberOfNights(int numberOfNights) {
        this.numberOfNights = numberOfNights;
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
        Booking booking = (Booking) o;
        return id == booking.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public int compareTo(Booking o) {
        return id - o.id;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "id=" + id +
                ", date=" + date +
                ", citizenship='" + citizenship + '\'' +
                ", numberOfGuests=" + numberOfGuests +
                ", numberOfNights=" + numberOfNights +
                ", price=" + price +
                '}';
    }
}
