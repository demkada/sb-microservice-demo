package org.thesoftwarecraftsman.demo.sbProductService;

import javax.inject.Named;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceConfig {
	
	@Named
	static class JerseyConfig extends ResourceConfig {
		public JerseyConfig() {
			this.packages("org.thesoftwarecraftsman.demo.sbProductService.restAPI");
		}
	}
}
