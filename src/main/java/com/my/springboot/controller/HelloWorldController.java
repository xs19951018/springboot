package com.my.springboot.controller;

import com.my.springboot.model.MyProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    @Autowired
    private MyProperties properties ;

    @RequestMapping("/hello")
    public String hello(){
        return "Hello,World11122!";
    }

    @RequestMapping("/properties")
    public String testProperties(){
        return "title:"+properties.getTitle()+",description:"+properties.getDescription();
    }
}
