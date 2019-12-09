package com.javaee.psyche.dao;

import com.javaee.psyche.entity.Article;
import com.javaee.psyche.entity.CollectArticle;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("CollectArticleDao ")
public interface CollectArticleDao extends JpaRepository<CollectArticle,Integer> {

    List<Integer> findArticleIdByCollectorId(int collectorId);

    CollectArticle findAllByCollectorIdAndArticleId(int collectorId, int articleId);
}
