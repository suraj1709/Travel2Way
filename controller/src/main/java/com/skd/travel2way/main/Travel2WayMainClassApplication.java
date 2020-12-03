package com.skd.travel2way.main;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {"com.skd.travel2way"})
@EnableJpaRepositories(basePackages = {"com.skd.travel2way"})
@EntityScan(basePackages = {"com.skd.travel2way"})
class Travel2WayMainClassApplication extends SpringBootServletInitializer {


    public static void main(String[] args) {

        SpringApplication.run(Travel2WayMainClassApplication.class, args);

    }




}