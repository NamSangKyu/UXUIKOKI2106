package com.example.di;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppContext {
	
	@Bean
	public Greeting greeting() {
		return new Greeting(1, "test");
	}
	
	@Bean
	public BookDTO book() {
		return new BookDTO();
	}
	
}
