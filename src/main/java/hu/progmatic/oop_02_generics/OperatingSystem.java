package hu.progmatic.oop_02_generics;

import java.util.Objects;

public class OperatingSystem {
    private final int id;
    private String name;

    public OperatingSystem(int id) {
        this.id = id;
    }

    public OperatingSystem(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OperatingSystem operatingSystem = (OperatingSystem) o;
        return id == operatingSystem.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Document{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
