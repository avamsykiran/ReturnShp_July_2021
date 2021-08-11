package com.cts.srad.model;

public class ErrorWrapper {

	private String errMessage;

	public ErrorWrapper(String errMessage) {
		super();
		this.errMessage = errMessage;
	}

	public String getErrMessage() {
		return errMessage;
	}

	public void setErrMessage(String errMessage) {
		this.errMessage = errMessage;
	}
}
