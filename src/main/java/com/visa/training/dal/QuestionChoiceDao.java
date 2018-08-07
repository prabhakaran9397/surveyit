package com.visa.training.dal;

import com.visa.training.domain.QuestionChoice;


public interface QuestionChoiceDao {
	QuestionChoice create(QuestionChoice questionChoice);

	void delete(int id);

	QuestionChoice findById(int id);

}
