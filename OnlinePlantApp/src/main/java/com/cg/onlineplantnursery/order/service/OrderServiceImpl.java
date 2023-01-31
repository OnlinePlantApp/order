package com.cg.onlineplantnursery.order.service;

import java.util.List;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.onlineplantnursery.exceptions.CustomerIdNotFoundException;
import com.cg.onlineplantnursery.exceptions.InSufficientQuantity;
import com.cg.onlineplantnursery.exceptions.OrderIdNotFoundException;
import com.cg.onlineplantnursery.exceptions.PlantIdNotFoundException;
import com.cg.onlineplantnursery.exceptions.PlanterIdNotFoundException;
import com.cg.onlineplantnursery.exceptions.SeedIdNotFoundException;
import com.cg.onlineplantnursery.order.entity.Order;
import com.cg.onlineplantnursery.order.repository.IOrderRepository;

import java.util.Optional;

import javax.transaction.Transactional;
@Service
public class OrderServiceImpl implements IOrderService {
	
	@Autowired
	private IOrderRepository orderRepo;
	

	@Override
	@Transactional
	public Order addOrder(Order order) throws OrderIdNotFoundException {
		// TODO Auto-generated method stub
		Order savedOrder=orderRepo.save(order);
		if(savedOrder!=null) {
			return savedOrder;
		}
		else {
			throw new OrderIdNotFoundException("no such order");
		}
	}

	@Override
	@Transactional
	public Order updateOrder(Order order) throws OrderIdNotFoundException{
		Optional<Order> updateorder=orderRepo.findById(order.getBookingOrderId());
		if(updateorder.isPresent()) {
			return orderRepo.save(order);
		}
		else {
			throw new OrderIdNotFoundException("Invalid order details");
		}
		// TODO Auto-generated method stub
	}

	@Override
	@Transactional
	public Order deleteOrder(int orderId) throws OrderIdNotFoundException {
		// TODO Auto-generated method stub
      Order exsistingOrder=orderRepo.findById(orderId).orElseThrow(() -> new OrderIdNotFoundException("Order is not listed"+orderId));
		
		orderRepo.delete(exsistingOrder);
		return exsistingOrder;
		
	}

	@Override
	public Order viewOrder(int orderId) throws OrderIdNotFoundException {
		// TODO Auto-generated method stub
		Optional<Order> vieworder =orderRepo.findById(orderId);
		if(vieworder.isPresent()) {
			return vieworder.get();
		}
		else {
			throw new OrderIdNotFoundException("No order is found");
		}
	}

	@Override
	
	public List<Order> viewAllOrders() throws OrderIdNotFoundException {
		// TODO Auto-generated method stub
		List<Order> orders=orderRepo.findAll();
		if(orders.size()>0) {
			return orders;
		}
		else {
			throw new OrderIdNotFoundException("No order found");
		}
		
	}

	/*@Override
	public Order getOrderByCategory(String category) {
		// TODO Auto-generated method stub
		return orderRepo.getOrderByCategory(category);
	}

	@Override
	public Order getOrderByCustomerId(Integer customerId) throws CustomerIdNotFoundException {
		// TODO Auto-generated method stub
	
		if(customerId!= null) {
			return orderRepo.getOrderByCustomerId(customerId);
		}
		else {
			throw new CustomerIdNotFoundException("No order is found");
		}
		
	}

	@Override
	public Order getOrderByPlantId(String sessionId, Integer planterId, Integer quantity)
			throws CustomerIdNotFoundException, PlantIdNotFoundException, InSufficientQuantity {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Order getOrderBySeedId(String sessionId, Integer seedId, Integer quantity)
			throws CustomerIdNotFoundException, SeedIdNotFoundException, InSufficientQuantity {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Order getOrderByPlanterId(String sessionId, Integer PlanterId, Integer quantity)
			throws CustomerIdNotFoundException, PlanterIdNotFoundException, InSufficientQuantity {
		// TODO Auto-generated method stub
		return null;
	}*/
	

}
