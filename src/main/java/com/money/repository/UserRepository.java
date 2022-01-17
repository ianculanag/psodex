package com.money.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.money.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	
	@Query("FROM User WHERE email=:email")
	User findByEmail(@Param("email") String email);

}
