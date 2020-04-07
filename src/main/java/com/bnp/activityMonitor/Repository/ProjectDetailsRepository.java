package com.bnp.activityMonitor.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bnp.activityMonitor.Bean.Model.Project;

public interface ProjectDetailsRepository extends JpaRepository<Project, Long> {

}
