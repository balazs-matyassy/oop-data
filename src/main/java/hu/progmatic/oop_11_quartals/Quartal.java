package hu.progmatic.oop_11_quartals;

public class Quartal {
    private int income;
    private int expenditure;

    public Quartal() {
    }

    public Quartal(int income, int expenditure) {
        this.income = income;
        this.expenditure = expenditure;
    }

    public Quartal(String line) {
        String[] parts = line.split(" ");
        this.income = Integer.parseInt(parts[0]);
        this.expenditure = Integer.parseInt(parts[1]);
    }

    public int getIncome() {
        return income;
    }

    public void setIncome(int income) {
        this.income = income;
    }

    public int getExpenditure() {
        return expenditure;
    }

    public void setExpenditure(int expenditure) {
        this.expenditure = expenditure;
    }

    public int getProfit() {
        return income - expenditure;
    }

    @Override
    public String toString() {
        return "Quartal{" +
                "income=" + income +
                ", expenditure=" + expenditure +
                '}';
    }
}
