package com.cg.bookmanagement.dto;

import com.cg.bookmanagement.entity.Book;

public class OrderRequest {
private Book book;

public Book getBook() {
	return book;
}

public void setBook(Book book) {
	this.book = book;
}

public OrderRequest() {
	super();
	// TODO Auto-generated constructor stub
}

public OrderRequest(Book book) {
	super();
	this.book = book;
}

@Override
public String toString() {
	return "OrderRequest [book=" + book + "]";
}

}
