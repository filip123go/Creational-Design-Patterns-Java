package com.stavros.factory;

import java.util.ArrayList;
import java.util.List;

import com.stavros.factory.pages.Page;

public abstract class Website {

	public List<Page> getPages() {
		return pages;
	}


	protected List<Page> pages = new ArrayList<>();

	public Website(){
		this.createWebsite();
	}

	public abstract void createWebsite();


}
