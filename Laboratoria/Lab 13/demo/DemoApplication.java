package com.example.demo;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.SpringApplication;

@SpringBootApplication
public class DemoApplication {
	public static void main(String[] args) {
		DatabaseConnection.connect();
		SpringApplication.run(DemoApplication.class, args);
	}
}
