package com.money.service;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.money.domain.Role;
import com.money.repository.RoleRepository;

@Service
public class RoleService {
	@Autowired
	private RoleRepository roleRepository;
	
	public Collection<Role> findAll() {
		return roleRepository.findAll();
	}
	
	public Optional<Role> findById(Integer id) {
		return roleRepository.findById(id);
	}
	
	public Role saveOrUpdate(Role role) {
		return roleRepository.saveAndFlush(role);
	}
	
	public void deleteById(Integer id) {
		roleRepository.deleteById(id);
	}
}
