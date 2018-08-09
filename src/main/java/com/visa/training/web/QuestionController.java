package com.visa.training.web;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.visa.training.domain.Question;
import com.visa.training.domain.Survey;
import com.visa.training.domain.User;
import com.visa.training.service.QuestionService;
import com.visa.training.service.SurveyDistributionService;
import com.visa.training.service.SurveyService;

@Controller
public class QuestionController {

	@Autowired
	LoginController login;

	@Autowired
	SurveyService surveyService;

	@Autowired
	QuestionService questionService;

	@RequestMapping(value="/question",method=RequestMethod.POST)
	public String createQuestion(@RequestParam("question")String question,@RequestParam("questionType")int questionType,@RequestParam("surveyId")int surveyId, Map<String, Object> data){
		User user = login.getLoggedInUser();
		if (user == null) {
			return "loginView";
		}
		if (user.getUsertype() < 1) {
			return "homeView";
		}
		
		Survey survey = surveyService.findById(surveyId);
		
		if(!survey.getUser().equals(user))
		{
			data.put("error", "Not authorized to use it");
			return "errorView";
		}
		
		if(survey.getDistributions()!=null){
			data.put("error", "Survey already distributed");
			return "errorView";
		}
		Question q = new Question(questionType, question, survey);
		questionService.create(q,survey);
		data.put("question", q);
		return "questionEditView";
	}

	@RequestMapping(value="/question/{id}/title",method=RequestMethod.PUT)
	public String editTitle()
}
