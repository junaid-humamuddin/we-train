package com.aem.junaid.core.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.rmi.ServerException;

import javax.servlet.Servlet;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.HttpConstants;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.aem.junaid.core.services.config.JunaidTestConfigurationService;

@Component(service = Servlet.class, property = { "sling.servlet.methods=" + HttpConstants.METHOD_GET,
		"sling.servlet.paths=" + "/bin/getTestCongiguration" })
public class JunaidTestConfigurationServlet extends SlingAllMethodsServlet {

	private static final long serialVersionUID = 2598426539166789515L;

	protected final Logger log = LoggerFactory.getLogger(this.getClass());

	@Reference
	private JunaidTestConfigurationService junaidTestConfigurationService;

	@Override
	protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response)
			throws ServerException, IOException {
		PrintWriter out = response.getWriter();
		log.debug("Inside JunaidTestConfigurationServlet Class");
		//junaidTestConfigurationService.printConfigData();
		out.write(junaidTestConfigurationService.printConfigData());
	}

}
