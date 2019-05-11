package com.zuul.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@EnableAutoConfiguration
@Configuration
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class PersonaFeignApplication {

	public static void main(String[] args) {
		SpringApplication.run(PersonaFeignApplication.class, args);
	}

}
