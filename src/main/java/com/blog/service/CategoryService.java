package com.blog.service;

import com.blog.dao.CategoryDao;
import com.blog.entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by laman on 16-11-17.
 */
@Service
public class CategoryService {

    @Autowired
    private CategoryDao categoryDao;


    public Category save(Category category){
        return this.categoryDao.save(category);
    }

    public List<Category> findAll(){
        return this.categoryDao.findAll();
    }

    public List<Category> findAllOderBySort(){
        return this.categoryDao.findAllByOrderBySortDesc();
    }
}
