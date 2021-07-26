package com.cts.jhd.entities;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
//@DiscriminatorValue(value = "inhouse_vendor")
//@Table(name="ihvendors")
@Table(name="ihvendors_only")
public class InHouseVendor extends Vendor {

	@Column(name="passes_count")
	private int passessCount;
	
	public InHouseVendor() {}

	public InHouseVendor(Long vendorId, String title, int passesCount,Address address) {
		super(vendorId, title, address);
		this.passessCount=passesCount;
	}

	public int getPassessCount() {
		return passessCount;
	}

	public void setPassessCount(int passessCount) {
		this.passessCount = passessCount;
	}

	@Override
	public String toString() {
		return "InHouseVendor [passessCount=" + passessCount + "," + super.toString() + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + passessCount;
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
		InHouseVendor other = (InHouseVendor) obj;
		if (passessCount != other.passessCount)
			return false;
		return true;
	}
	
	
}
