package com.interview.tax.impl;

import java.math.BigDecimal;
import java.math.RoundingMode;

import com.google.inject.Singleton;
import com.interview.tax.TaxManager;

@Singleton
public class TaxManagerImpl implements TaxManager {

	@Override public BigDecimal calculateSaleTax(BigDecimal price, BigDecimal tax) {
		double finalTaxPercentage = tax.doubleValue();
		double itemPrice          = price.doubleValue();
		double roundFactor        = TaxManager.ROUNDING_FACTOR.doubleValue();
		double saleTax            = (double) Math.ceil( (itemPrice * finalTaxPercentage) / roundFactor) * roundFactor;
		return BigDecimal.valueOf(saleTax).setScale(2, RoundingMode.HALF_UP);
	}

}
