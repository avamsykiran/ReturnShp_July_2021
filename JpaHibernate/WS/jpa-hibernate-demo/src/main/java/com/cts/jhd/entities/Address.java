package com.cts.jhd.entities;

import javax.persistence.Embeddable;

@Embeddable
public class Address {

	private String doorNumber;
	private String area;

	public Address() {

	}

	public Address(String doorNumber, String area) {
		super();
		this.doorNumber = doorNumber;
		this.area = area;
	}

	public String getDoorNumber() {
		return doorNumber;
	}

	public void setDoorNumber(String doorNumber) {
		this.doorNumber = doorNumber;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	@Override
	public String toString() {
		return "Address [doorNumber=" + doorNumber + ", area=" + area + "]";
	}

}
