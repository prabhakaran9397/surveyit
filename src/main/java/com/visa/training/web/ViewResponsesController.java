package com.visa.training.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.visa.training.domain.Answer;
import com.visa.training.domain.Question;
import com.visa.training.domain.QuestionChoice;
import com.visa.training.domain.Survey;
import com.visa.training.domain.SurveyDistribution;
import com.visa.training.domain.User;
import com.visa.training.service.AnswerService;
import com.visa.training.service.QuestionChoiceService;
import com.visa.training.service.QuestionService;
import com.visa.training.service.SurveyDistributionService;
import com.visa.training.service.SurveyService;

@Controller
public class ViewResponsesController {
	
	@Autowired
	LoginController login;
	
	@Autowired
	SurveyService surveyService;
	@Autowired
	SurveyDistributionService surveyDistService;
	@Autowired
	QuestionService questionService;
	@Autowired
	AnswerService answerService;
	@Autowired
	QuestionChoiceService questionChoiceService;
	
	@RequestMapping(value = "/viewResponses/{id}", method = RequestMethod.GET)
	public String showResponses(@PathVariable("id") int surveyDistId, Map<String, Object> data){
		System.out.println("in get of /viewResponses/"+surveyDistId);
		User user = login.getLoggedInUser();
		if (user == null) return "redirect:/login";
		
		SurveyDistribution surveyDist = surveyDistService.findById(surveyDistId);
		if(surveyDist == null) return "redirect:/home";
		
		data.put("surveytitle", surveyDist.getSurvey().getTitle());
		data.put("surveydesc", surveyDist.getSurvey().getDescription());
		data.put("surveytimestamp", surveyDist.getDistributedTime());
		
		Survey survey = surveyDist.getSurvey();
		List<Question> questionList = questionService.findAllBySurvey(survey);
		
		Map<Question, List<Answer>> questionAnswer = new HashMap<>();
		for(Question q: questionList) {
			if(q.getQuestionType() == 3 || q.getQuestionType() == 4) {
				List<Answer> ans = answerService.findAllByQuestion(q);
				questionAnswer.put(q, ans);
			}
		}
		
		data.put("questiontypethreeandfour", questionAnswer);
		
		Map<Question, Map<QuestionChoice, Integer>> questionchoicesAnswer = new HashMap<>();
		
		
		
		for(Question q: questionList) {
			if(q.getQuestionType() == 1 || q.getQuestionType() == 2) {
				Map<QuestionChoice, Integer> questionchoiceRespondents = new  HashMap<>();
				
				List<QuestionChoice> questionChoices = questionChoiceService.findAllByQuestion(q);
				List<Answer> answerforChoices = answerService.findAllByQuestion(q);
				
				
				for(QuestionChoice qch: questionChoices) {
					int count = 0;
					for(Answer a : answerforChoices) {
						if(a.getAnswer().equals(qch.getQuestionChoice())){
							count = count + 1;
						}
					}
					questionchoiceRespondents.put(qch, Integer.valueOf(count));
				}
				questionchoicesAnswer.put(q, questionchoiceRespondents);			
			}
		}
		
		data.put("questiontypeoneandtwo", questionchoicesAnswer);
		return "responsesView";
		
		
	}

	
}
