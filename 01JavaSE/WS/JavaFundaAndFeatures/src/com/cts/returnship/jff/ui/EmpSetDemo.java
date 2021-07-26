package com.cts.returnship.jff.ui;

import java.time.LocalDate;
import java.util.Set;
import java.util.TreeSet;

import com.cts.returnship.jff.model.Employee;
import com.cts.returnship.jff.util.EmployeweFullNameComparator;

public class EmpSetDemo {

	public static void main(String[] args) {
		
		//Set<Employee> emps = new TreeSet<>();
		//Set<Employee> emps = new TreeSet<>(new EmployeweFullNameComparator());
		Set<Employee> emps = new TreeSet<>(new EmployeweFullNameComparator().reversed());
		
		emps.add(new Employee(111L, "Vamsy", LocalDate.now(), 10000.0));
		emps.add(new Employee(101L, "Zubar", LocalDate.now().plusDays(10), 30000.0));
		emps.add(new Employee(112L, "Arun", LocalDate.now().plusDays(4), 15000.0));
		emps.add(new Employee(104L, "Charan", LocalDate.now().plusDays(12), 20000.0));
		emps.add(new Employee(102L, "Benjumen", LocalDate.now().plusDays(5), 11000.0));
	
		for(Employee e : emps)
			System.out.println(e);
	}

}
