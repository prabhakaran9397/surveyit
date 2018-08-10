package com.visa.training.dal;


import java.util.List;

import com.visa.training.domain.Survey;
import com.visa.training.domain.User;

public interface SurveyDao {
	
	Survey create(Survey s);
	
	Survey findById(int id);
	
	void delete(int id);

	List<Survey> findAllByUser(User u);
	
}
