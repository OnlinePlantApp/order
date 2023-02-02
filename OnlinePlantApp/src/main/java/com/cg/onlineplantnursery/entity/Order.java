package com.cg.onlineplantnursery.entity;

import java.time.LocalDate;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;


import lombok.Data;
import lombok.NoArgsConstructor;
@Table(name = "MyOrder")
@Entity
@Data
@NoArgsConstructor
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) // code to generate PK automatically
	private int bookingOrderId;
	private LocalDate orderDate;
	private String transactionMode;
	private int quantity;
	private double totalCost;
	private int customerId;
	private  int productId;
	private String category;
	
	//@OneToOne(cascade= CascadeType.ALL)
	//private Planter planter;
	public Order(String transactionMode, int quantity, double totalCost, int customerId, int productId,
			String category) {
		super();
		this.transactionMode = transactionMode;
		this.quantity = quantity;
		this.totalCost = totalCost;
		this.customerId = customerId;
		this.productId = productId;
		this.category = category;
		this.orderDate = LocalDate.now();
		System.out.println("insideOrderEntity" + this);
	}
	
	

	
	
}
