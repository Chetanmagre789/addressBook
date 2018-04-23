package com.yash.addressbook.dao;

import java.util.List;

import com.yash.addressbook.model.User;

public interface UserDAO {

	public int insert(User user);

	public List<User> getAllUsers();
}
