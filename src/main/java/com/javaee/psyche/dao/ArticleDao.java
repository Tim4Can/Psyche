package com.javaee.psyche.dao;

import com.javaee.psyche.entity.Article;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;


@Repository("ArticleDao")
public interface ArticleDao extends JpaRepository<Article,Integer>, JpaSpecificationExecutor {

    Article findById(int id);

    Page<Article> findByTitleLike(String title, Pageable pageable);

    Page<Article> findAll(Pageable pageable);

}

