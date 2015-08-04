package demo.service;

import static org.elasticsearch.index.query.QueryBuilders.fuzzyLikeThisFieldQuery;

import javax.inject.Inject;

import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.stereotype.Service;

import demo.domain.Car;

@Service
public class CarSearchService {
	
	@Inject
	ElasticsearchTemplate template;
	
	public Iterable<Car> search(String field, String text) {
		
		SearchQuery query = new NativeSearchQueryBuilder()
				.withQuery(
					fuzzyLikeThisFieldQuery(field).likeText(text))
				.build();
		
		return template.queryForList(query, Car.class);

	}
	
}
