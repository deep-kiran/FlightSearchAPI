package com.nagarro.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.nagarro.input.UserFlightData;
import com.nagarro.model.FlightData;
import com.nagarro.util.HibernateUtil;

/**
 * 
 * to perform insert , delete or get data from database of table FlightData
 *
 */
public class FlightDataDAO {
	Session session = HibernateUtil.getSessionFactory().openSession();

	public void saveFlightData(FlightData data) {
		session.beginTransaction();
		session.save(data);
		System.out.println("successfully stored the data");
		session.getTransaction().commit();
	}

	public void deleteFlightData(FlightData data) {
		session.delete(data);
		session.getTransaction().commit();
	}

	public FlightData getById(int id) {
		FlightData e = (FlightData) session.get(FlightData.class, id);
		return e;
	}

	public List<FlightData> searchFlights(UserFlightData inputData) throws HibernateException {
		Transaction tx = null;
		List<FlightData> results;
		System.out.println("i am in searchflights and i am going to use criteria ");
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			tx = session.beginTransaction();
			long tic = System.nanoTime();
			Criteria cr = session.createCriteria(FlightData.class);
			if (inputData.getOutputPref().equals("fare")) {
				cr.add(Restrictions.eq("arrLoc", inputData.getArrivalLoc()))
						.add(Restrictions.gt("validTill", inputData.getFlightDate()))
						.add(Restrictions.eq("seatavl", "Y")).add(Restrictions.eq("depLoc", inputData.getDepatureLoc()))
						.addOrder(Order.asc("fare"));
				results =cr.list();
			} else {
				cr.add(Restrictions.eq("arrLoc", inputData.getArrivalLoc()))
						.add(Restrictions.gt("validTill", inputData.getFlightDate()))
						.add(Restrictions.eq("seatavl", "Y")).add(Restrictions.eq("depLoc", inputData.getDepatureLoc()))
						.addOrder(Order.asc("fare")).addOrder(Order.asc("flightDur"));
				results = cr.list();
			}
			long toc = System.nanoTime();
			System.out.println("time elapsed is "+ (toc -tic));
			System.out.println("i am successfully filtered out");
			tx.commit();
			return results;
		} finally {
			session.close();
		}
	}

}
