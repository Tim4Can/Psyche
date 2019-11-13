package cn.psyche.javaee.controller;

import cn.psyche.javaee.dao.StudentDao;
import cn.psyche.javaee.entity.Student;
import cn.psyche.javaee.service.ConstantUtils;
import cn.psyche.javaee.service.Result;
import cn.psyche.javaee.service.LoginService;
import cn.psyche.javaee.service.ResultUtil;
import jdk.nashorn.internal.ir.RuntimeNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/User")
public class StudentController {

    @Autowired
    StudentDao studentDao;
    @Autowired
    private LoginService loginService;


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
        //return "Success";
    }

/*
    @RequestMapping(value="/login/{id}",method=RequestMethod.PUT)
    public Result login(@PathVariable("id") int id,
                        @RequestParam (value="pwd",required = true) String pwd){
        return loginService.login(id,pwd);
    }
*/
    @RequestMapping("/login")
    public Result login(HttpServletRequest request){
        int id=Integer.parseInt(request.getParameter("id"));
        String pwd=request.getParameter("pwd");
        HttpSession session=request.getSession();

        return loginService.login(id,pwd,session);
        //return ResultUtil.error(id,pwd);
    }

    @RequestMapping("/getStu")
    public Result test(HttpServletRequest request){
        HttpSession session=request.getSession();

        Student s= (Student) session.getAttribute(ConstantUtils.USER_SESSION_KEY);
        //return loginService.login(id,pwd,session);
        return ResultUtil.success(s);
    }


}
