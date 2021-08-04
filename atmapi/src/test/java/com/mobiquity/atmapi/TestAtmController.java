package com.mobiquity.atmapi;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;

import com.mobiquity.atmapi.controller.AtmController;
import com.mobiquity.atmapi.model.Address;
import com.mobiquity.atmapi.model.Atm;

@WebMvcTest(controllers = TestAtmController.class)
public class TestAtmController {
	
	@Autowired                           
    private MockMvc mockMvc;  
                                                 
    @MockBean                           
    private AtmController atmController; 
                                               
    private List<Atm> atmList;       
                                            
    @BeforeEach                           
    void setUp() {                               
       this.atmList = new ArrayList<>();                                                       
 
    }

	
	@Test
	void testGetAllAtmCenters() throws Exception {
		given(atmController.getAllAtmCenters()).willReturn(ResponseEntity.ok(atmList));
		
		this.mockMvc.perform(get("/atm/getAllAtmDetails"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.size()", is(atmList.size())));
	}

	
	@Test
	void testGetAtmCentersByCity() throws Exception {
        Atm atm = new Atm();
        Address address = new Address();
        address.setCity("Spijkenisse");
        address.setHousenumber("93");
        address.setPostalcode("3201 EM");
        atm.setAddress(address);
        atmList.add(atm);
        
        given(atmController.getAtmsByCity("Spijkenisse")).willReturn(ResponseEntity.ok(atmList));
        this.mockMvc.perform(get("/atm/getAtmsByCity?city=Spijkenisse", "Spijkenisse"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.[0].address.city", is(atmList.get(0).getAddress().getCity())));
	}
	
	

}
