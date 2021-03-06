package com.visa.training.web;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.visa.training.domain.Question;
import com.visa.training.domain.QuestionChoice;
import com.visa.training.domain.Survey;
import com.visa.training.domain.SurveyDistribution;
import com.visa.training.domain.User;
import com.visa.training.service.QuestionChoiceService;
import com.visa.training.service.QuestionService;
import com.visa.training.service.SurveyDistributionService;

@Controller
public class QuestionChoiceController {
	
	@Autowired
	LoginController login;
	
	@Autowired
	QuestionChoiceService questionChoiceService;
	
	@Autowired
	SurveyDistributionService surveyDistributionService;
	
	@Autowired
	QuestionService questionService;
	
	@RequestMapping(value="/questionchoice/{id}", method=RequestMethod.GET)
	public String editChoice(@PathVariable("id")int id, Map<String, Object> data){
		User user = login.getLoggedInUser();
		if (user == null) {
			return "redirect:/login";
		}
		QuestionChoice qc = questionChoiceService.findById(id);
		if(qc==null)
		{
			data.put("error", "No such choice found!");
			return "errorView";
		}
		Survey survey = qc.getQuestion().getSurvey();
		if(survey.getUser().getId()!=user.getId())
		{
			data.put("error", "Not authorized to use it");
			return "errorView";
		}
		List<SurveyDistribution> sd = surveyDistributionService.findAllById(survey);
		if(sd.size()>0){
			data.put("error", "Survey already distributed");
			return "errorView";
		}
		data.put("choice", qc);
		return "editQuestionChoiceView";
	}
	
	@RequestMapping(value="/questionchoice/{id}", method=RequestMethod.POST)
	public String saveChoice(@PathVariable("id")int id, @RequestParam("questionChoice")String questionChoice, Map<String, Object> data){
		User user = login.getLoggedInUser();
		if (user == null) {
			return "redirect:/login";
		}
		QuestionChoice qc = questionChoiceService.findById(id);
		if(qc==null)
		{
			data.put("error", "No such choice found!");
			return "errorView";
		}
		Survey survey = qc.getQuestion().getSurvey();
		if(survey.getUser().getId()!=user.getId())
		{
			data.put("error", "Not authorized to use it");
			return "errorView";
		}
		List<SurveyDistribution> sd = surveyDistributionService.findAllById(survey);
		if(sd.size()>0){
			data.put("error", "Survey already distributed");
			return "errorView";
		}
		qc.setQuestionChoice(questionChoice);
		return "redirect:/question/"+qc.getQuestion().getId();
	}
	
	@RequestMapping(value="/questionchoice", method=RequestMethod.POST)
	public String createChoice(@RequestParam("questionChoice")String questionChoice,@RequestParam("questionId")int qid, Map<String, Object> data){
		User user = login.getLoggedInUser();
		if (user == null) {
			return "redirect:/login";
		}
		
		Question question = questionService.findById(qid);
		Survey survey = question.getSurvey();
		if(survey.getUser().getId()!=user.getId())
		{
			data.put("error", "Not authorized to use it");
			return "errorView";
		}
		List<SurveyDistribution> sd = surveyDistributionService.findAllById(survey);
		if(sd.size()>0){
			data.put("error", "Survey already distributed");
			return "errorView";
		}
		if(question.getQuestionType()!=1 && question.getQuestionType()!=2){
			data.put("error", "Cannot add choices to this question type");
			return "errorView";
		}
		QuestionChoice qc = new QuestionChoice(questionChoice,question);
		questionChoiceService.create(qc, question);
		return "redirect:/question/"+qid;
	}
}
