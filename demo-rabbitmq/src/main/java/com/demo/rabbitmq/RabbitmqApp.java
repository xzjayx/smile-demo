package com.demo.rabbitmq;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author :xiezhi
 * @date : 2023/1/31
 */
@SpringBootApplication(scanBasePackages = {"com.demo.rabbitmq"})
public class RabbitmqApp {

    public static void main(String[] args) {
        SpringApplication.run(RabbitmqApp.class, args);
    }
}
