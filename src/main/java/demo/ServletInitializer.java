package demo;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;

/**
 * ServletInitializer 
 *    Só é necessário para deploy direto em um webserver (tomcat, jetty etc)
 *    veja as anotações com as demais mudanças necessárias no pom.xml
 *    
 * @author wanderleisouza
 */
public class ServletInitializer extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(SpringBootDemoApplication.class);
	}

}
