package com.interview.samples;

import com.interview.shoppingcart.ShoppingCart;
import com.interview.shoppingcart.impl.ShoppingCartImpl;

public class ShoppingCartSamples {
	
	public static final ShoppingCart INPUT_1 = new ShoppingCartImpl();
	static { 
		INPUT_1.add(ItemSamples.BOOK,          1); 
		INPUT_1.add(ItemSamples.MUSIC_CD,      1); 
		INPUT_1.add(ItemSamples.CHOCOLATE_BAR, 1); 
	}

	public static final ShoppingCart INPUT_2 = new ShoppingCartImpl();
	static {
		INPUT_2.add(ItemSamples.IMP_CHOCOLATES_BOX_1, 1);
		INPUT_2.add(ItemSamples.IMP_PERFUME_BOTTLE_1, 1);
	}
	
	public static final ShoppingCart INPUT_3 = new ShoppingCartImpl();
	static {
		INPUT_3.add(ItemSamples.IMP_PERFUME_BOTTLE_2, 1);
		INPUT_3.add(ItemSamples.PERFUME_BOTTLE,       1);
		INPUT_3.add(ItemSamples.HEADACHE_PILLS_PACK,  1);
		INPUT_3.add(ItemSamples.IMP_CHOCOLATES_BOX_2, 1);
	}
	
}
