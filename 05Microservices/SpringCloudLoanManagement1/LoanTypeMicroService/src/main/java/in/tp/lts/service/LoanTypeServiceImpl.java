package in.tp.lts.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.tp.lts.entity.LoanTypeEntity;
import in.tp.lts.exception.LoanTypeException;
import in.tp.lts.repo.LoanTypeRepo;

@Service
public class LoanTypeServiceImpl implements LoanTypeService {

	@Autowired
	private LoanTypeRepo repo;

	@Override
	public List<LoanTypeEntity> findAll() {
		return repo.findAll();
	}

	@Override
	public LoanTypeEntity findById(long loanId) {
		return repo.findById(loanId).orElse(null);
	}

	@Transactional
	@Override
	public LoanTypeEntity add(LoanTypeEntity model) {
		return repo.save(model);
	}

	@Transactional
	@Override
	public void updateInterestRate(long loanId, double rateOfInterest) throws LoanTypeException {
		LoanTypeEntity entity = repo.findById(loanId).orElse(null);
		
		if(entity==null)
			throw new LoanTypeException("No Such Record");
		else {
			entity.setInterestRatePerAnum(rateOfInterest);
			repo.save(entity);
		}
	}

}
