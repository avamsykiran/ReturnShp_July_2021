package in.tp.lts.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import in.tp.lts.exception.LoanTypeException;

@RestControllerAdvice
public class LoanTypeControllerAdvise {

	@ExceptionHandler(LoanTypeException.class)
	public ResponseEntity<String> handleLoanTypeException(LoanTypeException excep){
		return new ResponseEntity<String>(excep.getMessage(),HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> handleOtherExceptions(Exception excep){
		return new ResponseEntity<String>(excep.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
