package com.visa.training.web;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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

	@RequestMapping(value = "/createSurvey", method = RequestMethod.GET)
	public String createSurvey() {
		User user = login.getLoggedInUser();
		if (user == null) return "redirect:/login";
		if(user.getUsertype()<1) return "redirect:/home";
		return "surveyView";
	}

	@RequestMapping(value = "/saveSurvey", method = RequestMethod.POST)
	public String saveSurvey(@ModelAttribute("survey") Survey s) {
		User user = login.getLoggedInUser();
		if (user == null) return "redirect:/login";
		if(user.getUsertype()<1) return "redirect:/home";
		service.create(s, user);
		return "redirect:/home";
	}

	@RequestMapping(value = "/survey/{id}", method = RequestMethod.GET)
	public String showSavedSurvey(@PathVariable("id") int id, Map<String, Object> data) {
		User user = login.getLoggedInUser();
		if (user == null) return "redirect:/login";
		if(user.getUsertype()<1) return "redirect:/home";
		
		Survey s = service.findById(id);
		data.put("id", s.getId());
		data.put("title", s.getTitle());
		data.put("description", s.getDescription());
		data.put("questions", s.getQuestions());
		return "savedSurveyView";
	}
}
