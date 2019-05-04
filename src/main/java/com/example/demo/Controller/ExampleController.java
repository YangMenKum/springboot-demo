package com.example.demo.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author by Young
 * @date 2019/4/10 0010
 * @Description
 */
@RestController
public class ExampleController {
    @RequestMapping("/index")
    String index() {
        return "hello world!";
    }
}
