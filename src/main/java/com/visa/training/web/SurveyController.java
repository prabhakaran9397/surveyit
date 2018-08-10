package com.visa.training.web;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.visa.training.domain.Question;
import com.visa.training.domain.Survey;
import com.visa.training.domain.User;
import com.visa.training.service.QuestionService;
import com.visa.training.service.SurveyService;

@Controller
public class SurveyController {

	@Autowired
	LoginController login;

	@Autowired
	SurveyService service;
	
	@Autowired
	QuestionService questionService;

	@RequestMapping(value = "/createSurvey", method = RequestMethod.GET)
	public String createSurvey() {
		User user = login.getLoggedInUser();

		if (user == null) return "redirect:/login";
		if(user.getUsertype()<1) return "redirect:/home";
		return "surveyView";
	}

	@RequestMapping(value = "/saveSurvey", method = RequestMethod.POST)
	public String saveSurvey(@ModelAttribute("survey") Survey s) {
		User user = login.getLoggedInUser();

		if (user == null) return "redirect:/login";
		if(user.getUsertype()<1) return "redirect:/home";

		service.create(s, user);
		return "redirect:/home";
	}

	@RequestMapping(value = "/survey/{id}", method = RequestMethod.GET)
	public String editSurvey(@PathVariable("id") int id, Map<String, Object> data) {
		User user = login.getLoggedInUser();

		if (user == null) return "redirect:/login";
		if(user.getUsertype()<1) return "redirect:/home";
		

		Survey s = service.findById(id);
		data.put("survey", s);
		data.put("questions",questionService.findAllBySurvey(s));
		return "editSurveyView";
	}

	@RequestMapping(value="/survey/{id}/title", method = RequestMethod.PUT)
	public String saveTitle(@PathVariable("id") int id,@RequestParam("title")String title, Map<String, Object> data){
		User user = login.getLoggedInUser();
		if (user == null) {
			return "redirect:/login";
		}
		Survey s = service.findById(id);
		if(s==null)
		{
			data.put("error", "No such survey found!");
			return "errorView";
		}
		if(!s.getUser().equals(user)){
			data.put("error", "Not authorized");
			return "errorView";
		}

		s.setTitle(title);

		return "redirect:/survey/"+s.getId();
	}
	
	@RequestMapping(value="/survey/{id}/description", method = RequestMethod.PUT)
	public String saveDescription(@PathVariable("id") int id,@RequestParam("description")String description, Map<String, Object> data){
		User user = login.getLoggedInUser();
		if (user == null) {
			return "redirect:/login";
		}
		Survey s = service.findById(id);
		if(s==null)
		{
			data.put("error", "No such survey found!");
			return "errorView";
		}
		if(!s.getUser().equals(user)){
			data.put("error", "Not authorized");
			return "errorView";
		}

		s.setDescription(description);

		return "redirect:/survey/"+s.getId();
	}
	
	@RequestMapping(value="/survey/{id}/title", method=RequestMethod.GET)
	public String editTitle(@PathVariable("id")int id, Map<String,Object> data){
		User user = login.getLoggedInUser();
		if (user == null) {
			return "redirect:/login";
		}
		Survey s = service.findById(id);
		if(s==null)
		{
			data.put("error", "No such survey found!");
			return "errorView";
		}
		if(!s.getUser().equals(user)){
			data.put("error", "Not authorized");
			return "errorView";
		}
		data.put("survey", s);
		return "editSurveyTitleView";
	}
	
	@RequestMapping(value="/survey/{id}/description", method=RequestMethod.GET)
	public String editDescription(@PathVariable("id")int id, Map<String,Object> data){
		User user = login.getLoggedInUser();
		if (user == null) {
			return "redirect:/login";
		}
		Survey s = service.findById(id);
		if(s==null)
		{
			data.put("error", "No such survey found!");
			return "errorView";
		}
		if(!s.getUser().equals(user)){
			data.put("error", "Not authorized");
			return "errorView";
		}
		data.put("survey", s);
		return "editSurveyDescriptionView";
	}
}
