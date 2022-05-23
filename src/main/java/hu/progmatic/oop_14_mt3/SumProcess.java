package hu.progmatic.oop_14_mt3;

public class SumProcess implements Runnable {
    private final int[] numbers;
    private final int lowerBound;
    private final int upperBound;
    private int result;

    public SumProcess(int[] numbers, int lowerBound, int upperBound) {
        this.numbers = numbers;
        this.lowerBound = lowerBound;
        this.upperBound = upperBound;
    }

    @Override
    public void run() {
        for (int i = lowerBound; i < upperBound; i++) {
            result += numbers[i];
        }
    }

    public int getResult() {
        return result;
    }
}
