package org.thesoftwarecraftsman.demo.sbOrderService;

import javax.inject.Named;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ServiceConfig {
	
	@Named
	static class JerseyConfig extends ResourceConfig {
		public JerseyConfig() {
			this.packages("org.thesoftwarecraftsman.demo.sbOrderService.restAPI");
		}
	}
	
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
}
