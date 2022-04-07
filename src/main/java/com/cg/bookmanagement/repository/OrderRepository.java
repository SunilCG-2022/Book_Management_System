package com.cg.bookmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.bookmanagement.entity.Book;
import com.cg.bookmanagement.entity.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer>{

	Book save(Book book);


	 
}
