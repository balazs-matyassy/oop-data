package hu.progmatic.oop_04_travel;

import java.util.Objects;

public class Travel {
    private final int id;
    private String cityFrom;
    private String cityTo;
    private int distance;
    private String vehicle;
    private int price;
    private double time;

    public Travel(int id) {
        this.id = id;
    }

    public Travel(int id, String cityFrom, String cityTo, int distance, String vehicle, int price, double time) {
        this.id = id;
        this.cityFrom = cityFrom;
        this.cityTo = cityTo;
        this.distance = distance;
        this.vehicle = vehicle;
        this.price = price;
        this.time = time;
    }

    public Travel(String csvLine) {
        String[] values = csvLine.split(";");
        this.id = Integer.parseInt(values[0]);
        this.cityFrom = values[1];
        this.cityTo = values[2];
        this.distance = Integer.parseInt(values[3]);
        this.vehicle = values[4];
        this.price = Integer.parseInt(values[5]);
        this.time = Double.parseDouble(values[6]);
    }

    public int getId() {
        return id;
    }

    public String getCityFrom() {
        return cityFrom;
    }

    public void setCityFrom(String cityFrom) {
        this.cityFrom = cityFrom;
    }

    public String getCityTo() {
        return cityTo;
    }

    public void setCityTo(String cityTo) {
        this.cityTo = cityTo;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public String getVehicle() {
        return vehicle;
    }

    public void setVehicle(String vehicle) {
        this.vehicle = vehicle;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public double getTime() {
        return time;
    }

    public void setTime(double time) {
        this.time = time;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Travel travel = (Travel) o;
        return id == travel.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Travel{" +
                "id=" + id +
                ", cityFrom='" + cityFrom + '\'' +
                ", cityTo='" + cityTo + '\'' +
                ", distance=" + distance +
                ", vehicle='" + vehicle + '\'' +
                ", price=" + price +
                ", time=" + time +
                '}';
    }
}
