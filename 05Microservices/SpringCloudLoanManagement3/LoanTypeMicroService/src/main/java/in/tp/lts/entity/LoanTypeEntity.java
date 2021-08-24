package in.tp.lts.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class LoanTypeEntity {

	@Id
	private long id;
	
	@Column(name="typeTitle",nullable=false)
	private String typeTitle;
	
	@Column(name="rate",nullable=false)
	private double interestRatePerAnum;
	
	@Transient
	private int port;

	public LoanTypeEntity() {}
	
	public LoanTypeEntity(long id, String typeTitle, double interestRatePerAnum) {
		super();
		this.id = id;
		this.typeTitle = typeTitle;
		this.interestRatePerAnum = interestRatePerAnum;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTypeTitle() {
		return typeTitle;
	}

	public void setTypeTitle(String typeTitle) {
		this.typeTitle = typeTitle;
	}

	public double getInterestRatePerAnum() {
		return interestRatePerAnum;
	}

	public void setInterestRatePerAnum(double interestRatePerAnum) {
		this.interestRatePerAnum = interestRatePerAnum;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}
	
	
	
}
