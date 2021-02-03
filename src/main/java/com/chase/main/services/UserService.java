package com.chase.main.services;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chase.main.models.User;
import com.chase.main.repos.UserRepo;

@Service
public class UserService {
	
	@Autowired
	private UserRepo userRepo;

//	private final UserRepo userRepo;
//	public UserService(UserRepo ur) {
//		this.userRepo = ur;
//	}
	
	public User findByEmail(String email) {
		return userRepo.findByEmail(email);
	}
	
	
	public User register(User user) {
		String hashedPassword = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
		user.setPassword(hashedPassword);
		return userRepo.save(user);
	}
	
	public boolean authenticateUser(String email, String password) {
		User user = userRepo.findByEmail(email);
		if(user == null) {
			return false;
		} else {
			if(BCrypt.checkpw(password, user.getPassword())) {
				return true;
			}else {
				return false;
			}
		}
	}
}