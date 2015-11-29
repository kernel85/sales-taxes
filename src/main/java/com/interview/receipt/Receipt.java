package com.interview.receipt;

import java.math.BigDecimal;
import java.util.List;

public interface Receipt {

	public Receipt            add(ReceiptEntry entry);
	public List<ReceiptEntry> getEntries();
	public BigDecimal         getSalesTaxes();
	public BigDecimal         getTotal();

}