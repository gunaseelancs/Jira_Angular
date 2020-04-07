package com.bnp.activityMonitor.Bean.Model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name="user")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class User{

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="user_id")
	private String userId;
    
    @Column(name="user_name")
	private String userName;
    
    @Column(name="role")
	private String role;
    
    
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}


}
