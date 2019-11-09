package com.javaee.psyche.controller;

import com.javaee.psyche.dao.TestDao;
import com.javaee.psyche.entity.Test;
import com.javaee.psyche.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/test")
public class TestController {


    @Autowired
    private TestService testService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<Test> getAccounts() {
        return testService.getAccounts();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Test getAccountById(@PathVariable("id") int id) {
         return testService.getAccountById(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public String updateAccount(@PathVariable("id") int id, @RequestParam(value = "name", required = true) String name,
                                @RequestParam(value = "money", required = true) double money) {

        return testService.updateAccount(id, name, money);

    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public void postAccount(@RequestParam(value = "name") String name,
                            @RequestParam(value = "money") double money) {
        testService.postAccount(name, money);
    }
}


