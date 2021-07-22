package com.cts.jhd.ui;

import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.cts.jhd.entities.Department;
import com.cts.jhd.entities.Employee;
import com.cts.jhd.util.JPAUtil;

public class App05JPQL {

	public static void main(String[] args) {

		EntityManager em = JPAUtil.getEntityManager();

		//TypedQuery<Department> tqry = em.createQuery("SELECT d FROM Department d WHERE d.deptId=3", Department.class);
		TypedQuery<Department> tqry = em.createQuery("SELECT d FROM Department d JOIN FETCH d.emps WHERE d.deptId=3", Department.class);
		Department d = tqry.getSingleResult();
		System.out.println(d);
		em.close();
		Set<Employee> emps = d.getEmps();
		if (emps != null)
			emps.stream().forEach(System.out::println);
		
		em = JPAUtil.getEntityManager();
		TypedQuery<Employee> tqry1 = em.createQuery("SELECT e FROM Department d JOIN d.emps e WHERE (d.deptId=:did and e.salary>=:salLimit)", Employee.class);
		tqry1.setParameter("did", 3L);
		tqry1.setParameter("salLimit", 60000.0);
		List<Employee> emps1 = tqry1.getResultList();
			emps1.stream().forEach(System.out::println);
		em.close();
		
		em = JPAUtil.getEntityManager();
		TypedQuery<Employee> tqry2= em.createNamedQuery("EMP_SAL_QRY", Employee.class);
		tqry2.setParameter("did", 3L);
		tqry2.setParameter("salLimit", 60000.0);
		List<Employee> emps2 = tqry2.getResultList();
			emps2.stream().forEach(System.out::println);
		em.close();
		
		
		
		JPAUtil.shutdown();
	}
}
