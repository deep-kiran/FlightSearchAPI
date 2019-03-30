package com.nagarro.model;

import java.math.RoundingMode;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

import com.nagarro.util.DateUtils;
import com.nagarro.util.DecimalUtil;

/**
 * 
 * 
 * Class to create flightdata table in MySQL using hibernate
 *
 */
public class FlightData {
	private int id;
	private String flightNo;
	private String depLoc; 
	private String arrLoc;	 
	private Date validTill;	 
	private String flightTime;
	private double flightDur;
	private double fare;
	private String seatavl;
	private String flightClass;

	FlightData() {

	}

	public FlightData(String dataarr[]) throws ParseException {

		flightNo = dataarr[0];
		depLoc = dataarr[1];
		arrLoc = dataarr[2];
		validTill = DateUtils.stoDate(dataarr[3]);
		flightTime = dataarr[4];
		flightDur = DecimalUtil.convert(Double.parseDouble(dataarr[5]));
		fare = DecimalUtil.convert(Double.parseDouble(dataarr[6]));
		seatavl = dataarr[7];
		flightClass = dataarr[8];
		fare = updateFare(fare, flightClass);
	}

	/**
	 * 
	 * @param fare
	 * @param flightClass
	 * @return updated fare if class is "E" or "EB"
	 */
	public double updateFare(double fare, String flightClass) {
		DecimalFormat df = new DecimalFormat(".##");
		df.setRoundingMode(RoundingMode.DOWN);
		if (flightClass.contains("B")) {
			fare = fare * 1.4;
			fare = Double.parseDouble(df.format(fare));
		}
		return fare;

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFlightNo() {
		return flightNo;
	}

	public void setFlightNo(String flightNo) {
		this.flightNo = flightNo;
	}

	public String getDepLoc() {
		return depLoc;
	}

	public void setDepLoc(String depLoc) {
		this.depLoc = depLoc;
	}

	public String getArrLoc() {
		return arrLoc;
	}

	public void setArrLoc(String arrLoc) {
		this.arrLoc = arrLoc;
	}

	public java.util.Date getValidTill() {
		return validTill;
	}

	public void setValidTill(java.util.Date validTill) {
		this.validTill = validTill;
	}

	public String getFlightTime() {
		return flightTime;
	}

	public void setFlightTime(String flightTime) {
		this.flightTime = flightTime;
	}

	public double getFlightDur() {
		return flightDur;
	}

	public void setFlightDur(double flightDur) {
		this.flightDur = flightDur;
	}

	public double getFare() {
		return fare;
	}

	public void setFare(double fare) {
		this.fare = fare;
	}

	public String getSeatavl() {
		return seatavl;
	}

	public void setSeatavl(String seatavl) {
		this.seatavl = seatavl;
	}

	public String getFlightClass() {
		return flightClass;
	}

	public void setFlightClass(String flightClass) {
		this.flightClass = flightClass;
	}

	@Override
	public String toString() {
		return "FlightData [id=" + id + ", flightNo=" + flightNo + ", depLoc=" + depLoc + ", arrLoc=" + arrLoc
				+ ", validTill=" + validTill + ", flightTime=" + flightTime + ", flightDur=" + flightDur + ", fare="
				+ fare + ", seatavl=" + seatavl + ", flightClass=" + flightClass + "]";
	}

}
