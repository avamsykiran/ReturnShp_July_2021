package com.cts.jhd.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
//@DiscriminatorValue(value = "contract_vendor")
//@Table(name="cvendors")
@Table(name="cvendors_only")
public class ContractVendor extends Vendor {
	
	@Column(name="vdt")
	private LocalDate validTill;

	public ContractVendor() {}

	public ContractVendor(Long vendorId, String title, LocalDate validTill,Address address) {
		super(vendorId, title, address);
		this.validTill=validTill;
	}

	public LocalDate getValidTill() {
		return validTill;
	}

	public void setValidTill(LocalDate validTill) {
		this.validTill = validTill;
	}

	@Override
	public String toString() {
		return "ContractVendor ["+super.toString()+"validTill=" + validTill + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((validTill == null) ? 0 : validTill.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		ContractVendor other = (ContractVendor) obj;
		if (validTill == null) {
			if (other.validTill != null)
				return false;
		} else if (!validTill.equals(other.validTill))
			return false;
		return true;
	}
	
	
}
