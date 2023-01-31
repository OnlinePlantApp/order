package com.cg.onlineplantnursery.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.onlineplantnursery.dto.OrderAdminResponseDTO;
import com.cg.onlineplantnursery.dto.OrderDTO;
import com.cg.onlineplantnursery.exceptions.OrderIdNotFoundException;
import com.cg.onlineplantnursery.order.entity.Order;
import com.cg.onlineplantnursery.order.service.IOrderService;
import com.cg.onlineplantnursery.util.OrderDTOConvertor;



@RestController
@RequestMapping("/order")
public class OrderController {
	
	@Autowired
	IOrderService orderService;
	
	@Autowired
	OrderDTOConvertor orderDTOConvertor;
	
	
	@PostMapping("/add")
	public ResponseEntity<Order> addOrder(@RequestBody Order cOrder) throws OrderIdNotFoundException {

		Order newOrder = orderService.addOrder(cOrder);
		OrderAdminResponseDTO responseDTO = orderDTOConvertor.getOrderAdminResponseDTO(newOrder);

		return new ResponseEntity<Order>(newOrder, HttpStatus.OK);
	}

	@PutMapping("/order/update")
	public ResponseEntity<Order> updateOrder(@RequestBody Order cOrder) throws OrderIdNotFoundException {

		Order updatedOrder = orderService.updateOrder(cOrder);
		OrderAdminResponseDTO responseDTO = orderDTOConvertor.getOrderAdminResponseDTO(updatedOrder);
		
       
		return new ResponseEntity<Order>(updatedOrder, HttpStatus.OK);
        
	}
	@DeleteMapping("/order/delete/{oID}")
	public ResponseEntity<Order> deleteOrder(@PathVariable Integer oID) throws OrderIdNotFoundException {
       if(oID == null) {
    	   throw new OrderIdNotFoundException("No customer exist with this key");
       }
       else {
		Order deletedOrder = orderService.deleteOrder(oID);

		return new ResponseEntity<Order>(deletedOrder, HttpStatus.OK);
       }
         
	}

	@GetMapping("/order/view/{oID}")
	public ResponseEntity<Order> viewOrder(@PathVariable Integer oID) throws OrderIdNotFoundException {

		Order viewOrder = orderService.deleteOrder(oID);

		return new ResponseEntity<Order>(viewOrder, HttpStatus.OK);
	}
	@GetMapping("/orders")
	public ResponseEntity<List<OrderDTO>> viewAllOrders() throws OrderIdNotFoundException {
		
		List<Order> allOrders = orderService.viewAllOrders(); // give us raw data (complete information , which we cannot share with users directly)
		// Converting into DTO form , which we can share with user
		List<OrderDTO> allOrderDTO = new ArrayList<>();
		
		for (Order order : allOrders) {
			
			allOrderDTO.add(orderDTOConvertor.getOrderDTO(order));
			
		}
		
		return new ResponseEntity<List<OrderDTO>>(allOrderDTO,HttpStatus.OK);
		
	}

}
