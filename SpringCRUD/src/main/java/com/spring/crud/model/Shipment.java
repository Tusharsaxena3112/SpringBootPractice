package com.spring.crud.model;




import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class Shipment{


	@Id
	@GeneratedValue
	private int Shipment_id;
	
	private double totalPrice;
	
	private boolean ShipmentStatus;
	
	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
	private User user;
	

	public Shipment() {
		
	}
	
	public int getShipment_id() {
		return Shipment_id;
	}

	public void setShipment_id(int Shipment_id) {
		this.Shipment_id = Shipment_id;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Shipment(int Shipment_id, double totalPrice, boolean ShipmentStatus, User user) {
		super();
		this.Shipment_id = Shipment_id;
		this.totalPrice = totalPrice;
		this.ShipmentStatus = ShipmentStatus;
		this.user = user;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public boolean isShipmentStatus() {
		return ShipmentStatus;
	}

	public void setShipmentStatus(boolean ShipmentStatus) {
		this.ShipmentStatus = ShipmentStatus;
	}
	
	
	
}
