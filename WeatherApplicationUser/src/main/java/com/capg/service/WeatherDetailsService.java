package com.capg.service;

import java.util.List;

import com.capg.model.WeatherDetails;

public interface WeatherDetailsService
{
	public List<WeatherDetails> getAllWeathers();

	public WeatherDetails GetWeatherById(int id);
}
