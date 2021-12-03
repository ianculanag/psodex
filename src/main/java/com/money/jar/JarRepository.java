package com.money.jar;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface JarRepository extends CrudRepository<Jar, Integer> {

	@Override
	List<Jar> findAll();
}
