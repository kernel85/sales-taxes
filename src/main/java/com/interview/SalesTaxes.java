package com.interview;

import java.util.stream.Collectors;

import com.interview.receipt.Receipt;
import com.interview.receipt.impl.ReceiptEntryImpl;
import com.interview.receipt.impl.ReceiptImpl;
import com.interview.samples.ShoppingCartSamples;
import com.interview.shoppingcart.ShoppingCart;

public class SalesTaxes {
	
	public static void main(String[] args) {
		
		System.out.println("================ Sales Taxes ================");
		System.out.println();
		
		System.out.println(">>>>>>>>>> OUTPUT 1 <<<<<<<<<<");
		printReceipt(ShoppingCartSamples.INPUT_1);
		System.out.println();
		
		System.out.println(">>>>>>>>>> OUTPUT 2 <<<<<<<<<<");
		printReceipt(ShoppingCartSamples.INPUT_2);
		System.out.println();

		System.out.println(">>>>>>>>>> OUTPUT 3 <<<<<<<<<<");
		printReceipt(ShoppingCartSamples.INPUT_3);
		
	}
	
	public static void printReceipt(ShoppingCart shoppingCart) {
		Receipt receipt = new ReceiptImpl(shoppingCart.getEntries().stream().map(ReceiptEntryImpl::of).collect(Collectors.toList()));
		receipt.getEntries().forEach(System.out::println);
		System.out.println(receipt);
	}

}
