package com.visa.training.dal;

import java.util.List;

import com.visa.training.domain.User;
import com.visa.training.domain.UserSurvey;

public interface UserSurveyDao {
	
	UserSurvey findById(int id);
	
	void delete(int id);
	
	UserSurvey create(UserSurvey us);
	
	List<UserSurvey> findAllByUser(User user);

}
