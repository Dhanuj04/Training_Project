package com.example.policymsproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan("com")
@EnableEurekaClient
@EnableJpaRepositories("com")
@EntityScan("com.entity")
public class PolicyMsProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(PolicyMsProjectApplication.class, args);
	}

}
