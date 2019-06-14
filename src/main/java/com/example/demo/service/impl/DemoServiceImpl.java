package com.example.demo.service.impl;

import com.example.demo.service.DemoService;
import org.springframework.stereotype.Service;

@Service("demoService")
public class DemoServiceImpl implements DemoService {
    @Override
    public String serviceMethod() {
        return "this is serviceMethod!";
    }
}
