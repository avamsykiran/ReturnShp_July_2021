package in.tp.lms.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import in.tp.lms.entity.LoanEntity;
import in.tp.lms.entity.LoanStatus;
import in.tp.lms.exception.LoanException;
import in.tp.lms.model.LoanModel;
import in.tp.lms.model.LoanTypeModel;
import in.tp.lms.repo.LoanRepo;

@Service
public class LoanServiceImpl implements LoanService {

	@Value("${loantypeurl}")
	private String loanTypeUrl;
	
	@Autowired
	private RestTemplate rest;
	
	@Autowired
	private LoanRepo repo;
	
	private LoanEntity of(LoanModel source) {
		LoanEntity result=null;
		if(source!=null) {
			result=new LoanEntity();
			result.setLoanId(source.getLoanId());
			result.setLoanHolderName(source.getLoanHolderName());
			result.setDisbursmentDate(source.getDisbursmentDate());
			result.setPrincipal(source.getPrincipal());
			result.setTermInYears(source.getTermInYears());
			result.setStatus(source.getStatus());
			result.setLoanTypeId(source.getLoanTypeId());
		}
		return result;
	}
	
	private LoanModel of(LoanEntity source) {
		LoanModel result=null;
		if(source!=null) {
			result=new LoanModel();
			result.setLoanId(source.getLoanId());
			result.setLoanHolderName(source.getLoanHolderName());
			result.setDisbursmentDate(source.getDisbursmentDate());
			result.setPrincipal(source.getPrincipal());
			result.setTermInYears(source.getTermInYears());
			result.setStatus(source.getStatus());
			result.setLoanTypeId(source.getLoanTypeId());
			
			LoanTypeModel typeSource = rest.getForObject(
					loanTypeUrl+"/"+source.getLoanTypeId(), 
					LoanTypeModel.class);
			
			if(typeSource!=null) {
				result.setRate(typeSource.getInterestRatePerAnum());
				result.setLoanTypeTitle(typeSource.getTypeTitle());
			}
		}
		return result;
	}
	
	@Override
	public List<LoanModel> findAll() {
		return repo.findAll().stream().map(e -> of(e)).collect(Collectors.toList());
	}

	@Override
	public LoanModel findById(long id) {
		LoanModel loanModel=null;
		LoanEntity entity = repo.findById(id).orElse(null);
		if(entity!=null) {
			loanModel = of(entity);
		}
		return loanModel;
	}

	@Override
	public LoanModel add(LoanModel model) {
		return of(repo.save(of(model)));
	}

	@Override
	public LoanModel updateStatus(long loanId, LoanStatus status) throws LoanException {
		LoanEntity entity = repo.findById(loanId).orElse(null);
		if(entity==null) {
			throw new LoanException("No Such Record");
		}
		entity.setStatus(status);
		return of(repo.save(entity));
	}

}
