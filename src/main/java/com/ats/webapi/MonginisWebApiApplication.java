package com.ats.webapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages={"com.ats.webapi"})
public class MonginisWebApiApplication {

	
	public static void main(String[] args) {
		SpringApplication.run(MonginisWebApiApplication.class, args);
	}
	
}
