package com.flexon.UserDemoSpring;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class User {
	
	public enum Gender {Male, Female, Other};
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long userId;
	
	private String firstName;
	private String lastName;
	private String emailAddress;
	
	@JsonIgnore  //filter this in response
	private String password;
	private LocalDate birthday;
	private Gender gender;
	
	public User() {
		
	}
	
	public User (String firstName, 
			     String lastName, 
			     String emailAddress, 
			     String password,
			     Gender gender,
			     LocalDate birthday) {
		setFirstName(firstName);
		setLastName(lastName);
		setEmailAddress(emailAddress);
		setPassword(password);
		setGender(gender);
		setBirthday(birthday);
	}
	
	public long getUserId() {
		return userId;
	}
	public void setUserID(long id) {
		this.userId = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		if (!validateName(firstName)) {
			System.out.println(firstName + " is not a valid name.");
			throw new IllegalArgumentException("Please enter a valid name.");
		}
		this.firstName = firstName.toLowerCase();
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		if (!validateName(lastName)) {
			System.out.println(lastName + " is not a valid name.");
			throw new IllegalArgumentException("Please enter a valid name.");
		}
		this.lastName = lastName.toLowerCase();
	}
	
	private boolean validateName(String s) {
		return s.matches("^[a-zA-Z]+([ '-][a-zA-Z]+)*");
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		if (!emailAddress.matches("^[a-zA-Z0-9+-._]+@+[a-zA-Z0-9.-]+$")) {
			System.out.println(emailAddress + " is not a valid email.");
			throw new IllegalArgumentException("Please enter a valid email address.");
		}
		this.emailAddress = emailAddress;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		if (!password.matches("((?=.*[a-z])(?=.*\\d)(?=.*[@#$%!])(?=.*[A-Z]).{6,16})")) {
			System.out.println(password + " is not an valid password");
			System.out.println("password needs to have at least one lowercase letter,\n"
					  + "at least one digit, \n"
					  + "at least one special character, \n"
					  + "at least one capital letter. ");
			throw new IllegalArgumentException("Please enter a valid password.");
		}
		this.password = password;
	}

	public LocalDate getBirthday() {
		return birthday;
	}

	public void setBirthday(LocalDate birthday) {
		this.birthday = birthday;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}
	
	@Override
	public String toString() {
		return "User [userID=" + userId + ", firstname=" + firstName + ", lastname=" + lastName + ", email="
				+ emailAddress + "]";
	}
}