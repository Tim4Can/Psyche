package cn.psyche.javaee.controller;

import cn.psyche.javaee.dao.TreeholeDao;
import cn.psyche.javaee.service.Result;
import cn.psyche.javaee.service.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/Treehole")
public class TreeholeController {
    @Autowired
    TreeholeDao treeholeDao;

    @RequestMapping(method= RequestMethod.GET)
    public Result getList(HttpServletRequest request){

        return ResultUtil.success();
    }

    @RequestMapping(value="/{id}", method = RequestMethod.GET)
    public Result getTreehole(@PathVariable("id") int id, HttpServletRequest request){

        return ResultUtil.success();
    }


}
