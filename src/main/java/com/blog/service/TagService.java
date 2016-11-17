package com.blog.service;

import com.blog.dao.TagDao;
import com.blog.entity.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by laman on 16-11-17.
 */
@Service
public class TagService {

    @Autowired
    private TagDao tagDao;


    public Tag save(Tag tag){
        return this.tagDao.save(tag);
    }

    public Tag findOne(int id){
        return this.tagDao.findOne(id);
    }

    public Page<Tag> findAllByPage(int page, int pageSize){
        Sort sort = new Sort(Sort.Direction.ASC,"id");
        Pageable pageable = new PageRequest(page,pageSize,sort);

        return this.tagDao.findAll(pageable);
    }

    public List<Tag> findAll(){
        return this.tagDao.findAllByOrderBySortDesc();
    }

}
