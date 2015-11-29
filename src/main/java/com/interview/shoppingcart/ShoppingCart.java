package com.interview.shoppingcart;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.LinkedList;
import java.util.List;

import com.interview.item.Item;

public class ShoppingCart {
	
	public static ShoppingCart empty() {
		return new ShoppingCart(new LinkedList<>());
	}
	
	private ShoppingCart(List<ShoppingCartEntry> entries) {
		this.entries = checkNotNull(entries, "shopping cart list cannot be a null value");
	}
	
	private final List<ShoppingCartEntry> entries;
	
	public ShoppingCart add(ShoppingCartEntry entry) {
		entries.add(checkNotNull(entry, "shopping cart entry cannot be a null value"));
		return this;
	}
	
	public ShoppingCart add(Item item, int quantity) {
		entries.add(ShoppingCartEntry.of(item, quantity));
		return this;
	}
	
	public List<ShoppingCartEntry> getEntries() { 
		return entries; 
	}

}
