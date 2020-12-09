package com.aem.junaid.core.services.impl;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.ConfigurationPolicy;
import org.osgi.service.metatype.annotations.Designate;

import com.aem.junaid.core.services.config.JunaidConfigurationService;
import com.aem.junaid.core.services.config.JunaidTestConfigurationService;

@Component(service = JunaidTestConfigurationService.class, configurationPolicy = ConfigurationPolicy.REQUIRE)
@Designate(ocd = JunaidConfigurationService.class)
public class JunaidTestConfigurationServiceImpl implements JunaidTestConfigurationService {

	private String configAccountName;

	@Activate
	public void activate(JunaidConfigurationService junaidConfigurationService) {
		this.configAccountName = junaidConfigurationService.aem_account_name();

	}

	@Override
	public String printConfigData() {
		return "The name fetched from custom configuration is ".concat(configAccountName);
	}

}
