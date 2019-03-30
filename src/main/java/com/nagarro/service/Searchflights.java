package com.nagarro.service;

import java.util.List;

import com.nagarro.dao.ManageFlightData;
import com.nagarro.input.UserFlightData;
import com.nagarro.model.FlightData;

/**
 * 
 * call the dao's layer search method
 *
 */
public class Searchflights {

	public static List<FlightData> searchValidFlights(UserFlightData input) {

		return ManageFlightData.searchFlights(input);
	}
}
