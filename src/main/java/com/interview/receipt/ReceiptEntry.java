package com.interview.receipt;

import java.math.BigDecimal;

public interface ReceiptEntry {

	public String     getName();
	public int        getQuantity();
	public BigDecimal getSaleTax();
	public BigDecimal getSalePrice();

}