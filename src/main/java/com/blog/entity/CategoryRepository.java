package com.blog.entity;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by LamanLu on 2016/11/7.
 */
@Transactional
public interface CategoryRepository extends CrudRepository<Category, Integer> {
    public Category findByName(String name);
}
