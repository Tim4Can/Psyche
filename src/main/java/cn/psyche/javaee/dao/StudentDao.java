package cn.psyche.javaee.dao;

import cn.psyche.javaee.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StudentDao extends JpaRepository<Student,Integer> {
    Optional<Student> findByIdAndPassword(int id, String pwd);
}
