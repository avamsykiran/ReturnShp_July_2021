package com.cts.jhd.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="accounts")
public class BankAccount {

	@Id
	@Column(name="acno")
	private Long accountNumber;
	@Column(name="ifsc")
	private String ifscCode;
	
	@OneToOne(mappedBy = "salAccount")
	private Employee accountHolder;
	
	public BankAccount() {
		
	}

	public BankAccount(Long accountNumber, String ifscCode) {
		super();
		this.accountNumber = accountNumber;
		this.ifscCode = ifscCode;
	}

	public Long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(Long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getIfscCode() {
		return ifscCode;
	}

	public void setIfscCode(String ifscCode) {
		this.ifscCode = ifscCode;
	}

	public Employee getAccountHolder() {
		return accountHolder;
	}

	public void setAccountHolder(Employee accountHolder) {
		this.accountHolder = accountHolder;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((accountNumber == null) ? 0 : accountNumber.hashCode());
		result = prime * result + ((ifscCode == null) ? 0 : ifscCode.hashCode());
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
		BankAccount other = (BankAccount) obj;
		if (accountNumber == null) {
			if (other.accountNumber != null)
				return false;
		} else if (!accountNumber.equals(other.accountNumber))
			return false;
		if (ifscCode == null) {
			if (other.ifscCode != null)
				return false;
		} else if (!ifscCode.equals(other.ifscCode))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "BankAccount [accountNumber=" + accountNumber + ", ifscCode=" + ifscCode + "]";
	}
	
	
}
