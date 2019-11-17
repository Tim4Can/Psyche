package cn.psyche.javaee.service;

import cn.psyche.javaee.dao.TreeholeDao;
import cn.psyche.javaee.entity.Student;
import cn.psyche.javaee.entity.Treehole;
import cn.psyche.javaee.entity.holeList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service("myInfosService")
public class MyInfosService {
    @Autowired
    private TreeholeDao treeholeDao;

    public Result myInfos(HttpServletRequest request){
        HttpSession session=request.getSession();
        Student s=(Student)session.getAttribute(ConstantUtils.USER_SESSION_KEY);
        if(s==null){
            return ResultUtil.error(ResultEnum.NOT_LOGIN);
        }

        return ResultUtil.success(s);
    }

    public Result myTreeholes(Student s){
        if(s==null){
            return ResultUtil.error(ResultEnum.NOT_LOGIN);
        }
        List<Treehole> treeholes=treeholeDao.findByOwnerId(s.getId());
        holeList[] list=new holeList[treeholes.size()];
        for(int i=0;i<treeholes.size();i++){
            list[i]=new holeList();
            list[i].setByTreehole(treeholes.get(i));
            //System.out.println(treeholes.get(i));
            //System.out.println(list[i]);

        }
        List li = new ArrayList(Arrays.asList(list));
        return ResultUtil.success(li);

    }



}
