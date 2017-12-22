package gr.hua.dit.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import gr.hua.dit.entity.User;

@Repository
public class UserDAOImpl implements UserDAO {
	// inject the session factory
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<User> getUsers() {
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// create a query
		Query<User> query = currentSession.createQuery("from User order by lastName", 
				User.class);
		
		
		// execute the query and get the results list
		List<User> users = query.getResultList();
				
		//return the results
		return users;
	}

	@Override
	public void saveUser(User user) {
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// save the customer
		currentSession.save(user);
		
	}

	@Override
	public User getUser(int id) {
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		//get and return Customer
		User user = currentSession.get(User.class, id);
		return user;
	}

	@Override
	public void deleteUser(int id) {
		
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// find the customer
		User user = currentSession.get(User.class, id);

		
		// delete customer
		currentSession.delete(user);
	}

}
