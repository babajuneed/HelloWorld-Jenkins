package com.helloworld.jenkins.helloworld_jenkins;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class HelloworldJenkinsApplication {

	public static void main(String[] args) {
		SpringApplication.run(HelloworldJenkinsApplication.class, args);
	}

	@GetMapping
	public String getHelloWorld() {
		return "Hello World! Spring Boot application has been running successfully";
	}
}
