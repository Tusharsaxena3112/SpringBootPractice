package com.spring.crud.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.spring.crud.dto.OrderedItemsDto;
import com.spring.crud.model.OrderedItem;

@Repository
public interface OrderedItemRepository extends JpaRepository<OrderedItem, Integer>{

	@Query(value = "Select s.shipment_id, p.id, p.name from shipment s join ordered_item oi on s.shipment_id = oi.shipment_id join product p on oi.product_id = p.id where s.shipment_id = ?1",nativeQuery = true)
	public List<OrderedItemsDto> getOrderedItems(int shipmentId);
}
