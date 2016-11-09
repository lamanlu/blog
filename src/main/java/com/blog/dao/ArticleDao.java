package com.blog.dao;

import com.blog.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by LamanLu on 2016/11/8.
 */
@Repository
public interface ArticleDao extends JpaRepository<Article, Integer> {

}
