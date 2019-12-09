package com.javaee.psyche.dao;

import com.javaee.psyche.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository("StudentInfo")
public interface StudentInfoDao extends JpaRepository<Student,Integer> {

}