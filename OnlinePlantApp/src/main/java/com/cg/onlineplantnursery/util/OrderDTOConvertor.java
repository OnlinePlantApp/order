package com.cg.onlineplantnursery.util;

import org.springframework.stereotype.Component;


import com.cg.onlineplantnursery.dto.OrderAdminResponseDTO;
import com.cg.onlineplantnursery.dto.OrderDTO;
import com.cg.onlineplantnursery.entity.Order;



@Component
public class OrderDTOConvertor {
	public OrderAdminResponseDTO getOrderAdminResponseDTO(Order order)
	{
		OrderAdminResponseDTO dto = new OrderAdminResponseDTO();
		dto.setBookingOrderId(order.getBookingOrderId());
		dto.setOrderDate(order.getOrderDate());
		dto.setQuantity(order.getQuantity());
		dto.setTotalCost(order.getTotalCost());
		dto.setTransactionMode(order.getTransactionMode());
		dto.setMsg("order saved");
		return dto;
	}
	public OrderDTO getOrderDTO(Order o)
	{
		return new OrderDTO(o.getBookingOrderId(), o.getOrderDate(),o.getTransactionMode(),o.getQuantity(),o.getTotalCost());
		
	}
	

}
