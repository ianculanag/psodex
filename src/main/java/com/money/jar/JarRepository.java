package com.money.jar;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JarRepository extends CrudRepository<Jar, Integer> {

	@Override
	List<Jar> findAll();
}
