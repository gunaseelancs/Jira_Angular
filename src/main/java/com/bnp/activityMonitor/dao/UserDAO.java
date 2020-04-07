package com.bnp.activityMonitor.dao;

import java.net.URISyntaxException;
import java.util.List;
import java.util.concurrent.ExecutionException;

import org.springframework.stereotype.Service;

import com.bnp.activityMonitor.Bean.User;

public interface UserDAO {

	public User getuserById(String userId) throws InterruptedException, ExecutionException, URISyntaxException;
	

	public List<User> finduserByName(String userId) throws URISyntaxException, InterruptedException, ExecutionException;


	List<User> getAllUsers() throws URISyntaxException, InterruptedException, ExecutionException;
}
