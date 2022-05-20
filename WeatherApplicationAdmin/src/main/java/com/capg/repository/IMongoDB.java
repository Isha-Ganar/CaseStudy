package com.capg.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.capg.model.WeatherDetails;

public interface IMongoDB extends MongoRepository<WeatherDetails, Integer> 
{

}
