package cn.psyche.javaee.dao;

import cn.psyche.javaee.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository("StudentInfo")
public interface StudentInfoDao extends JpaRepository<Student,Integer> {

}