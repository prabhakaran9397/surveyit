package com.visa.training.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.visa.training.domain.User;

@Controller
public class HomeController {
	
	@Autowired
	LoginController login;
	
	@RequestMapping(value="/home", method=RequestMethod.GET)
	public String decideView() {
		User user = login.getLoggedInUser();
		return user == null ? "loginView" : "homeView";
	}
	
}
