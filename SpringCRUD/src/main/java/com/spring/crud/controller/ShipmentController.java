package com.spring.crud.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.crud.dto.OrderedItemsDto;
import com.spring.crud.dto.ShipmentDto;
import com.spring.crud.model.OrderedItem;
import com.spring.crud.model.Shipment;
import com.spring.crud.model.User;
import com.spring.crud.service.OrderedItemService;
import com.spring.crud.service.ShipmentService;
import com.spring.crud.service.UserService;

@RestController
@RequestMapping("/users")
public class ShipmentController {

	@Autowired
	private ShipmentService shipmentService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private OrderedItemService orderedItemService;
	
	@PostMapping("/{userId}/shipments")
	public Shipment checkout(@PathVariable int userId,@RequestBody ShipmentDto shipmentDto) {
		Shipment shipment = new Shipment();
		
		shipment.setShipmentStatus(shipmentDto.getShipmentStatus());
		shipment.setTotalPrice(shipmentDto.getTotalPrice());
		User currentUser = userService.getUserbyId(userId);
		shipment.setUser(currentUser);
		
		Shipment shipmentResponse = shipmentService.createShipment(shipment);
		
		List<OrderedItem> orderedItems = new ArrayList<>();
		
		for(Integer productId:shipmentDto.getProduct_ids()) {
			orderedItems.add(new OrderedItem(shipmentResponse.getShipment_id(),productId));
		}
		orderedItemService.addOrderedItem(orderedItems);
		return shipmentResponse;
	}
	
	@GetMapping("/{userId}/shipments")
	public ResponseEntity<List<Shipment>> getShipments(@PathVariable int userId){
	 List<Shipment> shipments = shipmentService.getShipments(userId);
	 return new ResponseEntity<>(shipments, HttpStatus.OK);
	}
	
	@GetMapping("/shipment/{shipmentId}/items")
	public ResponseEntity<List<OrderedItemsDto>> getOrderedItems(@PathVariable int shipmentId){
		List<OrderedItemsDto> orderedItemsList = orderedItemService.getOrderedItems(shipmentId);
		 System.out.println(orderedItemsList);
		 
		 return new ResponseEntity<List<OrderedItemsDto>>(orderedItemsList,HttpStatus.OK);
		}
}
