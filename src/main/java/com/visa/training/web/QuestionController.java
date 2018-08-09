package com.visa.training.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.visa.training.service.SurveyService;


@Controller
public class QuestionController {
	
	@Autowired
	SurveyService service;
	
	@RequestMapping(value="/question",method=RequestMethod.POST)
	public String createQuestion(){
		return 
	}
}
