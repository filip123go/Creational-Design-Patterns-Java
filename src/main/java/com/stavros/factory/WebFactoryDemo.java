package com.stavros.factory;

import static com.stavros.factory.WebsiteTypeEnum.BLOG;
import static com.stavros.factory.WebsiteTypeEnum.SHOP;

public class WebFactoryDemo {
	public static void main(String[] args) {


		Website site = WebsiteFactory.getWebsite(BLOG);

		assert site != null;
		System.out.println(site.getPages());


		site = WebsiteFactory.getWebsite(SHOP);

		assert site != null;
		System.out.println(site.getPages());
	}
}
