package com.capg.exception;

public class WeatherIsAlreadyPresentException extends Exception
{

	//Default Serial Version ID
	private static final long serialVersionUID = 1L;
	
	

	//Default Constructor
	public WeatherIsAlreadyPresentException() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	//Parameterized Constructor With String Parameter
	public WeatherIsAlreadyPresentException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
	

	
}
