package cn.psyche.javaee.controller;

import cn.psyche.javaee.dao.TreeholeDao;
import cn.psyche.javaee.entity.StudentNoPwd;
import cn.psyche.javaee.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

@RestController
@RequestMapping("/Treehole")
public class TreeholeController {
    @Autowired
    TreeholeService treeholeService;
/*
    //get the first page of treehole list
    @RequestMapping(method= RequestMethod.GET)
    public Result getList(HttpServletRequest request){

        return ResultUtil.success(treeholeService.getTreeholes(0));
    }
*/
    //get certain page of the treehole list
    @RequestMapping(method =RequestMethod.GET)
    public Result getCertainList(@RequestParam(value="page",required = false,defaultValue = "0") int page){

        return ResultUtil.success(treeholeService.getTreeholes(page));
    }

    //check certain treehole and its first page of comments
    @RequestMapping(value="/treehole", method = RequestMethod.GET)
    public Object getTreehole(@RequestParam("id") int id,@RequestParam(value="page",required = false,defaultValue = "0") int page){

        Map<String,Object> map=treeholeService.getTreehole(id,page);
        if(map==null)
            return ResultUtil.error(ResultEnum.NOT_FOUND);
        else
            return ResultUtil.success(map);

    }
/*
    //get certain page of comments
    @RequestMapping(value = "/treehole={id}&page={page}",method = RequestMethod.GET)
    public Result getComments(@PathVariable("id") int id,@PathVariable(value="page") int page){
        Map<String,Object> map=treeholeService.getCommentList(id,page);
        if(map==null)
            return ResultUtil.error(ResultEnum.NOT_FOUND);
        else
            return ResultUtil.success(map);
    }
*/
    //release treehole
    @RequestMapping(value="/sendTreehole")
    public Result sentTreehole(HttpServletRequest request){
        HttpSession session=request.getSession();
        StudentNoPwd s= (StudentNoPwd) session.getAttribute(ConstantUtils.USER_SESSION_KEY);
        int user=s.getId();
        String title=request.getParameter("title");
        String content=request.getParameter("content");
        int anonymous=Integer.parseInt(request.getParameter("anonymous"));
        System.out.println(title+content+anonymous);

        return treeholeService.sendTreehole(title,content,user,anonymous);
    }

    //release comments
    @RequestMapping(value = "/sendComment",method = RequestMethod.POST)
    public Result sentComment(HttpServletRequest request){
        HttpSession session=request.getSession();
        StudentNoPwd s= (StudentNoPwd) session.getAttribute(ConstantUtils.USER_SESSION_KEY);
        int user=s.getId();
        String content=request.getParameter("content");
        int treehole=Integer.parseInt(request.getParameter("treeholeId"));
        int anonymous=Integer.parseInt(request.getParameter("anonymous"));

        return treeholeService.sendComment(content,user,treehole,anonymous);
    }

    //delete my treeehole
    @RequestMapping(value="/deleteTreehole",method = RequestMethod.POST)
    public Result removeTreehole(HttpServletRequest request){
        int id=Integer.parseInt(request.getParameter("id"));
        HttpSession session=request.getSession();
        StudentNoPwd s= (StudentNoPwd) session.getAttribute(ConstantUtils.USER_SESSION_KEY);
        int user=s.getId();
        return treeholeService.deleteTreehole(user,id);
    }

    //delete my comments


}
