package com.javaee.psyche.dao;

import com.javaee.psyche.entity.Test;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestDao extends JpaRepository<Test,Integer> {
}
