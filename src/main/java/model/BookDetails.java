package model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 * @author roman-rggeleta@dmacc.edu CIS175-Spring 2022 Mar 4, 2022
 */

@Entity
public class BookDetails {
	@Id
	@GeneratedValue
	private int id;
	private String listName;
	private LocalDate publishedDate;
	@ManyToOne(cascade = CascadeType.PERSIST)
	private User user;
	@OneToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
	private List<Book> listOfBooks;
	
	

	public BookDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BookDetails(int id, String listName, LocalDate publishedDate, User user, List<Book> listOfBooks) {
		super();
		this.id = id;
		this.listName = listName;
		this.publishedDate = publishedDate;
		this.user = user;
		this.listOfBooks = listOfBooks;
	}

	public BookDetails(String listName, LocalDate publishedDate, User user, List<Book> listOfBooks) {
		super();
		this.listName = listName;
		this.publishedDate = publishedDate;
		this.user = user;
		this.listOfBooks = listOfBooks;
	}

	public BookDetails(LocalDate tripDate, User user, List<Book> listOfBooks) {
		super();
		this.publishedDate = publishedDate;
		this.user = user;
		this.listOfBooks = listOfBooks;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getListName() {
		return listName;
	}

	public void setListName(String listName) {
		this.listName = listName;
	}

	public LocalDate getPublishedDate() {
		return publishedDate;
	}

	public void setPublishedDate(LocalDate publishedDate) {
		this.publishedDate = publishedDate;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Book> getListOfBooks() {
		return listOfBooks;
	}

	public void setListOfBooks(List<Book> selectedItemsInList) {
		this.listOfBooks = selectedItemsInList;
	}

	@Override
	public String toString() {
		return "BookDetails [id=" + id + ", listName=" + listName + ", localDate=" + publishedDate + ", user=" + user
				+ ", listOfBooks=" + listOfBooks + "]";
	}

}
