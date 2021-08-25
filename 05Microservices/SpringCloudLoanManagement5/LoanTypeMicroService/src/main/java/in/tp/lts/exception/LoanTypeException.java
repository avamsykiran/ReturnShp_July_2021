package in.tp.lts.exception;

public class LoanTypeException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public LoanTypeException(String errMsg) {
		super(errMsg);
	}
}
