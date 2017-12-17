package com.ubs.simonpowers.oms.presentation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityLinks;
import org.springframework.stereotype.Component;

import com.ubs.simonpowers.oms.domain.Stock;

@Component
public class StockResourceAssembler extends ResourceAssembler<Stock, StockResource> {

	@Autowired
	protected EntityLinks entityLinks;

	@Override
	public StockResource toResource(Stock stock) {
		return new StockResource(stock);
	}
}