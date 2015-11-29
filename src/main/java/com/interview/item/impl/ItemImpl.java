package com.interview.item.impl;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

import java.math.BigDecimal;

import com.interview.item.Item;
import com.interview.item.ItemCategory;

public class ItemImpl implements Item {
	
	public static final BigDecimal DUTY_TAX = new BigDecimal("0.05");
	
	public static Item imported(String sku, String name, ItemCategory category, BigDecimal shelfPrice) {
		return new ItemImpl(sku, name, category, shelfPrice, true);
	}
	
	public static Item of(String sku, String name, ItemCategory category, BigDecimal shelfPrice) {
		return new ItemImpl(sku, name, category, shelfPrice, false);
	}
	
	private ItemImpl(String sku, String name, ItemCategory category, BigDecimal shelfPrice, boolean imported) {
		this.sku        = checkNotNull(sku,        "sku cannot be a null value");
		this.name       = checkNotNull(name,       "name cannot be a null value");
		this.category   = checkNotNull(category,   "category cannot be a null value");
		this.shelfPrice = checkNotNull(shelfPrice, "shelf price cannot be a null value");
		this.imported   = imported;
		checkArgument(shelfPrice.compareTo(BigDecimal.ZERO) >= 0, "shel price must be a positive value");
	}

	private final String       sku;
	private final String       name;
	private final ItemCategory category;
	private final BigDecimal   shelfPrice;
	private final boolean      imported;
	
	@Override public String       getSku()        { return sku; }
	@Override public String       getName()       { return name; }
	@Override public ItemCategory getCategory()   { return category; }
	@Override public BigDecimal   getShelfPrice() { return shelfPrice; }
	@Override public boolean      isImported()    { return imported; }

	@Override public int hashCode() {
		int result = 1;
		result = 31 * result + category.hashCode();
		result = 31 * result + (imported ? 1231 : 1237);
		result = 31 * result + name.hashCode();
		result = 31 * result + shelfPrice.hashCode();
		result = 31 * result + sku.hashCode();
		return result;
	}

	@Override public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		Item other = (Item) obj;
		return category.equals(other.getCategory())
		    && imported == other.isImported()
		    && name.equals(other.getName())
		    && category.equals(other.getCategory())
		    && shelfPrice.equals(other.getShelfPrice())
		    && sku.equals(other.getSku());
	}

}
