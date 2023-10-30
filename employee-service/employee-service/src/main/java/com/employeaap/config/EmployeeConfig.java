package com.employeaap.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class EmployeeConfig {
	
//	 @Value("${addressservice.base.url}") 
//	private String addressBaseUrl;

	@Bean
	public ModelMapper modelMapperBean() {
		return new ModelMapper();
	}
	
	@Bean
	public RestTemplate restTemplateBean() {
	        return new RestTemplate();
	}
	
//	@Bean
//	public WebClient webClient() {
//		return WebClient.builder().baseUrl(addressBaseUrl).build();
//	}

}
