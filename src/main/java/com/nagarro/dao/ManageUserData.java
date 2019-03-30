package com.nagarro.dao;

import com.nagarro.model.UserData;

/**
 * 
 * 
 * create database connection with help of dao layer
 * 
 *
 */
public class ManageUserData {
	/**
	 * inserts user into db
	 * @param user
	 */
	public static void insertUserData(UserData user) {
		UserDataDAO dao = new UserDataDAO();
		System.out.println("just before save");
		dao.saveUserData(user);
		System.out.println("just after save");

	}

	/**
	 * gets userdata object by primary key username
	 * 
	 * @param user
	 * @return UserData
	 */
	public static UserData getUserData(UserData user) {
		UserDataDAO dao = new UserDataDAO();
		System.out.println("just before getting user");
		UserData userdata = dao.getById(user.getUsername());
		System.out.println("user is got succesfulyy");
		return userdata;
	}
}
