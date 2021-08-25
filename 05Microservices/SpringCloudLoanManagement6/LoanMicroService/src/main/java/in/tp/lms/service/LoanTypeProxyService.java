package in.tp.lms.service;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import in.tp.lms.model.LoanTypeModel;

@FeignClient(name="loan-type-service")
@RibbonClient(name="loan-type-service")
public interface LoanTypeProxyService {

	@GetMapping("/loanTypes/{id}")
	public LoanTypeModel getLoanType(@PathVariable(name="id") long id);
}
