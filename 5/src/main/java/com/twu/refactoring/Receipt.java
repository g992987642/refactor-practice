package com.twu.refactoring;

public class Receipt {
    private static final int FIXED_CHARGE = 50;
    private static final double PEAK_TIME_MULTIPLIER = 1.2;
    private static final double OFF_PEAK_MULTIPLIER = 1.0;
    private static final int RATE_CHANGE_DISTANCE = 10;
    private static final int PRE_RATE_CHANGE_NON_AC_RATE = 15;
    private static final int POST_RATE_CHANGE_NON_AC_RATE = 12;
    private static final int PRE_RATE_CHANGE_AC_RATE = 20;
    private static final int POST_RATE_CHANGE_AC_RATE = 17;
    private static final double SALES_TAX_RATE = 0.1;

    private final Taxi taxi;

    public Receipt(Taxi taxi) {
        this.taxi = taxi;
    }

    public double getTotalCost() {
        int totalKms = taxi.getTotalKms();
        double peakTimeMultiple = taxi.isPeakTime() ? PEAK_TIME_MULTIPLIER : OFF_PEAK_MULTIPLIER;
        boolean isAirConditioned = taxi.isAirConditioned();
        double milestonesPayment = getMilestonesPayment(totalKms, isAirConditioned, peakTimeMultiple);
        double totalCost = calculateTotalCost(FIXED_CHARGE, milestonesPayment, SALES_TAX_RATE);
        return totalCost;
    }

    public double getMilestonesPayment(int totalKms, boolean isAirConditioned, double peakTimeMultiple) {
        double milestonesPayment = 0;
        if (isAirConditioned) {
            milestonesPayment += Math.min(RATE_CHANGE_DISTANCE, totalKms) * PRE_RATE_CHANGE_AC_RATE * peakTimeMultiple;
            milestonesPayment += Math.max(0, totalKms - RATE_CHANGE_DISTANCE) * POST_RATE_CHANGE_AC_RATE * peakTimeMultiple;
        } else {
            milestonesPayment += Math.min(RATE_CHANGE_DISTANCE, totalKms) * PRE_RATE_CHANGE_NON_AC_RATE * peakTimeMultiple;
            milestonesPayment += Math.max(0, totalKms - RATE_CHANGE_DISTANCE) * POST_RATE_CHANGE_NON_AC_RATE * peakTimeMultiple;
        }
        return milestonesPayment;
    }

    public double calculateTotalCost(int fixedCharge, double milestonesPayment, double salesTaxRate) {
        return (fixedCharge + milestonesPayment) * (1 + salesTaxRate);
    }
}
