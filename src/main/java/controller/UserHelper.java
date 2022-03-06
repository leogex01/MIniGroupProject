package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.User;

/**
 *@author Roman-rggeleta@dmacc.edu
 *CIS175-Spring 2022
 *Mar 4, 2022
 */
public class UserHelper {
	
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("WebBookwithUser");

	public void insertShopper(User u) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(u);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<User> showAllShoppers(){
		EntityManager em = emfactory.createEntityManager();
		List<User> allUsers = em.createQuery("SELECT u from User u").getResultList();
		return allUsers;
	}
	
	public User findUser(String nameToLookUp) {

		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<User> typedQuery = em.createQuery("select uh from User uh where sh.userName = :selectedName",User.class);
		typedQuery.setParameter("selectedName", nameToLookUp);
		typedQuery.setMaxResults(1);
		User foundUser;
		try {
			foundUser = typedQuery.getSingleResult();
		} catch (NoResultException ex) {
			foundUser = new User(nameToLookUp);
		}
		em.close();

		return foundUser;
	}

}
