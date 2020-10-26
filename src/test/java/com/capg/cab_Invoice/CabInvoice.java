package com.capg.cab_Invoice;

import java.util.ArrayList;

public class CabInvoice {

	public static final double MIN_COST_PER_KM = 10.0;
	public static final int COST_PER_TIME = 1;
	public static final double MIN_FARE = 5.0;

	public double calculateFare(double distance, int time) {
		double totalFare = distance * MIN_COST_PER_KM + time * COST_PER_TIME;
		return Math.max(totalFare, MIN_FARE);
	}

	public InvoiceSummary calculateFare(ArrayList<Ride> rides) {
		double totalFare = 0.0;
		for (Ride ride : rides) {
			totalFare += calculateFare(ride.distance, ride.time);
		}
		return new InvoiceSummary(rides.size(), totalFare);
	}
}
