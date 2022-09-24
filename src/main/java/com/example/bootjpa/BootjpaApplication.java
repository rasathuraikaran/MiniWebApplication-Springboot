package com.example.bootjpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@EnableJpaRepositories("com.example.bootjpa.dao")
public class BootjpaApplication {

    public static void main(String[] args) {
        SpringApplication.run(BootjpaApplication.class, args);
        System.out.println("Hello world");

    }

}
