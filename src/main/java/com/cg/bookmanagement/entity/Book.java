package com.cg.bookmanagement.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "BookId")
	private int book_id;
	private String book_Name;
	private String author;
	private String publisher;
	private String store_Location;
	private String category;
	private String book_ISBN;
	private int price;
	private int edition;
	private int no_of_copies;
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "OrderId")
	private Order order;
	
	public int getBook_id() {
		return book_id;
	}

	public void setBook_id(int book_id) {
		this.book_id = book_id;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public String getBook_Name() {
		return book_Name;
	}

	public void setBook_Name(String book_Name) {
		this.book_Name = book_Name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getStore_Location() {
		return store_Location;
	}

	public void setStore_Location(String store_Location) {
		this.store_Location = store_Location;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getBook_ISBN() {
		return book_ISBN;
	}

	public void setBook_ISBN(String book_ISBN) {
		this.book_ISBN = book_ISBN;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getEdition() {
		return edition;
	}

	public void setEdition(int edition) {
		this.edition = edition;
	}

	public int getNo_of_copies() {
		return no_of_copies;
	}

	public void setNo_of_copies(int no_of_copies) {
		this.no_of_copies = no_of_copies;
	}

	public Book(String book_Name, String author, String publisher, String store_Location, String category,
			String book_ISBN, int price, int edition, int no_of_copies) {
		super();
		this.book_Name = book_Name;
		this.author = author;
		this.publisher = publisher;
		this.store_Location = store_Location;
		this.category = category;
		this.book_ISBN = book_ISBN;
		this.price = price;
		this.edition = edition;
		this.no_of_copies = no_of_copies;
	}

	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Book [book_Name=" + book_Name + ", author=" + author + ", publisher=" + publisher + ", store_Location="
				+ store_Location + ", category=" + category + ", book_ISBN=" + book_ISBN + ", price=" + price
				+ ", edition=" + edition + ", no_of_copies=" + no_of_copies + "]"+"\n";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((author == null) ? 0 : author.hashCode());
		result = prime * result + ((book_ISBN == null) ? 0 : book_ISBN.hashCode());
		result = prime * result + ((book_Name == null) ? 0 : book_Name.hashCode());
		result = prime * result + ((category == null) ? 0 : category.hashCode());
		result = prime * result + edition;
		result = prime * result + no_of_copies;
		result = prime * result + price;
		result = prime * result + ((publisher == null) ? 0 : publisher.hashCode());
		result = prime * result + ((store_Location == null) ? 0 : store_Location.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		if (author == null) {
			if (other.author != null)
				return false;
		} else if (!author.equals(other.author))
			return false;
		if (book_ISBN == null) {
			if (other.book_ISBN != null)
				return false;
		} else if (!book_ISBN.equals(other.book_ISBN))
			return false;
		if (book_Name == null) {
			if (other.book_Name != null)
				return false;
		} else if (!book_Name.equals(other.book_Name))
			return false;
		if (category == null) {
			if (other.category != null)
				return false;
		} else if (!category.equals(other.category))
			return false;
		if (edition != other.edition)
			return false;
		if (no_of_copies != other.no_of_copies)
			return false;
		if (price != other.price)
			return false;
		if (publisher == null) {
			if (other.publisher != null)
				return false;
		} else if (!publisher.equals(other.publisher))
			return false;
		if (store_Location == null) {
			if (other.store_Location != null)
				return false;
		} else if (!store_Location.equals(other.store_Location))
			return false;
		return true;
	}

	public Object map(Object object) {
		// TODO Auto-generated method stub
		return null;
	}

}
