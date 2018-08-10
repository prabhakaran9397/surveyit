package com.visa.training.web;

import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.visa.training.dal.SurveyDistributionDao;
import com.visa.training.domain.SurveyDistribution;
import com.visa.training.domain.User;

@Controller
public class ResponseController {
	@Autowired
	LoginController login;
	@Autowired
	SurveyDistributionDao dao;

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
		data.put("questions", sd.getSurvey().getQuestions());
		data.put("answers", sd.getSurvey().getUser().getAnswers());
		
			
		return "responseView";
	}
	
}
