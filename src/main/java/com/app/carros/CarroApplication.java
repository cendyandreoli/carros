package com.app.carros;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@EnableAutoConfiguration
@ComponentScan
public class CarroApplication {
    public static void main(String[] args){
        SpringApplication.run(CarroApplication.class, args);
    }

}
