package com.visa.training.web;

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
import com.visa.training.service.AnswerService;
import com.visa.training.service.QuestionService;

@Controller
public class ResponseController {
	@Autowired
	LoginController login;
	@Autowired
	SurveyDistributionDao dao;
	@Autowired
	QuestionService questionService;
	@Autowired
	AnswerService answerService;
	
	@RequestMapping(value = "/viewResponse/{id}", method = RequestMethod.GET)
	public String viewResponseByRespondent(@PathVariable("id") int sdId,  Map<String, Object> data) {
		User user = login.getLoggedInUser();
		if (user == null) {
			return "loginView";
		}
		SurveyDistribution sd=dao.findById(sdId);
		data.put("title", sd.getSurvey().getTitle());
		data.put("description", sd.getSurvey().getDescription());
		data.put("timestamp", sd.getDistributedTime());
		List<Question> questions = questionService.findAllBySurvey(sd.getSurvey());
		data.put("questions", questions);
		List<List<Answer>> answers=null;
		int i=0;
		for(Question q: questions) {
			List<Answer> ans = answerService.findAllByQuestionAndUser(sd.getSurvey().getUser(),q);
			answers.add(ans);
		}
		data.put("answers", answers);
		
			
		return "responseView";
	}
	
}
