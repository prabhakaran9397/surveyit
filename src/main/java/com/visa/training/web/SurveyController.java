package com.visa.training.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.visa.training.domain.Survey;
import com.visa.training.domain.User;
import com.visa.training.service.SurveyService;

@Controller
public class SurveyController {
	
	@Autowired
	LoginController login;
	
	@Autowired
	SurveyService service;
	
	@RequestMapping(value="/createSurvey", method=RequestMethod.GET)
	public String createSurvey(){
		User user = login.getLoggedInUser();
		if(user==null){
			return "loginView";
		}
		return "surveyView";
	}
	
	@RequestMapping(value="/saveSurvey", method=RequestMethod.POST)
	public String saveSurvey(@ModelAttribute("survey")Survey s){
		User user = login.getLoggedInUser();
		if(user==null){
			return "loginView";
		}
		service.create(s, user);
		return "homeView";
	}
}
