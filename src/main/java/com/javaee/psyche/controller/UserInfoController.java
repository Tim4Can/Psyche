package com.javaee.psyche.controller;

import com.javaee.psyche.entity.User;
import com.javaee.psyche.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("/userInfo")
public class UserInfoController {


    @Autowired
    private UserInfoService userInfoService;

    @RequestMapping(value = "/getUserInfo/{id}", method = RequestMethod.GET)
    public User getUserInfoById(@PathVariable("id") int id) {
         return userInfoService.getUserInfoById(id);
    }

    @RequestMapping(value = "/modifyPassword/{id}", method = RequestMethod.PUT)
    public String modifyPassword(@PathVariable("id") int id, @RequestParam(value = "password") String password) {

        return userInfoService.modifyPassword(id, password);

    }

   // @RequestMapping(value = "",method = RequestMethod.POST)
    //public void addUser(@PathParam())

}


