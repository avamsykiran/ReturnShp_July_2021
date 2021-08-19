package in.tp.lms.service;

import java.util.List;

import in.tp.lms.entity.LoanStatus;
import in.tp.lms.exception.LoanException;
import in.tp.lms.model.LoanModel;

public interface LoanService {

	List<LoanModel> findAll();
	LoanModel findById(long id);
	
	LoanModel add(LoanModel model);
	LoanModel updateStatus(long loanId,LoanStatus status) throws LoanException;	
}
