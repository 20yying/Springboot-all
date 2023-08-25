package com.yy.controller;

import com.yy.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloController {

    @Value("${name}")
    private String name;

    @Autowired
    private Environment env;

    @Autowired
    private User user1;

    @GetMapping
    public String hello(){
//        System.out.println(name);
//        System.out.println(env.getProperty("user1.name"));
//        System.out.println(env.getProperty("name"));
        System.out.println(user1);
        return "springboot is runing....";
    }
}
