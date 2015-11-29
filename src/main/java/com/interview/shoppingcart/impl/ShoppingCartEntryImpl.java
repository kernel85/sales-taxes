package com.interview.shoppingcart.impl;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

import java.math.BigDecimal;
import java.math.RoundingMode;

import com.interview.item.Item;
import com.interview.item.impl.ItemImpl;
import com.interview.shoppingcart.ShoppingCartEntry;

public class ShoppingCartEntryImpl implements ShoppingCartEntry {
	
	public static final ShoppingCartEntryImpl of(Item item, int quantity) {
		return new ShoppingCartEntryImpl(item, quantity);
	}
	
	private ShoppingCartEntryImpl(Item item, int quantity) {
		this.item = checkNotNull(item, "item cannot be a nulla value");
		this.quantity = quantity;
		checkArgument(quantity > 0, "quantity must be a positive value");
	}

	private final Item item;
	private final int  quantity;

	@Override public Item getItem()     { return item; }
	@Override public int  getQuantity() { return quantity; }

	@Override public BigDecimal getUnitSalePrice() { return item.getShelfPrice(); }

	@Override public BigDecimal getSaleTax() {
		
		double finalTaxPercentage = (item.isImported() ? item.getCategory().getSaleTax().add(ItemImpl.DUTY_TAX) : item.getCategory().getSaleTax()).doubleValue();
		double itemPrice          = item.getShelfPrice().doubleValue();
		double roundFactor        = 0.05d;
		double saleTax            = (double) Math.ceil( (itemPrice * finalTaxPercentage) / roundFactor) * roundFactor;

		return BigDecimal.valueOf(saleTax).setScale(2, RoundingMode.HALF_UP);
	}
	
}
