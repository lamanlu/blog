package com.blog.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.Scope;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;


/**
 * Created by LamanLu on 2016/11/18.
 */
@Configuration
@EnableCaching
public class RedisCacheConfig extends CachingConfigurerSupport {

//    @Bean
//    @Profile("company")
//    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
//    @Qualifier()
//    public RedisConnectionFactory cacheCompanyFactory(){
//        JedisConnectionFactory jedisConnectionFactory = new JedisConnectionFactory();
//        jedisConnectionFactory.setHostName("192.168.1.192");
//        jedisConnectionFactory.setPort(7000);
//        return jedisConnectionFactory;
//    }


    @Bean
    public RedisTemplate<String , String> redisTemplate(){
        JedisConnectionFactory jedisConnectionFactory = new JedisConnectionFactory();
        jedisConnectionFactory.setHostName("192.168.1.192");
        jedisConnectionFactory.setPort(7000);

        RedisTemplate<String, String> redisTemplate = new RedisTemplate<String, String>();
        redisTemplate.setConnectionFactory(jedisConnectionFactory);
        return redisTemplate;
    }

    @Bean
    public CacheManager cacheManager(RedisTemplate redisTemplate){
        RedisCacheManager cacheManager = new RedisCacheManager(redisTemplate);
//        cacheManager.setDefaultExpiration(3000);
        return cacheManager;
    }

//    @Bean
//    public KeyGenerator customKeyGenerator(){
//        return (o, method, objects) -> {
//            StringBuilder sb = new StringBuilder();
//            sb.append(o.getClass().getName());
//            sb.append(method.getName());
//            for (Object obj : objects) {
//                sb.append(obj.toString());
//            }
//            return sb.toString();
//        };
//    }

}
