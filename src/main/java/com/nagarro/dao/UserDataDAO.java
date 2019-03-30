package com.nagarro.dao;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.nagarro.model.UserData;
import com.nagarro.util.HibernateUtil;

/**
 * 
 *
 * to perform insert ,delete and get operations on UserData
 */
public class UserDataDAO {
	public void saveUserData(UserData user) {
		Session sess = HibernateUtil.getSessionFactory().openSession();
		sess.save(user);
	}
	
 public void deleteUserData(UserData user) {
		Session sess = HibernateUtil.getSessionFactory().openSession();
		sess.delete(user);
	}
	
	 /**
	 *
	 * @param username
	 * @return UserData object if username matches
	 */
	 public UserData getById(String username ) {
	 Session sess = HibernateUtil.getSessionFactory().openSession();
	 UserData e = (UserData) sess.get(UserData.class, username);
	 return e;
	 }

}
