package com.money.jar;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JarService {
	
	@Autowired
	JarRepository jarRepository;

	public List<Jar> getAllJars() {
		return jarRepository.findAll();
	}

	public void addJar(Jar jar) {
		jarRepository.save(jar);
	}

	public void updateJar(Jar jar, int id) {
		jar.setId(id);
		jarRepository.save(jar);
	}

	public void deleteJar(int id) {
		jarRepository.deleteById(id);
	}
}
