package cn.psyche.javaee.controller;

import cn.psyche.javaee.dao.StudentDao;
import cn.psyche.javaee.entity.Student;
import cn.psyche.javaee.entity.StudentNoPwd;
import cn.psyche.javaee.service.*;
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
        return myInfosService.myInfos(request);
    }

    @RequestMapping(value = "/myTreeholes",method = RequestMethod.GET)
    public Result getMyTreeholes(HttpServletRequest request,@RequestParam(value="page",required = false,defaultValue = "0") int page){
        HttpSession session=request.getSession();
        StudentNoPwd s=(StudentNoPwd) session.getAttribute(ConstantUtils.USER_SESSION_KEY);
        return ResultUtil.success(myInfosService.myTreeholes(s,page));
    }

    @RequestMapping(value = "/modifyPwd")
    public Result modifyPwd(HttpServletRequest request){
        HttpSession session=request.getSession();
        StudentNoPwd s=(StudentNoPwd) session.getAttribute(ConstantUtils.USER_SESSION_KEY);
        String newPwd=request.getParameter("newPwd");
        String oldPwd=request.getParameter("oldPwd");

        return myInfosService.modifyPwd(newPwd,oldPwd,s);
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
