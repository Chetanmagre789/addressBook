package com.yash.addressbook.serviceimpl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yash.addressbook.dao.UserDAO;
import com.yash.addressbook.model.User;
import com.yash.addressbook.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	Logger logger = Logger.getLogger(UserServiceImpl.class);
	
	@Autowired
	private UserDAO userDAO;

	@Override
	public int registerUser(User user) {
		logger.info("Registration service Invoked");
		return userDAO.insert(user);
	}

	@Override
	public List<User> getAllUsers() {
		logger.info("GetAllUsers service Invoked");
		return userDAO.getAllUsers();
	}

}
