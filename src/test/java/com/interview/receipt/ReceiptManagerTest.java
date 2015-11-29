package com.interview.receipt;

import static junit.framework.Assert.assertEquals;
import static utils.Utils.bd;

import org.junit.Test;

import com.google.inject.Inject;
import com.interview.injector.InjectorFactory;
import com.interview.samples.ShoppingCartSamples;
import com.interview.shoppingcart.ShoppingCart;

public class ReceiptManagerTest {
	
	@Inject ReceiptManager receiptManager = InjectorFactory.getInjector().getInstance(ReceiptManager.class);
	
	@Test public void testGenerateReceipt1() {
		ShoppingCart shoppingCart = ShoppingCartSamples.INPUT_1;
		Receipt      receipt      = receiptManager.generateReceipt(shoppingCart);
		assertEquals(shoppingCart.getEntries().size(), receipt.getEntries().size());
		assertEquals(bd("1.50"),  receipt.getSalesTaxes());
		assertEquals(bd("29.83"), receipt.getTotal());
	}
	
	@Test public void testGenerateReceipt2() {
		ShoppingCart shoppingCart = ShoppingCartSamples.INPUT_2;
		Receipt      receipt      = receiptManager.generateReceipt(shoppingCart);
		assertEquals(shoppingCart.getEntries().size(), receipt.getEntries().size());
		assertEquals(bd("7.65"),  receipt.getSalesTaxes());
		assertEquals(bd("65.15"), receipt.getTotal());
	}

	@Test public void testGenerateReceipt3() {
		ShoppingCart shoppingCart = ShoppingCartSamples.INPUT_3;
		Receipt      receipt      = receiptManager.generateReceipt(shoppingCart);
		assertEquals(shoppingCart.getEntries().size(), receipt.getEntries().size());
		assertEquals(bd("6.70"),  receipt.getSalesTaxes());
		assertEquals(bd("74.68"), receipt.getTotal());
	}

}
