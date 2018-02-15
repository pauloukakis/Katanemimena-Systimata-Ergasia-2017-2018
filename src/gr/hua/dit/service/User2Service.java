package gr.hua.dit.service;

import java.util.List;

import gr.hua.dit.entity.User2;

public interface User2Service {

	public void save(User2 user);

	public List<User2> getUsers2();

	public User2 getUser2(String username);
	
	public void saveRole(User2 user, String role);


}
