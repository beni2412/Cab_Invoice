package com.capg.cab_Invoice;

import java.util.ArrayList;

public class CabInvoice {

	public static final double MIN_COST_PER_KM_NORMAL = 10;
	public static final double COST_PER_TIME_NORMAL = 1;
	public static final double MIN_COST_PER_KM_PREMIUM = 15;
	public static final double COST_PER_TIME_PREMIUM = 2;
	public static final double MIN_FARE_PREMIUM = 20;
	public static final double MIN_FARE_NORMAL = 5;

	public double calculateFare(double distance, int time, String type) {
		double totalFare=0;
		if (type.equalsIgnoreCase("normal")) {
			totalFare = distance * MIN_COST_PER_KM_NORMAL + time * COST_PER_TIME_NORMAL;
			totalFare = Math.max(totalFare, MIN_FARE_NORMAL);
		} else if (type.equalsIgnoreCase("premium")) {
			totalFare = distance * MIN_COST_PER_KM_PREMIUM + time * COST_PER_TIME_PREMIUM;
			totalFare= Math.max(totalFare, MIN_FARE_PREMIUM);
		}
		return totalFare;
	}

	public InvoiceSummary calculateFare(ArrayList<Ride> rides) {
		double totalFare = 0.0;
		for (Ride ride : rides) {
			if(ride.type.equalsIgnoreCase("premium")) {
				totalFare += calculateFare(ride.distance, ride.time, "premium");
			}else if(ride.type.equalsIgnoreCase("normal")) {
				totalFare += calculateFare(ride.distance, ride.time, "normal");
			}
			
		}
		return new InvoiceSummary(rides.size(), totalFare);
	}
}
