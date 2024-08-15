package com.Registration.Service;

import java.util.List;

import com.Registration.modal.User;

public interface UserService {

	public User addUser(User user);

	public List<User> getAllUser();
	
}
