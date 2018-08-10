package com.visa.training.web;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.visa.training.domain.Survey;
import com.visa.training.domain.SurveyDistribution;
import com.visa.training.domain.User;
import com.visa.training.service.SurveyDistributionService;
import com.visa.training.service.SurveyService;

@Controller
public class ViewResponsesController {
	
	@Autowired
	LoginController login;
	
	@Autowired
	SurveyService surveyService;
	@Autowired
	SurveyDistributionService surveyDistService;
	
	@RequestMapping(value = "/viewRespones/{id}", method = RequestMethod.GET)
	public String showResponses(@PathVariable("id") int surveyDistId, Map<String, Object> data){
		
		User user = login.getLoggedInUser();
		if (user == null) return "redirect:/login";
		
		SurveyDistribution surveyDist = surveyDistService.findById(surveyDistId);
		if(surveyDist == null) return "redirect:/home";
		
		data.put("surveytitle", surveyDist.getSurvey().getTitle());
		data.put("surveydesc", surveyDist.getSurvey().getDescription());
		data.put("surveytimestamp", surveyDist.getDistributedTime());
		
		
		return null;
		
		
		
	}

}
