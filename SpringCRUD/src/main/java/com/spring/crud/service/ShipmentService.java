package com.spring.crud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.crud.model.Shipment;
import com.spring.crud.repository.ShipmentRespository;


@Service
public class ShipmentService {

	@Autowired 
	private ShipmentRespository shipmentRespository;
	
	
	public Shipment createShipment(Shipment shipment) {
		
		return shipmentRespository.save(shipment);
	}
	
	public List<Shipment> getShipments(int userId){
		return shipmentRespository.findByUserId(userId);
	}
}
