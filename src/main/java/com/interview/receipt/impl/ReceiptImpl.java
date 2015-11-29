package com.interview.receipt.impl;

import static com.google.common.base.Preconditions.checkNotNull;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import com.interview.receipt.Receipt;
import com.interview.receipt.ReceiptEntry;

public class ReceiptImpl implements Receipt {
	
	public ReceiptImpl() {
		entries     = new LinkedList<>();
		salesTaxes  = BigDecimal.ZERO;
		total       = BigDecimal.ZERO;
	}

	public ReceiptImpl(List<ReceiptEntry> entries) {
		this.entries = entries;
		salesTaxes = entries.stream().map(ReceiptEntry::getSaleTax).collect(Collectors.reducing(BigDecimal.ZERO, BigDecimal::add));
		total = entries.stream().map(ReceiptEntry::getSalePrice).collect(Collectors.reducing(BigDecimal.ZERO, BigDecimal::add));
	}
	
	private final List<ReceiptEntry> entries;
	private final BigDecimal         salesTaxes;
	private final BigDecimal         total;

	@Override public Receipt add(ReceiptEntry entry) {
		entries.add(checkNotNull(entry));
		return this;
	}
	
	@Override public List<ReceiptEntry> getEntries()    { return entries; }
	@Override public BigDecimal         getSalesTaxes() { return salesTaxes; }
	@Override public BigDecimal         getTotal()      { return total; }

	@Override public String toString() {
		return "Sales Taxes: " + salesTaxes + "\n" + "Total: " + total;
	}

}
