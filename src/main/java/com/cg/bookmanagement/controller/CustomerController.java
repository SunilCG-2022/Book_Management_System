package com.cg.bookmanagement.controller;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.bookmanagement.entity.Book;
import com.cg.bookmanagement.entity.Customer;
import com.cg.bookmanagement.repository.CustomerRepository;
import com.cg.bookmanagement.repository.OrderRepository;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private CustomerRepository customerRepository;

	@PostMapping("/{orderId}/customers")
	public Customer saveCustomer(@PathVariable(value = "orderId") Integer customerId,
			@Validated @RequestBody Customer customer)
			throws com.cg.bookmanagement.exception.ResourceNotFoundException {
		return orderRepository.findById(customerId).map(order -> {
			customer.setOrder(order);
			return customerRepository.save(customer);
		}).orElseThrow(() -> new com.cg.bookmanagement.exception.ResourceNotFoundException("Order not found"));
	}

	// get coupon by custId

	@GetMapping("/allcustomers")

	public List<Customer> getCustomerList() {
		return customerRepository.findAll();
	}

	@PutMapping("/customers/{id}")
	public ResponseEntity<Customer> updateCustomer(@PathVariable(value = "id") int customerId,

			@Validated @RequestBody Customer customerDetails) throws

	com.cg.bookmanagement.exception.ResourceNotFoundException {
		Customer customer = customerRepository.findById(customerId)
				.orElseThrow(() -> new com.cg.bookmanagement.exception.ResourceNotFoundException(
						"Customer not found for this id :: " + customerId));

		customer.setCustomer_Name(customerDetails.getCustomer_Name());
		customer.setCustomer_address(customerDetails.getCustomer_address());
		customer.setCustomer_email(customerDetails.getCustomer_email());
		customer.setContact_no(customerDetails.getContact_no());

		final Customer updatedCustomer = customerRepository.save(customer);
		return ResponseEntity.ok(updatedCustomer);
	}
	@DeleteMapping("/deletecustomer/{id}")
	public void deleteCustomer(@PathVariable("id") int customerid) {
		customerRepository.deleteById(customerid);
	}
}
