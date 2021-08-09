package com.example.apiRecovered;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.boot.autoconfigure.data.mongo.MongoDataAutoConfiguration;
import org.springframework.data.mongodb.core.MongoTemplate;

@SpringBootApplication
public class ApiRecoveredApplication {
       
	public static void main(String[] args) {
		SpringApplication.run(ApiRecoveredApplication.class, args);
	}

}
