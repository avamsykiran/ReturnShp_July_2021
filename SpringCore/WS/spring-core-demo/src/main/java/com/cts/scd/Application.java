package com.cts.scd;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.cts.scd.service.WelcomeService;
import com.cts.scd.service.WelcomeServiceArgumentedImpl;

public class Application {

	public static void main(String[] args) {
	
		ApplicationContext context = 
				new AnnotationConfigApplicationContext(AppConfig.class);
		
		WelcomeService ws1 = (WelcomeService) context.getBean("ws1");
		System.out.println(ws1.greetUser("Vamsy Kiran"));
		
		WelcomeService ws2 = (WelcomeService) context.getBean("ws2");
		System.out.println(ws2.greetUser("Vamsy Kiran"));
		((WelcomeServiceArgumentedImpl)ws2).setWelcomeText("Vannakkam");
		System.out.println(ws2.greetUser("Vamsy Kiran"));
		
		WelcomeService ws2a = (WelcomeService) context.getBean("ws2");
		System.out.println(ws2a.greetUser("Vamsy Kiran"));
		
		WelcomeService ws3 = (WelcomeService) context.getBean("ws3");
		System.out.println(ws3.greetUser("Vamsy Kiran"));
		
		context=null; //deallocating the context.
	}

}
