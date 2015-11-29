package com.interview.receipt.impl;

import static com.google.common.base.Preconditions.checkNotNull;

import java.math.BigDecimal;

import com.interview.receipt.ReceiptEntry;
import com.interview.shoppingcart.ShoppingCartEntry;

public class ReceiptEntryImpl implements ReceiptEntry {
	
	public static ReceiptEntry of(ShoppingCartEntry sce) {
		return new ReceiptEntryImpl(checkNotNull(sce, "shopping cart entry cannot be a null value"));
	}
	
	private ReceiptEntryImpl(ShoppingCartEntry sce) {
		this.name      = sce.getItem().getName();
		this.quantity  = sce.getQuantity();
		this.saleTax   = sce.getSaleTax().multiply(new BigDecimal(quantity));
		this.salePrice = sce.getUnitSalePrice().add(saleTax).multiply(new BigDecimal(quantity));
	}

	private final String     name;
	private final int        quantity;
	private final BigDecimal saleTax;
	private final BigDecimal salePrice;
	
	@Override public String     getName()      { return name; }
	@Override public int        getQuantity()  { return quantity; }
	@Override public BigDecimal getSaleTax()   { return saleTax; }
	@Override public BigDecimal getSalePrice() { return salePrice; }

	@Override public String toString() {
		return quantity + " " + name + ": " + salePrice;
	}

}
