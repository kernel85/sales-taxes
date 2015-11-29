package com.interview.shoppingcart;

import java.util.List;

import com.interview.item.Item;

public interface ShoppingCart {

	public ShoppingCart            add(ShoppingCartEntry entry);
	public ShoppingCart            add(Item item, int quantity);
	public List<ShoppingCartEntry> getEntries();

}