package com.visa.training.dal;


import com.visa.training.domain.Survey;

public interface SurveyDao {
	
	Survey create(Survey s);
	
	Survey findById(int id);
	
	void delete(int id);
	
}
