package demo.controller;

import static demo.config.API.VERSION;

import javax.inject.Inject;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import demo.domain.Car;
import demo.service.CarSearchService;

@RestController
@RequestMapping(VERSION + "/cars")
public class CarController {

	@Inject
	CarSearchService service;
	
	@RequestMapping()
	public Iterable<Car> getCarsByQuery(@RequestParam(value = "q") String q) {
		return service.search("make", q);
	}

}
