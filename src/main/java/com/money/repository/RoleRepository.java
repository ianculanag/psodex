package com.money.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.money.domain.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {

}
