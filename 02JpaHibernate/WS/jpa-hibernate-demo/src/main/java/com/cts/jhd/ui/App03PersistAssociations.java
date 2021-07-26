package com.cts.jhd.ui;

import java.util.Scanner;
import java.util.TreeSet;

import javax.persistence.EntityManager;

import com.cts.jhd.entities.Address;
import com.cts.jhd.entities.BankAccount;
import com.cts.jhd.entities.Department;
import com.cts.jhd.entities.Designation;
import com.cts.jhd.entities.Employee;
import com.cts.jhd.util.JPAUtil;

public class App03PersistAssociations {

	public static void main(String[] args) {
		
		Department d1 = new Department(null, "JavaAngularFSD");
		Department d2 = new Department(null, "JavaReactFSD");
		
		d1.setEmps(new TreeSet<Employee>());		
		
		d1.getEmps().add(new Employee(null, "Vamsy Kiran", 45000.0, Designation.JUNIOR_ASSOSIATE, 
				new Address("4-16/1", "Vizag"),new BankAccount(123456L, "IND00889"), d1));
		d1.getEmps().add(new Employee(null, "Suseela", 85000.0, Designation.ASSOSIATE, 
				new Address("4-16/1", "Vizag"),new BankAccount(123436L, "IND00889"), d1));
		d1.getEmps().add(new Employee(null, "Indhikaa", 105000.0, Designation.MANAGER, 
				new Address("4-16/1", "Vizag"),new BankAccount(123356L, "IND00889"), d1));
		
		d2.setEmps(new TreeSet<Employee>());		
		d2.getEmps().add(new Employee(null, "Srinu", 45000.0, Designation.JUNIOR_ASSOSIATE, 
				new Address("4-16/3", "Banglore"),new BankAccount(113456L, "IND00889"), d2));
		d2.getEmps().add(new Employee(null, "Deepa", 64000.0, Designation.SENIOR_ASSOSIATE, 
				new Address("4-16/4", "Kolkatta"),new BankAccount(223456L, "IND00889"), d2));
		d2.getEmps().add(new Employee(null, "Sagar", 405000.0, Designation.MANAGER, 
				new Address("4-16/5", "Chennai"),new BankAccount(323456L, "IND00889"), d2));
		
		EntityManager em = JPAUtil.getEntityManager();
		em.getTransaction().begin();
		em.persist(d1);
		em.persist(d2);
		em.getTransaction().commit();
		em.close();
		
		JPAUtil.shutdown();
	}
}
