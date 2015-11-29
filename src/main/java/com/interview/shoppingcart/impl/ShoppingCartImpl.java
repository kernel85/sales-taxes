package com.interview.shoppingcart.impl;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.LinkedList;
import java.util.List;

import com.interview.item.Item;
import com.interview.shoppingcart.ShoppingCart;
import com.interview.shoppingcart.ShoppingCartEntry;

public class ShoppingCartImpl implements ShoppingCart {
	
	public ShoppingCartImpl() {
		entries = new LinkedList<>();
	}

	private final List<ShoppingCartEntry> entries;
	
	public ShoppingCartImpl(List<ShoppingCartEntry> entries) {
		this.entries = checkNotNull(entries);
	}
	
	@Override public ShoppingCart add(ShoppingCartEntry entry) {
		entries.add(checkNotNull(entry));
		return this;
	}
	
	@Override public ShoppingCart add(Item item, int quantity) {
		entries.add(ShoppingCartEntryImpl.of(item, quantity));
		return this;
	}
	
	@Override public List<ShoppingCartEntry> getEntries() { 
		return entries; 
	}

}
