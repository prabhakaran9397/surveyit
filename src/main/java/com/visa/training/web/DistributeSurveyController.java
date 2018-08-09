package com.visa.training.web;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.visa.training.domain.Survey;
import com.visa.training.domain.SurveyDistribution;
import com.visa.training.domain.User;
import com.visa.training.domain.UserSurvey;
import com.visa.training.service.SurveyDistributionService;
import com.visa.training.service.SurveyService;
import com.visa.training.service.UserService;
import com.visa.training.service.UserSurveyService;

@Controller
public class DistributeSurveyController {

	@Autowired
	LoginController login;

	@Autowired
	SurveyDistributionService sdService;

	@Autowired
	UserService userService;

	@Autowired
	UserSurveyService userSurveyService;
	
	@Autowired
	SurveyService surveyService;

	@RequestMapping(value = "/distribute/{id}", method = RequestMethod.GET)
	public String handleDistributeView(@PathVariable("id") int surveyId, Map<String, Object> data) {
		User user = login.getLoggedInUser();
		if (user == null) return "loginView";
		
		Survey survey = surveyService.findById(surveyId);

		data.put("survey", survey);
		List<User> users = userService.findAll();
		data.put("userslist", users);
		
		return "distributeView";

	}

	@RequestMapping(value = "/distribute", method = RequestMethod.POST)
	public String processDistributeSurvey(@RequestParam("survey") int sid, @RequestParam("user") List<Integer> uids) {

		User user = login.getLoggedInUser();
		if (user == null) {
			return "loginView";
		}

		Survey s = surveyService.findById(sid);
		if(s == null){
			return "homeView";
		}
		List<User> users = uids.stream().map(userService::findById).collect(Collectors.toList());
		
		SurveyDistribution sd = new SurveyDistribution();
		sd.setDistributedTime(new Date());
		sdService.create(sd, s);

		List<UserSurvey> usersurveyList = new ArrayList<>();
		for (User u : users) {
			UserSurvey userSurvey = new UserSurvey();
			userSurvey.setFinished(false);
			userSurvey = userSurveyService.create(userSurvey, u, sd);
			usersurveyList.add(userSurvey);
		}

		sd.setUserSurveys(usersurveyList);

		return null;

	}

}
