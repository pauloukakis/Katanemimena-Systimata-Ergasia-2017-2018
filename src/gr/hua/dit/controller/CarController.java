package gr.hua.dit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import gr.hua.dit.entity.Car;
import gr.hua.dit.service.CarService;

@Controller
@RequestMapping("/car")
public class CarController {
	
	// inject the customer service
	@Autowired
	private CarService carService;
	
	@GetMapping("/carlist")
	public String listCars(Model model) {
		
		// get customers from the service
		List<Car> cars = carService.getCars();
		
		// add the customers to the model
		model.addAttribute("cars",cars);
		
		// add page title
		model.addAttribute("pageTitle", "List Cars");
		return "list-cars";
	}
	
	@GetMapping("/{id}")
	public String getCar(Model model, @PathVariable("id") int id) {
		// get the car
		Car car = carService.getCar(id);
		
		model.addAttribute("car", car);
		
		return "car-form";
	}
	
	@GetMapping("/showAddFormCar")
	public String showAddForm(Model model) {
		// create model attribute to get form data
		Car car = new Car();
		model.addAttribute("car", car);
		
		// add page title
		model.addAttribute("pageTitle", "Add Car");
		return "car-form";
	}
	
	@PostMapping("/saveCar")
	public String saveCar(@ModelAttribute("car") Car car) {
		// save the customer using the service
		carService.saveCar(car);
		
		return "redirect:/car/list";
	}

}
