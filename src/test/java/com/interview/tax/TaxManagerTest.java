package com.interview.tax;

import static junit.framework.Assert.assertEquals;
import static utils.Utils.bd;

import org.junit.Test;

import com.interview.injector.InjectorFactory;

public class TaxManagerTest {
	
	TaxManager taxManager = InjectorFactory.getInjector().getInstance(TaxManager.class);

	@Test public void calculateSalesTaxes() {
		assertEquals(bd("0.00"), taxManager.calculateSaleTax(bd("12.40"), bd("0.00")));
		assertEquals(bd("1.50"), taxManager.calculateSaleTax(bd("14.99"), bd("0.10")));
		assertEquals(bd("7.15"), taxManager.calculateSaleTax(bd("47.50"), bd("0.15")));
		assertEquals(bd("0.60"), taxManager.calculateSaleTax(bd("11.25"), bd("0.05")));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void negativeTax() {
		assertEquals(bd("1.00"), taxManager.calculateSaleTax(bd("10"), bd("-0.05")));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void invalidTax() {
		assertEquals(bd("1.00"), taxManager.calculateSaleTax(bd("10"), bd("1.05")));
	}
	
}
