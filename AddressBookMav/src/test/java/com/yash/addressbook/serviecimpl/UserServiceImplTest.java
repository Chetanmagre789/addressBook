package com.yash.addressbook.serviecimpl;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.yash.addressbook.model.User;
import com.yash.addressbook.service.UserService;

public class UserServiceImplTest {

	@Mock
	private UserService userService;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void test_for_registerUser_if_registered_return1() {
		when(userService.registerUser(any(User.class))).thenReturn(1);
		User user = new User();
		assertEquals(1, userService.registerUser(user));
	}

	@Test
	public void test_for_getAllUsers_if_any_return_list_of_Users() {
		List<User> users = new ArrayList<>();
		when(userService.getAllUsers()).thenReturn(users);
		assertEquals(users, userService.getAllUsers());
	}

}
