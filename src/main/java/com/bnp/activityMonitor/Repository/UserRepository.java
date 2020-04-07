package com.bnp.activityMonitor.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bnp.activityMonitor.Bean.Model.User;

public interface UserRepository extends JpaRepository<User, Long>{

}