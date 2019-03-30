package com.nagarro.util;

public class DecimalUtil {
	public static double convert(double value) {
		return Math.floor(value * 100) / 100;
	}

}
