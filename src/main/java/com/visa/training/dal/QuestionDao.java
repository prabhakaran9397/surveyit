package com.visa.training.dal;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.visa.training.domain.Question;



@Repository
@Transactional
public interface QuestionDao {

	Question create(Question question);
	
	void delete(int id);
	
	Question findById(int id);
	
}
