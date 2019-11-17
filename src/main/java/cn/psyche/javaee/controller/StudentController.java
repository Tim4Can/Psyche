package cn.psyche.javaee.controller;

import cn.psyche.javaee.dao.StudentDao;
import cn.psyche.javaee.entity.Student;
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
    }

    @RequestMapping(value = "/myInfos",method = RequestMethod.GET)
    public Result getMyInfos(HttpServletRequest request){
        return myInfosService.myInfos(request);
    }

    @RequestMapping(value = "/myTreeholes",method = RequestMethod.GET)
    public Result getMyTreeholes(HttpServletRequest request){
        HttpSession session=request.getSession();
        Student s=(Student)session.getAttribute(ConstantUtils.USER_SESSION_KEY);
        return myInfosService.myTreeholes(s);
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
