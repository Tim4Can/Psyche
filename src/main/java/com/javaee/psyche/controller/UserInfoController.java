package com.javaee.psyche.controller;

import com.javaee.psyche.entity.User;
import com.javaee.psyche.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/test")
public class UserInfoController {


    @Autowired
    private UserInfoService userInfoService;

    @RequestMapping(value = "/getUserInfo", method = RequestMethod.GET)
    public User getUserInfoById(@RequestParam("id") int id) {
         return userInfoService.getUserInfoById(id);
    }

    @RequestMapping(value = "/modifyPassword", method = RequestMethod.PUT)
    public String modifyPassword(@RequestParam("id") int id, @RequestParam(value = "password") String password) {

        return userInfoService.modifyPassword(id, password);

    }

}


