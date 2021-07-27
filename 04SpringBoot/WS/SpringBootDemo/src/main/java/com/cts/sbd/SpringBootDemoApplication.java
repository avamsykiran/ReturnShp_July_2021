package com.cts.sbd;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.cts.sbd.service.WelcomeService;

@SpringBootApplication
public class SpringBootDemoApplication implements CommandLineRunner{

	@Autowired
	//@Qualifier("ws1")
	WelcomeService ws1;
	
	@Autowired
	//@Qualifier("ws2")
	WelcomeService ws2;
	
	@Autowired
	//@Qualifier("ws3")
	WelcomeService ws3;
	
	public static void main(String[] args) {
		//spring context is not yet created
		
		SpringApplication.run(SpringBootDemoApplication.class, args);
		
		//spring context (contiaenr) is already closed and killed.
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Hai this is my first spring boot console app");
		
		System.out.println(ws1.greetUser("Vamsy Kiran"));
		System.out.println(ws2.greetUser("Vamsy Kiran"));		
		System.out.println(ws3.greetUser("Vamsy Kiran"));	
	}

}
