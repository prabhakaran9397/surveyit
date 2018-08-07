package com.visa.training.dal;

import com.visa.training.domain.Question;

public interface QuestionDao {

	Question create(Question question);

	void delete(int id);

	Question findById(int id);

}
