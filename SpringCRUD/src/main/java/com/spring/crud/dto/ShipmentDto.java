package com.spring.crud.dto;

import java.util.List;

public class ShipmentDto {

	private double totalPrice;
	
	private boolean shipmentStatus;
	
	private List<Integer> product_ids;

	public List<Integer> getProduct_ids() {
		return product_ids;
	}

	public void setProduct_ids(List<Integer> product_ids) {
		this.product_ids = product_ids;
	}
	
	public ShipmentDto() {}

	public ShipmentDto(double totalPrice, boolean shipmentStatus, List<Integer> product_ids) {
		super();
		this.totalPrice = totalPrice;
		this.shipmentStatus = shipmentStatus;
		this.product_ids = product_ids;
	}

	public ShipmentDto(double totalPrice, boolean shipmentStatus) {
		super();
		this.totalPrice = totalPrice;
		this.shipmentStatus = shipmentStatus;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public boolean getShipmentStatus() {
		return shipmentStatus;
	}

	public void setShipmentStatus(boolean shipmentStatus) {
		this.shipmentStatus = shipmentStatus;
	}
	
	
}
