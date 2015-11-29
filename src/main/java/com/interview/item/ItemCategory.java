package com.interview.item;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

import java.math.BigDecimal;

public enum ItemCategory {
	
	BOOK    (BigDecimal.ZERO),
	FOOD    (BigDecimal.ZERO),
	MEDICAL (BigDecimal.ZERO),
	OTHER   (new BigDecimal("0.10"));
	
	private ItemCategory(BigDecimal saleTax) {
		checkNotNull(saleTax, "sale tax cannot be a null value");
		checkArgument(saleTax.compareTo(BigDecimal.ZERO) >= 0 && saleTax.compareTo(BigDecimal.ONE) <= 0, "sale tax must be within 0 and 1");
		this.saleTax = saleTax;
	}
	
	private final BigDecimal saleTax;
	public BigDecimal getSaleTax() { return saleTax; }

}
