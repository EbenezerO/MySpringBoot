package com.example.demo.controller;

import com.example.demo.model.Dom4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
    @RequestMapping("/hello")
    public String index() {
        return "Hello World";
    }

    @RequestMapping("/getXML")
    public String get() {
        Dom4j t=new Dom4j();
        return t.getXML();
    }
}
