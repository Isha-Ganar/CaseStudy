package com.capg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class WeatherApplicationCaseStudyApplication {

	public static void main(String[] args) {
		SpringApplication.run(WeatherApplicationCaseStudyApplication.class, args);
	}

}
