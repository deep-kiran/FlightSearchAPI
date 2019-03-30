package com.nagarro.dao;

import java.io.File;
import java.io.FileFilter;

public class ReadFlightDataFromCSV {

	/**
	 * look for files at given location ending with .csv
	 */
	public static File[] scanForFile(final String str) {
		File[] listofFiles = null;
		File file = new File(str);
		FileFilter filter = (File pathname) -> (pathname.isFile() && pathname.getName().endsWith(".csv"));
		// Tests whether or not the specified abstract pathname should be included in a
		// pathname list.
		listofFiles = file.listFiles(filter);
		return listofFiles;

	}

}