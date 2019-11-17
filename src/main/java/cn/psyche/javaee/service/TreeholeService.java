package cn.psyche.javaee.service;

import cn.psyche.javaee.dao.CommentDao;
import cn.psyche.javaee.dao.TreeholeDao;
import cn.psyche.javaee.entity.Comment;
import cn.psyche.javaee.entity.Treehole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("treeholeService")
public class TreeholeService {
    @Autowired
    TreeholeDao treeholeDao;
    @Autowired
    CommentDao commentDao;

    public Treehole getTreehole(int id){
        return  treeholeDao.findById(id);
    }


}
