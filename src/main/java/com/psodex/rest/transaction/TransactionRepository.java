package com.psodex.rest.transaction;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Integer> {

	List<Transaction> findAllByUserId(int loggedInUserId);

	Optional<Transaction> findByIdAndUserId(int id, int loggedInUserId);

}
