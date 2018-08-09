package com.visa.training.dal;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.visa.training.domain.User;

@Repository
@Transactional
public class MysqlUserDao implements UserDao {

	@Autowired
	EntityManager em;
	
	@Override
	public User create(User u) {
		em.persist(u);
		return u;
	}
	
	@Override
	public void delete(int id) {
		User u = em.find(User.class, id);
		em.remove(u);
	}

	@Override
	public User findById(int id) {
		return em.find(User.class, id);
	}

	@Override
	public User findByUsername(String username) {
		return (User) em.createQuery("SELECT u FROM User u WHERE u.username = '" + username + "'").getSingleResult();
	}
	
	
}
