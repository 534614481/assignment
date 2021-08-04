package com.mobiquity.atmapi;

import static org.junit.Assert.assertNotNull;
import static org.mockito.BDDMockito.given;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;
import com.mobiquity.atmapi.service.AtmService;

@ExtendWith(MockitoExtension.class)
public class TestAtmServiceImpl {
	
	@Mock          
    private AtmService atmService; 
                                               
	@Test
	void testGetAllAtmCenters() throws Exception {
		given(atmService.getAllAtmCenters()).willReturn(getResponse());
		assertNotNull(atmService.getAllAtmCenters());
	}
	
	private ResponseEntity<String> getResponse() {
		
		String resp="[\r\n"
				+ "    {\r\n"
				+ "        \"address\": {\r\n"
				+ "            \"street\": \"Thijplein\",\r\n"
				+ "            \"housenumber\": \"1\",\r\n"
				+ "            \"postalcode\": \"7596 KM\",\r\n"
				+ "            \"city\": \"Rossum\",\r\n"
				+ "            \"geoLocation\": {\r\n"
				+ "                \"lat\": \"52.351943\",\r\n"
				+ "                \"lng\": \"6.922799\"\r\n"
				+ "            }\r\n"
				+ "        },\r\n"
				+ "        \"distance\": 0,\r\n"
				+ "        \"openingHours\": [\r\n"
				+ "            {\r\n"
				+ "                \"dayOfWeek\": 2,\r\n"
				+ "                \"hours\": [\r\n"
				+ "                    {\r\n"
				+ "                        \"hourFrom\": \"07:00\",\r\n"
				+ "                        \"hourTo\": \"23:00\"\r\n"
				+ "                    }\r\n"
				+ "                ]\r\n"
				+ "            },\r\n"
				+ "            {\r\n"
				+ "                \"dayOfWeek\": 3,\r\n"
				+ "                \"hours\": [\r\n"
				+ "                    {\r\n"
				+ "                        \"hourFrom\": \"07:00\",\r\n"
				+ "                        \"hourTo\": \"23:00\"\r\n"
				+ "                    }\r\n"
				+ "                ]\r\n"
				+ "            },\r\n"
				+ "            {\r\n"
				+ "                \"dayOfWeek\": 4,\r\n"
				+ "                \"hours\": [\r\n"
				+ "                    {\r\n"
				+ "                        \"hourFrom\": \"07:00\",\r\n"
				+ "                        \"hourTo\": \"23:00\"\r\n"
				+ "                    }\r\n"
				+ "                ]\r\n"
				+ "            },\r\n"
				+ "            {\r\n"
				+ "                \"dayOfWeek\": 5,\r\n"
				+ "                \"hours\": [\r\n"
				+ "                    {\r\n"
				+ "                        \"hourFrom\": \"07:00\",\r\n"
				+ "                        \"hourTo\": \"23:00\"\r\n"
				+ "                    }\r\n"
				+ "                ]\r\n"
				+ "            },\r\n"
				+ "            {\r\n"
				+ "                \"dayOfWeek\": 6,\r\n"
				+ "                \"hours\": [\r\n"
				+ "                    {\r\n"
				+ "                        \"hourFrom\": \"07:00\",\r\n"
				+ "                        \"hourTo\": \"23:00\"\r\n"
				+ "                    }\r\n"
				+ "                ]\r\n"
				+ "            },\r\n"
				+ "            {\r\n"
				+ "                \"dayOfWeek\": 7,\r\n"
				+ "                \"hours\": [\r\n"
				+ "                    {\r\n"
				+ "                        \"hourFrom\": \"07:00\",\r\n"
				+ "                        \"hourTo\": \"23:00\"\r\n"
				+ "                    }\r\n"
				+ "                ]\r\n"
				+ "            },\r\n"
				+ "            {\r\n"
				+ "                \"dayOfWeek\": 1,\r\n"
				+ "                \"hours\": [\r\n"
				+ "                    {\r\n"
				+ "                        \"hourFrom\": \"07:00\",\r\n"
				+ "                        \"hourTo\": \"23:00\"\r\n"
				+ "                    }\r\n"
				+ "                ]\r\n"
				+ "            }\r\n"
				+ "        ],\r\n"
				+ "        \"functionality\": \"Geldautomaat\",\r\n"
				+ "        \"type\": \"GELDMAAT\"\r\n"
				+ "    }]";
		
		
		return ResponseEntity.ok(resp);
		
		
	}
	
}
