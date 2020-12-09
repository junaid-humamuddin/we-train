package com.aem.junaid.core.services.config;

import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.AttributeType;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;

@ObjectClassDefinition(name = "AEM User Configuration Service", description = "AEM User Account Configuration Service")
public @interface JunaidConfigurationService {

	@AttributeDefinition(name = "AEM Account Name", description = "AEM Account Name Details", type = AttributeType.STRING, defaultValue = "junaid")
	String aem_account_name();
}
