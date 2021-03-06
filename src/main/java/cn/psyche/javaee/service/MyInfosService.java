package cn.psyche.javaee.service;

import cn.psyche.javaee.dao.StudentDao;
import cn.psyche.javaee.dao.TreeholeDao;
import cn.psyche.javaee.entity.Student;
import cn.psyche.javaee.entity.Treehole;
import cn.psyche.javaee.entity.HoleList;
import cn.psyche.javaee.util.ConstantUtils;
import cn.psyche.javaee.util.Result;
import cn.psyche.javaee.util.ResultEnum;
import cn.psyche.javaee.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.*;

@Service("myInfosService")
public class MyInfosService {
    private static long myTreeholePg=-1;
    @Autowired
    private TreeholeDao treeholeDao;
    @Autowired
    private StudentDao studentDao;

    @Cacheable(value = "myInfos")
    public Result myInfos(int id){

        Student s=studentDao.findById(id);
        //has been replaced by loginInterceptor
        if(s==null){
            return ResultUtil.error(ResultEnum.NOT_LOGIN);
        }

        return ResultUtil.success(s.copy());
    }

    public Result modifyPwd(String newPwd,String oldPwd,int id){
        Student student=studentDao.findById(id);
        String pwd=student.getPassword();

        if(!pwd.equals(oldPwd)){
            return ResultUtil.error(ResultEnum.PASSWORD_INCORRECT);
        }

        student.setPassword(newPwd);
        studentDao.saveAndFlush(student);
        return ResultUtil.success();
    }

    public Map<String,Object> myTreeholes(int id,int page){

        Sort sort = Sort.by(Sort.Direction.DESC,"id");
        Page<Treehole> pg=treeholeDao.findByOwnerId(id,PageRequest.of(page, ConstantUtils.TREEHOLE_PAGE_SIZE,sort));
        List<Treehole> treeholes=pg.getContent();
        System.out.println("It's called here when there's no cache！");

        //no treeholes
        if(treeholes==null){
            return null;
        }

        //set pageCount
        if(myTreeholePg==-1){
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
        map.put("total",myTreeholePg);
        map.put("list",treeholeList);

        return map;
    }

    public void refreshTreeholePg(){
        myTreeholePg=treeholeDao.count()/ConstantUtils.TREEHOLE_PAGE_SIZE;
        if(treeholeDao.count()%ConstantUtils.TREEHOLE_PAGE_SIZE==0){
            myTreeholePg-=1;
        }
        //System.out.println(treeholePgCount+" "+treeholeDao.count());
    }

}
