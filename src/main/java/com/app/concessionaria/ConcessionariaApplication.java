package com.app.concessionaria;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableAutoConfiguration
@ComponentScan
@EnableSwagger2
//@EntityScan(basePackageClasses = {ConcessionariaApplication.class, Jsr310JpaConverters.class})
public class ConcessionariaApplication {
    public static void main(String[] args){
        SpringApplication.run(ConcessionariaApplication.class, args);
    }
}
