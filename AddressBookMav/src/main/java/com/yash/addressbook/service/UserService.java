package com.yash.addressbook.service;

import java.util.List;

import com.yash.addressbook.model.User;

public interface UserService {
	
	public int registerUser(User user);
	
	public List<User> getAllUsers();
}
