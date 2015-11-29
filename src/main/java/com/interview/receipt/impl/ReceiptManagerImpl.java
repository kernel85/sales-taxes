package com.interview.receipt.impl;

import static com.google.common.base.Preconditions.checkNotNull;

import java.math.BigDecimal;
import java.util.stream.Collectors;

import com.google.inject.Inject;
import com.interview.receipt.Receipt;
import com.interview.receipt.ReceiptEntry;
import com.interview.receipt.ReceiptManager;
import com.interview.shoppingcart.ShoppingCart;
import com.interview.tax.TaxManager;

public class ReceiptManagerImpl implements ReceiptManager {
	
	@Inject TaxManager taxManager;
	
	@Override public Receipt generateReceipt(ShoppingCart shoppingCart) {
		checkNotNull(shoppingCart);
		return Receipt.of(
			shoppingCart.getEntries().stream().map(sce -> {
				int        quantity  = sce.getQuantity();
				BigDecimal tax       = sce.getItem().isImported() ? sce.getSaleTax().add(TaxManager.DUTY_TAX) : sce.getSaleTax();
				BigDecimal saleTax   = taxManager.calculateSaleTax(sce.getUnitSalePrice(), tax).multiply(BigDecimal.valueOf(quantity));
				BigDecimal salePrice = sce.getUnitSalePrice().multiply(BigDecimal.valueOf(quantity)).add(saleTax);
				return ReceiptEntry.of(sce.getItem().getName(), quantity, salePrice, saleTax);
			}).collect(Collectors.toList())
		);
	}

}
