package com.visa.training.dal;

import com.visa.training.domain.Answer;

public interface AnswerDao {
	Answer create(Answer answer);
	
	void delete(int id);
	
	Answer findById(int id);
}