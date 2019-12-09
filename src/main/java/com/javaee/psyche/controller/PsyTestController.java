package com.javaee.psyche.controller;

import com.javaee.psyche.Util.Result;
import com.javaee.psyche.service.PsyTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/psytest")
public class PsyTestController {
    @Autowired
    private PsyTestService psyTestService;

    @RequestMapping(method = RequestMethod.GET)
    public Result testList(){
        return psyTestService.findAlltest();
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public Result testQ(@RequestParam("testId")int testId,@RequestParam("qId")int questionId,@RequestParam("choiceId")int choiceId){
        return psyTestService.nextQ(testId, questionId, choiceId);
    }

}
