package com.duongvietanh.service;

import com.duongvietanh.model.User;

public interface UserService {

	public void AddAccount(User user);
	public User CheckAccount(User user);
}
