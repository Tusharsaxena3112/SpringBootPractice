package com.spring.crud.dto;

public class OrderedItemsDto {

	private int shipment_id;
	
	private int product_id;
	
	private String productName;
	
	public OrderedItemsDto() {}

	public OrderedItemsDto(int shipment_id, int product_id, String productName) {
		super();
		this.shipment_id = shipment_id;
		this.product_id = product_id;
		this.productName = productName;
	}

	public int getShipment_id() {
		return shipment_id;
	}

	public void setShipment_id(int shipment_id) {
		this.shipment_id = shipment_id;
	}

	public int getProduct_id() {
		return product_id;
	}

	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	
}
