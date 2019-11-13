package cn.psyche.javaee.controller;

import cn.psyche.javaee.entity.Student;
import cn.psyche.javaee.service.Result;
import cn.psyche.javaee.service.ResultUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
    @RequestMapping("/hello")
    public String index(){
        return "Hello World";
    }

    @GetMapping("/test")
    @ResponseBody
    public Result test() throws Exception {
        String str = "程序猿最帅";
        Student s=new Student();
        s.setName("XiaoMing");
        s.setId(123);
        return ResultUtil.success(s);
    }

}
