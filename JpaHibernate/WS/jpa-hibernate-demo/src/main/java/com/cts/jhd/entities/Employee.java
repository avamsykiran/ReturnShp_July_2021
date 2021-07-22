package com.cts.jhd.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@NamedQueries({
	@NamedQuery(name = "EMP_SAL_QRY",
			query = "SELECT e FROM Department d JOIN d.emps e WHERE (d.deptId=:did and e.salary>=:salLimit)")
})

@Entity
@Table(name="emps")
public class Employee implements Comparable<Employee>{

	@Id
	@GeneratedValue
	@Column(name="emp_id")
	private Long empId;
	@Column(name="fmm")
	private String fullName;
	@Column(name="sal")
	private Double salary;
	
	@Column(name="desg")
	@Enumerated(EnumType.STRING)
	private Designation designation;
	
	//composition
	@Embedded
	private Address address;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="acno")
	private BankAccount salAccount;
	
	@ManyToOne
	@JoinColumn(name="deptno")
	private Department dept;

	public Employee() {}
	
	public Employee(Long empId, String fullName, Double salary, Designation designation, Address address,
			BankAccount salAccount, Department dept) {
		super();
		this.empId = empId;
		this.fullName = fullName;
		this.salary = salary;
		this.designation = designation;
		this.address = address;
		this.salAccount = salAccount;
		this.dept = dept;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((designation == null) ? 0 : designation.hashCode());
		result = prime * result + ((empId == null) ? 0 : empId.hashCode());
		result = prime * result + ((fullName == null) ? 0 : fullName.hashCode());
		result = prime * result + ((salAccount == null) ? 0 : salAccount.hashCode());
		result = prime * result + ((salary == null) ? 0 : salary.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (designation != other.designation)
			return false;
		if (empId == null) {
			if (other.empId != null)
				return false;
		} else if (!empId.equals(other.empId))
			return false;
		if (fullName == null) {
			if (other.fullName != null)
				return false;
		} else if (!fullName.equals(other.fullName))
			return false;
		if (salAccount == null) {
			if (other.salAccount != null)
				return false;
		} else if (!salAccount.equals(other.salAccount))
			return false;
		if (salary == null) {
			if (other.salary != null)
				return false;
		} else if (!salary.equals(other.salary))
			return false;
		return true;
	}

	public Long getEmpId() {
		return empId;
	}

	public void setEmpId(Long empId) {
		this.empId = empId;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public Designation getDesignation() {
		return designation;
	}

	public void setDesignation(Designation designation) {
		this.designation = designation;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public BankAccount getSalAccount() {
		return salAccount;
	}

	public void setSalAccount(BankAccount salAccount) {
		this.salAccount = salAccount;
	}

	public Department getDept() {
		return dept;
	}

	public void setDept(Department dept) {
		this.dept = dept;
	}

	@Override
	public int compareTo(Employee arg0) {
		return this.empId==null? this.fullName.compareTo(arg0.fullName):this.empId.compareTo(arg0.empId);
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", fullName=" + fullName + ", salary=" + salary + ", designation="
				+ designation + ", address=" + address + ", salAccount=" + salAccount +"]";
	}
	
	
}
