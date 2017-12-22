package gr.hua.dit.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import gr.hua.dit.entity.Car;

@Repository
public class CarDAOImpl implements CarDAO {
	// inject the session factory
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Car> getCars() {
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// create a query
		Query<Car> query = currentSession.createQuery("from Car order by ownerName", 
				Car.class);
		
		
		// execute the query and get the results list
		List<Car> cars = query.getResultList();
				
		//return the results
		return cars;
	}

	@Override
	public void saveCar(Car car) {
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// save the customer
		currentSession.save(car);
		
	}

	@Override
	public Car getCar(int id) {
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		//get and return Customer
		Car car = currentSession.get(Car.class, id);
		return car;
	}

	@Override
	public void deleteCar(int id) {
		
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// find the customer
		Car car = currentSession.get(Car.class, id);

		
		// delete customer
		currentSession.delete(car);
	}

}
