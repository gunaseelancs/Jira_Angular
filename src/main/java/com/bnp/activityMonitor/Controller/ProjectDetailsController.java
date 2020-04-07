package com.bnp.activityMonitor.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bnp.activityMonitor.Bean.Model.Project;
import com.bnp.activityMonitor.Repository.ProjectDetailsRepository;



@RestController
@RequestMapping("/project")
public class ProjectDetailsController {

	@Autowired
	ProjectDetailsRepository projectDetailsController;
	
	@RequestMapping("/DBProjectDetails")
	public List<Project> getProjectrDetails() {
		List<Project> projectList=projectDetailsController.findAll();
		return projectList	;
	}
	
	
}
