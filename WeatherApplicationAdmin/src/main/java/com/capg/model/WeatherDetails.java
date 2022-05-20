package com.capg.model;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


//when we are using MongoRepository @Document annotation is used
@Document(collection = "DetailsOfWeather")
public class WeatherDetails
{
	// Parameter Variables for Weather
	@Id
	private int ID;

	private String Location;

	private Double Temperature, AtmosphericPressure, Humidity, Precipitation, SolarRadiation, Wind;

	
	// All Getters And Setters
	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getLocation() {
		return Location;
	}

	public void setLocation(String location) {
		Location = location;
	}
	public Double getTemperature() {
		return Temperature;
	}

	public void setTemperature(Double temperature) {
		Temperature = temperature;
	}

	public Double getAtmosphericPressure() {
		return AtmosphericPressure;
	}

	public void setAtmosphericPressure(Double atmosphericPressure) {
		AtmosphericPressure = atmosphericPressure;
	}

	public Double getHumidity() {
		return Humidity;
	}

	public void setHumidity(Double humidity) {
		Humidity = humidity;
	}

	public Double getPrecipitation() {
		return Precipitation;
	}

	public void setPrecipitation(Double precipitation) {
		Precipitation = precipitation;
	}

	public Double getSolarRadiation() {
		return SolarRadiation;
	}

	public void setSolarRadiation(Double solarRadiation) {
		SolarRadiation = solarRadiation;
	}

	public Double getWind() {
		return Wind;
	}

	public void setWind(Double wind) {
		Wind = wind;
	}

	
	// Parameterized Constructor
	public WeatherDetails(int id ,String location, Double temperature, Double atmosphericPressure, Double humidity,
			Double precipitation, Double solarRadiation, Double wind) {
		super();
		
		ID = id;
		Location = location;
		Temperature = temperature;
		AtmosphericPressure = atmosphericPressure;
		Humidity = humidity;
		Precipitation = precipitation;
		SolarRadiation = solarRadiation;
		Wind = wind;
	}
	
	
	// Default Constructor 
	public WeatherDetails() {
		super();
	}

	@Override
	public String toString() {
		return "WeatherDetails [ID=" + ID + ", Location=" + Location + ", Temperature=" + Temperature
				+ ", AtmosphericPressure=" + AtmosphericPressure + ", Humidity=" + Humidity + ", Precipitation="
				+ Precipitation + ", SolarRadiation=" + SolarRadiation + ", Wind=" + Wind + "]";
	}


	

}
