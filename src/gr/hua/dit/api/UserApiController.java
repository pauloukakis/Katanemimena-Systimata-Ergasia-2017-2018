package gr.hua.dit.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import gr.hua.dit.entity.User;
import gr.hua.dit.entity.UserList;
import gr.hua.dit.service.UserService;

@RestController
@RequestMapping("/api/user")
public class UserApiController {

	@Autowired
	private UserService userService;

	@Autowired
	private UserList userList;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = { "application/json", "application/xml" })
	public User getUser(@PathVariable("id") int id) {

		User user = userService.getUser(id);
		System.out.println("user :" + user);

		return user;
	}

	@RequestMapping(value="/delete/{id}", method= RequestMethod.DELETE, produces = { "application/json", "application/xml" })
	public ResponseEntity deleteUser(@PathVariable("id") int id) {
		userService.deleteUser(id);
		return new ResponseEntity(HttpStatus.OK);
	}
	
	@RequestMapping(value = "/all", method = RequestMethod.GET, produces = { "application/json", "application/xml" })
	public UserList getUsers() {

		List<User> users = userService.getUsers();
		System.out.println("users :" + users);
		this.userList.setUserList(users);
		return this.userList;
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST, produces = { "application/json", "application/xml" })
	public User createUser(@RequestParam("firstName") String firstName,
			@RequestParam("lastName") String lastName, @RequestParam("email") String email, @RequestParam("role") String role) {
		User user = new User(firstName, lastName, email, role);
		userService.saveUser(user);
		return user;

	}

	@RequestMapping(value = "/jsonadd", method = RequestMethod.POST,  produces = { "application/json", "application/xml" })
	public User createUserfromJson(@RequestBody User user) {
		userService.saveUser(user);
		return user;
	}
	
	

}
