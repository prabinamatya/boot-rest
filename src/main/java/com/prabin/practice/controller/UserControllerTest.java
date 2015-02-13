package com.prabin.practice.controller;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.prabin.practice.domain.User;
import com.prabin.practice.service.UserService;

@RunWith(MockitoJUnitRunner.class)
public class UserControllerTest {

	@Mock
	private UserService userService;
	
	@Mock
	private UserController userController;
	
	@Test
	public void testShouldCreateUser() throws Exception {
		User savedUser = stubServiceToReturnStoredUser();
		
		User user = new User();
		User returnedUser = userController.createUser(user);
		
		verify(userService, times(1)).save(user);
		assertEquals(savedUser, returnedUser);
	}

	private User stubServiceToReturnStoredUser() {
		User user = new User();
		when(userService.save(any(User.class))).thenReturn(user);
		return user;
	}
}
