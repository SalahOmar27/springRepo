package com.salah.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class SpringAppExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringAppExampleApplication.class, args);
	}

}
