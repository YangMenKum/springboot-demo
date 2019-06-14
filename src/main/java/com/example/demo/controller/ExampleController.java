package com.example.demo.controller;

import com.example.demo.service.DemoService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.logging.Logger;


/**
 * @author by Young
 * @date 2019/4/10 0010
 * @Description
 */
@RestController
public class ExampleController {
    private final Logger logger = Logger.getLogger(String.valueOf(getClass()));

    @Resource
    DemoService demoService;

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    String index() {
        return "hello world!";
    }

    @RequestMapping(value = "/serviceBean", method = RequestMethod.GET)
    String serviceBean() {
        return demoService.serviceMethod();
    }
}
