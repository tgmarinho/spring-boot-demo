package demo.config;

import lombok.Data;
import lombok.NoArgsConstructor;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties("configuration")
@Data
@NoArgsConstructor
public class ConfigurationProjectProperties {
	
	@NotBlank
	private String projectName;
	
}