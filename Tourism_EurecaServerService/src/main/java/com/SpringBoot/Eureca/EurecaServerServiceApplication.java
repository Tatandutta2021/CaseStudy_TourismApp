package com.SpringBoot.Eureca;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurecaServerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurecaServerServiceApplication.class, args);
	}

}
