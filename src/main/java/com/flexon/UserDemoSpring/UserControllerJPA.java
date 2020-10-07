package com.flexon.UserDemoSpring;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserControllerJPA {

	@Autowired
	private UserRepository userRepo;
	
	//Get all users from the Arraylist
	@GetMapping(path="/jpa/getAllUsers")
	public List<User> getAllStudents(){
		return userRepo.findAll();		
	}
		
	//Adding a new user into the account
	@PostMapping(path="/jpa/addNewUser")
	public ResponseEntity addNewUser(@RequestBody User newUser){
		userRepo.save(newUser);
			
		return new ResponseEntity<>("Created new user",HttpStatus.CREATED);
	}
	
	//Update a user password 
	@PutMapping(path="/jpa/updatePassword/{id}")
	public ResponseEntity changePassword(String newPassword, @PathVariable Long id) {
		Optional<User> user = userRepo.findById(id);
		user.get().setPassword(newPassword);
		return new ResponseEntity<>("Password updated",HttpStatus.CREATED);
	}
	
	//Delete a user by it's id
	@DeleteMapping(path="/jpa/deleteUser/{id}")
	public ResponseEntity deleteUser(@PathVariable Long id) {
		userRepo.deleteById(id);
		
		return new ResponseEntity<>("User :" + id + " deleted.",HttpStatus.ACCEPTED);
	}

}
