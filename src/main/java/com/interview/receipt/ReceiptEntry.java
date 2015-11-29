package com.interview.receipt;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

import java.math.BigDecimal;

public class ReceiptEntry {
	
	public static ReceiptEntry of(String name, int quantity, BigDecimal salePrice, BigDecimal saleTax) {
		return new ReceiptEntry(name, quantity, salePrice, saleTax);
	}
	
	private ReceiptEntry(String name, int quantity, BigDecimal salePrice, BigDecimal saleTax) {
		checkArgument(quantity > 0, "quantity must be a positve value");
		this.name      = checkNotNull(name);
		this.quantity  = quantity;
		this.salePrice = checkNotNull(salePrice);
		this.saleTax   = checkNotNull(saleTax);
	}
	
	private final String     name;
	private final int        quantity;
	private final BigDecimal salePrice;
	private final BigDecimal saleTax;

	public String     getName()      { return name; }
	public int        getQuantity()  { return quantity; }
	public BigDecimal getSalePrice() { return salePrice; }
	public BigDecimal getSaleTax()   { return saleTax; }

	@Override public String toString() {
		return quantity + " " + name + ": " + salePrice;
	}

}
