package com.ubs.simonpowers.oms.presentation;

import org.springframework.hateoas.ResourceSupport;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
import com.ubs.simonpowers.oms.domain.Stock;

public class StockResource extends ResourceSupport {

	@JsonUnwrapped
	private final Stock stock;

	public StockResource(Stock stock) {
		this.stock = stock;
	}
}