package com.cts.returnship.jff.ui;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.Scanner;

public class DateandTimeDemo {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
				
		LocalDateTime current = LocalDateTime.now();
		System.out.println(current);
		ZonedDateTime floridaCurrent = ZonedDateTime.now(ZoneId.of("GMT-4"));
		System.out.println(floridaCurrent);
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMM-yyyy hh:mm:ss a");
		System.out.println(current.format(formatter));
		System.out.println(floridaCurrent.format(formatter));
		
		LocalDateTime indIndepence = LocalDateTime.of(1947, Month.AUGUST,15,0,0);
		System.out.println(indIndepence.format(formatter));
		
		Period p = Period.between(indIndepence.toLocalDate(), current.toLocalDate());
		System.out.println(p);
		
		Duration d = Duration.between(indIndepence, current);
		System.out.println(d);
		
		DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		System.out.println("DOB(dd-MM-yyyy):> ");
		String dobStr = scan.next();
		
		LocalDate dob = LocalDate.parse(dobStr,formatter2);
		LocalDate dor = dob.plusYears(60);
		System.out.println(dor.format(formatter2));
		
		scan.close();
	}

}
