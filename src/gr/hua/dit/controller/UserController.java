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

import gr.hua.dit.entity.User;
import gr.hua.dit.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	// inject the customer service
	@Autowired
	private UserService userService;
	
	@GetMapping("/userlist")
	public String listUsers(Model model) {
		
		// get customers from the service
		List<User> users = userService.getUsers();
		
		// add the customers to the model
		model.addAttribute("users",users);
		
		// add page title
		model.addAttribute("pageTitle", "List Users");
		return "list-users";
	}
	
	@GetMapping("/{id}")
	public String getUser(Model model, @PathVariable("id") int id) {
		// get the customer
		User user = userService.getUser(id);
		
		model.addAttribute("user", user);
		
		return "user-form";
	}
	
	@GetMapping("/showAddFormUser")
	public String showAddForm(Model model) {
		// create model attribute to get form data
		User user = new User();
		model.addAttribute("user", user);
		
		// add page title
		model.addAttribute("pageTitle", "Add User");
		return "user-form";
	}
	
	@PostMapping("/saveUser")
	public String saveUser(@ModelAttribute("user") User user) {
		// save the customer using the service
		userService.saveUser(user);
		
		return "redirect:/user/list";
	}

}
