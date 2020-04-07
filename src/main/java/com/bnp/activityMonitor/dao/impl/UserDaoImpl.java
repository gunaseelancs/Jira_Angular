package com.bnp.activityMonitor.dao.impl;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atlassian.jira.rest.client.api.ExpandableProperty;
import com.atlassian.jira.rest.client.api.JiraRestClient;
import com.atlassian.jira.rest.client.api.UserRestClient;
import com.atlassian.jira.rest.client.api.domain.User;
import com.atlassian.jira.rest.client.internal.async.AsynchronousJiraRestClientFactory;
import com.bnp.activityMonitor.Common.DataExtractor;
import com.bnp.activityMonitor.dao.UserDAO;

import io.atlassian.util.concurrent.Promise;

@Service
public class UserDaoImpl implements UserDAO{
	
	@Autowired
	DataExtractor dataExtractor;
		
	@Override
	public com.bnp.activityMonitor.Bean.User getuserById(String userId) throws InterruptedException, ExecutionException, URISyntaxException {

		UserRestClient client=dataExtractor.getJRC().getUserClient();
		Promise<User> promusers=client.getUser("gunaseelancs");
		return setUsertDetails(promusers.get(),new com.bnp.activityMonitor.Bean.User());
	}

	private com.bnp.activityMonitor.Bean.User setUsertDetails(User promuser, com.bnp.activityMonitor.Bean.User user) {
		
		user.setAccountId(promuser.getAccountId());
		user.setEmailAddress(promuser.getEmailAddress());
		user.setName(promuser.getName());
		user.setUri(promuser.getSelf().toString());
		user.setTimezone(promuser.getTimezone());		
		ExpandableProperty<String> groups=promuser.getGroups();
		if(groups!=null && groups.getSize()>0) {
			Iterable<String> versions= groups.getItems();
			Iterator<String> itr=versions.iterator();	
			List<String> groupList=new ArrayList<>();
			while(itr.hasNext()) {
				groupList.add(itr.next());
			}
			user.setGroups(groupList);		
		}

		return user;
	}

	@Override
	public List<com.bnp.activityMonitor.Bean.User> finduserByName(String userId) throws URISyntaxException, InterruptedException, ExecutionException {
		List<com.bnp.activityMonitor.Bean.User> userList=new ArrayList<>();
		UserRestClient client=dataExtractor.getJRC().getUserClient();
		Promise<Iterable<User>> promuser=client.findUsers(userId);
		Iterable<User> users= promuser.get();
		Iterator<User> itr=users.iterator();
		while(itr.hasNext()) {
			User puser=itr.next();
			userList.add(puser!=null?setUsertDetails(puser,new com.bnp.activityMonitor.Bean.User()):new com.bnp.activityMonitor.Bean.User());
		}
		return userList;
	}

	@Override
	public List<com.bnp.activityMonitor.Bean.User> getAllUsers()
			throws URISyntaxException, InterruptedException, ExecutionException {
		//in-devolepment
		return null;
	}

}
