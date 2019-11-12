package com.javaee.psyche.controller;

import com.javaee.psyche.entity.*;
import com.javaee.psyche.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @RequestMapping(value = "/browseArticles",method = RequestMethod.GET)
    public Result browseArticles(@RequestParam("pageNum")int pageNum, @RequestParam("pageSize") int pageSize){

        return articleService.findAll(pageNum, pageSize);
    }

   @RequestMapping(value = "/searchArticles",method = RequestMethod.GET)
   public Result searchArticles(@RequestParam("title") String title, @RequestParam("pageNum")int pageNum, @RequestParam("pageSize") int pageSize){

       return articleService.findArticleByTitle(title,pageNum,pageSize);
   }

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public Result searchArticles(@PathVariable("id") int id){

        return articleService.articleDetail(id);

    }

}


