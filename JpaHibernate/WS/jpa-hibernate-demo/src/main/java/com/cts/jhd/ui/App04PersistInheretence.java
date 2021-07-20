package com.cts.jhd.ui;

import java.time.LocalDate;

import javax.persistence.EntityManager;

import com.cts.jhd.entities.Address;
import com.cts.jhd.entities.ContractVendor;
import com.cts.jhd.entities.InHouseVendor;
import com.cts.jhd.entities.Vendor;
import com.cts.jhd.util.JPAUtil;

public class App04PersistInheretence {

	public static void main(String[] args) {
		
		Vendor v = new Vendor(null, "SKML Stationaries", new Address("4-4/5","Mumbai"));
		InHouseVendor hv = new InHouseVendor(null, "GHMC Sanitizers", 20, new Address("5-5/5","Hyderabad"));
		ContractVendor cv = new ContractVendor(null, "Kappa Tea", LocalDate.now().plusYears(2), new Address("5-5/5","Vizag"));
		
		EntityManager em = JPAUtil.getEntityManager();
		em.getTransaction().begin();
		em.persist(v);
		em.persist(hv);
		em.persist(cv);
		em.getTransaction().commit();
		em.close();
		
		JPAUtil.shutdown();
	}
}
