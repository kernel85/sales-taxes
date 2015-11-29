package com.interview.shoppingcart;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

import java.math.BigDecimal;

import com.interview.item.Item;

public class ShoppingCartEntry {
	
	public static final ShoppingCartEntry of(Item item, int quantity) {
		return new ShoppingCartEntry(item, quantity);
	}
	
	private ShoppingCartEntry(Item item, int quantity) {
		checkArgument(quantity > 0, "quantity must be a positive value");
		this.item          = checkNotNull(item, "item cannot be a null value");
		this.quantity      = quantity;
		this.unitSalePrice = item.getShelfPrice();
		this.saleTax       = item.getCategory().getSaleTax();
	}

	private final Item       item;
	private final int        quantity;
	private final BigDecimal unitSalePrice;
	private final BigDecimal saleTax;

	public Item       getItem()          { return item; }
	public int        getQuantity()      { return quantity; }
	public BigDecimal getUnitSalePrice() { return unitSalePrice; }
	public BigDecimal getSaleTax()       { return saleTax; }
	
}
