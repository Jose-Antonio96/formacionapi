package com.formacion;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;


@SpringBootApplication(scanBasePackages={"com.formacion.controllers", "com.formacion.services"})
public class FormarapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(FormarapiApplication.class, args);
	}

	@Bean
	public RestTemplate template() {
		return new RestTemplate();
	}

}
