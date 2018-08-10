package com.visa.training.dal;

import java.util.List;

import com.visa.training.domain.Question;
import com.visa.training.domain.Survey;

public interface QuestionDao {

	Question create(Question question);

	void delete(int id);

	Question findById(int id);

	List<Question> findAllBySurvey(Survey s);

}
