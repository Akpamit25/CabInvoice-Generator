package com.capgemini.CabInvoice;

import org.junit.Assert;
import org.junit.Test;

public class CabInvoiceTest {

	@Test
	public void givenDistanceAndTime_ShouldReturnCorrectTotalFare() {
		CabInvoice invoiceService = new CabInvoice();
		double fare = invoiceService.calculateFare(2.0, 5);
		Assert.assertEquals(25, fare, 0.0);
	}

	@Test
	public void givenMinDistanceAndTime_ShouldReturnCorrectTotalFare() {
		CabInvoice invoiceService = new CabInvoice();
		double fare = invoiceService.calculateFare(0.5, 3);
		Assert.assertEquals(8, fare, 0.0);
	}
}
