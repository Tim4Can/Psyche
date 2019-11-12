package com.javaee.psyche.service;

import com.javaee.psyche.dao.ArticleDao;
import com.javaee.psyche.entity.Article;
import com.javaee.psyche.entity.Result;
import com.javaee.psyche.entity.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


@Service("ArticleService")
public class ArticleService {

    @Autowired
    private ArticleDao articleDao;

    public Result findArticleByTitle(String title, int pageNum, int pageSize){

        Pageable pageable = PageRequest.of(pageNum-1, pageSize);

        Page<Article>articles = articleDao.findByTitleLike("%"+title+"%",pageable);

        if(articles!=null) {
            return ResultUtil.success(articles);
        }else {
            return ResultUtil.noRecord();
        }
    }

    public Result findAll(int pageNum, int pageSize){

        Pageable pageable = PageRequest.of(pageNum-1, pageSize,Sort.Direction.DESC,"id");
        Page<Article>articles = articleDao.findAll(pageable);

        if(articles!=null) {
            return ResultUtil.success(articles);
        }else {
            return ResultUtil.noRecord();
        }
    }

    public Result articleDetail(int id){
        Article article = articleDao.findById(id);
        if(article!=null) {
            return ResultUtil.success(article);
        }else {
            return ResultUtil.noRecord();
        }
    }
}
