package com.visa.training.dal;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.visa.training.domain.Answer;
import com.visa.training.domain.Question;
import com.visa.training.domain.User;

@Repository
@Transactional
public class MysqlAnswerDao implements AnswerDao {
    @Autowired
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

	@Override
	public List<Answer> findAllByUser(User u) {
		return (List<Answer>) em.createQuery("SELECT a FROM Answer a WHERE a.user.id = " + u.getId()).getResultList();

	}

}
