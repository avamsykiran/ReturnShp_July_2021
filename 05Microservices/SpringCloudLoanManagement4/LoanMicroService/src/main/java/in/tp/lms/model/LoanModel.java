package in.tp.lms.model;

import java.time.LocalDate;

import in.tp.lms.entity.LoanStatus;

public class LoanModel {

	private long loanId;
	private String loanHolderName;
	private LocalDate disbursmentDate;
	private double principal;
	private double termInYears;
	private LoanStatus status;
	private long loanTypeId;
	private String loanTypeTitle;
	private double rate;
	private int port;
	
	public long getLoanId() {
		return loanId;
	}

	public void setLoanId(long loanId) {
		this.loanId = loanId;
	}

	public String getLoanHolderName() {
		return loanHolderName;
	}

	public void setLoanHolderName(String loanHolderName) {
		this.loanHolderName = loanHolderName;
	}

	public LocalDate getDisbursmentDate() {
		return disbursmentDate;
	}

	public void setDisbursmentDate(LocalDate disbursmentDate) {
		this.disbursmentDate = disbursmentDate;
	}

	public double getPrincipal() {
		return principal;
	}

	public void setPrincipal(double principal) {
		this.principal = principal;
	}

	public double getTermInYears() {
		return termInYears;
	}

	public void setTermInYears(double termInYears) {
		this.termInYears = termInYears;
	}

	public long getLoanTypeId() {
		return loanTypeId;
	}

	public void setLoanTypeId(long loanTypeId) {
		this.loanTypeId = loanTypeId;
	}

	public LoanStatus getStatus() {
		return status;
	}

	public void setStatus(LoanStatus status) {
		this.status = status;
	}

	public String getLoanTypeTitle() {
		return loanTypeTitle;
	}

	public void setLoanTypeTitle(String loanTypeTitle) {
		this.loanTypeTitle = loanTypeTitle;
	}

	public double getRate() {
		return rate;
	}

	public void setRate(double rate) {
		this.rate = rate;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}
	
	
}
