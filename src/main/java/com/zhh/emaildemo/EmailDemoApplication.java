package com.zhh.emaildemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;


@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class EmailDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(EmailDemoApplication.class, args);
    }

}
