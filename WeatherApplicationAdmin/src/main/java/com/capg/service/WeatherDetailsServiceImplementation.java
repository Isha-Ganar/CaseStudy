package com.capg.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.exception.DataNotFound;
import com.capg.exception.WeatherIsAlreadyPresentException;
import com.capg.model.WeatherDetails;
import com.capg.repository.IMongoDB;


@Service
public class WeatherDetailsServiceImplementation implements WeatherDetailsService
{

	private IMongoDB Database_Obj;
	
	@Autowired
	public WeatherDetailsServiceImplementation(IMongoDB database_Obj) {
		super();
		Database_Obj = database_Obj;
	}

	// This Method Will Insert Single document of data into the database
	@Override
	public WeatherDetails AddWeather(WeatherDetails WD)  throws WeatherIsAlreadyPresentException  
	{
		
		  if(Database_Obj.existsById(WD.getID()))
		  {
			  throw new WeatherIsAlreadyPresentException();
		  }
		 
		  WeatherDetails weather = Database_Obj.insert(WD);
		  
		  return weather;
		
	}

	//This method will return list of all present documents. 
	@Override
	public List<WeatherDetails> getAllWeathers() throws DataNotFound
	{
	   List<WeatherDetails> list = this.Database_Obj.findAll();
		
		if(list.isEmpty()) 
		{
			throw new DataNotFound();
		}
		
		return (List<WeatherDetails>) Database_Obj.findAll();
		
	}
	
	@Override
	public WeatherDetails UpdateWeather(WeatherDetails WD)
	{
		
		WeatherDetails WD_temp;
	
		Optional<WeatherDetails> opt = this.Database_Obj.findById(WD.getID());
		
		if(opt.isPresent()) 
		{
			WD_temp = opt.get();
			WD_temp.setID(WD.getID());
			WD_temp.setLocation(WD.getLocation());
			WD_temp.setAtmosphericPressure(WD.getAtmosphericPressure());
			WD_temp.setHumidity(WD.getHumidity());
			WD_temp.setPrecipitation(WD.getPrecipitation());
			WD_temp.setSolarRadiation(WD.getSolarRadiation());
			WD_temp.setTemperature(WD.getTemperature());
			WD_temp.setWind(WD.getWind());
			
			Database_Obj.save(WD_temp);
			
			return WD_temp;
			
		}else 
		{
		  return new WeatherDetails();
		}
	}
	
	
	@Override
	public void DeleteWeatherById(int id) 
	{
		// TODO Auto-generated method stub
		
		Optional<WeatherDetails> Weather = this.Database_Obj.findById(id);

        if (Weather.isPresent()) {
        	
            this.Database_Obj.delete(Weather.get());
        }  
		//Database_Obj.deleteById(id);
	}

	

}
