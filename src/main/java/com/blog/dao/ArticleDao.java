package com.blog.dao;

import com.blog.entity.Article;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by LamanLu on 2016/11/8.
 */
@Repository
public interface ArticleDao extends JpaRepository<Article, Integer> {

    Page<Article> findByStatusGreaterThan(byte status,Pageable pageable);
}
