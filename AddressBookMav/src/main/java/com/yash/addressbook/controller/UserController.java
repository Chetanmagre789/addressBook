package com.yash.addressbook.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.yash.addressbook.model.User;
import com.yash.addressbook.service.UserService;

@RestController
public class UserController {
	
	Logger logger = Logger.getLogger(UserController.class);

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String registerUser(@RequestParam String name, @RequestParam String email, @RequestParam String contact) {
		logger.info("Registration Controller Invoked");
		User user = new User();
		user.setName(name);
		user.setEmail(email);
		user.setContact(contact);
		int status = userService.registerUser(user);
		if (status > 0) {
			return "User saved : " + name + " contact : " + contact;
		} else {
			return "error";
		}
	}

}
