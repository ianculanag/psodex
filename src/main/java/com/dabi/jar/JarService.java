package com.dabi.jar;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dabi.util.IService;

@Service
public class JarService implements IService<Jar> {
	
	@Autowired
	JarRepository jarRepository;

	@Override
	public List<Jar> findAll() {
		return jarRepository.findAll();
	}

	@Override
	public Jar findById(int id) {
		return jarRepository.findById(id).get();
	}

	@Override
	public void save(Jar jar) {
		jarRepository.save(jar);
		
	}

	@Override
	public void update(Jar jar, int id) {
		jar.setId(id);
		jarRepository.save(jar);
	}

	@Override
	public void delete(int id) {
		jarRepository.deleteById(id);
	}

	public void topUp(BigDecimal amount) {
		List<Jar> jars = findAll();
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
