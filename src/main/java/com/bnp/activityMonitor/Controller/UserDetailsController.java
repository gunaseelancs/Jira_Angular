package com.bnp.activityMonitor.Controller;

import java.net.URISyntaxException;
import java.util.List;
import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bnp.activityMonitor.Bean.User;
import com.bnp.activityMonitor.Repository.UserRepository;
import com.bnp.activityMonitor.dao.impl.UserDaoImpl;

@RestController
@RequestMapping("/user")
public class UserDetailsController {
	
	@Autowired
	UserRepository userDetailsRepository;
	
	@Autowired
	UserDaoImpl userDAOImpl;
		
	@RequestMapping("/DBuser")
	public List<com.bnp.activityMonitor.Bean.Model.User> getUserDetails() {
		List<com.bnp.activityMonitor.Bean.Model.User> userList=userDetailsRepository.findAll();
		return userList	;
	}
	
	@RequestMapping("/getUserDetailsById")
	public User getUserDetailsById(@RequestParam(name="userId", required = false, defaultValue = "") String userId) throws InterruptedException, ExecutionException, URISyntaxException {
		User user=userDAOImpl.getuserById(userId);
		return user	;
	}
	
	@RequestMapping("/getUserDetailsByName")
	public List<User> getUserDetailsByName(@RequestParam(name="userId", required = false, defaultValue = "") String userId) throws InterruptedException, ExecutionException, URISyntaxException {
		List<User> userList=userDAOImpl.finduserByName(userId);
		return userList	;
	}
	
	@RequestMapping("/getAllUsers")
	public List<User> getUserDetailsByName() throws InterruptedException, ExecutionException, URISyntaxException {
		List<User> userList=userDAOImpl.getAllUsers();
		return userList;
	}
	
	//adduser(), updateuser(), removeUser() apis in devolepment
}
