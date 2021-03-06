package cn.psyche.javaee.controller;

import cn.psyche.javaee.service.*;
import cn.psyche.javaee.util.ConstantUtils;
import cn.psyche.javaee.util.Result;
import cn.psyche.javaee.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/User")
public class StudentController {

    @Autowired
    private LoginService loginService;
    @Autowired
    private MyInfosService myInfosService;


    @RequestMapping("/login")
    public Result login(HttpServletRequest request){
        int id=Integer.parseInt(request.getParameter("id"));
        String pwd=request.getParameter("pwd");
        HttpSession session=request.getSession();

        return loginService.login(id,pwd,session);
    }

    @RequestMapping(value = "/myInfos",method = RequestMethod.GET)
    public Result getMyInfos(HttpServletRequest request){
        HttpSession session=request.getSession();
        int id=(int) session.getAttribute(ConstantUtils.USER_SESSION_KEY);

        return myInfosService.myInfos(id);
    }

    @RequestMapping(value = "/myTreeholes",method = RequestMethod.GET)
    public Result getMyTreeholes(HttpServletRequest request,@RequestParam(value="page",required = false,defaultValue = "0") int page){
        HttpSession session=request.getSession();
        int id=(int) session.getAttribute(ConstantUtils.USER_SESSION_KEY);
        System.out.println("Redis test:");
        return ResultUtil.success(myInfosService.myTreeholes(id,page));
    }

    @RequestMapping(value = "/modifyPwd")
    public Result modifyPwd(HttpServletRequest request){
        HttpSession session=request.getSession();
        int id=(int) session.getAttribute(ConstantUtils.USER_SESSION_KEY);
        String newPwd=request.getParameter("newPwd");
        String oldPwd=request.getParameter("oldPwd");

        return myInfosService.modifyPwd(newPwd,oldPwd,id);
    }

    @RequestMapping(value="/loginOut")
    public Result loginOut(HttpServletRequest request){
        HttpSession session=request.getSession();
        session.invalidate();
        return ResultUtil.success();
    }







/*
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Student getUserById(@PathVariable("id") int id) {
        return studentDao.findById(id).orElse(null);
    }

    @RequestMapping(value="/{id}",method=RequestMethod.PUT)
    public String updatePerson(@PathVariable("id") int id,
                               @RequestParam (value="name",required = true) String name){
        Student user=new Student();
        user.setName(name);
        user.setId(id);
        Student u1= studentDao.saveAndFlush(user);

        return u1.toString();
    }
*/

}
