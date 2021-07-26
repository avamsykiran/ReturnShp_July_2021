package com.cts.jhd.ui;

import java.util.Scanner;

import javax.persistence.EntityManager;

import com.cts.jhd.entities.Department;
import com.cts.jhd.util.JPAUtil;

public class App01PersistDepts {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		Department dept = new Department();
		System.out.print("DName: ");
		dept.setName(scan.next());
		
		EntityManager em = JPAUtil.getEntityManager();
		em.getTransaction().begin();
		em.persist(dept);
		em.getTransaction().commit();
		em.close();
		JPAUtil.shutdown();
	}
}
