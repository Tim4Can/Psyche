package cn.psyche.javaee.service;

import cn.psyche.javaee.dao.ArticleDao;
import cn.psyche.javaee.dao.CollectArticleDao;
import cn.psyche.javaee.entity.Article;
import cn.psyche.javaee.entity.CollectArticle;
import cn.psyche.javaee.util.Result;
import cn.psyche.javaee.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
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

    @Cacheable(value="findArticle")
    public Result findArticleByTitle(String title, int pageNum, int pageSize){

        Pageable pageable = PageRequest.of(pageNum-1, pageSize);

        Page<Article>articles = articleDao.findByTitleLike("%"+title+"%",pageable);

        if(articles!=null) {
            return ResultUtil.success(articles);
        }else {
            return ResultUtil.success("didn't find article");
        }
    }

    @Cacheable(value="findAllArticle")
    public Result findAll(int pageNum, int pageSize){

        Pageable pageable = PageRequest.of(pageNum-1, pageSize,Sort.Direction.DESC,"id");
        Page<Article>articles = articleDao.findAll(pageable);

        if(articles!=null) {
            return ResultUtil.success(articles);
        }else {
            return ResultUtil.noRecord();
        }
    }

    @Cacheable(value="articleDetail")
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
