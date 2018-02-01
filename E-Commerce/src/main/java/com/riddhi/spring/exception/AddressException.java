package com.riddhi.spring.exception;

public class AddressException extends Exception{
	public AddressException(String message)
	{
		super("AddressException-"+ message);
	}
	
	public AddressException(String message, Throwable cause)
	{
		super("AddressException-"+ message,cause);
	}

}
