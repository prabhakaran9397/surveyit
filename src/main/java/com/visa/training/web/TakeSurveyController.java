package com.visa.training.web;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.visa.training.domain.Question;
import com.visa.training.domain.QuestionChoice;
import com.visa.training.domain.SurveyDistribution;
import com.visa.training.domain.User;
import com.visa.training.service.QuestionChoiceService;
import com.visa.training.service.QuestionService;
import com.visa.training.service.SurveyDistributionService;

@Controller
public class TakeSurveyController {

	@Autowired
	LoginController login;
	
	@Autowired
	SurveyDistributionService surveyDistService;
	
	@Autowired
	QuestionService questionService;
	
	@Autowired
	QuestionChoiceService questionChoiceService;
	
	@RequestMapping(value = "/takeSurvey/{id}", method = RequestMethod.GET)
	public String takeSurvey(@PathVariable("id") int surveyDistId, Map<String, Object> data) {
		User user = login.getLoggedInUser();
		if (user == null) return "redirect:/login";
		
		SurveyDistribution surveyDist = surveyDistService.findById(surveyDistId);
		
		if(surveyDist == null) return "redirect:/home";
		
		data.put("title", surveyDist.getSurvey().getTitle());
		data.put("description", surveyDist.getSurvey().getDescription());
		data.put("timestamp", surveyDist.getDistributedTime());
		List<Question> questions = questionService.findAllBySurvey(surveyDist.getSurvey());
		for(Question q: questions) {
			List<QuestionChoice> questionChoices = questionChoiceService.findAllByQuestion(q);
		}
		data.put("questions", null);
		
		return null;
	}
	
}
