package org.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@RestController
public class RedisController {

    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @GetMapping("/hello")
    public String hello(){
        //Set<String> keys = redisTemplate.keys("*");
       /* String name = (String)redisTemplate.opsForValue().get("name");
        name = (String)redisTemplate.boundValueOps("name").get();

        DataType type = redisTemplate.type("name");
        name = stringRedisTemplate.opsForValue().get("name");*/
        // jdk序列化存储到redis
        redisTemplate.opsForValue().set("name","schen");
        String name = (String)redisTemplate.opsForValue().get("name");
        // 字符串序列化存储到redis
        // 序列化方式不同，所以redisTemplate和stringRedisTemplate数据不互通
        name = stringRedisTemplate.opsForValue().get("name");

        Set<String> keys = stringRedisTemplate.keys("*");

        redisTemplate.opsForHash().put("key","smallKey","value");
        Map<String,String> map = new HashMap<>();
        redisTemplate.opsForHash().putAll("key",map);
        return name;
    }

}
