package com.capg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.exception.DataNotFound;
import com.capg.exception.WeatherIsAlreadyPresentException;
import com.capg.model.WeatherDetails;
import com.capg.service.WeatherDetailsService;


@RestController
@RequestMapping("/api/Weather")
public class WeatherDetailsController 
{
	// Instance of WeatherDetailsService Interface
	@Autowired
	private WeatherDetailsService weatherServ;

	
	// parameterized constructor
	public WeatherDetailsController(WeatherDetailsService weatherServ) {
		super();
		this.weatherServ = weatherServ;
	}
 
	
	
	/*
	 * This is the Entry point for Post Method Which takes the input in JSON format -
	 * from Postman and send it to the "WeatherDetailsService" Service to Store it into mongo Database.
	 * Database Name => WeatherDB, Collection Name => DetailsOfWeather
	 */
	@PostMapping("/addWeather")
	public ResponseEntity<WeatherDetails> AddWeather(@RequestBody WeatherDetails WD)  throws WeatherIsAlreadyPresentException  
	{
		WeatherDetails saveWeather = weatherServ.AddWeather(WD);
		return new ResponseEntity<>(saveWeather, HttpStatus.CREATED);
		
		
	}
 
	
	// This is the Entry point for Get Method Which Do not take input in JSON format But Returns All the Documents Data in the JSON Format.
	@GetMapping("/GetAllWeathers")
	public ResponseEntity<List<WeatherDetails>> GetAllWeathers() throws DataNotFound
	{
	             // ReturnType         // TypeCasting          // Object  // Method Of Service  // Response
		return new ResponseEntity<> (  (List<WeatherDetails>)   weatherServ.getAllWeathers(),  HttpStatus.OK  );
	}
	
	// Entry point to Update the document by using ID
	 @PutMapping("/UpdateWeatherDetailsByLocation/{id}")
	 public ResponseEntity<WeatherDetails> UpdateWeather(@PathVariable int id, @RequestBody WeatherDetails WD) 
	 {
		 WD.setID(id);
		 return ResponseEntity.ok().body(this.weatherServ.UpdateWeather(WD));
	 }
	
	// Entry point to delete the document by using ID
	@DeleteMapping("/deleteWeather/{id}")
	public ResponseEntity <WeatherDetails> DeleteWeatherbyLoc(@PathVariable int id)
	{
		
		weatherServ.DeleteWeatherById(id);
		return ResponseEntity.noContent().build();
		
	}
	
	
	
	
	
}
