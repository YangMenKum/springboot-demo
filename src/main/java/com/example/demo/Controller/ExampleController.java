package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.logging.Logger;


/**
 * @author by Young
 * @date 2019/4/10 0010
 * @Description
 */
@RestController
public class ExampleController {
    private final Logger logger = Logger.getLogger(String.valueOf(getClass()));
    @Autowired
    private DiscoveryClient client;
    @RequestMapping(value="/index",method = RequestMethod.GET)
    String index() {
        List<ServiceInstance> instanceList = client.getInstances("demo-service");
        instanceList.stream().forEach(instance -> {
            logger.info("host:" + instance.getHost() + "，serviceId:" + instance.getServiceId());
        });
        return "hello world!";
    }
}
