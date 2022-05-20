package com.capg.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.model.WeatherDetails;
import com.capg.service.WeatherDetailsService;

@RestController
@RequestMapping("/api/Weather")
public class WeatherController
{
	@Autowired
	private WeatherDetailsService WeatherServ;

	public WeatherController(WeatherDetailsService weatherServ) {
		super();
		WeatherServ = weatherServ;
	}
	
	@GetMapping("/GetAllWeatherInfo")
	public ResponseEntity<List<WeatherDetails>> GetAllWeathers()
	{
	             // ReturnType         // TypeCasting          // Object  // Method Of Service  // Response
		return new ResponseEntity<> (  (List<WeatherDetails>)   WeatherServ.getAllWeathers(),  HttpStatus.OK  );
	}
	
	@GetMapping("/GetWeatherById/{id}")
	public ResponseEntity<WeatherDetails> GetWeatherById(@PathVariable int id)
	{
		
		return new ResponseEntity<>( (WeatherDetails) WeatherServ.GetWeatherById(id), HttpStatus.OK  );
	}
	
	
}
