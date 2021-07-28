package com.cts.sdd;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.cts.sdd.exception.D2HException;
import com.cts.sdd.ui.D2HApplicationStater;

@SpringBootApplication
public class SpringDataDemoApplication implements CommandLineRunner {
	
	@Autowired
	private D2HApplicationStater appStarter;

	public static void main(String[] args) {
		SpringApplication.run(SpringDataDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		appStarter.start();
	}

}
