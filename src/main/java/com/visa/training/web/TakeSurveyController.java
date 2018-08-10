package com.visa.training.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.visa.training.domain.Answer;
import com.visa.training.domain.Question;
import com.visa.training.domain.QuestionChoice;
import com.visa.training.domain.SurveyDistribution;
import com.visa.training.domain.User;
import com.visa.training.domain.UserSurvey;
import com.visa.training.service.AnswerService;
import com.visa.training.service.QuestionChoiceService;
import com.visa.training.service.QuestionService;
import com.visa.training.service.SurveyDistributionService;
import com.visa.training.service.UserSurveyService;

@Controller
public class TakeSurveyController {

	@Autowired
	LoginController login;
	
	@Autowired
	SurveyDistributionService surveyDistService;
	
	@Autowired
	QuestionService questionService;
	
	@Autowired
	AnswerService answerService;
	
	@Autowired
	QuestionChoiceService questionChoiceService;
	
	@Autowired
	UserSurveyService userSurveyService;
	
	@RequestMapping(value = "/takeSurvey/{id}", method = RequestMethod.GET)
	public String takeSurvey(@PathVariable("id") int surveyDistId, Map<String, Object> data) {
		User user = login.getLoggedInUser();
		if (user == null) return "redirect:/login";
		
		SurveyDistribution surveyDist = surveyDistService.findById(surveyDistId);
		if(surveyDist == null) return "redirect:/home";
		
		boolean found = false;
		List<UserSurvey> userSurveys = userSurveyService.findAllByUser(user);
		for(UserSurvey us : userSurveys) {
			found = !us.isFinished() && us.getSurveyDistribution().getId() == surveyDist.getId();
			if(found) break;
		}
		if(!found) return "redirect:/home";
		
		data.put("sid", surveyDist.getId());
		data.put("title", surveyDist.getSurvey().getTitle());
		data.put("description", surveyDist.getSurvey().getDescription());
		data.put("timestamp", surveyDist.getDistributedTime());
		List<Question> questions = questionService.findAllBySurvey(surveyDist.getSurvey());
		data.put("questions", questions);
		List<List<QuestionChoice>> qcs = new ArrayList<>();
		for(Question q: questions) {
			qcs.add(questionChoiceService.findAllByQuestion(q));
		}
		data.put("questionChoices", qcs);
		List<List<Answer>> answers = new ArrayList<>();
		for(Question q: questions) {
			answers.add(answerService.findAllByQuestionAndUser(q, user));
		}
		Map<Question, List<String>> qas = new HashMap<>();
		for(List<Answer> a : answers) {
			for(Answer _a : a) {
				List<String> temp = qas.getOrDefault(_a.getQuestion(), new ArrayList<>());
				temp.add(_a.getAnswer());
				qas.put(_a.getQuestion(), temp);
			}
		}
		data.put("qas", qas);
		
		return "takeSurveyView";
	}
	
	@RequestMapping(value = "/takeSurvey/{id}", method = RequestMethod.POST)
	public String processResponse(@PathVariable("id") int surveyDistId, HttpServletRequest req) {
		User user = login.getLoggedInUser();
		if (user == null) return "redirect:/login";
		
		SurveyDistribution surveyDist = surveyDistService.findById(surveyDistId);
		
		if(surveyDist == null) return "redirect:/home";
		
		boolean found = false;
		List<UserSurvey> userSurveys = userSurveyService.findAllByUser(user);
		UserSurvey userSurvey = null;
		for(UserSurvey us : userSurveys) {
			if(!us.isFinished() && us.getSurveyDistribution().getId() == surveyDist.getId()) {
				found = true;
				userSurvey = us;
				break;
			}
		}
		if(!found) return "redirect:/home";
		
		List<Question> questions = questionService.findAllBySurvey(surveyDist.getSurvey());
		questions.forEach(q -> {
			if(q.getQuestionType() == 1) {
				String[] answers = req.getParameterValues("" + q.getId());
				for(String a : answers) {
					Answer answer = new Answer();
					answer.setAnswer(a);
					answerService.create(answer, q, user);
				}
			}
			else {
				String a = req.getParameter(String.valueOf(q.getId()));
				Answer answer = new Answer();
				answer.setAnswer(a);
				answerService.create(answer, q, user);
			}
			req.getParameter(String.valueOf(q.getId()));
		});
		
		if(req.getParameter("submit").equals("Respond")) {
			userSurveyService.setFinished(userSurvey, true);
		}
		
		return "redirect:/home";
	}
	
}
