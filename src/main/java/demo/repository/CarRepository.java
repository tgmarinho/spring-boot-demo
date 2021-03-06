package demo.repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import demo.domain.Car;

public interface CarRepository extends ElasticsearchRepository<Car, Long> {

	Iterable<Car> findByMakeIgnoringCase(String make);

}