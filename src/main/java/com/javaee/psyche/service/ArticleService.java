package com.javaee.psyche.service;

import com.javaee.psyche.dao.ArticleDao;
import com.javaee.psyche.dao.CollectArticleDao;
import com.javaee.psyche.entity.Article;
import com.javaee.psyche.entity.CollectArticle;
import com.javaee.psyche.Util.Result;
import com.javaee.psyche.Util.ResultUtil;
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

    @Autowired
    private CollectArticleDao collectArticleDao;

    public Result findArticleByTitle(String title, int pageNum, int pageSize){

        Pageable pageable = PageRequest.of(pageNum-1, pageSize);

        Page<Article>articles = articleDao.findByTitleLike("%"+title+"%",pageable);

        if(articles!=null) {
            return ResultUtil.success(articles);
        }else {
            return ResultUtil.success("didn't find article");
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
            return ResultUtil.success("didn't find this article");
        }
    }


    public Result collectArticle(CollectArticle collectArticle){

        collectArticleDao.save(collectArticle);
        return ResultUtil.success();
    }

    public Result collectedOrNot(int collectorId, int articleId) {

        CollectArticle article = collectArticleDao.findAllByCollectorIdAndArticleId(collectorId, articleId);

        if (article != null) {
            return ResultUtil.success("collected");
        } else {
            return ResultUtil.success("not collected");
        }
    }
}
