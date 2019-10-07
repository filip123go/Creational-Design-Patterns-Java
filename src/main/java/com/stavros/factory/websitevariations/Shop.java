package com.stavros.factory.websitevariations;

import com.stavros.factory.Website;
import com.stavros.factory.pages.CartPage;
import com.stavros.factory.pages.ItemPage;
import com.stavros.factory.pages.SearchPage;

public class Shop extends Website {
	@Override
	public void createWebsite() {
		pages.add(new CartPage());
		pages.add(new ItemPage());
		pages.add(new SearchPage());
	}
}
