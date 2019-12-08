package cn.psyche.javaee.dao;

import cn.psyche.javaee.entity.Teacher;
import cn.psyche.javaee.entity.Treehole;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherDao extends JpaRepository<Teacher,Integer> {
    Page<Teacher> findAll(Pageable pegeable);

}
