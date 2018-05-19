package com.worstbuy.assignment.worstbuyshoppingcart.exception;



public class ValidationException extends Exception{
	
	private static final long serialVersionUID = 1L;
	
	private String message;

	public ValidationException(String message) {
		super(message);
		this.message = message;
	}

	@Override
	public String toString() {
		return "ValidationException [message=" + message + "]";
	}
	
	
}
