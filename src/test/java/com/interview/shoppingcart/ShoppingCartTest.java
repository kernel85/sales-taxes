package com.interview.shoppingcart;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.interview.samples.ItemSamples;

public class ShoppingCartTest {
	
	@Test public void testMergeSingleItem() {
		ShoppingCart cart = ShoppingCart.empty();
		cart.add(ItemSamples.BOOK, 1);
		cart.add(ItemSamples.BOOK, 1);
		cart.add(ItemSamples.BOOK, 1);
		
		assertEquals(1, cart.getEntries().size());
		assertEquals(3, cart.getEntries().get(0).getQuantity());
	}
	
	@Test public void testMergeManyItems() {
		ShoppingCart cart = ShoppingCart.empty();
		cart.add(ItemSamples.BOOK,                1);
		cart.add(ItemSamples.BOOK,                1);
		cart.add(ItemSamples.CHOCOLATE_BAR,       1);
		cart.add(ItemSamples.HEADACHE_PILLS_PACK, 1);
		assertEquals(3, cart.getEntries().size());
	}
	
	@Test public void testEmpty() {
		assertTrue(ShoppingCart.empty().getEntries().isEmpty());
	}

}
