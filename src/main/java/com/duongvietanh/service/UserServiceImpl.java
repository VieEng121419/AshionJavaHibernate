package com.duongvietanh.service;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.duongvietanh.dao.UserDAO;
import com.duongvietanh.model.User;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDAO userDAO;
	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}
	
	@Override
	@Transactional
	public void AddAccount(User user) {
		user.setPassword(BCrypt.hashpw(user.getPassword(), BCrypt.gensalt(12)));
		this.userDAO.AddAccount(user);
	}

	@Override
	@Transactional
	public User CheckAccount(User user) {
		String pass = user.getPassword();
		user = userDAO.getUserByAcc(user);
		if (user != null)
		{
			if (BCrypt.checkpw(pass, user.getPassword()))
			{
				return user;
			}
			else
			{
				return null;
			}
		}
		return null;		
	}
	
}
