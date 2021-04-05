package com.duongvietanh.dao;

import com.duongvietanh.model.User;

public interface UserDAO {

	public void AddAccount(User user);
	
	public User getUserByAcc(User user); 
}
