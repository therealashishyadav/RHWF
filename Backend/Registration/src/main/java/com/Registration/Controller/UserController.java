package com.Registration.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Registration.Service.UserService;
import com.Registration.modal.User;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/user")

public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping("/")
	public ResponseEntity<User> addUser(@RequestBody User user) {
		try {
			User local = userService.addUser(user);
			return new ResponseEntity<>(local, HttpStatus.OK);
		} catch (Exception e) {
			System.out.println(e);
			return new ResponseEntity<>(null, HttpStatus.CONFLICT);
		}
	}

	@GetMapping("/")
	public ResponseEntity<List<User>> getAllUser(){
		List<User> user = userService.getAllUser();
		return ResponseEntity.ok(user);
	}
	
	
}