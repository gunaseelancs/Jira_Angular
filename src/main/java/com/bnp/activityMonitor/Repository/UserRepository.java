package com.bnp.activityMonitor.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bnp.activityMonitor.Bean.UserBean;


public interface UserRepository extends JpaRepository<UserBean, Long>{

}