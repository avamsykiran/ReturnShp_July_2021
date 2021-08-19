package in.tp.lms.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Entity
@Table(name="loanDetails")
public class LoanEntity {

	@Id
	@Column(name="loanId")
	private long loanId;
	
	@Column(name="lhm")
	private String loanHolderName;
	
	@DateTimeFormat(iso=ISO.DATE)
	@Column(name="drdt")
	private LocalDate disbursmentDate;
	
	@Column(name="p")
	private double principal;
	
	@Column(name="term")
	private double termInYears;
	
	@Enumerated(EnumType.STRING)
	@Column(name="status")
	private LoanStatus status;
		
	@Column(name="ltype")
	private long loanTypeId;

	public LoanEntity() {}
	
	public LoanEntity(long loanId, String loanHolderName, LocalDate disbursmentDate, 
			double principal,
			double termInYears, LoanStatus status, long loanTypeId) {
		super();
		this.loanId = loanId;
		this.loanHolderName = loanHolderName;
		this.disbursmentDate = disbursmentDate;
		this.principal = principal;
		this.termInYears = termInYears;
		this.status = status;
		this.loanTypeId = loanTypeId;
	}



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
	
	
}
