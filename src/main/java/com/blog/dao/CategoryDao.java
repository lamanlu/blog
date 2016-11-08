package com.blog.dao;

import com.blog.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by LamanLu on 2016/11/8.
 */
public interface CategoryDao extends JpaRepository<Category,Integer> {
    public List<Category> findByName(String name);
}
