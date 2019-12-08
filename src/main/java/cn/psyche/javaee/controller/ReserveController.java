package cn.psyche.javaee.controller;

import cn.psyche.javaee.service.ConstantUtils;
import cn.psyche.javaee.service.ReserveService;
import cn.psyche.javaee.service.Result;
import cn.psyche.javaee.service.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


@RestController
@RequestMapping("/Counseling")
public class ReserveController {
    @Autowired
    ReserveService reserveService;

    //get teachers
    @RequestMapping(method = RequestMethod.GET)
    public Result getTeachers(@RequestParam(value="page",required = false,defaultValue = "0") int page){

        return ResultUtil.success(reserveService.getTeachers(page));
    }

    //check reservation table
    @RequestMapping(method = RequestMethod.GET,value = "/schedule")
    public Result getTable(@RequestParam("id")int id){

        return reserveService.getReservationTable(id);
    }

    //reserve teacher
    @RequestMapping(method = RequestMethod.POST,value="/reserve")
    public Result reserve(HttpServletRequest request){
        HttpSession session=request.getSession();
        int student= (int) session.getAttribute(ConstantUtils.USER_SESSION_KEY);
        int teacher=Integer.parseInt(request.getParameter("teacher"));
        int weekday=Integer.parseInt(request.getParameter("weekday"));
        int period=Integer.parseInt(request.getParameter("period"));

        return reserveService.reserveTeacher(teacher,student,weekday,period);

    }

    //cancel
    @RequestMapping(method = RequestMethod.POST,value = "/cancel")
    public Result cancel(@RequestParam("id")int id){
        return reserveService.cancelReservation(id);
    }

    //check my reservation
    @RequestMapping(method = RequestMethod.POST,value = "myReservation")
    public Result checkReservation(HttpServletRequest request){
        HttpSession session=request.getSession();
        int user= (int) session.getAttribute(ConstantUtils.USER_SESSION_KEY);
        return reserveService.myReservation(user);
    }
}
