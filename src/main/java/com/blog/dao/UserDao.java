package com.blog.dao;

import com.blog.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by laman on 16-11-15.
 */
@Repository
public interface UserDao extends JpaRepository<User, Integer> {
    User findByUsername(String username);
}
