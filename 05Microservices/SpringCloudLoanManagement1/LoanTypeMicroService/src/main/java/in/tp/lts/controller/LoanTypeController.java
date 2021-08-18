package in.tp.lts.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.tp.lts.entity.LoanTypeEntity;
import in.tp.lts.exception.LoanTypeException;
import in.tp.lts.service.LoanTypeService;

@RestController
@RequestMapping("/loanTypes")
public class LoanTypeController {

	@Autowired
	private LoanTypeService service;
	
	@GetMapping
	public ResponseEntity<List<LoanTypeEntity>> findAll(){
		return new ResponseEntity<>(service.findAll(),HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<LoanTypeEntity> findById(@PathVariable("id") long id){
		ResponseEntity<LoanTypeEntity> result;
		LoanTypeEntity model = service.findById(id);
		if(model==null)
			result =  new ResponseEntity<>(HttpStatus.NOT_FOUND);
		else
			result =  new ResponseEntity<>(model,HttpStatus.OK);
		return result;
	}
	
	@PostMapping
	public ResponseEntity<LoanTypeEntity> add(@RequestBody LoanTypeEntity model){
		return new ResponseEntity<>(service.add(model),HttpStatus.CREATED);
	}
	
	@PutMapping
	public ResponseEntity<LoanTypeEntity> update(@RequestBody LoanTypeEntity model) throws LoanTypeException{
		service.updateInterestRate(model.getId(), model.getInterestRatePerAnum());
		return new ResponseEntity<>(model,HttpStatus.OK);
	}
	
}
