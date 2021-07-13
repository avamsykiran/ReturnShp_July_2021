package com.cts.returnship.jff.ui;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.cts.returnship.jff.model.Employee;

public class EmpStreamDemo {

	public static void main(String[] args) {
		
		Set<Employee> emps = new TreeSet<>();
		
		emps.add(new Employee(111L, "Vamsy", LocalDate.now(), 10000.0,
				Arrays.asList("Java","SQL","Angular")));
		emps.add(new Employee(101L, "Zubar", LocalDate.now().plusDays(10), 30000.0,
				Arrays.asList("Java","SQL","ReactJS")));;
		emps.add(new Employee(112L, "Arun", LocalDate.now().plusDays(4), 15000.0,
				Arrays.asList("Java","NoSQL","Angular")));
		emps.add(new Employee(104L, "Charan", LocalDate.now().plusDays(12), 20000.0,
				Arrays.asList("Java","NoSQL","ReactJS")));
		emps.add(new Employee(102L, "Benjumen", LocalDate.now().plusDays(5), 11000.0,
				Arrays.asList("Java","SQL","NoSQL","ReactJS","Angular")));
	
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
		

		System.out.println("--------------------------------------------------------");
		List<Employee> empList = emps.stream().collect(Collectors.toList());
		System.out.println(empList);
		
		System.out.println("--------------------------------------------------------");
		Map<Long,String> empNameMap = emps.stream()
				.collect(Collectors.toMap(Employee::getEmpId,Employee::getFullName));
		System.out.println(empNameMap);
		System.out.println("--------------------------------------------------------");
		Map<Long,Employee> empsMap = emps.stream()
				.collect(Collectors.toMap(Employee::getEmpId,e -> e));
		System.out.println(empsMap);
		System.out.println("--------------------------------------------------------");
		//emps.stream().filter(e -> e.getBasic()<=30000).forEach(System.out::println);
		List<Employee> filteredEmpsList =
				emps.stream().filter(e -> e.getBasic()<=30000).collect(Collectors.toList());
		System.out.println(filteredEmpsList);
		System.out.println("--------------------------------------------------------");
		emps.stream().map(Employee::getFullName).forEach(System.out::println);
		System.out.println("--------------------------------------------------------");
		emps.stream()
		.map(e -> e.getFullName() + " is earning INR."+e.getBasic())
		.forEach(System.out::println);
		System.out.println("--------------------------------------------------------");
		emps.stream()
		.filter(e -> e.getBasic()<=30000)
		.map(e -> e.getFullName() + " is earning as little as INR."+e.getBasic())
		.forEach(System.out::println);
		System.out.println("--------------------------------------------------------");
		emps.stream()
		.map(e -> e.getSkills())
		.forEach(System.out::println);
		System.out.println("--------------------------------------------------------");
		emps.stream()
		.flatMap(e -> e.getSkills().stream())
		.forEach(System.out::println);
		System.out.println("--------------------------------------------------------");
		emps.stream()
		.flatMap(e -> e.getSkills().stream())
		.distinct()
		.forEach(System.out::println);
	}

}
