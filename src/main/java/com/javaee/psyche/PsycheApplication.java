package com.javaee.psyche;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;


@SpringBootApplication
public class PsycheApplication {

    public static void main(String[] args) {
        SpringApplication.run(PsycheApplication.class, args);
    }

}
