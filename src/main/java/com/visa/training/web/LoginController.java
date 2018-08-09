package com.visa.training.web;

import java.util.Map;

import javax.persistence.NoResultException;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.visa.training.domain.User;
import com.visa.training.service.UserService;

@Controller
public class LoginController {

	@Autowired
	UserService service;
	
	@Autowired
	private HttpSession session;
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String decideLoginView() {
		User user = getLoggedInUser();
		return user == null ? "loginView" : "homeView";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String processLogin(@ModelAttribute("user") User u, Map<String, Object> data) {
		try {
			User userInDb = service.findByUsername(u.getUsername());
			if(userInDb == null || !userInDb.getPassword().equals(u.getPassword())) {
				data.put("error", "Username or Password is wrong");
				return "loginView";
			} else {
				session.setAttribute("user", u);
				return "homeView";
			}
		} catch (NoResultException e) {
			data.put("error", "Username or Password is wrong");
			return "loginView";
		}
	}
	
	public User getLoggedInUser() {
		return (User) session.getAttribute("user");
	}
	
}
