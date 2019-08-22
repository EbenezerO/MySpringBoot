package com.example.demo.controller;

import com.example.demo.model.dom4j.Dom4j;
import com.example.demo.model.redis.ReadData;
import com.example.demo.model.redis.RedisHelperImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class HelloWorldController {
    @RequestMapping("/hello")
    public String index() {
        return "Hello World";
    }

    @RequestMapping("/getXML")
    public String get() { return new Dom4j().getXML(); }

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private RedisHelperImpl redisHelper;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @RequestMapping("/getinfo")
    public String getinfo() {

        String input="a4";//输入要获取的 key

        boolean exist=redisTemplate.hasKey(input);
        if(exist)
            return stringRedisTemplate.opsForValue().get(input);
        else
        {
            //从另一个地方拿 ，放入redis中
            ReadData a=new ReadData();
            try {
                if(a.FindAll(input)!=null)
                {
                    System.out.println(a.FindAll(input));
                    redisHelper.valuePut(input,a.FindAll(input));
                }
            }catch (IOException e) {
                System.out.println("data文件中没有找到");
                e.printStackTrace();
            }
        }
        return "redis中不存在,从data文件中拿取并存入redis，以便下次访问";
    }
}
