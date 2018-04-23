package com.yash.addressbook.daoimpl;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.yash.addressbook.dao.UserDAO;
import com.yash.addressbook.model.User;

public class UserDAOImplTest {

	@Mock
	private UserDAO userDAO;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void test_for_insert_method_if_inserted_return1() {
		when(userDAO.insert(any(User.class))).thenReturn(1);
		User user = new User();
		assertEquals(1, userDAO.insert(user));
	}
	
	@Test
	public void test_for_insert_method_if_not_inserted_return0() {
		when(userDAO.insert(any(User.class))).thenReturn(0);
		User user = new User();
		assertEquals(0, userDAO.insert(user));
	}
	
	@Test
	public void test_for_getAllUsers_method_if_any_return_list_of_users() {
		List<User> users = new ArrayList<>();
		when(userDAO.getAllUsers()).thenReturn(users);
		assertEquals(users, userDAO.getAllUsers());
	}
	
	@Test
	public void test_for_getAllUsers_method_if_any_return_null_list_of_users() {
		List<User> users = null;
		when(userDAO.getAllUsers()).thenReturn(users);
		assertEquals(null, userDAO.getAllUsers());
	}
}
