package com.dabi.user;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public Collection<User> findAll() {
		return userRepository.findAll();
	}
	
	public Optional<User> findById(Integer id) {
		return userRepository.findById(id);
	}
	
	public User saveOrUpdate(User user) {
		user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
		return userRepository.saveAndFlush(user);
	}
	
	public void deleteById(Integer id) {
		userRepository.deleteById(id);
	}
	
	public User getLoggedInUser() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		return findByEmail(authentication.getName());
	}
	
	public int getLoggedInUserId() {
		return getLoggedInUser().getId();
	}
	
	public User findByEmail(String email) {
		return userRepository.findByEmail(email);
	}
}
