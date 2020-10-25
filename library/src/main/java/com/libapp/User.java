package com.libapp;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="USERS")
public class User {
private int userId;
private String userName;
private String userEmail;
private String userPhone;
private String userPass;


private Role userRole;


public User() {
	super();
	// TODO Auto-generated constructor stub
}

public User(String userName, String userEmail, String userPhone, String userPass, Role userRole) {
	super();
	this.userName = userName;
	this.userEmail = userEmail;
	this.userPhone = userPhone;
	this.userPass = userPass;
	this.userRole = userRole;
}

@Id
@Column(name = "UserId")
@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "c_generator")
@SequenceGenerator(name = "c_generator", sequenceName = "USERS_SEQUENCE",allocationSize = 1,initialValue = 1)
public int getUserId() {
	return userId;
}
public void setUserId(int userId) {
	this.userId = userId;
}
public String getUserName() {
	return userName;
}
public void setUserName(String userName) {
	this.userName = userName;
}
public String getUserEmail() {
	return userEmail;
}
public void setUserEmail(String userEmail) {
	this.userEmail = userEmail;
}
public String getUserPhone() {
	return userPhone;
}
public void setUserPhone(String userPhone) {
	this.userPhone = userPhone;
}
public String getUserPass() {
	return userPass;
}
public void setUserPass(String userPass) {
	this.userPass = userPass;
}

@ManyToOne(cascade = CascadeType.ALL)
public Role getUserRole() {
	return userRole;
}

public void setUserRole(Role userRole) {
	this.userRole = userRole;
}

@Override
public String toString() {
	return "User [userId=" + userId + ", userName=" + userName + ", userEmail=" + userEmail + ", userPhone=" + userPhone
			+ ", userPass=" + userPass + ", userRole=" + userRole + "]";
}




}
