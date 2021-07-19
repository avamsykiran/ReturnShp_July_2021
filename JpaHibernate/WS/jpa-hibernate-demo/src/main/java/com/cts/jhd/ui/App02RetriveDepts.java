package com.cts.jhd.ui;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.cts.jhd.entities.Department;
import com.cts.jhd.util.JPAUtil;

public class App02RetriveDepts {

	public static void main(String[] args) {
				
		EntityManager em = JPAUtil.getEntityManager();
		
		//Department d = em.find(Department.class, 4L);
		//System.out.println(d);
		
		String jpql = "SELECT d FROM Department d";
		
		Query qry = em.createQuery(jpql);
		List<Object> results = qry.getResultList();
		System.out.println(results);
		
		TypedQuery<Department> tqry = em.createQuery(jpql,Department.class);
		List<Department> depts = tqry.getResultList();
		System.out.println(depts);
		
		em.close();
		JPAUtil.shutdown();
	}
}
