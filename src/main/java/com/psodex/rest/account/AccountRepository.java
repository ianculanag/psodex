package com.psodex.rest.account;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {

	List<Account> findAllByUserId(int id);

	Optional<Account> findByIdAndUserId(int id, int loggedInUserId);

}
