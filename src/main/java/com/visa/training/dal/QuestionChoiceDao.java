package com.visa.training.dal;

import java.util.List;

import com.visa.training.domain.Question;
import com.visa.training.domain.QuestionChoice;


public interface QuestionChoiceDao {
	QuestionChoice create(QuestionChoice questionChoice);

	void delete(int id);

	QuestionChoice findById(int id);

	List<QuestionChoice> findAllBySurvey(Question q);

}
