package com.yjy.security.service.impl;

import com.yjy.security.service.HelloService;
import org.springframework.stereotype.Service;

@Service
public class HelloServiceImpl implements HelloService {

    @Override
    public String greeting(String name) {
        System.out.println("greeting");

        return "hello " + name;
    }
}
