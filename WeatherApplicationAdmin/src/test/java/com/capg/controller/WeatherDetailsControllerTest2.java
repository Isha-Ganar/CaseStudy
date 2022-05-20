package com.capg.controller;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import com.capg.model.WeatherDetails;
import com.capg.service.WeatherDetailsService;
import com.fasterxml.jackson.databind.ObjectMapper;


@ExtendWith(MockitoExtension.class)
class WeatherDetailsControllerTest2 
{
	@Autowired
	private MockMvc mock_mvc;
	
	@Mock
	private WeatherDetailsService WServ;
	
	private WeatherDetails WD;
	
	List <WeatherDetails> WDList;
	
	 @InjectMocks
	private WeatherDetailsController WDC;
	
	 
	 @BeforeEach
	 public void SetUp() 
	 {
		
		 WD = new WeatherDetails(601, "Queen India",63.43,234.42,24.33,63.33,64.35,34.31); //User Input
		 mock_mvc = MockMvcBuilders.standaloneSetup(WDC).build() ;
	 }

	@Test
	public void GetAllWeathersTest()throws Exception
	{
		 when(WServ.getAllWeathers()).thenReturn(WDList);
		 
		 mock_mvc.perform(MockMvcRequestBuilders.get("/api/Weather/GetAllWeathers")
		 .contentType(MediaType.APPLICATION_JSON)
		 .content(asJSONString(WD)))
         .andDo(MockMvcResultHandlers.print());
		 verify(WServ,times(1)).getAllWeathers();
	}
	
	private static String asJSONString(final Object obj) 
	{
		try 
		{
			
			return new ObjectMapper().writeValueAsString(obj);
			
		}catch(Exception e)
		{
			
			throw new RuntimeException(e);
			
		}
	}

	

}
