package com.interview;

import com.google.inject.Injector;
import com.interview.injector.InjectorFactory;
import com.interview.receipt.Receipt;
import com.interview.receipt.ReceiptManager;
import com.interview.samples.ShoppingCartSamples;
import com.interview.shoppingcart.ShoppingCart;

public class SalesTaxes {
	
	public static void main(String[] args) {
		
		Injector       injector       = InjectorFactory.getInjector();
		ReceiptManager receiptManager = injector.getInstance(ReceiptManager.class);
		
		System.out.println("================ Sales Taxes ================");
		System.out.println();
		
		System.out.println(">>>>>>>>>> OUTPUT 1 <<<<<<<<<<");
		printReceipt(receiptManager, ShoppingCartSamples.INPUT_1);
		System.out.println();
		
		System.out.println(">>>>>>>>>> OUTPUT 2 <<<<<<<<<<");
		printReceipt(receiptManager, ShoppingCartSamples.INPUT_2);
		System.out.println();

		System.out.println(">>>>>>>>>> OUTPUT 3 <<<<<<<<<<");
		printReceipt(receiptManager, ShoppingCartSamples.INPUT_3);
		
	}
	
	public static void printReceipt(ReceiptManager receiptManager, ShoppingCart shoppingCart) {
		Receipt receipt = receiptManager.generateReceipt(shoppingCart);
		receipt.getEntries().forEach(System.out::println);
		System.out.println(receipt);
	}

}
