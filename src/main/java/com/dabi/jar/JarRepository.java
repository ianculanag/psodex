package com.dabi.jar;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JarRepository extends JpaRepository<Jar, Integer> {

	List<Jar> findAllByUserId(int loggedInUserId);

	Optional<Jar> findByIdAndUserId(int id, int loggedInUserId);
}
