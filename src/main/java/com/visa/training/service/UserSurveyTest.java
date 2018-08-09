package com.visa.training.service;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.visa.training.domain.User;
import com.visa.training.domain.UserSurvey;

@Component
public class UserSurveyTest {

	@Autowired
	UserSurveyService userSurveyService;
	
	@Autowired
	UserService userService;
	
	@Test
	public void test() {
		User u = userService.findById(1);
		System.out.println(u);
		List<UserSurvey> userSurveys = userSurveyService.findAllByUser(u);
		System.out.println(userSurveys);
		assertTrue(true);
	}

}
