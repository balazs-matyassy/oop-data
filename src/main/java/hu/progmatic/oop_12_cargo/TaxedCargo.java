package hu.progmatic.oop_12_cargo;

public class TaxedCargo extends Cargo {
    private int limit;
    private int taxRate;

    public TaxedCargo() {
    }

    public TaxedCargo(String date, String source, String destination, String type, int value) {
        super(date, source, destination, type, value);
    }

    public TaxedCargo(String line) {
        super(line);
    }

    public TaxedCargo(String date, String source, String destination, String type, int value, int limit, int tax) {
        super(date, source, destination, type, value);
        this.limit = limit;
        this.taxRate = tax;
    }

    public TaxedCargo(String line, int limit, int tax) {
        super(line);
        this.limit = limit;
        this.taxRate = tax;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public int getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(int taxRate) {
        this.taxRate = taxRate;
    }

    @Override
    public int getGrossValue() {
        if (getValue() <= limit) {
            return getValue();
        } else {
            return  limit + (getValue() - limit) * (100 + taxRate) / 100;
        }
    }
}
