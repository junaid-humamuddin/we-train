package com.aem.junaid.core.servlets;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.adobe.cq.sightly.WCMUsePojo;
import com.day.cq.wcm.api.Page;
import com.day.cq.wcm.api.PageFilter;

public class TopNavJava extends WCMUsePojo {
	Logger logger = LoggerFactory.getLogger(TopNavJava.class);
	private List<Page> items = new ArrayList<Page>();
	private Page rootPage;

	// Initializes the navigation
	@Override
	public void activate() throws Exception {
		rootPage = getCurrentPage().getAbsoluteParent(2);

		if (rootPage == null) {
			rootPage = getCurrentPage();
		}

		logger.info("Java Helper Log Example");

		Iterator<Page> childPages = rootPage.listChildren(new PageFilter(getRequest()));
		while (childPages.hasNext()) {
			items.add(childPages.next());
		}
	}

	// Returns the navigation items
	public List<Page> getItems() {
		return items;
	}

	// Returns the navigation root
	public Page getRoot() { 
		return rootPage;
	}
}
