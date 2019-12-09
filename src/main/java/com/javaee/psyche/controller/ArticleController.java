package com.javaee.psyche.controller;

import com.javaee.psyche.Util.Result;
import com.javaee.psyche.entity.*;
import com.javaee.psyche.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    private ArticleService articleService;


    @RequestMapping(method = RequestMethod.GET)
    public Result browseArticles(@RequestParam("pageNum")int pageNum, @RequestParam("pageSize") int pageSize){

        return articleService.findAll(pageNum, pageSize);
    }

   @RequestMapping(value = "/searchArticles",method = RequestMethod.GET)
   public Result searchArticles(@RequestParam("title") String title, @RequestParam("pageNum")int pageNum, @RequestParam("pageSize") int pageSize){

       return articleService.findArticleByTitle(title,pageNum,pageSize);
   }

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public Result readArticles(@PathVariable("id") int id){

        return articleService.articleDetail(id);

    }

    @RequestMapping(value = "/collectArticle",method = RequestMethod.POST)
    public Result collectArticle(@RequestParam("collectorId")int collectorId, @RequestParam("articleId")int articleId){
        CollectArticle collectArticle = new CollectArticle();
        collectArticle.setCollectorId(collectorId);
        collectArticle.setArticleId(articleId);
        return articleService.collectArticle(collectArticle);
    }

    @RequestMapping(value = "/collectedOrNot",method = RequestMethod.GET)
    public Result collectedOrNot(@RequestParam("collectorId")int collectorId, @RequestParam("articleId")int articleId){

        return articleService.collectedOrNot(collectorId, articleId);
    }


}


