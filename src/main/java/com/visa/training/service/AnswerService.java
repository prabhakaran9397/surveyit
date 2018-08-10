package com.visa.training.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.visa.training.dal.AnswerDao;
import com.visa.training.domain.Answer;
import com.visa.training.domain.Question;
import com.visa.training.domain.Survey;
import com.visa.training.domain.User;

@Service
@Transactional
public class AnswerService {
	
	@Autowired
	AnswerDao dao;
	
	@Autowired
	QuestionService questionService;
	
	@Autowired
	UserService userService;
	
	public Answer create(Answer answer) {
		return dao.create(answer);
	}
	
	public Answer create(Answer a, Question q, User u) {
		q = questionService.findById(q.getId());
		u = userService.findById(u.getId());
		a.setQuestion(q);
		a.setUser(u);
		dao.create(a);
		q.getAnswers().add(a);
		u.getAnswers().add(a);
		return a;
	}
	
	public void delete(int id) {
		dao.delete(id);
	}

	
	public Answer findById(int id) {
		return dao.findById(id);
	}

	

	public List<Answer> findAllByUser(User user) {
		return dao.findAllByUser(user);
	}
}
