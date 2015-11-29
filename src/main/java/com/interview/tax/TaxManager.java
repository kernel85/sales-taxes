package com.interview.tax;

import java.math.BigDecimal;

import com.google.inject.ImplementedBy;
import com.interview.tax.impl.TaxManagerImpl;

@ImplementedBy(TaxManagerImpl.class)
public interface TaxManager {
	
	public static final BigDecimal DUTY_TAX        = BigDecimal.valueOf(0.05d);
	public static final BigDecimal ROUNDING_FACTOR = BigDecimal.valueOf(0.05d);
	
	public BigDecimal calculateSaleTax(BigDecimal price, BigDecimal tax);

}
