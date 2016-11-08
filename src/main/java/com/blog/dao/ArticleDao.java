package com.blog.dao;

import com.blog.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by LamanLu on 2016/11/8.
 */
public interface ArticleDao extends JpaRepository<Article, Integer> {

}
