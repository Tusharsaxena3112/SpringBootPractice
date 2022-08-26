package com.spring.crud.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class OrderedItem {

	@Id
	@GeneratedValue
	private int id;
	
	private int shipment_id;
	
	private int product_id;
	
	public OrderedItem() {}

	public OrderedItem(int shipment_id, int product_id) {
		super();
		this.shipment_id = shipment_id;
		this.product_id = product_id;
	}

	public int getshipment_id() {
		return shipment_id;
	}

	public void setshipment_id(int shipment_id) {
		this.shipment_id = shipment_id;
	}

	public int getProduct_id() {
		return product_id;
	}

	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	
	
}
