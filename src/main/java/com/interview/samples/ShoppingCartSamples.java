package com.interview.samples;

import com.interview.shoppingcart.ShoppingCart;

public class ShoppingCartSamples {
	
	public static final ShoppingCart INPUT_1 = ShoppingCart.empty();
	static { 
		INPUT_1.add(ItemSamples.BOOK,          1); 
		INPUT_1.add(ItemSamples.MUSIC_CD,      1); 
		INPUT_1.add(ItemSamples.CHOCOLATE_BAR, 1); 
	}

	public static final ShoppingCart INPUT_2 = ShoppingCart.empty();
	static {
		INPUT_2.add(ItemSamples.IMP_CHOCOLATES_BOX_1, 1);
		INPUT_2.add(ItemSamples.IMP_PERFUME_BOTTLE_1, 1);
	}
	
	public static final ShoppingCart INPUT_3 = ShoppingCart.empty();
	static {
		INPUT_3.add(ItemSamples.IMP_PERFUME_BOTTLE_2, 1);
		INPUT_3.add(ItemSamples.PERFUME_BOTTLE,       1);
		INPUT_3.add(ItemSamples.HEADACHE_PILLS_PACK,  1);
		INPUT_3.add(ItemSamples.IMP_CHOCOLATES_BOX_2, 1);
	}
	
}
