package com.twu.refactoring;

public class NumberCruncher {
    private final int[] numbers;

    public NumberCruncher(int... numbers) {
        this.numbers = numbers;
    }

    int countEven = -1;
    int CountOdd = -1;
    int countPositive = -1;
    int countNegative = -1;

    public int countEven() {
        if (countEven < 0) {
            countEven = 0;
            for (int number : numbers) {
                if (number % 2 == 0) countEven++;
            }
        }
        return countEven;
    }

    public int countOdd() {
        if (CountOdd < 0) {
            CountOdd = 0;
            for (int number : numbers) {
                if (number % 2 == 1) CountOdd++;
            }
        }
        return CountOdd;
    }

    public int countPositive() {
        if (countPositive < 0) {
            countPositive = 0;
            for (int number : numbers) {
                if (number >= 0) countPositive++;
            }
        }
        return countPositive;
    }

    public int countNegative() {
        if (countNegative < 0) {
            countNegative = 0;
            for (int number : numbers) {
                if (number < 0) countNegative++;
            }
        }
        return countNegative;
    }
}
