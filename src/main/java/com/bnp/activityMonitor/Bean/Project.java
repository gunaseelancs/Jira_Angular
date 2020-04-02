package com.bnp.activityMonitor.Bean;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name="project")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Project {
	

    @Id
    @Column(name="project_id")
	private String projectId;
	
    @Column(name="project_name")
	private String projectName;

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
}
