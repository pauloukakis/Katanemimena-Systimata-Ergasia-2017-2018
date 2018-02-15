package gr.hua.dit.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import gr.hua.dit.dao.User2DAO;
import gr.hua.dit.entity.User2;

@Service
public class User2ServiceImpl implements User2Service {

	// inject the UserDAO
	@Autowired
	private User2DAO user2DAO;
	
	@Autowired
    private PasswordEncoder passwordEncoder;
 

	@Override
	@Transactional
	public void save(User2 user) {
		// enable by default the user
		user.setEnabled((short) 1);
		
		// hash the password
        user.setPassword(passwordEncoder.encode(user.getPassword()));
		user2DAO.save(user);

	}

	@Override
	@Transactional
	public List<User2> getUsers2() {
		return user2DAO.getUsers2();
	}

	@Override
	@Transactional
	public User2 getUser2(String username) {
		return user2DAO.getUser2(username);
	}

	@Override
	@Transactional
	public void saveRole(User2 user, String role) {
		user2DAO.saveRole(user, role);
		
	}

}
