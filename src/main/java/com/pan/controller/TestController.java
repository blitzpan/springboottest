package com.pan.controller;

import com.pan.vo.Hope;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2017-3-16.
 */

@RestController(value = "testController")
@RequestMapping(value = "/test")
@PropertySource("classpath:config.properties")
public class TestController {
    @Value("${com.test.name}")
    private String name;
    @Value("${com.test.say}")
    private String say;
    @Value("${com.test.onesay}")
    private String oneSay;

    //Hope类的配置
    @Autowired
    private Hope hope;

    //random的配置
    @Value("${randomtest.secret}")
    private String secret;
    @Value("${randomtest.int}")
    private int int1;
    @Value("${randomtest.bignumber}")
    private long long1;
    @Value("${randomtest.uuid}")
    private String uuid;
    @Value("${randomtest.int.less.than.ten}")
    private String lessThanTen;
    @Value("${randomtest.int.in.range}")
    private String inRange;





    @RequestMapping(value = "/test1")
    public String test1(){
        return name + "说：" + say + "</br>"
                + oneSay;
    }

    @RequestMapping(value="/test2")
    public String test2(){
        return hope.toString();
    }
    @RequestMapping(value="/testRandom")
    public String testRandom(){
//        return "{" +
//                "secret='" + secret + '\'' +
//                ", int1=" + int1 +
//                ", long1=" + long1 +
//                ", uuid='" + uuid + '\'' +
//                ", lessThanTen=" + lessThanTen +
//                ", inRange=" + inRange +
//                '}';
        return secret + "</br>"
                + int1 + "</br>"
                + long1 + "</br>"
                + uuid + "</br>"
                + lessThanTen + "</br>"
                + inRange;
    }

}
