package com.spring.crud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.crud.dto.OrderedItemsDto;
import com.spring.crud.model.OrderedItem;
import com.spring.crud.repository.OrderedItemRepository;

@Service
public class OrderedItemService {
	
	@Autowired
	private OrderedItemRepository orderedItemRepository;
	
	public void addOrderedItem(List<OrderedItem> orderedItems) {
		orderedItemRepository.saveAll(orderedItems);
	}
	
	public List<OrderedItemsDto> getOrderedItems(int shipmentId) {
		return orderedItemRepository.getOrderedItems(shipmentId);
	}
}
