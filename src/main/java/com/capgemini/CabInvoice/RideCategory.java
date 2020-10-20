package com.capgemini.CabInvoice;

public enum RideCategory {

    PREMIUM(15, 2, 20), NORMAL(10, 1, 5);

    public int minCostPerKM, minimumFare;
    public int costPerMin;

    RideCategory(int minCostPerK, int cpt, int minimumFare) {
        this.minCostPerKM = minCostPerK;
        this.costPerMin = cpt;
        this.minimumFare = minimumFare;
    }
}