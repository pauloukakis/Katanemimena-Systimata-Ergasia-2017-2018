package gr.hua.dit.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import gr.hua.dit.entity.User2;

@Repository
public class User2DAOImpl implements User2DAO {

	// inject the session factory
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void save(User2 user) {

		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		currentSession.save(user);

	}

	@Override
	public List<User2> getUsers2() {
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// create a query
		Query<User2> query = currentSession.createQuery("from User order by username", User2.class);

		// execute the query and get the results list
		List<User2> users = query.getResultList();

		// return the results
		return users;

	}

	@Override
	public void saveRole(User2 user, String role) {
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		NativeQuery sql=currentSession.createNativeQuery("INSERT INTO authorities(username,authority) VALUES('"+ user.getUser2name() +"', '"+ role + "')");
		sql.executeUpdate();

	}

	@Override
	public User2 getUser2(String username) {
		Session currentSession = sessionFactory.getCurrentSession();

		// get and return Teacher
		User2 user = currentSession.get(User2.class, username);
		return user;
	}

}
