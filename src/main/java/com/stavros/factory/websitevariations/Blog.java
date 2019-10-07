package com.stavros.factory.websitevariations;

import com.stavros.factory.Website;
import com.stavros.factory.pages.AboutPage;
import com.stavros.factory.pages.CommentPage;
import com.stavros.factory.pages.ContactPage;
import com.stavros.factory.pages.PostPage;

public class Blog extends Website {

	@Override
	public void createWebsite() {
		pages.add(new PostPage());
		pages.add(new AboutPage());
		pages.add(new CommentPage());
		pages.add(new ContactPage());
	}
}
