package com.capg.cab_Invoice;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CabInvoiceTest{
	CabInvoice cabInvoice;
	
	@Before
	public void initialze() {
		cabInvoice = new CabInvoice();
	}
	
	@Test
	public void givenDistAndTimeReturnTotalFare() {
		double dist = 2.0;
		int time =5;
		double fare = cabInvoice.calculateFare(dist, time);
		Assert.assertEquals(25, fare, 0.0);
	}
	
	@Test
	public void givenDistAndTimeReturnMinFare() {
		double dist = 0.1;
		int time =1;
		double fare = cabInvoice.calculateFare(dist, time);
		Assert.assertEquals(5, fare, 0.0);
	}
}
