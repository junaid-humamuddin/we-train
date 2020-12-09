package com.aem.junaid.core.servlets;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.osgi.service.component.annotations.Component;


//@SlingServlet(paths="/bin/trainingproject/testservlet")  --Felix SCR Annotation

//@SlingServlet(resourceTypes="training/components/structure/contentpage", selectors="sample")

//OSGI Declarative Service Annotation
/*@Component(
		service=Servlet.class,
		property={
				//path method
				"sling.servlet.paths="+ "/bin/aem65project/testservlet"
		}
)*/

@Component(
		service=Servlet.class,
		property={
				//reourceTypes method
				//sling.servlet.resourceTypes should be the jcr:content's sling:resourceType path from CONTENT folder
				"sling.servlet.resourceTypes="+ "training/components/structure/contentpage",
				"sling.servlet.selectors=" + "sample"
		}
)

public class TestSlingServlet extends SlingSafeMethodsServlet {
	
	private static final long serialVersionUID = 1L;

	@Override
    protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response) throws ServletException, IOException {
    	response.setHeader("Content-Type", "text/html");
    	response.getWriter().print("<h1>Sling Servlet Called</h1>"); 
    	response.getWriter().close();
    }   
}
