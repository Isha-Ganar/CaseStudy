package com.capg.service;

import java.util.List;

import com.capg.exception.DataNotFound;
import com.capg.exception.WeatherIsAlreadyPresentException;
import com.capg.model.WeatherDetails;

public interface WeatherDetailsService
{
	public WeatherDetails AddWeather(WeatherDetails WD)  throws WeatherIsAlreadyPresentException ;
	
	public List<WeatherDetails> getAllWeathers() throws DataNotFound;
	
	public void DeleteWeatherById(int id);

	public WeatherDetails UpdateWeather(WeatherDetails WD);
}
