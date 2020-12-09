package com.aem.junaid.core.models;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ValueMap;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.Via;
import org.apache.sling.models.annotations.injectorspecific.InjectionStrategy;
import org.apache.sling.models.annotations.injectorspecific.RequestAttribute;
import org.apache.sling.models.annotations.injectorspecific.ScriptVariable;
import org.apache.sling.models.annotations.injectorspecific.SlingObject;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import com.day.cq.wcm.api.Page;

@Model(adaptables = SlingHttpServletRequest.class)
public class UserInfoModel {

	@Inject
	Resource resourceForPath;

	public String getPath() {
		return resourceForPath.getPath();
	}

	// Injects currentPage using ScriptVariable annotation
	@ScriptVariable(name = "currentPage", injectionStrategy = InjectionStrategy.REQUIRED)
	Page page;

	public String getPagePath() {
		return page.getPath();
	}

	// Injects the child of the resource using ChildResource annotation
	/*
	 * @ChildResource(name = "hero", via = "resource") Resource child;
	 * 
	 * public String getChildPath() { return child.getPath(); }
	 */

	// Injects Resource and get ValueMap from the resource
	@SlingObject
	Resource resource;

	public String getLastNameValue() {
		ValueMap valueMap = resource.adaptTo(ValueMap.class);
		return valueMap.get("lastName", String.class);
	}

	// Injects title from ValuMapValue
	@ValueMapValue
	@Via("resource")
	String title;

	public String getTitleValue() {
		return title;
	}

	// directly inject a path as a resource
	/*
	 * @ResourcePath(path = "/etc/social") Resource pathResource;
	 * 
	 * public String getPathResource() { return pathResource.getPath(); }
	 */

	/*
	 * @ResourcePath(name = "path") Resource resourcePath;
	 * 
	 * public String getPath() { return resourcePath.getPath(); }
	 */

	/*
	 * @ResourcePath(paths = {"/etc/social","/etc/tags"}) Resource[] paths;
	 */

	// Injects all the input parameters from sightly injects as RequestAttribute in
	// Sling Models
	@RequestAttribute(name = "color")
	String param;

	public String getParam() {
		return param.toUpperCase();
	}

	/*
	 * @Inject
	 * 
	 * @Named("jcr:description") String jcrDescription;
	 * 
	 * public String getJcrDescription() { return jcrDescription; }
	 */

	@Inject
	@Via("resource")
	private String firstName;

	@Inject
	@Via("resource")
	private String lastName;

	@Inject
	@Via("resource")
	private String technology;

	private String userInfo;

	@PostConstruct
	protected void init() {
		userInfo = firstName + " " + lastName + " is a " + technology + " developer";
	}

	public String getUserInfo() {
		return userInfo;
	}

}
