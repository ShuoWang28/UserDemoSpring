package com.flexon.UserDemoSpring;

import java.time.LocalDate;
import java.util.ArrayList;

import org.springframework.stereotype.Component;

import com.flexon.UserDemoSpring.User.Gender;

@Component
public class UserDAO {
	
	public ArrayList<User> userData = new ArrayList<User>();
	
	public UserDAO() {
		init();
	}
	
	//Create / insert a User
	public void addUser(User user) {
		userData.add(user);
	}
	
	public void init() {
		User user1 = new User("John", 
	            "Mike", 
	            "john@gmail.com", 
	            "dasDDF3D3#", 
	            Gender.Male, 
	            LocalDate.of(1950, 10, 10));
		userData.add(user1);
	}
	
	// Delete a user by it's email
	public void deleteUser(String email) {
		User user = findUser(email);
		if (user == null) {
			return;
		}
		userData.remove(user);
		System.out.println("Now user is deleted \n");
	}
	
	// find first user by email. Return null if such user doesn't exist
	public User findUser(String email) {
		for (int i = 0; i < userData.size(); i++) {
			if (userData.get(i).getEmailAddress().equals(email)) {
				printUserInfo(userData.get(i));
				return userData.get(i);
			}
		}
		System.out.println("User does not exist.");
		return null;
	}
	
	// print a user information
	public void printUserInfo(User user) {
		System.out.println("User first name is: " + user.getFirstName());
		System.out.println("User last name is: " + user.getLastName());
		System.out.println("User birthday is: " + user.getBirthday().toString());
		System.out.println("User email is: " + user.getEmailAddress()); 
	}
	
	// print all users
	public void printAll() {
		System.out.println("Print all users : \n");
		for (int i = 0; i < userData.size(); i++) {
			System.out.println("No." + (i + 1) + " user: ");
			printUserInfo(userData.get(i));
			System.out.println("********");
		}
		System.out.println();
	}
}
