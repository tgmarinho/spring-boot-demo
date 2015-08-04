package demo.controller;

import static demo.config.API.VERSION;

import javax.inject.Inject;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import demo.config.ConfigurationProjectProperties;

@RestController
@RequestMapping(VERSION + "/configurations")
public class ConfigurationController {

	@Inject
	ConfigurationProjectProperties configurationProjectProperties;
	
	@RequestMapping(params = "projectName") 
	public String getConfiguration() {
		return configurationProjectProperties.getProjectName();
	}

}
