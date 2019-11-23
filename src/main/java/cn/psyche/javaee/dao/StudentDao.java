package cn.psyche.javaee.dao;

import cn.psyche.javaee.entity.Student;
import cn.psyche.javaee.entity.StudentNoPwd;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;

import java.util.Optional;

public interface StudentDao extends JpaRepository<Student,Integer> {

   Optional<StudentNoPwd> findByIdAndPassword(int id, String pwd);


}
