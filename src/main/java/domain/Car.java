package domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "car", type = "car", shards = 1, replicas = 0, refreshInterval = "-1")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Car {

	@Id
	private Long id;
	private String make;
	private String model;
	private int year;

}