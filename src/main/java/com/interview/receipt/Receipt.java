package com.interview.receipt;

import static com.google.common.base.Preconditions.checkNotNull;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

public class Receipt {
	
	public static Receipt of(List<ReceiptEntry> entries) {
		return new Receipt(entries);
	}
	
	private Receipt(List<ReceiptEntry> entries) {
		this.entries = checkNotNull(entries, "receipt entry list cannot be a null value");
		salesTaxes = entries.stream().map(ReceiptEntry::getSaleTax).collect(Collectors.reducing(BigDecimal.ZERO, BigDecimal::add));
		total = entries.stream().map(ReceiptEntry::getSalePrice).collect(Collectors.reducing(BigDecimal.ZERO, BigDecimal::add));
	}
	
	private final List<ReceiptEntry> entries;
	private final BigDecimal         salesTaxes;
	private final BigDecimal         total;

	public List<ReceiptEntry> getEntries()    { return entries; }
	public BigDecimal         getSalesTaxes() { return salesTaxes; }
	public BigDecimal         getTotal()      { return total; }

	@Override public String toString() {
		return "Sales Taxes: " + salesTaxes + "\n" + "Total: " + total;
	}

}
