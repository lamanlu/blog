package com.blog.config;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.Scope;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

import javax.servlet.http.HttpSessionListener;

/**
 * Created by LamanLu on 2016/11/15.
 */
@Configuration
@EnableRedisHttpSession
public class SessionConfig {

    @Bean
    @Profile("company")
    public RedisConnectionFactory jedisCompanyConnection (){
        JedisConnectionFactory redisObj =  new JedisConnectionFactory();
        redisObj.setHostName("192.168.1.192");
        redisObj.setPort(6380);
        return redisObj;
    }

    @Bean
    @Profile("home")
    public RedisConnectionFactory jedisHomeConnection (){
        JedisConnectionFactory redisObj =  new JedisConnectionFactory();
        redisObj.setHostName("127.0.0.1");
        redisObj.setPort(6379);
        return redisObj;
    }



}
