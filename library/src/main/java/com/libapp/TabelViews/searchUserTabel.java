package com.libapp.TabelViews;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class searchUserTabel {
	
	private SimpleIntegerProperty userId;
	private SimpleStringProperty userName;
	private SimpleStringProperty userEmail;
	private SimpleStringProperty userPhone;
	private SimpleStringProperty userPass;
	private SimpleStringProperty userRole;
	private SimpleStringProperty registrationDate;
	
	public searchUserTabel(SimpleIntegerProperty userId, SimpleStringProperty userName, SimpleStringProperty userEmail,
			SimpleStringProperty userPhone, SimpleStringProperty userPass, SimpleStringProperty userRole,
			SimpleStringProperty registrationDate) {
	    // super();
		this.userId = userId;
		this.userName = userName;
		this.userEmail = userEmail;
		this.userPhone = userPhone;
		this.userPass = userPass;
		this.userRole = userRole;
		this.registrationDate = registrationDate;
	}
	
	     public int getId() {
	        return userId.get();
	    }

	    public SimpleIntegerProperty idProperty()
	    { 
	    	return userId; 
	    }

	    public void setId(int id) {
	        this.userId.set(id);
	    }
	    
	    public String getUserName() {
	    	return userName.get();
	    }
	    
	    public SimpleStringProperty userNameProperty() {
	    	return userName;
	    }
	    
	    public void setUserName(String name) {
	    	this.userName.set(name);
	    }
	    
	    public String getUserEmail() {
	    	return userEmail.get();
	    }
	    
	    public SimpleStringProperty userEmailProperty() {
	    	return userEmail;
	    }
	    
	    public void setUserEmail(String email) {
	    	this.userName.set(email);
	    }

		public String getUserPhone() {
			return userPhone.get();
		}
		
		 public SimpleStringProperty userPhoneProperty() {
		    	return userPhone;
		    }

		public void setUserPhone(String userPhone) {
			this.userPhone.set(userPhone);
		}

		public String getUserPass() {
			return userPass.get();
		}

		 public SimpleStringProperty userPassProperty() {
		    	return userPass;
		    }
		public void setUserPass(String userPass) {
			this.userPass.set(userPass);
		}

		public String getUserRole() {
			return userRole.get();
		}

		 public SimpleStringProperty userRoleProperty() {
		    	return userRole;
		    }
		public void setUserRole(String userRole) {
			this.userRole.set(userRole);
		}

		public String getRegistrationDate() {
			return registrationDate.get();
		}

		public void setRegistrationDate(String registrationDate) {
			this.registrationDate.set(registrationDate);
		}

		@Override
		public String toString() {
			return "searchUserTabel [userId=" + userId + ", userName=" + userName + ", userEmail=" + userEmail
					+ ", userPhone=" + userPhone + ", userPass=" + userPass + ", userRole=" + userRole
					+ ", registrationDate=" + registrationDate + "]";
		}
	    
	    
	
}
