package in.tp.lms.exception;

public class LoanException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public LoanException(String errMsg) {
		super(errMsg);
	}
}
