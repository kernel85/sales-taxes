package com.interview.shoppingcart;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.interview.item.Item;

public class ShoppingCart {
	
	public static ShoppingCart empty() {
		return new ShoppingCart(new HashMap<>());
	}
	
	private ShoppingCart(Map<Item, Integer> entries) {
		this.entries = entries;
	}
	
	private final Map<Item, Integer> entries;
	
	public ShoppingCart add(Item item, int quantity) {
		entries.merge(item, quantity, Integer::sum);
		return this;
	}
	
	public List<ShoppingCartEntry> getEntries() { 
		return entries.entrySet().stream().map((Map.Entry<Item,Integer> e) -> {
			return ShoppingCartEntry.of(e.getKey(), e.getValue());
		}).collect(Collectors.toList());
	}

}
