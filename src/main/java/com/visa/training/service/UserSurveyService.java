package com.visa.training.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.visa.training.dal.SurveyDistributionDao;
import com.visa.training.dal.UserSurveyDao;
import com.visa.training.domain.SurveyDistribution;
import com.visa.training.domain.User;
import com.visa.training.domain.UserSurvey;

@Service
@Transactional
public class UserSurveyService {
	
	@Autowired
	UserSurveyDao dao;
	
	@Autowired
	UserService userService;
	
	@Autowired
	SurveyDistributionService surveyDistributionService;

	public UserSurvey create(UserSurvey us) {
		return dao.create(us);
	}

	public UserSurvey findById(int id) {
		return dao.findById(id);
	}

	public void delete(int id) {
		dao.delete(id);
	}

	public UserSurvey create(User u, SurveyDistribution sd, UserSurvey userSurvey) {
		u = userService.findById(u.getId());
		sd = surveyDistributionService.findById(sd.getId());
		userSurvey.setSurveyDistribution(sd);
		userSurvey.setUser(u);
		dao.create(userSurvey);
		u.getUserSurveys().add(userSurvey);
		sd.getUserSurveys().add(userSurvey);
		return userSurvey;
	}
	

}
