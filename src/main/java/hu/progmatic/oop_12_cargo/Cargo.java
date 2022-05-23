package hu.progmatic.oop_12_cargo;

public class Cargo {
    private String date;
    private String source;
    private String destination;
    private String type;
    private int value;

    public Cargo() {
    }

    public Cargo(String date, String source, String destination, String type, int value) {
        this.date = date;
        this.source = source;
        this.destination = destination;
        this.type = type;
        this.value = value;
    }

    public Cargo(String line) {
        String[] values = line.split(";");
        this.date = values[0];
        this.source = values[1];
        this.destination = values[2];
        this.type = values[3];
        this.value = Integer.parseInt(values[4]);
    }

    public final String getDate() {
        return date;
    }

    public final void setDate(String date) {
        this.date = date;
    }

    public final String getSource() {
        return source;
    }

    public final void setSource(String source) {
        this.source = source;
    }

    public final String getDestination() {
        return destination;
    }

    public final void setDestination(String destination) {
        this.destination = destination;
    }

    public final String getType() {
        return type;
    }

    public final void setType(String type) {
        this.type = type;
    }

    public final int getValue() {
        return value;
    }

    public final void setValue(int value) {
        this.value = value;
    }

    public int getGrossValue() {
        return value;
    }

    public final int getTax() {
        return getGrossValue() - getValue();
    }

    @Override
    public final String toString() {
        return "Cargo{" +
                "date='" + date + '\'' +
                ", source='" + source + '\'' +
                ", destination='" + destination + '\'' +
                ", type='" + type + '\'' +
                ", value=" + value +
                '}';
    }
}
