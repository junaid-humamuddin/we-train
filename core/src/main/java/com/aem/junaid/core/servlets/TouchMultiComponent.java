package com.aem.junaid.core.servlets;

import java.util.ArrayList;
import java.util.List;

import javax.jcr.Node;
import javax.jcr.NodeIterator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.adobe.cq.sightly.WCMUsePojo;
import com.aem.junaid.core.services.vo.TouchMultiBean;

public class TouchMultiComponent extends WCMUsePojo {

	protected final Logger log = LoggerFactory.getLogger(this.getClass());

	private List<TouchMultiBean> submenuItems = new ArrayList<TouchMultiBean>();

	@Override
	public void activate() throws Exception {

		Node currentNode = getResource().adaptTo(Node.class);
		NodeIterator ni = currentNode.getNodes();

		// get the grandchild node of the currentNode - which represents where the
		// MultiField values are stored
		while (ni.hasNext()) {

			Node child = (Node) ni.nextNode();

			NodeIterator ni2 = child.getNodes();
			setMultiFieldItems(ni2);
		}
	}

	/**
	 * Method to get Multi field data
	 * 
	 * @return submenuItems
	 */
	private List<TouchMultiBean> setMultiFieldItems(NodeIterator ni2) {

		try {

			String product;
			String path;
			String startDate;
			String show;
			String size;

			// THIS WILL READ THE VALUE OF THE CORAL3 Multifield and set them in a
			// collection
			while (ni2.hasNext()) {

				TouchMultiBean menuItem = new TouchMultiBean();

				Node grandChild = (Node) ni2.nextNode();

				log.info("*** GRAND CHILD NODE PATH IS " + grandChild.getPath());

				product = grandChild.getProperty("product").getString();
				path = grandChild.getProperty("path").getString();
				show = grandChild.getProperty("show").getString();
				startDate = grandChild.getProperty("startDate").getString();
				size = grandChild.getProperty("size").getString();
				log.info("*** VALUE OF DATE IS " + startDate);

				menuItem.setProduct(product);
				menuItem.setPath(path);
				menuItem.setShow(show);
				menuItem.setDate(startDate);
				menuItem.setSize(size);
				submenuItems.add(menuItem);
			}
		}

		catch (Exception e) {
			log.error("Exception while Multifield data {}", e.getMessage(), e);
		}
		return submenuItems;
	}

	public List<TouchMultiBean> getMultiFieldItems() {
		return submenuItems;
	}
}