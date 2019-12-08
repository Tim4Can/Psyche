package cn.psyche.javaee.dao;

import cn.psyche.javaee.entity.Treehole;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TreeholeDao extends JpaRepository<Treehole,Integer> {
   // List<Treehole> findByOwnerId(int id);
    Treehole findById(int id);
    //Page<Treehole> findAll(Pageable pegeable);
    Page<Treehole> findAll(Pageable pegeable);
    Page<Treehole> findByOwnerId(int id,Pageable pegeable);
    long count();
}
