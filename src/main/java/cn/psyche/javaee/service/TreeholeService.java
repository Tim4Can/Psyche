package cn.psyche.javaee.service;

import cn.psyche.javaee.dao.CommentDao;
import cn.psyche.javaee.dao.TreeholeDao;
import cn.psyche.javaee.entity.Comment;
import cn.psyche.javaee.entity.Treehole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("treeholeService")
public class TreeholeService {
    @Autowired
    TreeholeDao treeholeDao;
    @Autowired
    CommentDao commentDao;
    private long treeholePgCount=-1;
    private long commentPgCount=-1;

    public Result getTreehole(int id){
        Map<String,Object> map=new HashMap<String, Object>();
        Treehole  treehole=treeholeDao.findById(id);
        if(treehole==null){
            System.out.println("treehole not exists.");
            return ResultUtil.error(ResultEnum.NOT_FOUND);
        }

        List<Comment> comments=getList(id,0);
        map.put("treehole",treehole);
        map.put("comments",comments);
        return ResultUtil.success(map);
    }

    public List<Comment> getList(int treeholeId, int page){
        Page<Comment> pg=commentDao.findByTreeHoleId(treeholeId,PageRequest.of(page,ConstantUtils.DEFAULT_PAGE_SIZE));
        List<Comment> list=pg.getContent();
        return list;
    }

    public Result getAllTreeholes(int page){
        this.treeholePgCount=treeholeDao.count()/ConstantUtils.DEFAULT_PAGE_SIZE;
        Page<Treehole> pg=treeholeDao.findAll(PageRequest.of(page,ConstantUtils.DEFAULT_PAGE_SIZE));
        List<Treehole> list=pg.getContent();
        return ResultUtil.success(list);
    }
}
