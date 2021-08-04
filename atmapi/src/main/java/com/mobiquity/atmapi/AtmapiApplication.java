package com.mobiquity.atmapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class AtmapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(AtmapiApplication.class, args);
	}
	
	@Bean
	public RestTemplate restTemplet() {
		return new RestTemplate();
	}

}
