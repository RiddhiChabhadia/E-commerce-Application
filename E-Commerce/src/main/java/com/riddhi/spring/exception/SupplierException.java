package com.riddhi.spring.exception;

public class SupplierException extends Exception {

	
	public SupplierException(String message)
	{
		super("SupplierException-"+ message);
	}
	
	public SupplierException(String message, Throwable cause)
	{
		super("SupplierException-"+ message,cause);
	}
	
	
}
