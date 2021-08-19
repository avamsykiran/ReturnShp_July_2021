package in.tp.lts.service;

import java.util.List;

import in.tp.lts.entity.LoanTypeEntity;
import in.tp.lts.exception.LoanTypeException;

public interface LoanTypeService {
	List<LoanTypeEntity> findAll();
	LoanTypeEntity findById(long loanId);
	LoanTypeEntity add(LoanTypeEntity model);
	void updateInterestRate(long loanId,double rateOfInterest) throws LoanTypeException;
}
