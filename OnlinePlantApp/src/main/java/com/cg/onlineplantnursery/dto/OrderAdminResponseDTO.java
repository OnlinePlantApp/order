package com.cg.onlineplantnursery.dto;

import java.time.LocalDate;


import lombok.Data;

@Data
public class OrderAdminResponseDTO {
	private Integer bookingOrderId;
	private LocalDate orderDate;
	private String transactionMode;
	private int quantity;
	private double totalCost;
	private String msg;

}
