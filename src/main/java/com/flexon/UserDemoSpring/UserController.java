package com.flexon.UserDemoSpring;

import java.time.LocalDate;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.flexon.UserDemoSpring.User;
import com.flexon.UserDemoSpring.User.Gender;

@RestController
public class UserController {
	@Autowired
	private UserDAO userService;
	
	@GetMapping(path="/printAllUsers")
	public ArrayList<User> printAllUsers() {
		return userService.userData;
	}
	
	@PostMapping(path="/addUser")
	@ResponseStatus(HttpStatus.OK)
	public String addUser(@RequestBody User newUser) {
		userService.addUser(newUser);
		return "User added successfully!";
	}

}
