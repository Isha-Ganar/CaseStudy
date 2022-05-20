package com.capg.service;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import com.capg.exception.WeatherIsAlreadyPresentException;
import com.capg.model.WeatherDetails;
import com.capg.repository.IMongoDB;


@SpringBootTest
@ExtendWith(MockitoExtension.class)
class WeatherDetailsServiceTest
{
	@Mock
	private IMongoDB DB_Obj;
	
	@InjectMocks
	private WeatherDetailsServiceImplementation WeatherServ;
	
	@Test
	void testAddWeather() throws WeatherIsAlreadyPresentException
	{ 
		WeatherDetails WD1 = new WeatherDetails(101,"Mumbai",40.32,1.00,5.0,3.0,200.0,300.0); //User Input
		when(DB_Obj.insert(WD1)).thenReturn(WD1);
		WeatherServ.AddWeather(WD1);
		verify(DB_Obj, times(1)).insert(WD1);
	}

}
