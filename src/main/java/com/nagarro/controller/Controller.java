package com.nagarro.controller;

import java.io.IOException;

import java.text.ParseException;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.nagarro.dao.PopulateDatabase;
import com.nagarro.input.UserFlightData;
import com.nagarro.model.FlightData;
import com.nagarro.model.UserData;
import com.nagarro.service.AuthenticateUser;
import com.nagarro.service.Searchflights;

@org.springframework.stereotype.Controller
public class Controller {

	/**
	 * Simply selects the home view to render by returning its name.
	 * 
	 * @throws IOException
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) throws IOException {
		return "login";
	}

	/**
	 * 
	 * @param model
	 * @return jsp page to be rendered
	 * 
	 *         logout user and return to login page
	 */
	@RequestMapping(value = "/LogOut", method = RequestMethod.GET)
	public String logOut(Model model) {
		return "login";
	}

	/**
	 * 
	 * @param model
	 * @param request
	 * @return
	 * @throws IOException
	 * 
	 *             get parameters from jsp page and call search function to get
	 *             valid search results
	 * @throws ParseException
	 */
	@RequestMapping(value = "/search", method = RequestMethod.POST)
	public String findResult(Model model, HttpServletRequest request) throws IOException, ParseException {
		String departureLoc = request.getParameter("from");
		String arrivalLoc = request.getParameter("to");
		String flightDate = request.getParameter("date");
		String flightClass = request.getParameter("flightclass");
		String outputPref = request.getParameter("flightpref");
		System.out.println(" i have got the parameters ");
		System.out.println(departureLoc +" "+ arrivalLoc +""+flightDate +" " +flightClass +" "+outputPref);
		if (departureLoc != null && arrivalLoc != null && flightDate != null && flightClass != null
				&& outputPref != null) {
			UserFlightData input = new UserFlightData(departureLoc, arrivalLoc, flightDate, flightClass, outputPref);
			List<FlightData> searchresults = Searchflights.searchValidFlights(input);
			model.addAttribute("searchresults", searchresults);
		}
		return "results";
	}

	/**
	 * 
	 * @return
	 * 
	 * 		redirect to login page
	 */
	@RequestMapping(value = "/redirect", method = RequestMethod.POST)
	private String redirect() {
		return "login";
	}

	/**
	 * 
	 * @param model
	 * @param request
	 * @return
	 * @throws IOException
	 * 
	 *             check if user is registered in database
	 * @throws ParseException
	 */
	@RequestMapping(value = "/Authenticate", method = RequestMethod.POST)
	public String login(Model model, HttpServletRequest request) throws IOException, ParseException {
		System.out.println("before populate db");
		PopulateDatabase.populateFlightsData();
		System.out.println("after populate db");
		UserData user = new UserData();
		user.setUsername(request.getParameter("uname"));
		user.setPassword(request.getParameter("pass"));
		model.addAttribute("username", user.getUsername());
		System.out.println("username is "+ user.getUsername() +"password is "+ user.getPassword());
		if (AuthenticateUser.isValidUser(user)) {
			model.addAttribute("user", user);
			System.out.println("valid user");
			return "results";
			//return findResult(model, request);
		} else {
			return "error";
		}
	}

}
