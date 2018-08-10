package com.visa.training.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.visa.training.dal.SurveyDistributionDao;
import com.visa.training.domain.Answer;
import com.visa.training.domain.Question;
import com.visa.training.domain.QuestionChoice;
import com.visa.training.domain.SurveyDistribution;
import com.visa.training.domain.User;
import com.visa.training.domain.UserSurvey;
import com.visa.training.service.AnswerService;
import com.visa.training.service.QuestionService;
import com.visa.training.service.SurveyDistributionService;
import com.visa.training.service.UserSurveyService;

@Controller
public class ResponseController {
	@Autowired
	LoginController login;
	
	@Autowired
	SurveyDistributionService surveyDistService;
	
	@Autowired
	QuestionService questionService;
	
	@Autowired
	AnswerService answerService;
	
	@Autowired
	UserSurveyService userSurveyService;
	
	@RequestMapping(value = "/viewResponse/{id}", method = RequestMethod.GET)
	public String viewResponseByRespondent(@PathVariable("id") int surveyDistId,  Map<String, Object> data) {
		User user = login.getLoggedInUser();
		if (user == null) return "redirect:/login";
		
		SurveyDistribution surveyDist = surveyDistService.findById(surveyDistId);
		if(surveyDist == null) return "redirect:/home";
		
		boolean found = false;
		List<UserSurvey> userSurveys = userSurveyService.findAllByUser(user);
		for(UserSurvey us : userSurveys) {
			found = us.isFinished() && us.getSurveyDistribution().getId() == surveyDist.getId();
		}
		if(!found) return "redirect:/home";
		
		data.put("title", surveyDist.getSurvey().getTitle());
		data.put("description", surveyDist.getSurvey().getDescription());
		data.put("timestamp", surveyDist.getDistributedTime());
		List<Question> questions = questionService.findAllBySurvey(surveyDist.getSurvey());
		List<List<Answer>> answers = new ArrayList<>();
		for(Question q: questions) {
			answers.add(answerService.findAllByQuestionAndUser(q, user));
		}
		Map<Question, List<String>> qas = new HashMap<>();
		for(Question q : questions) {
			for(List<Answer> a : answers) {
				for(Answer _a : a) {
					List<String> temp = qas.getOrDefault(q, new ArrayList<>());
					temp.add(_a.getAnswer());
					qas.put(q, temp);
				}
			}
		}
		data.put("qas", qas);
			
		return "responseView";
	}
	
}
