package com.capg.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.capg.model.WeatherDetails;
import com.capg.repository.IMongoDB;

@Service
public class WeatherDetailsServiceImplementation implements WeatherDetailsService 
{
   
	private IMongoDB Database_Obj;
	
	

	public WeatherDetailsServiceImplementation(IMongoDB database_Obj) {
		super();
		Database_Obj = database_Obj;
	}



	//This method will return list of all present documents.
	@Override
	public List<WeatherDetails> getAllWeathers() 
	{
		// TODO Auto-generated method stub
		return (List<WeatherDetails>) Database_Obj.findAll();
		
	}



	@Override
	public WeatherDetails GetWeatherById(int id) {
		// TODO Auto-generated method stub
		Optional<WeatherDetails> opt = this.Database_Obj.findById(id);
		WeatherDetails WD_temp;
		 if (opt.isPresent()) 
		 {
			    WD_temp = opt.get();
	            this.Database_Obj.findById(id);
	            return WD_temp;
	     } 
		 else{
	        	return new WeatherDetails();
	     }
		
		
	}

}
