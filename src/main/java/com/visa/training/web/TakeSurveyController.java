package com.visa.training.web;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.visa.training.domain.SurveyDistribution;
import com.visa.training.domain.User;
import com.visa.training.service.SurveyDistributionService;

@Controller
public class TakeSurveyController {

	@Autowired
	LoginController login;
	
	@Autowired
	SurveyDistributionService surveyDistService;
	
	@RequestMapping(value = "/takeSurvey/{id}", method = RequestMethod.GET)
	public String takeSurvey(@PathVariable("id") int surveyDistId, Map<String, Object> data) {
		User user = login.getLoggedInUser();
		if (user == null) return "loginView";
		
		SurveyDistribution surveyDist = surveyDistService.findById(surveyDistId);
		
		if(surveyDist == null) {
			data.put("error", "Sorry That Page Is Not Present");
			return "homeView";
		}
		
		
		return null;
	}
	
}
