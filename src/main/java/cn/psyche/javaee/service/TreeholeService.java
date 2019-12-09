package cn.psyche.javaee.service;

import cn.psyche.javaee.dao.CommentDao;
import cn.psyche.javaee.dao.StudentDao;
import cn.psyche.javaee.dao.TreeholeDao;
import cn.psyche.javaee.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

@Service("treeholeService")
public class TreeholeService {
    @Autowired
    private TreeholeDao treeholeDao;
    @Autowired
    private CommentDao commentDao;
    @Autowired
    private StudentDao studentDao;
    private static long treeholePgCount=-1; //pages count from 0
    private static long commentPgCount=-1;//pages count from 0


    //get certain page of treehole
   public Map<String,Object> getTreeholes(int page){
        Sort sort = Sort.by(Sort.Direction.DESC,"id");
        Page<Treehole> pg=treeholeDao.findAll(PageRequest.of(page,ConstantUtils.TREEHOLE_PAGE_SIZE,sort));
        List<Treehole> treeholes=pg.getContent();

        //no treeholes
        if(treeholes==null){
            return null;
        }

        //set pageCount
       if(this.treeholePgCount==-1){
           refreshTreeholePg();
           //System.out.println(treeholePgCount);
       }

        //only send part of the treehole infos to the frontend
        HoleList[] list=new HoleList[treeholes.size()];
        for(int i=0;i<treeholes.size();i++){
            list[i]=new HoleList();
            list[i].setByTreehole(treeholes.get(i));

        }
        List treeholeList = new ArrayList(Arrays.asList(list));

        //return page
       Map<String,Object> map=new HashMap<String, Object>();
       map.put("current",page);
       map.put("total",this.treeholePgCount);
       map.put("list",treeholeList);

        return map;
    }

    //get certain page of comments
    public Map<String,Object> getCommentList(int treeholeId, int page){
        Sort sort = Sort.by(Sort.Direction.ASC,"id");
        Page<Comment> pg=commentDao.findByTreeHoleId(treeholeId,PageRequest.of(page,ConstantUtils.COMMENT_PAGE_SIZE,sort));

        //not found
        if(pg==null){
            return null;
        }
        //refresh
        refreshCommentPg(treeholeId);

        //pass by HashMap
        List<Comment> list=pg.getContent();
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("current",page);
        map.put("total",this.commentPgCount);
        map.put("comment",list);

        return map;
    }

    //check certain treehole and its comments
    public Map<String,Object> getTreehole(int treeholeId,int page){
        Map<String,Object> map=new HashMap<String, Object>();

        //get treehole
        Treehole  treehole=treeholeDao.findById(treeholeId);

        //not found
        if(treehole==null){
            System.out.println("treehole not exists.");
            return null;
        }
        //refresh comment page
        refreshCommentPg(treeholeId);
        //get comments
        Map<String,Object> comments=getCommentList(treeholeId,page);
        //send treehole and its comments
        if(treehole.getAnonymous()==0){
            Student owner=studentDao.findById(treehole.getOwnerId());
            map.put("owner",owner.getNickName());
        }
        map.put("treehole",treehole);
        map.put("comments",comments);
        return map;
    }

    //release treehole
    public Result sendTreehole(String title,String content,int id,int anonymous){
       Treehole treehole=new Treehole();
       Calendar calendar=Calendar.getInstance();
       treehole.setSendTime(calendar.getTime());
       treehole.setTitle(title);
       treehole.setContent(content);
       treehole.setAnonymous(anonymous);
       treehole.setOwnerId(id);
       treeholeDao.saveAndFlush(treehole);

       refreshTreeholePg();
       return ResultUtil.success();
    }

    //delete treehole
    public Result deleteTreehole(int user,int treeholeId){
       Treehole treehole=treeholeDao.findById(treeholeId);
       //no such treehole
       if(treehole==null){
           return ResultUtil.error(ResultEnum.NOT_FOUND);
       }
       //check authority
       int owner=treehole.getOwnerId();
       if(owner!=user){
           return ResultUtil.error(ResultEnum.UNAUTHORIZED);
       }

        treeholeDao.deleteById(treeholeId);
        //refresh page
        refreshTreeholePg();
        return ResultUtil.success();
    }

    //send comment
    public Result sendComment(String content,int speaker,int treehole,int anonymous){
       Comment comment=new Comment();
       Calendar calendar=Calendar.getInstance();
       comment.setSendTime(calendar.getTime());
       comment.setTreeHoleId(treehole);
       comment.setSpeakerId(speaker);
       comment.setContent(content);
       if(anonymous==1){
           comment.setAnonymous(1);
       }else{
           comment.setSpeakerName(studentDao.findById(speaker).getNickName());
       }
       commentDao.saveAndFlush(comment);

       refreshCommentPg(treehole);
       return ResultUtil.success(comment);
    }

    public void refreshCommentPg(int id){
        this.commentPgCount=commentDao.countByTreeHoleId(id)/ConstantUtils.COMMENT_PAGE_SIZE;
        if(commentDao.count()%ConstantUtils.COMMENT_PAGE_SIZE==0) {
            this.commentPgCount -= 1;
        }
    }

    public void refreshTreeholePg(){
       treeholePgCount=treeholeDao.count()/ConstantUtils.TREEHOLE_PAGE_SIZE;
       if(treeholeDao.count()%ConstantUtils.TREEHOLE_PAGE_SIZE==0){
           treeholePgCount-=1;
       }
        //System.out.println(treeholePgCount+" "+treeholeDao.count());
    }
}
