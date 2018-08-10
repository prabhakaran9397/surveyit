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
import com.visa.training.domain.Survey;
import com.visa.training.domain.User;
import com.visa.training.service.QuestionChoiceService;
import com.visa.training.service.QuestionService;
import com.visa.training.service.SurveyDistributionService;
import com.visa.training.service.SurveyService;

@Controller
public class QuestionController {

	@Autowired
	LoginController login;

	@Autowired
	SurveyService surveyService;

	@Autowired
	QuestionService questionService;
	
	@Autowired
	QuestionChoiceService questionChoiceService;

	@RequestMapping(value="/question",method=RequestMethod.POST)
	public String createQuestion(@RequestParam("question")String question,@RequestParam("questionType")int questionType,@RequestParam("surveyId")int surveyId, Map<String, Object> data){
		User user = login.getLoggedInUser();
		if (user == null) {
			return "redirect:/login";
		}
		if (user.getUsertype() < 1) {
			return "redirect:/home";
		}
		
		Survey survey = surveyService.findById(surveyId);
		
		if(survey.getUser().getId()!=user.getId())
		{
			data.put("error", "Not authorized to use it");
			return "errorView";
		}
		
		if(survey.getDistributions()!=null || survey.getDistributions().size()>0){
			data.put("error", "Survey already distributed");
			return "errorView";
		}
		Question q = new Question(questionType, question, survey);
		q = questionService.create(q,survey);
		return "redirect:/question/"+q.getId();
	}
	
	@RequestMapping(value="/question/{id}", method=RequestMethod.GET)
	public String editQuestion(@PathVariable("id")int id, Map<String, Object> data){
		User user = login.getLoggedInUser();
		if (user == null) {
			return "redirect:/login";
		}
		Question q = questionService.findById(id);
		if(q==null)
		{
			data.put("error", "No such question found!");
			return "errorView";
		}
		Survey survey = q.getSurvey();
		if(survey.getUser().getId()!=user.getId())
		{
			data.put("error", "Not authorized to use it");
			return "errorView";
		}
		if(survey.getDistributions()!=null || survey.getDistributions().size()>0){
			data.put("error", "Survey already distributed");
			return "errorView";
		}
		data.put("question", q.getQuestion());
		data.put("choices", questionChoiceService.findAllByQuestion(q));
		return "editQuestionView";
	}
	
	@RequestMapping(value="/question/{id}/title",method=RequestMethod.GET)
	public String editQuestionTitle(@PathVariable("id")int id, Map<String, Object> data){
		User user = login.getLoggedInUser();
		if (user == null) {
			return "redirect:/login";
		}
		Question q = questionService.findById(id);
		if(q==null)
		{
			data.put("error", "No such question found!");
			return "errorView";
		}
		Survey survey = q.getSurvey();
		if(survey.getUser().getId()!=user.getId())
		{
			data.put("error", "Not authorized to use it");
			return "errorView";
		}
		data.put("id", id);
		data.put("question", q.getQuestion());
		return "editQuestionTitleView";
	}
	
	@RequestMapping(value="/question/{id}/title",method=RequestMethod.POST)
	public String saveTitle(@PathVariable("id")int id, @RequestParam("question")String question,Map<String, Object> data){
		User user = login.getLoggedInUser();
		if (user == null) {
			return "redirect:/login";
		}
		Question q = questionService.findById(id);
		if(q==null)
		{
			data.put("error", "No such question found!");
			return "errorView";
		}
		Survey survey = q.getSurvey();
		if(survey.getUser().getId()!=user.getId())
		{
			data.put("error", "Not authorized to use it");
			return "errorView";
		}
		q.setQuestion(question);
		return "redirect:/question/"+id;
	}
}
