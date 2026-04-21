package com.trsystems.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trsystems.environment.InstanceInformation;
import com.trsystems.model.Exchange;

@RestController
@RequestMapping("exchange-service")
public class ExchangeController {
	
	@Autowired
	private InstanceInformation information;

	@GetMapping(value="/{amount}/{from}/{to}", produces=MediaType.APPLICATION_JSON_VALUE)
	public Exchange getExchenge(
			@PathVariable BigDecimal amount, 
			@PathVariable String from, 
			@PathVariable String to) {
		return new Exchange(1L, null, null, null, null, information.retrieveServerPort());
	}
}
