package gr.hua.dit.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gr.hua.dit.dao.CarDAO;
import gr.hua.dit.entity.Car;

@Service
public class CarServiceImpl implements CarService {

	// inject the CustomerDAO
	@Autowired
	private CarDAO carDAO;
	
	@Override
	@Transactional
	public List<Car> getCars() {
		return carDAO.getCars();
	}

	@Override
	@Transactional
	public void saveCar(Car car) {
		carDAO.saveCar(car);
	}

	@Override
	@Transactional
	public Car getCar(int id) {
		return carDAO.getCar(id);
	}

	@Override
	@Transactional
	public void deleteCar(int id) {
		carDAO.deleteCar(id);
	}

}
