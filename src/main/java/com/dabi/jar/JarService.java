package com.dabi.jar;

import java.math.BigDecimal;
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

	public void topUp(BigDecimal amount) {
		List<Jar> jars = getAllJars();
		jars.forEach(jar -> jar.setAvailableBalance(
				jar.getAvailableBalance().add(amount.multiply(BigDecimal.valueOf(jar.getPercentage() / 100)))));
		jars.forEach(jar -> jarRepository.save(jar));
	}

	public void withdrawBalance(BigDecimal amount, int jarId) {
		Jar jar = jarRepository.findById(jarId).orElse(null);
		if (jar != null) {
			jar.setAvailableBalance(jar.getAvailableBalance().subtract(amount));
		}
		jarRepository.save(jar);
	}
}
