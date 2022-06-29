package com.ega.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@EnableEurekaClient

@PropertySource("classpath:application.properties")
public class   UserApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserApplication.class, args);
	}

}
