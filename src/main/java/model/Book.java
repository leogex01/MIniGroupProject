package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author roman-rggeleta@dmacc.edu CIS175-Spring 2022 Mar 4, 2022
 */

@Entity
@Table(name = "books")
public class Book {
	@Id
	@GeneratedValue
	@Column(name = "ID")
	private int id;
	@Column(name = "BookTitle")
	private String bookTitle;
	@Column(name = "Author")
	private String bookAuthor;

	public Book() {
		// TODO Auto-generated constructor stub
	}

	public Book(int id, String bookTitle, String bookAuthor) {
		super();
		this.id = id;
		this.bookTitle = bookTitle;
		this.bookAuthor = bookAuthor;
	}

	public Book(String bookTitle, String bookAuthor) {
		super();
		this.bookTitle = bookTitle;
		this.bookAuthor = bookAuthor;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBookTitle() {
		return bookTitle;
	}

	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}

	public String getBookAuthor() {
		return bookAuthor;
	}

	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}

	public String returnItemDetails() {
		return this.bookTitle + " : " + this.bookAuthor;
	}

}
