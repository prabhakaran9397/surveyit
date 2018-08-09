package com.visa.training.web;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.visa.training.domain.Survey;
import com.visa.training.domain.User;
import com.visa.training.domain.UserSurvey;

@Controller
public class HomeController {
	
	@Autowired
	LoginController login;
	
	@RequestMapping(value="/home", method=RequestMethod.GET)
	public String decideView(Map<String, Object> data) {
		User user = login.getLoggedInUser();
		if (user == null) return "loginView";
		
		if(user.getUsertype() == 0 || user.getUsertype() == 2) {
			List<UserSurvey> userSurveys = user.getUserSurveys();
			
			data.put("table1", userSurveys.stream()
				.filter(s -> !s.isFinished())
				.map(s -> {
					List<String> sd = new ArrayList<>();
					sd.add(String.valueOf(s.getSurveyDistribution().getId()));
					sd.add(s.getSurveyDistribution().getSurvey().getTitle());
					sd.add(String.valueOf(s.getSurveyDistribution().getDistributedTime()));
					return sd;
				}
			).collect(Collectors.toList()));
			
			data.put("table2", userSurveys.stream()
				.filter(s -> s.isFinished())
				.map(s -> {
					List<String> sd = new ArrayList<>();
					sd.add(String.valueOf(s.getSurveyDistribution().getId()));
					sd.add(s.getSurveyDistribution().getSurvey().getTitle());
					sd.add(String.valueOf(s.getSurveyDistribution().getDistributedTime()));
					return sd;
				}
			).collect(Collectors.toList()));
		}
		
		if(user.getUsertype() == 1 || user.getUsertype() == 2) {
			List<Survey> surveys = user.getSurveys();
			
			data.put("table3", surveys.stream()
				.map(s -> {
					List<String> sd = new ArrayList<>();
					sd.add(String.valueOf(s.getId()));
					sd.add(s.getTitle());
					return sd;
				}
			).collect(Collectors.toList()));
			
			List<List<String>> out = new ArrayList<List<String>>();
			for(Survey s: surveys) {
				s.getDistributions().stream()
					.map(d -> {
						List<String> sd = new ArrayList<>();
						sd.add(String.valueOf(d.getId()));
						sd.add(d.getSurvey().getTitle());
						sd.add(String.valueOf(d.getDistributedTime()));
						return sd;
					}
				).collect(Collectors.toList())
				.forEach(e -> out.add(e));
			}
			data.put("table4", out);
		}
		
		return "homeView";
	}
	
}
