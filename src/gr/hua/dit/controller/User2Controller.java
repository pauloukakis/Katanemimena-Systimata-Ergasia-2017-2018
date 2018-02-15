package gr.hua.dit.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import gr.hua.dit.entity.User2;
import gr.hua.dit.service.User2Service;

@Controller
@RequestMapping("/user2")
public class User2Controller {
	

	// inject the teacher service
	@Autowired
	private User2Service user2Service;
	
	@GetMapping("/list")
	public String listUsers(Model model) {
		
		// get teachers from the service
		List<User2> users = user2Service.getUsers2();
		
		// add the teachers to the model
		model.addAttribute("users",users);
		
		// add page title
		model.addAttribute("pageTitle", "List Users");
		return "list-users2";
	}
	
	@GetMapping("/showAddForm")
	public String showAddForm(Model model) {
		// create model attribute to get form data
		User2 user = new User2();
		model.addAttribute("user", user);
		
		// add page title
		model.addAttribute("pageTitle", "Add User");
		return "user2-form";
	}
	
	@PostMapping("/saveUser")
	public String saveStudent(@ModelAttribute("user") User2 user) {
		// save the student using the service
		user2Service.save(user);
		
		return "redirect:/user2/assignRole/"+user.getUser2name();
	}
	
	@Secured("ROLE_ADMIN")
	@GetMapping("/assignRole/{username}")
	public String assignRole(Model model,  @PathVariable("username") String username) {
		User2 user = user2Service.getUser2(username);
		List<String> roles = new ArrayList<>();
		roles.add("ROLE_ADMIN");
		roles.add("ROLE_USER");
	    model.addAttribute("roles", roles);
	    model.addAttribute("user", user);
		return "assign-role";
	}
	
	@Secured("ROLE_ADMIN")
	@PostMapping("/assignRole/{username}")
	public String assignRoleToUser(@PathVariable("username") String username, @RequestParam("role") String role) {
		User2 user = user2Service.getUser2(username);
		
		System.out.println("Role : " + role);
		user2Service.saveRole(user, role);
		return "redirect:/user2/list";
	}

}
