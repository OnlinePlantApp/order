package com.cg.onlineplantnursery.order.service;

import java.util.List;



import org.springframework.stereotype.Service;

import com.cg.onlineplantnursery.entity.Order;
import com.cg.onlineplantnursery.exceptions.CustomerIdNotFoundException;
import com.cg.onlineplantnursery.exceptions.InSufficientQuantity;
import com.cg.onlineplantnursery.exceptions.OrderIdNotFoundException;
import com.cg.onlineplantnursery.exceptions.PlantIdNotFoundException;
import com.cg.onlineplantnursery.exceptions.PlanterIdNotFoundException;
import com.cg.onlineplantnursery.exceptions.SeedIdNotFoundException;

@Service
public interface IOrderService {
	public Order addOrder(Order order);
	public Order updateOrder(int orderId) throws OrderIdNotFoundException;
	public Order deleteOrder(int orderId) throws OrderIdNotFoundException;
	public Order viewOrder(int  orderId) throws OrderIdNotFoundException;
	public List<Order> viewAllOrders();
	public List<Order> getOrderByCategory(String category);
	public List<Order> getOrderByCustomerId(int customerId) throws CustomerIdNotFoundException;
	//public Order updatePlanter(int orderId,int planterId);
    //public Order getOrderByPlantId(String sessionId,Integer planterId,Integer quantity) throws CustomerIdNotFoundException,PlantIdNotFoundException,InSufficientQuantity;
	//public Order getOrderBySeedId(String sessionId,Integer seedId,Integer quantity) throws CustomerIdNotFoundException,SeedIdNotFoundException,InSufficientQuantity;
	//public Order getOrderByPlanterId(String sessionId,Integer PlanterId,Integer quantity) throws CustomerIdNotFoundException,PlanterIdNotFoundException,InSufficientQuantity;
	

}
