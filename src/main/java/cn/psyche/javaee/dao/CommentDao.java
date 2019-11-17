package cn.psyche.javaee.dao;

import cn.psyche.javaee.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentDao extends JpaRepository<Comment,Integer> {
    List<Comment> findByTreeHoleId(int id);
}
