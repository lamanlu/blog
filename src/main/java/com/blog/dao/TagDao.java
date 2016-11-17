package com.blog.dao;

import com.blog.entity.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by LamanLu on 2016/11/8.
 */
@Repository
public interface TagDao extends JpaRepository<Tag , Integer> {
    public List<Tag> findAllByOrderBySortDesc();
}
