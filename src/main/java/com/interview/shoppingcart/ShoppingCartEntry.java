package com.interview.shoppingcart;

import java.math.BigDecimal;

import com.interview.item.Item;

public interface ShoppingCartEntry {

	public Item getItem();
	public int  getQuantity();

	public BigDecimal getUnitSalePrice();
	public BigDecimal getSaleTax();

}