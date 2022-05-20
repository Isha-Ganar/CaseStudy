package com.capg.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.capg.model.WeatherDetails;

@SpringBootTest
@ExtendWith(SpringExtension.class)
class IMongoDBTest {

	@Autowired
	private IMongoDB repo;
	
	@Test
	@DisplayName("Given Weather Should Return Weather Object !")
	void givenWetherReturnsWeaherObject()
	{
       
		WeatherDetails WD1 = new WeatherDetails(401,"Dombivli",376.43,34.4,63.44,34.44,63.73,33.4);
		//repo.insert(WD1);  // data is saving into mongo database
		repo.save(WD1); 
		WeatherDetails WD2 = repo.findById(WD1.getID()).get();  // fetching data from database
		
		assertNotNull(WD2); // to check if object returns the object or not !
		assertEquals(WD1.getLocation(),WD2.getLocation());  // checks whether it returns same value or not
	}

}
