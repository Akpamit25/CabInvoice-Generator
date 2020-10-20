package com.capgemini.CabInvoice;

public class CabInvoice {
    public int COST_PER_MIN = 1;
    public int COST_MIN = 5;
    public int COST_PER_KM = 10;
    RideRepository rideRepository;

    public void setValue(RideCategory rideCategory) {
        COST_PER_KM = rideCategory.minCostPerKM;
        COST_PER_MIN = rideCategory.costPerMin;
        COST_MIN = rideCategory.minimumFare;
    }

    public CabInvoice() {
        this.rideRepository = new RideRepository();
    }

    public double calculateFare(double distance, double time, RideCategory rideCategory) {
        setValue(rideCategory);
        double fare = distance * COST_PER_KM + time * COST_PER_MIN;
        return Math.max(fare, COST_MIN);
    }

    public InvoiceSummary calculateRide(Ride[] ride) {
        double totalFare = 0;
        for (Ride rides : ride)
            totalFare += this.calculateFare(rides.distance, rides.time, rides.rideCategory);
        return new InvoiceSummary(ride.length, (int) totalFare);
    }

    public void addRides(String userId, Ride[] ride) {
        rideRepository.addRide(userId, ride);
    }

    public InvoiceSummary getInvoiceSummary(String userId) {
        return this.calculateRide(rideRepository.getRides(userId));
    }
}
