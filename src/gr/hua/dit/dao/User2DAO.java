package gr.hua.dit.dao;

import java.util.List;


import gr.hua.dit.entity.User2;

public interface User2DAO {

	public void save(User2 user);

	public List<User2> getUsers2();
	
	public void saveRole(User2 user, String role);

	public User2 getUser2(String username);

	

}
