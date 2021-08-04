package com.mobiquity.atmapi.controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mobiquity.atmapi.model.Atm;
import com.mobiquity.atmapi.service.AtmService;

@RestController
@RequestMapping("/atm")
public class AtmController {
	
	@Autowired
	private AtmService atmService;
	
	@GetMapping("/getAllAtmDetails")
	public ResponseEntity<List<Atm>> getAllAtmCenters() throws JsonMappingException, JsonProcessingException{
		List<Atm> listOfAtmCenters = getListOfAtmCenters();
		return ResponseEntity.ok(listOfAtmCenters);
	}
	
	@GetMapping("/getAtmsByCity")
	public ResponseEntity<List<Atm>> getAtmsByCity(@RequestParam String city) throws JsonMappingException, JsonProcessingException{
		List<Atm> listOfAtmCenters = getListOfAtmCenters();
		List<Atm> cityList = listOfAtmCenters.stream().filter(x->x.getAddress().getCity().equalsIgnoreCase(city)).collect(Collectors.toList());
		return ResponseEntity.ok(cityList);
	}
	
	private List<Atm> getListOfAtmCenters() throws JsonMappingException, JsonProcessingException{
		ResponseEntity<String> allAtmCenters = atmService.getAllAtmCenters();
		ObjectMapper objectMapper = new ObjectMapper(); 
		Atm[] allAtmCenterArray = objectMapper.readValue(allAtmCenters.getBody(), Atm[].class);
		return	Arrays.asList(allAtmCenterArray);
	}

}
