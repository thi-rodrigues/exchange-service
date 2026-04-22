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
import com.trsystems.repository.ExchangeRepository;

@RestController
@RequestMapping("exchange-service")
public class ExchangeController {
	
	@Autowired
	private InstanceInformation information;
	@Autowired
	private ExchangeRepository exchangeRepository;

	@GetMapping(value="/{amount}/{from}/{to}", produces=MediaType.APPLICATION_JSON_VALUE)
	public Exchange getExchange(
			@PathVariable BigDecimal amount, 
			@PathVariable String from, 
			@PathVariable String to) {
		
		Exchange exchange = exchangeRepository.findByFromAndTo(from, to);
		
		if ( exchange == null )
			throw new RuntimeException("Currency Unsupported!");
		
		BigDecimal conversionFactor = exchange.getConversionFactory();
		BigDecimal convertedValue = conversionFactor.multiply(amount);
		exchange.setConversionValue(convertedValue);
		exchange.setEnvironment("PORT " + information.retrieveServerPort());
		return exchange;
	}
}
