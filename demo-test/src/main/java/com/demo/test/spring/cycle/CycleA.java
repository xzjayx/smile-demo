package com.demo.test.spring.cycle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CycleA {

    @Autowired
    private CycleB b;
}
