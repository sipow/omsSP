package com.ubs.simonpowers.oms.domain;

public class Order implements MyIdentifiable{
	private long orderId;
	private long stockId;
	private long userId;
	private int buy;
	private int qty;
	
	public Long getId() {
		return orderId;
	}
	
	public void setId(Long orderId) {
		this.orderId = orderId;
	}
	
	public long getOrderId() {
		return orderId;
	}

	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}

	public long getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public int getBuy() {
		return buy;
	}
	
	public void setBuy( int buy ) {
		this.buy = buy;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public long getStockId() {
		return stockId;
	}

	public void setStockId(int stockId) {
		this.stockId = stockId;
	}
}
