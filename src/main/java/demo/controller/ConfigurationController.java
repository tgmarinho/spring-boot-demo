package demo.controller;

import javax.inject.Inject;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import demo.config.ConfigurationProjectProperties;

@RestController
public class ConfigurationController {

	@Inject
	ConfigurationProjectProperties configurationProjectProperties;
	
	@RequestMapping("/configuration") 
	public String getConfiguration() {
		return configurationProjectProperties.getProjectName();
	}
	
}
