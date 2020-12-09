package com.aem.junaid.core.servlets;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletException;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.osgi.service.component.annotations.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.aem.junaid.core.models.AdaptationModel;

@Component(service = Servlet.class, property = { "sling.servlet.methods=GET",
		"sling.servlet.resourceTypes=" + "/apps/training/components/content/slingmodelillustration",
		"sling.servlet.selectors=" + "slingAdaptTest" 
		//"sling.servlet.paths="+ "/bin/training/slingAdaptTest"
		})
public class AdaptationServlet extends SlingAllMethodsServlet { 

	private static final long serialVersionUID = 1L;
	Logger logger = LoggerFactory.getLogger(this.getClass());

	public void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");

		try {
			AdaptationModel slingReqModel = request.adaptTo(AdaptationModel.class);
			// AdaptationModel slingReqModel =
			// request.getResourceResolver().getResource(null).adaptTo(AdaptationModel.class);
			response.getWriter().write(slingReqModel.getMessage());
			/*response.setHeader("Content-Type", "text/html");
	    	response.getWriter().print(slingReqModel.getMessage()); 
	    	response.getWriter().close();*/
			logger.info("Adaptattion DONE");
		} catch (Exception e) {
			logger.error("{} Exception! ", new Object[] { e.getMessage(), e });
		}
	}
}
