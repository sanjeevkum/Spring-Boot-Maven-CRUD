package com.infostretch.poc.springbootmaven.services;

//Custom Exception
public class DataNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;

	public DataNotFoundException(String message) {
		super(message);
	}
	
}
