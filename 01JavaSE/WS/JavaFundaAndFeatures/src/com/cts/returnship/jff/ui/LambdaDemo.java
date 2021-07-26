package com.cts.returnship.jff.ui;

import java.time.LocalTime;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;

import com.cts.returnship.jff.service.Greet;

public class LambdaDemo {

	public static void main(String[] args) {		
		Greet g1 = unm -> "Hello "+unm;
		System.out.println(g1.doGreet("Vamsy"));
		
		Greet g2 = unm -> {
			String greeting = "";
			
			int h = LocalTime.now().getHour();
			
			if(h>=3 && h<12) greeting="Good Morning ";
			else if(h>=12 && h<=16) greeting="Good Noon ";
			else greeting="Good Evening ";
			
			return greeting + unm;
		};
		System.out.println(g2.doGreet("Vamsy"));
		
		Consumer<String> c = System.out::println;
		c.accept("Hello i am being printeed");
		
		BinaryOperator<Double> p = Math::pow;
		System.out.println(p.apply(2.0, 5.0));
	}
}
