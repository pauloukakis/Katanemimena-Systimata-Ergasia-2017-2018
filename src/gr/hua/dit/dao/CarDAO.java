package gr.hua.dit.dao;

import java.util.List;

import gr.hua.dit.entity.Car;

public interface CarDAO {

	public List<Car> getCars();

	public void saveCar(Car car);
	
	public Car getCar(int id);

	public void deleteCar(int id);
	
}
