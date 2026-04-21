package com.trsystems.model;

import java.io.Serializable;
import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Exchange implements Serializable {
	private static final long serialVersionUID = 4952277079267652059L;

	private Long id;
	private String from;
	private String to;
	private BigDecimal conversionFactory;
	private BigDecimal conversionValue;
	private String environment;

}
