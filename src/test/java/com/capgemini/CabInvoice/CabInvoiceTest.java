package com.capgemini.CabInvoice;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CabInvoiceTest {
    CabInvoice invoiceService;
    RideRepository rideRepository;

    @Before
    public void setUp() throws Exception {
        invoiceService = new CabInvoice();
        rideRepository = new RideRepository();
    }

    //uc1
    @Test
    public void givenDistanceAndTime_ShouldReturnCorrectTotalFare() {
        double fare = invoiceService.calculateFare(2.0, 5, RideCategory.NORMAL);
        Assert.assertEquals(25, fare, 0.0);
    }

    //uc2
    @Test
    public void givenMinDistanceAndTime_ShouldReturnCorrectTotalFare() {
        double fare = invoiceService.calculateFare(0.5, 3, RideCategory.NORMAL);
        Assert.assertEquals(8, fare, 0.0);
    }

    //uc3
    @Test
    public void givenDistanceAndTimeForMultipleRides_ShouldReturnInvoiceSummary() {
        Ride[] ride = {
                new Ride(2.0, 5, RideCategory.NORMAL),
                new Ride(0.1, 1, RideCategory.NORMAL)};

        InvoiceSummary invoiceSummary = invoiceService.calculateRide(ride);
        InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(2, 30);
        Assert.assertEquals(expectedInvoiceSummary, invoiceSummary);
    }

    //uc4
    @Test
    public void givenUserIdAndRides_ShouldReturnInvoiceSummary() {
        String userId = "plk@ggg.com";
        Ride[] ride = {
                new Ride(2.0, 5, RideCategory.NORMAL),
                new Ride(0.1, 1, RideCategory.NORMAL)};
        invoiceService.addRides(userId, ride);
        InvoiceSummary invoiceSummary = invoiceService.getInvoiceSummary(userId);
        InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(2, 30);
        Assert.assertEquals(expectedInvoiceSummary, invoiceSummary);
    }

    //uc5
    @Test
    public void givenUserIdAndPremiumRides_ShouldReturnInvoiceSummary() {
        String userId = "akp@ggg.com";
        Ride[] rides = {new Ride(2.0, 5, RideCategory.PREMIUM),
                new Ride(0.1, 1, RideCategory.PREMIUM),
        };
        invoiceService.addRides(userId, rides);
        InvoiceSummary summary = invoiceService.getInvoiceSummary(userId);
        InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(2, 60);
        Assert.assertEquals(expectedInvoiceSummary, summary);
    }

    //uc3 premium
    @Test
    public void givenDistanceAndTimeForMultipleRidesForPremium_ShouldReturnInvoiceSummary() {
        Ride[] ride = {
                new Ride(2.0, 5, RideCategory.PREMIUM),
                new Ride(0.1, 1, RideCategory.PREMIUM)};

        InvoiceSummary invoiceSummary = invoiceService.calculateRide(ride);
        InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(2, 60);
        Assert.assertEquals(expectedInvoiceSummary, invoiceSummary);
    }

    @Test
    public void givenUserIdAndNormalAndPremiumRides_ShouldReturnInvoiceSummary() {
        String userId = "akp@ggg.com";
        Ride[] rides = {new Ride(2.0, 5, RideCategory.NORMAL),
                new Ride(2.0, 5, RideCategory.PREMIUM),
        };
        invoiceService.addRides(userId, rides);
        InvoiceSummary summary = invoiceService.getInvoiceSummary(userId);
        InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(2, 65);
        Assert.assertEquals(expectedInvoiceSummary, summary);
    }
}