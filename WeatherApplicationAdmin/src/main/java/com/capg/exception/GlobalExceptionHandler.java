package com.capg.exception;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler 
{

	@Value(value="${data.exception.msg}")
	private String msg;
	
    @ExceptionHandler(WeatherIsAlreadyPresentException.class)
	public ResponseEntity<String> WeatherIsAlreadyPresentException(WeatherIsAlreadyPresentException WEP ) 
	{
		return new ResponseEntity<String> (msg, HttpStatus.CONFLICT) ;
		
	}
    
    @ExceptionHandler(DataNotFound.class)
    public ResponseEntity<String> DataNotFound(DataNotFound Dex)
    {
    	return new ResponseEntity<String> ("Data Not Found", HttpStatus.NOT_FOUND) ;
	}
	
}
