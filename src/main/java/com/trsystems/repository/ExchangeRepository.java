package com.trsystems.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trsystems.model.Exchange;

public interface ExchangeRepository extends JpaRepository<Exchange, Long> {
	
	Exchange findByFromAndTo(String from, String to);

}
