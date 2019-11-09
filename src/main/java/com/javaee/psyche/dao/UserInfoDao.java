package com.javaee.psyche.dao;

import com.javaee.psyche.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository("UserInfo")
public interface UserInfoDao extends JpaRepository<User,Integer>, JpaSpecificationExecutor {
}
