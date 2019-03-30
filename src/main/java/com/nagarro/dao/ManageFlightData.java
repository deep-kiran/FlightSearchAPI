package com.nagarro.dao;

import java.util.List;

import com.nagarro.input.UserFlightData;
import com.nagarro.model.FlightData;

public class ManageFlightData {

	public static void insertFlightData(FlightData flightData) {
		System.out.println("in insertflightdata");
		FlightDataDAO dao = new FlightDataDAO();
		System.out.println("yaha bhi aagya");
		dao.saveFlightData(flightData);
	}

	public static List<FlightData> searchFlights(UserFlightData input) {
		System.out.println("in searchflights");
		FlightDataDAO dao = new FlightDataDAO();
		return dao.searchFlights(input);
	}

}
