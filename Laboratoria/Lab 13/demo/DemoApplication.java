package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {
	public static void main(String[] args) {
		DatabaseConnection.connect();
		SpringApplication.run(DemoApplication.class, args);
	}
}
