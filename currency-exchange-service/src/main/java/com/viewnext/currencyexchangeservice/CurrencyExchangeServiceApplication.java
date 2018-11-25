package com.viewnext.currencyexchangeservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.data.repository.init.Jackson2RepositoryPopulatorFactoryBean;

import brave.sampler.Sampler;

@EnableDiscoveryClient
@SpringBootApplication
public class CurrencyExchangeServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CurrencyExchangeServiceApplication.class, args);
	}
	
	@Bean
    public Sampler defaultSampler(){
   	 return Sampler.ALWAYS_SAMPLE;
    }
	
	 @Bean
	  public Jackson2RepositoryPopulatorFactoryBean repositoryPopulator() {

	    Resource sourceData = new ClassPathResource("data.json");

	    Jackson2RepositoryPopulatorFactoryBean factory = new Jackson2RepositoryPopulatorFactoryBean();
	    factory.setResources(new Resource[] { sourceData });
	    return factory;
	  }
}
