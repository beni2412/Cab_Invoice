package com.capg.cab_Invoice;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CabInvoiceTest {
	CabInvoice cabInvoice;

	@Before
	public void initialze() {
		cabInvoice = new CabInvoice();
	}

	@Test
	public void givenDistAndTimeReturnTotalFare() {
		double dist = 2.0;
		int time = 5;
		double fare = cabInvoice.calculateFare(dist, time, "normal");
		Assert.assertEquals(25, fare, 0.0);
	}

	@Test
	public void givenDistAndTimeReturnMinFare() {
		double dist = 0.1;
		int time = 1;
		double fare = cabInvoice.calculateFare(dist, time, "normal");
		Assert.assertEquals(5, fare, 0.0);
	}

	@Test
	public void givenMultipleRidesReturnInvoiceSummary() {
		ArrayList<Ride> rides = new ArrayList<Ride>();
		rides.add(new Ride(5.0, 2, "normal"));
		rides.add(new Ride(0.1, 1, "normal"));

		InvoiceSummary summary = cabInvoice.calculateFare(rides);
		InvoiceSummary expectedSummay = new InvoiceSummary(2, 57);
		Assert.assertEquals(expectedSummay, summary);
	}

	@Test
	public void givenUserIdReturnShouldReturnInvoiceSummary() {
		String userId = "Person1";
		InvoiceService service = new InvoiceService();
		ArrayList<Ride> rides = new ArrayList<Ride>();
		rides.add(new Ride(5.0, 2, "normal"));
		rides.add(new Ride(0.1, 1, "normal"));
		service.addRide(userId, rides);
		ArrayList<Ride> result = service.getRides(userId);
		Assert.assertEquals(rides, result);
	}

	@Test
	public void givenUserIdShouldReturnInvoiceSummary_PremiumRideCategoryAdded() {
		ArrayList<Ride> rides = new ArrayList<Ride>();
		rides.add(new Ride(5.0, 2, "premium"));
		rides.add(new Ride(0.1, 1, "normal"));
		InvoiceSummary summary = cabInvoice.calculateFare(rides);
		InvoiceSummary expectedSummary = new InvoiceSummary(2, 84.0);
		Assert.assertEquals(expectedSummary, summary);
	}
}
