package com.ubs.simonpowers.oms.domain;

public class Stock implements MyIdentifiable{
	private Long stockId;
	private String description;
	private long price;

	public Stock(Long stockId, String description, long price) {
		this.stockId = stockId;
		this.description = description;
		this.price = price;
	}
	
	@Override
	public Long getId() {
		return stockId;
	}

	@Override
	public void setId(Long stockId) {
		this.stockId = stockId;
	}
	
	public String getDescripton() {
		return description;
	}

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}
}
