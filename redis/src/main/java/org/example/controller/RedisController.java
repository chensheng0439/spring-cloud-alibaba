package org.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
public class RedisController {

    @Autowired
    private RedisTemplate redisTemplate;

    @GetMapping("/hello")
    public String hello(){
        //Set<String> keys = redisTemplate.keys("*");
        String name = (String)redisTemplate.opsForValue().get("name");
        return "hello";
    }

}
