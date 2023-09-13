package com.wupos.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.web.reactive.function.client.WebClient;



@PropertySources({
		@PropertySource("classpath:blazeErrorCodes.properties"),
		@PropertySource("classpath:internalServerError.properties"),
		@PropertySource("classpath:rtraCodes.properties"),
        @PropertySource("classpath:responseCodes.properties")

})

@SpringBootApplication
public class CoreSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(CoreSystemApplication.class, args);
	}

	@Bean
	WebClient.Builder getWebClientBuilder() {
		return WebClient.builder();
	}

}
