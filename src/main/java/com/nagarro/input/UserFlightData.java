package com.nagarro.input;

import java.text.ParseException;
import java.util.Date;

import com.nagarro.util.DateUtils;

/**
 * 
 *
 * input class with getters and setters
 */
public class UserFlightData {

	public String depatureLoc;
	public String arrivalLoc;
	Date flightDate;
	public String flightClass;
	public String outputPref;

	public String getDepatureLoc() {
		return depatureLoc;
	}

	public void setDepatureLoc(String depatureLoc) {
		this.depatureLoc = depatureLoc;
	}

	public String getArrivalLoc() {
		return arrivalLoc;
	}

	public void setArrivalLoc(String arrivalLoc) {
		this.arrivalLoc = arrivalLoc;
	}

	public java.util.Date getFlightDate() {
		return flightDate;
	}

	public void setFlightDate(java.util.Date flightDate) {
		this.flightDate = flightDate;
	}

	public String getFlightClass() {
		return flightClass;
	}

	public void setFlightClass(String flightClass) {
		this.flightClass = flightClass;
	}

	public String getOutputPref() {
		return outputPref;
	}

	public void setOutputPref(String outputPref) {
		this.outputPref = outputPref;
	}

	public UserFlightData(String depLoc, String arrLoc, String date, String Fclass, String outputpref)
			throws ParseException {
		this.depatureLoc = depLoc.toUpperCase();
		this.arrivalLoc = arrLoc.toUpperCase();
		this.flightDate = DateUtils.stoDate(date);
		this.flightClass = Fclass.toUpperCase();
		this.outputPref = outputpref;
	}

}
