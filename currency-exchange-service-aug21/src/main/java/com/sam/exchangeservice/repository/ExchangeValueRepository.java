package com.sam.exchangeservice.repository;

import com.sam.exchangeservice.entity.ExchangeValue;

public interface ExchangeValueRepository {

	ExchangeValue findByFromAndTo(String from, String to);
}
