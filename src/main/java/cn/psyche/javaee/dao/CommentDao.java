package cn.psyche.javaee.dao;

import cn.psyche.javaee.entity.Comment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentDao extends JpaRepository<Comment,Integer> {
    Page<Comment> findByTreeHoleId(int treeHoleId, Pageable pegeable);
    long countByTreeHoleId(int treeholeId);
}
