package com.cts.jhd.entities;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
//@Table(name="all_vendors")
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
//@DiscriminatorColumn(name = "vtype",discriminatorType = DiscriminatorType.STRING)
//@DiscriminatorValue(value = "norm_vendor")

//@Table(name="vendors")
//@Inheritance(strategy = InheritanceType.JOINED)

@Table(name="vendors_only")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Vendor {

	@Id
	@GeneratedValue
	@Column(name="vid")
	private Long vendorId;
	
	private String title;
	
	@Embedded
	private Address address;
	
	public Vendor() {}

	public Vendor(Long vendorId, String title, Address address) {
		super();
		this.vendorId = vendorId;
		this.title = title;
		this.address = address;
	}

	public Long getVendorId() {
		return vendorId;
	}

	public void setVendorId(Long vendorId) {
		this.vendorId = vendorId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Vendor [vendorId=" + vendorId + ", title=" + title + ", address=" + address + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + ((vendorId == null) ? 0 : vendorId.hashCode());
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
		Vendor other = (Vendor) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		if (vendorId == null) {
			if (other.vendorId != null)
				return false;
		} else if (!vendorId.equals(other.vendorId))
			return false;
		return true;
	}
	
	
}
