package com.cg.bookmanagement.controller;



import java.util.List;

 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.bookmanagement.entity.Order;
import com.cg.bookmanagement.exception.ResourceNotFoundException;
import com.cg.bookmanagement.repository.OrderRepository;
import com.cg.bookmanagement.repository.SupplierRepository;

@RestController
@RequestMapping("/order")
public class OrderController {
	@Autowired
	private OrderRepository orderRepository;
	 
	@Autowired
	private SupplierRepository  supplierRepository;
	 
	// add new Order
	 
		@PostMapping("supliers/{supId}/orders")
		public Order saveOrder(@PathVariable(value = "supId") Integer supId, 
				@Validated @RequestBody  Order order) throws ResourceNotFoundException
		{
			 
				return supplierRepository.findById(supId).map(supplier -> {
					order.setSupplier(supplier);
				return orderRepository.save(order);
			
				}).orElseThrow(()-> new ResourceNotFoundException("Customer not found"));
		}
		//get coupon by custId
		@GetMapping("/allorders")
		 
		public List<Order> getorderList() {
			return orderRepository.findAll();
		}
		 
		
		
		//update coupon
		@PutMapping("orders/{supId}/orders/{orderId}")
		public Order updateOrder(@PathVariable(value = "supId") Integer supId,
				@PathVariable(value = "orderId") Integer orderId, @Validated @RequestBody Order orderDetails) throws ResourceNotFoundException
		{
			return orderRepository.findById(orderId).map(order ->{
				order.setOrder_Status(orderDetails.getOrder_Status());
				order.setOrder_Price(orderDetails.getOrder_Price());
				order.setAddress(orderDetails.getAddress());
				
				return orderRepository.save(order);
			}).orElseThrow(()->new ResourceNotFoundException("order not found"));
		}
		
}
