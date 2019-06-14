package com.example.demo.controller;

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
 * @date 2019/5/7 0007
 * @Description
 */
@RestController
public class EurekaDemoController {
    private final Logger logger = Logger.getLogger(String.valueOf(getClass()));
    @Autowired
    private DiscoveryClient client;

    @RequestMapping(value = "/eureka", method = RequestMethod.GET)
    String eureka() {
        List<ServiceInstance> instanceList = client.getInstances("demo-service");
        instanceList.stream().forEach(instance -> {
            logger.info("host:" + instance.getHost() + "，serviceId:" + instance.getServiceId());
        });
        return "demo-service";
    }
}
