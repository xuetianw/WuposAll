package com.system.blaze;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@SpringBootApplication

@PropertySources({
		@PropertySource("classpath:customCode.properties"),
		@PropertySource("classpath:checkLists.properties")
})
public class BlazeApplication {

	public static void main(String[] args) {
		SpringApplication.run(BlazeApplication.class, args);
	}

}
