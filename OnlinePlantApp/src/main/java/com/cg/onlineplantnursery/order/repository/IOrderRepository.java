package com.cg.onlineplantnursery.order.repository;


import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.onlineplantnursery.entity.Order;
import com.cg.onlineplantnursery.exceptions.CustomerIdNotFoundException;

@Repository
public interface IOrderRepository extends JpaRepository<Order, Integer> {
	
	public List<Order> getOrderByCategory(String category);

	public List<Order> getOrderByCustomerId(int customerId);
	
	
	
}
