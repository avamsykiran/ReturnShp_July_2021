package com.cts.returnship.jff.ui;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.cts.returnship.jff.model.Employee;
import com.cts.returnship.jff.util.EmployeweDateOfJoiningComparator;

public class EmpListDemo {

	public static void main(String[] args) {
		
		List<Employee> emps = new ArrayList<>();
	
		emps.add(new Employee(111L, "Vamsy", LocalDate.now(), 10000.0));
		emps.add(new Employee(101L, "Zubar", LocalDate.now().plusDays(10), 30000.0));
		emps.add(new Employee(112L, "Arun", LocalDate.now().plusDays(4), 15000.0));
		emps.add(new Employee(104L, "Charan", LocalDate.now().plusDays(12), 20000.0));
		emps.add(new Employee(102L, "Benjumen", LocalDate.now().plusDays(5), 11000.0));
		
		//Collections.sort(emps);
		Collections.sort(emps,new EmployeweDateOfJoiningComparator());
		
		for(Employee e : emps)
			System.out.println(e);
	}

}
