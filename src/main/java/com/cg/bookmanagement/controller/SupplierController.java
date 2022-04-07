
package com.cg.bookmanagement.controller;

import java.util.List;

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

import com.cg.bookmanagement.entity.Supplier;
import com.cg.bookmanagement.exception.ResourceNotFoundException;
import com.cg.bookmanagement.repository.SupplierRepository;

@RestController
@RequestMapping("/supplier")
public class SupplierController {
	@Autowired
	private SupplierRepository  supplierRepository;
	//get all Suppliers
		@GetMapping("/supplierList")
		public List<Supplier> getSupplierList()
		{
			return supplierRepository.findAll();
		}
		
		//add new customer
		@PostMapping("/insertsuppliers")
		public Supplier createCustomer(@Validated @RequestBody Supplier supplier)
		{
			return supplierRepository.save(supplier);
		}

		//get a supplier by id
		@GetMapping("/getsupplier/{id}")
	    public ResponseEntity<Supplier> getSupplierById(@PathVariable(value = "id") Integer supplierId)
	        throws ResourceNotFoundException {
			Supplier supplier = supplierRepository.findById(supplierId)
	          .orElseThrow(() -> new ResourceNotFoundException("Customer not found for this id :: " + supplierId));
	        return ResponseEntity.ok().body(supplier);
	    }
		//update a Supplier
		@PutMapping("/updatesuppliers/{id}")
	    public ResponseEntity<Supplier> updateCustomer(@PathVariable(value = "id") Integer supplierId,
	         @Validated @RequestBody Supplier supplierDetails) throws ResourceNotFoundException {
			Supplier supplier = supplierRepository.findById(supplierId)
	        .orElseThrow(() -> new ResourceNotFoundException("Customer not found for this id :: " + supplierId));

			supplier.setSupplier_Name(supplierDetails.getSupplier_Name());
			supplier.setSupplier_email(supplierDetails.getSupplier_email());
			supplier.setContact_no(supplierDetails.getContact_no());
			 
	        final Supplier updatedSupplier = supplierRepository.save(supplier);
	        return ResponseEntity.ok(updatedSupplier);
	    }
		@DeleteMapping("/deletesupplier/{id}")
		public void deleteSupplier(@PathVariable("id") int supplierid) {
			supplierRepository.deleteById(supplierid);
		}

}
