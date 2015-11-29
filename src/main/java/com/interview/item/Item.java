package com.interview.item;

import java.math.BigDecimal;

public interface Item {

	public String       getSku();
	public String       getName();
	public ItemCategory getCategory();
	public BigDecimal   getShelfPrice();
	public boolean      isImported();

}