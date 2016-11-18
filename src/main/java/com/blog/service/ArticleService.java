package com.blog.service;

import com.blog.dao.ArticleDao;
import com.blog.entity.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

/**
 * Created by LamanLu on 2016/11/17.
 */
@Service
public class ArticleService {

    @Autowired
    private ArticleDao articleDao;

    public Article findById(int id){
        return this.articleDao.getOne(id);
    }


    public Page<Article> findPublishedList(int page, int pageSize){
        Sort sort = new Sort(Sort.Direction.DESC,"id");
        Pageable pageable = new PageRequest(page,pageSize,sort);
        return this.articleDao.findByStatusGreaterThan((byte) 0,pageable);
    }

    public Page<Article> findPublishedListByCategory(int category_id, int page, int pageSize){
        Sort sort = new Sort(Sort.Direction.DESC,"id");
        Pageable pageable = new PageRequest(page,pageSize,sort);
        return this.articleDao.findByStatusGreaterThanAndCategory_id((byte) 0,category_id, pageable);
    }

    public Page<Article> findPublishedListByTagId(int tag_id, int page, int pageSize){
        Sort sort = new Sort(Sort.Direction.DESC,"id");
        Pageable pageable = new PageRequest(page,pageSize,sort);
        return this.articleDao.findPublishedByTagId((byte) 0, tag_id, pageable);
    }

}
