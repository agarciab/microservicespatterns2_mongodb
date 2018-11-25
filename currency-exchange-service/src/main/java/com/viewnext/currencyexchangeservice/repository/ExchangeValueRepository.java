package com.viewnext.currencyexchangeservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.viewnext.currencyexchangeservice.model.ExchangeValue;

public interface ExchangeValueRepository extends MongoRepository<ExchangeValue, String> {

	public ExchangeValue findByFromAndTo(String from, String to);
}
