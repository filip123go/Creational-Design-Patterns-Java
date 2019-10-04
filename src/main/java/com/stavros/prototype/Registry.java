package com.stavros.prototype;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Registry {
	private static final Logger LOGGER = Logger.getLogger( Registry.class.getName() );

	private Map<String, Item> items = new HashMap<String, Item>();

	public Registry() {
		loadItems();
	}

	public Item createItem(String type) {
		Item item = null;

		try {
			item = (Item) items.get(type).clone();
		}catch (CloneNotSupportedException e){
			LOGGER.log(Level.SEVERE,"-not able to clone-" , e);
		}

		return item;
	}

	private void loadItems() {
		Movie movie = new Movie();
		movie.setTitle("Basic Movie");
		movie.setPrice(24.99);
		movie.setRuntime("2 hours");
		items.put("Movie", movie);

		Book book = new Book();
		book.setNumberOfPages(335);
		book.setPrice(19.99);
		book.setTitle("Basic Book");
		items.put("Book", book);
	}
}
