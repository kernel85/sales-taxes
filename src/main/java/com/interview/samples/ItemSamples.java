package com.interview.samples;

import java.math.BigDecimal;

import com.interview.item.Item;
import com.interview.item.ItemCategory;
import com.interview.item.impl.ItemImpl;

public class ItemSamples {

	public static Item BOOK                = ItemImpl.of("BOK01", "Book",                     ItemCategory.BOOK,    new BigDecimal("12.49"));
	public static Item MUSIC_CD            = ItemImpl.of("MCD01", "Music CD",                 ItemCategory.OTHER,   new BigDecimal("14.99"));
	public static Item CHOCOLATE_BAR       = ItemImpl.of("CHB01", "Chocolate bar",            ItemCategory.FOOD,    new BigDecimal("00.85"));
	public static Item PERFUME_BOTTLE      = ItemImpl.of("PSB01", "Bottle of prefume",        ItemCategory.OTHER,   new BigDecimal("18.99"));
	public static Item HEADACHE_PILLS_PACK = ItemImpl.of("HPP01", "Packet of headache pills", ItemCategory.MEDICAL, new BigDecimal("09.75"));
	
	public static Item IMP_CHOCOLATES_BOX_1 = ItemImpl.imported("IMP01", "Imported box of chocolate",  ItemCategory.FOOD,  new BigDecimal("10.00"));
	public static Item IMP_CHOCOLATES_BOX_2 = ItemImpl.imported("IMP02", "Box of imported chocolates", ItemCategory.FOOD,  new BigDecimal("11.25"));
	public static Item IMP_PERFUME_BOTTLE_1 = ItemImpl.imported("IMP03", "Imported bottle of prefume", ItemCategory.OTHER, new BigDecimal("47.50"));
	public static Item IMP_PERFUME_BOTTLE_2 = ItemImpl.imported("IMP04", "Imported bottle of prefume", ItemCategory.OTHER, new BigDecimal("27.99"));
	
}
