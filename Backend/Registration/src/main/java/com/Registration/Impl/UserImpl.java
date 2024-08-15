package com.Registration.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Registration.Service.UserService;
import com.Registration.Service.Repository.UserRepository;
import com.Registration.modal.User;

@Service
public class UserImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public User addUser(User user) {
		if (userRepository.existsByUsername(user.getUsername())) {
			System.out.println("User Already Exists");
			return null;
		} else {
			User local = this.userRepository.save(user);
			return local;
		}
	}

	@Override
	public List<User> getAllUser() {
		return this.userRepository.findAll();
	}
}
