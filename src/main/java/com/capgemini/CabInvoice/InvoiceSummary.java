package com.capgemini.CabInvoice;

import java.util.Objects;

public class InvoiceSummary {
	public int totalFare;
	public int noOfRides;
	public double average;

	public InvoiceSummary(int noOfRides, int totalFare) {
		this.noOfRides = noOfRides;
		this.totalFare = totalFare;
		this.average = this.totalFare / this.noOfRides;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		InvoiceSummary that = (InvoiceSummary) o;
		return totalFare == that.totalFare && noOfRides == that.noOfRides && Double.compare(that.average, average) == 0;
	}
}//
