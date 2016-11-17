package com.blog.dao;

import com.blog.entity.Article;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by LamanLu on 2016/11/8.
 */
@Repository
@Transactional
public interface ArticleDao extends JpaRepository<Article, Integer> {

    Page<Article> findByStatusGreaterThan(byte status,Pageable pageable);

    Page<Article> findByStatusGreaterThanAndCategory_id(byte status,int category_id,Pageable pageable);

    @Query("SELECT a FROM Article a INNER JOIN a.tags m WHERE m.id = :tag_id AND a.status > :status")
//    @Query("SELECT p FROM Article p INNER JOIN p.tags t WHERE t.id = :tag_id AND p.status > :status")
    Page<Article> findPublishedByTagId(@Param(value = "status") byte status, @Param(value = "tag_id") int tag_id, Pageable pageable);


}
