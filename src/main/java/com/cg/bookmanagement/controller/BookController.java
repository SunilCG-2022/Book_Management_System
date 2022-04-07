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

import com.cg.bookmanagement.entity.Book;
import com.cg.bookmanagement.repository.BookRepository;
import com.cg.bookmanagement.repository.OrderRepository;

 
@RestController
@RequestMapping("/book")
public class BookController {
	@Autowired
	private BookRepository bookRepository;
	@Autowired
	private OrderRepository orderRepository;

	// add new Book
	 
		@PostMapping("orders/{orderId}/books")
		public Book saveBook(@PathVariable(value = "orderId") int orderId, 
				@Validated @RequestBody Book book) throws com.cg.bookmanagement.exception.ResourceNotFoundException
		{
			return orderRepository.findById(orderId).map(order -> {
				book.setOrder(order);
				return bookRepository.save(book);
			}).orElseThrow(()-> new com.cg.bookmanagement.exception.ResourceNotFoundException("Order not found"));
		}

	// get all books
	@GetMapping("/books")
	public List<Book> getBookList() {
		return bookRepository.findAll();
	}

	// get a book by id
	@GetMapping("/books/{id}")
	public ResponseEntity<Book> getBookById(@PathVariable(value = "id") int bookId)
			throws com.cg.bookmanagement.exception.ResourceNotFoundException {
		Book book = bookRepository.findById(bookId)
				.orElseThrow(() -> new com.cg.bookmanagement.exception.ResourceNotFoundException(
						"Customer not found for this id :: " + bookId));
		return ResponseEntity.ok().body(book);
	}
	 
	@DeleteMapping("/deletebook/{id}")
	public void deleteBook(@PathVariable("id") int bookid) {
		bookRepository.deleteById(bookid);
	}

	// update a Book
	@PutMapping("/books/{id}")
	public ResponseEntity<Book> updateBook(@PathVariable(value = "id") int bookId,
			@Validated @RequestBody Book bookDetails) throws com.cg.bookmanagement.exception.ResourceNotFoundException {
		Book book = bookRepository.findById(bookId)
				.orElseThrow(() -> new com.cg.bookmanagement.exception.ResourceNotFoundException(
						"Customer not found for this id :: " + bookId));

		book.setBook_Name(bookDetails.getBook_Name());
		book.setAuthor(bookDetails.getAuthor());
		book.setPublisher(bookDetails.getPublisher());
		book.setStore_Location(bookDetails.getStore_Location());
		book.setCategory(bookDetails.getCategory());
		book.setBook_ISBN(bookDetails.getBook_ISBN());
		book.setPrice(bookDetails.getPrice());
		book.setEdition(bookDetails.getEdition());
		book.setNo_of_copies(bookDetails.getNo_of_copies());

		final Book updatedBook = bookRepository.save(book);
		return ResponseEntity.ok(updatedBook);
	}
}
