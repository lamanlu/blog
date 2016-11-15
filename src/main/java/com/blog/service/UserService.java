package com.blog.service;

import com.blog.dao.UserDao;
import com.blog.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Collections;

/**
 * Created by laman on 16-11-15.
 */
public class UserService implements UserDetailsService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = this.userDao.findByUserName(username);

        if(user == null){
            throw new UsernameNotFoundException("User Not Found");
        }
        return this.createSpringUser(user);
    }

    public User createUser(User user){
        user.setUserpwd(passwordEncoder.encode(user.getUserpwd()));
        return this.userDao.save(user);
    }

    public void signin(User user){
        SecurityContextHolder.getContext().setAuthentication(this.authentication(user));
    }

    public User currentUser(){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if(auth == null || auth instanceof AnonymousAuthenticationToken){
            return null;
        }

        String username = ((org.springframework.security.core.userdetails.User) auth.getPrincipal()).getUsername();

        return this.userDao.findByUserName(username);
    }

    private Authentication authentication(User user){
        return new UsernamePasswordAuthenticationToken(this.createSpringUser(user),null,Collections.singleton(this.grantedAuthority(user)));
    }


    private org.springframework.security.core.userdetails.User createSpringUser(User user) {
        return new org.springframework.security.core.userdetails.User(
                user.getUsername(),
                user.getUserpwd(),
                Collections.singleton(this.grantedAuthority(user))
        );

    }

    private GrantedAuthority grantedAuthority(User user){
        return new SimpleGrantedAuthority(user.getRole());
    }
}
