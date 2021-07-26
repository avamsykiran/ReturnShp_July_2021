package com.cts.scd;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;

@Configuration
@ComponentScan("com.cts.scd.service")
@PropertySource("classpath:application.properties")
public class AppConfig {

	@Value("${date.format:dd-MM-yyyy}")
	private String DATE_FORMAT;
	
	@Bean
	@Scope("prototype")
	public LocalDate today() {
		return LocalDate.now();
	}
	
	@Bean
	public DateTimeFormatter stdDateFormat() {
		return DateTimeFormatter.ofPattern(DATE_FORMAT);
	}
}
