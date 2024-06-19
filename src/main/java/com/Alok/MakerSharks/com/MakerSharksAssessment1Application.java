package com.Alok.MakerSharks.com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class MakerSharksAssessment1Application {

	public static void main(String[] args) {
		SpringApplication.run(MakerSharksAssessment1Application.class, args);
	}

}
