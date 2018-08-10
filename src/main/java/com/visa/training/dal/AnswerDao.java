package com.visa.training.dal;

import java.util.List;

import com.visa.training.domain.Answer;
import com.visa.training.domain.Question;
import com.visa.training.domain.User;

public interface AnswerDao {
	Answer create(Answer answer);
	
	void delete(int id);
	
	Answer findById(int id);

	List<Answer> findAllByQuestionAndUser(Question q, User user);
}