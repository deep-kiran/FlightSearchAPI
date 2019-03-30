package com.nagarro.dao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;

import com.nagarro.constants.FlightConstants;
import com.nagarro.model.FlightData;

/**
 * 
 *
 * utility class to read csv files and enter the data into database
 */
public class PopulateDatabase {

	static File listOfFiles[] = null;

	public static void populateFlightsData() throws IOException, ParseException {
		listOfFiles = ReadFlightDataFromCSV.scanForFile(FlightConstants.PATH);
		System.out.println(" folder ki length " + listOfFiles.length);

		for (File file : listOfFiles) {
			String arr[];

			BufferedReader br = new BufferedReader(new FileReader(file));
			String newLine;
			int iter = 0;
			while ((newLine = br.readLine()) != null) {
				if (iter == 0) {
					iter++;
					continue;
				}
				System.out.println(newLine);
				arr = newLine.split("\\|");
				FlightData flightData = new FlightData(arr);
				ManageFlightData.insertFlightData(flightData);

			}

			br.close();

		}

	}
}
