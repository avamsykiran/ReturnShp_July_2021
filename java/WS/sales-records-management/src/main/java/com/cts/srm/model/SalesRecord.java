package com.cts.srm.model;

import java.time.LocalDate;

public class SalesRecord implements Comparable<SalesRecord> {
	
	private Long receiptNo;
	private String itemName;
	private String area;
	private Integer quantity;
	private Double amount;
	private Double rate;
	private LocalDate receiptDate;
	
	public SalesRecord() {
		
	}

	public SalesRecord(Long receiptNo, String itemName, String area, Integer quantity, Double amount, Double rate,
			LocalDate receiptDate) {
		super();
		this.receiptNo = receiptNo;
		this.itemName = itemName;
		this.area = area;
		this.quantity = quantity;
		this.amount = amount;
		this.rate = rate;
		this.receiptDate = receiptDate;
	}

	public Long getReceiptNo() {
		return receiptNo;
	}

	public void setReceiptNo(Long receiptNo) {
		this.receiptNo = receiptNo;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Double getRate() {
		return rate;
	}

	public void setRate(Double rate) {
		this.rate = rate;
	}

	public LocalDate getReceiptDate() {
		return receiptDate;
	}

	public void setReceiptDate(LocalDate receiptDate) {
		this.receiptDate = receiptDate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((amount == null) ? 0 : amount.hashCode());
		result = prime * result + ((area == null) ? 0 : area.hashCode());
		result = prime * result + ((itemName == null) ? 0 : itemName.hashCode());
		result = prime * result + ((quantity == null) ? 0 : quantity.hashCode());
		result = prime * result + ((rate == null) ? 0 : rate.hashCode());
		result = prime * result + ((receiptDate == null) ? 0 : receiptDate.hashCode());
		result = prime * result + ((receiptNo == null) ? 0 : receiptNo.hashCode());
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
		SalesRecord other = (SalesRecord) obj;
		if (amount == null) {
			if (other.amount != null)
				return false;
		} else if (!amount.equals(other.amount))
			return false;
		if (area == null) {
			if (other.area != null)
				return false;
		} else if (!area.equals(other.area))
			return false;
		if (itemName == null) {
			if (other.itemName != null)
				return false;
		} else if (!itemName.equals(other.itemName))
			return false;
		if (quantity == null) {
			if (other.quantity != null)
				return false;
		} else if (!quantity.equals(other.quantity))
			return false;
		if (rate == null) {
			if (other.rate != null)
				return false;
		} else if (!rate.equals(other.rate))
			return false;
		if (receiptDate == null) {
			if (other.receiptDate != null)
				return false;
		} else if (!receiptDate.equals(other.receiptDate))
			return false;
		if (receiptNo == null) {
			if (other.receiptNo != null)
				return false;
		} else if (!receiptNo.equals(other.receiptNo))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "SalesRecord [receiptNo=" + receiptNo + ", itemName=" + itemName + ", area=" + area + ", quantity="
				+ quantity + ", amount=" + amount + ", rate=" + rate + ", receiptDate=" + receiptDate + "]";
	}

	@Override
	public int compareTo(SalesRecord arg0) {
		return this.receiptNo.compareTo(arg0.receiptNo);
	}
}
