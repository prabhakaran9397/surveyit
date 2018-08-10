package com.visa.training.web;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.visa.training.domain.QuestionChoice;
import com.visa.training.domain.Survey;
import com.visa.training.domain.User;
import com.visa.training.service.QuestionChoiceService;

@Controller
public class QuestionChoiceController {
	
	@Autowired
	LoginController login;
	
	@Autowired
	QuestionChoiceService questionChoiceService;
	
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
		if(!survey.getUser().equals(user))
		{
			data.put("error", "Not authorized to use it");
			return "errorView";
		}
		data.put("choice", qc);
		return "editQuestionChoiceView";
	}
	
	@RequestMapping(value="/questionchoice/{id}", method=RequestMethod.PUT)
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
		if(!survey.getUser().equals(user))
		{
			data.put("error", "Not authorized to use it");
			return "errorView";
		}
		qc.setQuestionChoice(questionChoice);
		return "redirect:/question/"+qc.getQuestion().getId();
	}
}
