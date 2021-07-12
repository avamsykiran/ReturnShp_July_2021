package com.cts.returnship.jff.ui;

import java.time.LocalDate;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;

import com.cts.returnship.jff.model.Employee;
import com.cts.returnship.jff.util.EmployeweFullNameComparator;

public class EmpStreamDemo {

	public static void main(String[] args) {
		
		Set<Employee> emps = new TreeSet<>();
		
		emps.add(new Employee(111L, "Vamsy", LocalDate.now(), 10000.0));
		emps.add(new Employee(101L, "Zubar", LocalDate.now().plusDays(10), 30000.0));
		emps.add(new Employee(112L, "Arun", LocalDate.now().plusDays(4), 15000.0));
		emps.add(new Employee(104L, "Charan", LocalDate.now().plusDays(12), 20000.0));
		emps.add(new Employee(102L, "Benjumen", LocalDate.now().plusDays(5), 11000.0));
	
		emps.stream().forEach(System.out::println);
		System.out.println("--------------------------------------------------------");
		emps.stream().forEach(e -> e.setBasic(e.getBasic()*2));
		emps.stream().forEach(System.out::println);
		System.out.println("--------------------------------------------------------");
		Optional<Employee> senior = emps.stream()
				.reduce((e1,e2) -> e1.getDateOfJoining().isBefore(e2.getDateOfJoining())?e1:e2);
		if(senior.isPresent())
			System.out.println(senior.get());
	
		System.out.println("--------------------------------------------------------");
		Optional<Employee> junior = emps.stream()
				.reduce((e1,e2) -> e1.getDateOfJoining().isAfter(e2.getDateOfJoining())?e1:e2);
		if(junior.isPresent())
			System.out.println(junior.get());
		
	}

}
