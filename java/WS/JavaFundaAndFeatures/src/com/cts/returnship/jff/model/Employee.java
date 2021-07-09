package com.cts.returnship.jff.model;

import java.io.Serializable;
import java.time.LocalDate;

public class Employee implements Comparable<Employee>,Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long empId;
	private String fullName;
	private LocalDate dateOfJoining;
	private Double basic;
	
	public Employee() {}

	public Employee(Long empId, String fullName, LocalDate dateOfJoining, Double basic) {
		super();
		this.empId = empId;
		this.fullName = fullName;
		this.dateOfJoining = dateOfJoining;
		this.basic = basic;
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

	public LocalDate getDateOfJoining() {
		return dateOfJoining;
	}

	public void setDateOfJoining(LocalDate dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}

	public Double getBasic() {
		return basic;
	}

	public void setBasic(Double basic) {
		this.basic = basic;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((basic == null) ? 0 : basic.hashCode());
		result = prime * result + ((dateOfJoining == null) ? 0 : dateOfJoining.hashCode());
		result = prime * result + ((empId == null) ? 0 : empId.hashCode());
		result = prime * result + ((fullName == null) ? 0 : fullName.hashCode());
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
		if (basic == null) {
			if (other.basic != null)
				return false;
		} else if (!basic.equals(other.basic))
			return false;
		if (dateOfJoining == null) {
			if (other.dateOfJoining != null)
				return false;
		} else if (!dateOfJoining.equals(other.dateOfJoining))
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
		return true;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", fullName=" + fullName + ", dateOfJoining=" + dateOfJoining + ", basic="
				+ basic + "]";
	}

	@Override
	public int compareTo(Employee o) {
		return this.empId.compareTo(o.empId);
	}

}
