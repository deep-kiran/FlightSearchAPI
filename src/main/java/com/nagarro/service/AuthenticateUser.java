package com.nagarro.service;

import com.nagarro.dao.ManageUserData;
import com.nagarro.model.UserData;

public class AuthenticateUser {

	/**
	 * 
	 * @param user
	 *            - user to be authenticated
	 * @return - true if used data matches in database
	 */
	public static boolean isValidUser(UserData inputvalue) {
		UserData userdata = ManageUserData.getUserData(inputvalue);
		System.out.println("inserting user");
		Boolean isValid = Boolean.FALSE;
		System.out.println("from input " +inputvalue.getUsername()+ " "+inputvalue.getPassword());
		System.out.println("from db "+ userdata.getUsername()+" "+userdata.getPassword());
		if (userdata != null && inputvalue.getUsername().equals(userdata.getUsername())
				&& inputvalue.getPassword().equals(userdata.getPassword())) {
			isValid = Boolean.TRUE;
			System.out.println("user is authenticated successfully too");
		}
		return isValid.booleanValue();
	}
}
