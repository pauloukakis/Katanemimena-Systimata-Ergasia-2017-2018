package gr.hua.dit.service;

import java.util.List;

import gr.hua.dit.entity.User;

public interface UserService {
	public List<User> getUsers();

	public void saveUser(User user);
	
	public User getUser(int id);

	public void deleteUser(int id);
}
