package com.interview.receipt;

import com.google.inject.ImplementedBy;
import com.interview.receipt.impl.ReceiptManagerImpl;
import com.interview.shoppingcart.ShoppingCart;

@ImplementedBy(ReceiptManagerImpl.class)
public interface ReceiptManager {

	public Receipt generateReceipt(ShoppingCart shoppingCart);

}
