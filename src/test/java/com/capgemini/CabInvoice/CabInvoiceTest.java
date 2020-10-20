package com.capgemini.CabInvoice;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CabInvoiceTest {
    CabInvoice invoiceService;

    @Before
    public void setUp() throws Exception {
        invoiceService = new CabInvoice();
    }

    @Test
    public void givenDistanceAndTime_ShouldReturnCorrectTotalFare() {
        double fare = invoiceService.calculateFare(2.0, 5);
        Assert.assertEquals(25, fare, 0.0);
    }

    @Test
    public void givenMinDistanceAndTime_ShouldReturnCorrectTotalFare() {
        double fare = invoiceService.calculateFare(0.5, 3);
        Assert.assertEquals(8, fare, 0.0);
    }

    @Test
    public void givenDistanceAndTimeForMultipleRides_ShouldReturnInvoiceSummary() {
        Ride[] ride = {
                new Ride(2.0, 5),
                new Ride(0.1, 1)};

        InvoiceSummary invoiceSummary = invoiceService.calculateFare(ride);
        InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(2, 30);
        Assert.assertEquals(expectedInvoiceSummary,invoiceSummary);
    }
}