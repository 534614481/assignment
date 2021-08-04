package com.mobiquity.atmapi.service;


import org.springframework.http.ResponseEntity;

public interface AtmService {
	ResponseEntity<String> getAllAtmCenters();
}
