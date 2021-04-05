package com.duongvietanh.dao;



import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.duongvietanh.model.Product;
import com.duongvietanh.model.User;

@Transactional
@Repository
public class UserDAOImpl implements UserDAO{
	
	private static final Logger logger = LoggerFactory.getLogger(UserDAOImpl.class);
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	public void AddAccount(User user) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(user);
		logger.info("User saved successfully, User Details=" + user);
	}

	public User getUserByAcc(User user) {
		
        Session session = null;
 
        try {
        	session = sessionFactory.openSession();
        	List<User> result = new ArrayList<User>();
        	result = session.createQuery("from User where username=?").setParameter(0, user.getUsername()).list();
        	if(result.size()>0)
        	{
        		return result.get(0);
        	}
        }
        catch (HibernateException e){
        	e.printStackTrace();
        }
        return null;
    }
}
