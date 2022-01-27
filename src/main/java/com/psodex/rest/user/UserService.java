package com.psodex.rest.user;

import java.util.Collection;
import java.util.Optional;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.psodex.rest.security.JwtTokenProvider;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtTokenProvider jwtTokenProvider;
	
	private Authentication userAuthentication;

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

	public JSONObject authenticate(@RequestBody User user) throws JSONException {
		JSONObject jsonObject = new JSONObject();
		try {
			Authentication authentication = authenticationManager
					.authenticate(new UsernamePasswordAuthenticationToken(user.getEmail(), user.getPassword()));
			
			// TODO: pending fix
			this.userAuthentication = authentication;
			
			if (authentication.isAuthenticated()) {
				String email = user.getEmail();
				jsonObject.put("name", authentication.getName());
				jsonObject.put("authorities", authentication.getAuthorities());
				jsonObject.put("token",
						jwtTokenProvider.createToken(email, userRepository.findByEmail(email).getRole()));
				return jsonObject;
			}
		} catch (JSONException e) {
			try {
				jsonObject.put("exception", e.getMessage());
				throw e;
			} catch (JSONException e1) {
				e1.printStackTrace();
				throw e1;
			}
		}
		return null;
	}
	
	public User getLoggedInUser(boolean isFromView) {
		return findByEmail(this.userAuthentication.getName());
	}
}
