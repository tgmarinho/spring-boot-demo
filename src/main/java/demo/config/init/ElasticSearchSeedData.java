package demo.config.init;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Bean;

import demo.repository.CarRepository;
import domain.Car;

public class ElasticSearchSeedData {

    @Bean
	public InitializingBean seedDatabase(CarRepository repository) {
		return () -> {
			repository.deleteAll();
			repository.save(new Car(0L, "Honda", "Civic", 1997));
			repository.save(new Car(1L, "Honda", "Accord", 2003));
			repository.save(new Car(2L, "Ford", "Escort", 1985));
		};
	}
    
}
