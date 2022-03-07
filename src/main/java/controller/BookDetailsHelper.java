package controller;

import java.awt.print.Book;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.User;

/**
 *@author roman-rggeleta@dmacc.edu
 *CIS175-Spring 2022
 *Mar 4, 2022
 */
public class BookDetailsHelper {

	/**
	 * @param user
	 */
	public void insertNewListDetails(User user) {
		// TODO Auto-generated method stub
		
	}
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("WebBookswithUsers");

	public void insert(Book b) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(b);
		em.getTransaction().commit();
		em.close();

	}
	
	public List<Book> getLists() {
		EntityManager em = emfactory.createEntityManager();
		List<Book> allDetails = em.createQuery("SELECT d FROM ListDetails d").getResultList();
		return allDetails;
	}

	public List<Book> showAllBooks() {
		EntityManager em = emfactory.createEntityManager();
		List<Book> allBooks = em.createQuery("SELECT i from Book i").getResultList();
		return allBooks;

	}

	public void delete(Book toDelete) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Book> typedQuery = em.createQuery("select b from Book b where b.bookTitle = :selectedBookTitle",
				Book.class);

		// typedQuery.setParameter("selectedBookTitle", toDelete.getBookTitle());
		// typedQuery.setParameter("selectedBookAuthor", toDelete.getBookAuthor());

		typedQuery.setMaxResults(1);

		Book result = typedQuery.getSingleResult();

		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}

	public Book searchForBookAuthorById(int idToEdit) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();

		Book found = em.find(Book.class, idToEdit);
		em.close();
		return found;
	}

	public void updateABook(Book toEdit) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();

		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}

	public List<Book> searchForBooksByBookTitle(String bookTitle) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Book> typedQuery = em.createQuery("select b from Book b where b.bookTitle = :selectedBookTitle",
				Book.class);

		typedQuery.setParameter("selectedBookTitle", bookTitle);

		List<Book> foundBooks = typedQuery.getResultList();
		em.close();
		return foundBooks;
	}

	public List<Book> searchForBooksByBookAuthor(String bookAuthor) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Book> typedQuery = em.createQuery("select b from Book b where b.BookAuthor = :selectedBookAuthor",
				Book.class);

		typedQuery.setParameter("selectedBookAuthor", bookAuthor);

		List<Book> foundBooks = typedQuery.getResultList();
		em.close();
		return foundBooks;
	}
	
	

	public void cleanUp() {
		emfactory.close();
	}

	/**
	 * @param toDelete
	 */
	public void deleteBookTitle(Book toDelete) {
		// TODO Auto-generated method stub
		
	}

}



