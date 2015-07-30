package demo.controller;

import javax.inject.Inject;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import demo.config.ConfigurationProjectProperties;

@RestController
public class ConfigController {

	@Inject
	ConfigurationProjectProperties configurationProjectProperties;
	
	@RequestMapping("/config") 
	public String getAppName() {
		return configurationProjectProperties.getProjectName();
	}
	
}
