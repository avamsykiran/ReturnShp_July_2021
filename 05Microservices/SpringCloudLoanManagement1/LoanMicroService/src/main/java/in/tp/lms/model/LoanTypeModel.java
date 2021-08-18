package in.tp.lms.model;

public class LoanTypeModel {

	private long id;
	private String typeTitle;
	private double interestRatePerAnum;

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
	
	
}
