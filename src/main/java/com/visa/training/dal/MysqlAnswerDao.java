package com.visa.training.dal;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.visa.training.domain.Answer;

@Repository
@Transactional
public class MysqlAnswerDao implements AnswerDao {

	EntityManager em;
	
	@Override
	public Answer create(Answer answer) {
		em.persist(answer);
		return answer;
	}

	@Override
	public void delete(int id) {
		Answer answer=em.find(Answer.class, id);
		em.remove(answer);
	}

	@Override
	public Answer findById(int id) {
		return em.find(Answer.class, id);
	}

}
