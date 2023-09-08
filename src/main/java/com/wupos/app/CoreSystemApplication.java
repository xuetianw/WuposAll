package com.wupos.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
@PropertySource("classpath:blazeErrorCodes.properties")
public class CoreSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(CoreSystemApplication.class, args);
	}

	@Bean
	WebClient.Builder getWebClientBuilder() {
		return WebClient.builder();
	}

}
