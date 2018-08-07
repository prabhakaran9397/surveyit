package com.visa.training.dal;

import com.visa.training.domain.UserSurvey;

public interface UserSurveyDao {
	
	UserSurvey findById(int id);
	
	void delete(int id);
	
	UserSurvey create(UserSurvey us);

}
