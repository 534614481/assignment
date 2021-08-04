package com.mobiquity.atmapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class AtmServiceImpl implements AtmService {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Value("${ATM.URL}")
	private String atmServiceUrl;

	@Override
	public ResponseEntity<String> getAllAtmCenters() {
		ResponseEntity<String> forEntity = restTemplate.getForEntity(atmServiceUrl, String.class);
		return ResponseEntity.ok(forEntity.getBody().substring(5));
	}
	
	

}
