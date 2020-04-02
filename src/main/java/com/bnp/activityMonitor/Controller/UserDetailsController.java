package com.bnp.activityMonitor.Controller;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.atlassian.jira.rest.client.api.domain.User;
import com.atlassian.jira.rest.client.api.domain.Version;
import com.bnp.activityMonitor.Bean.Project;
import com.bnp.activityMonitor.Bean.UserBean;
import com.bnp.activityMonitor.Common.DataExtractor;
import com.bnp.activityMonitor.Repository.ProjectDetailsRepository;
import com.bnp.activityMonitor.Repository.UserRepository;

@RestController
@RequestMapping("")
public class UserDetailsController {
	
	@Autowired
	UserRepository userDetailsRepository;
	
	@Autowired
	ProjectDetailsRepository projectDetailsController;
	
	
	@RequestMapping("/DBProjectDetails")
	public List<Project> getProjectrDetails() {
		List<Project> projectList=projectDetailsController.findAll();
		return projectList	;
	}
	
	@RequestMapping("/JiraReleaseDetails")
	public List<Version> getJiraProjectDetails() throws URISyntaxException, InterruptedException, ExecutionException {
		DataExtractor dataExtractor=new DataExtractor();
		List<Version> releses=dataExtractor.getJiraProjectDetails();
		return releses;
	}
	
	@RequestMapping("/DBuser")
	public List<UserBean> getUserDetails() {
		List<UserBean> userList=userDetailsRepository.findAll();
		return userList	;
	}
	
	@RequestMapping("/JiraUser")
	public User getJiraUserDetails() throws URISyntaxException, InterruptedException, ExecutionException {
		DataExtractor dataExtractor=new DataExtractor();
		User json=dataExtractor.getJiraDetails();
		return json;
	}
	
}
