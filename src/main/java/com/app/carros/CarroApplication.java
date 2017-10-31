package com.app.carros;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;

@EnableAutoConfiguration
@ComponentScan
@EnableSwagger2
//@EntityScan(basePackageClasses = {CarroApplication.class, Jsr310JpaConverters.class})
public class CarroApplication {
    public static void main(String[] args){
        SpringApplication.run(CarroApplication.class, args);
    }
}
