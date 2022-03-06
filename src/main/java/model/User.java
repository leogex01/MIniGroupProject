package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *@author roman-rggeleta@dmacc.edu
 *CIS175-Spring 2022
 *Mar 4, 2022
 */
@Entity
@Table (name = "users")   //table name
public class User {
	@Id
	@GeneratedValue
	@Column(name = "USERSID")
	private int userId;
	private String userName;
 
	
	public User() {
		// TODO Auto-generated constructor stub
	}



	public User(int userId, String userName) {
		super();
		this.userId = userId;
		this.userName = userName;
	}


	public User(String userName) {
		super();
		this.userName = userName;
	}



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
	
	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + "]";
	}


}
