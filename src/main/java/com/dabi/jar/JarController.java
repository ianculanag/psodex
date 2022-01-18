package com.dabi.jar;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dabi.util.IController;

@RestController
@RequestMapping("/jars")
@CrossOrigin(origins = "http://localhost:3000")
@PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
public class JarController implements IController<Jar, JarRequest, JarResponse> {
	
	@Autowired
	JarService jarService;

	@Override
	@GetMapping
	public List<JarResponse> findAll() {
		return jarService.findAll().stream().map(jar -> postProcess(jar)).collect(Collectors.toList());
	}

	@Override
	@GetMapping("/{id}")
	public JarResponse findById(@PathVariable int id) {
		return postProcess(jarService.findById(id));
	}

	@Override
	@PostMapping
	public void save(@RequestBody JarRequest jarRequest) {
		jarService.save(preProcess(jarRequest));
		
	}

	@Override
	@PutMapping("/{id}")
	public void update(@RequestBody JarRequest jarRequest, @PathVariable int id) {
		jarService.update(preProcess(jarRequest), id);
	}

	@Override
	@DeleteMapping("/{id}")
	public void delete(@PathVariable int id) {
		jarService.delete(id);
	}

	@Override
	public Jar preProcess(JarRequest jarRequest) {
		return new Jar(jarRequest.getJarName(), jarRequest.getDescription(), jarRequest.getPercentage(),
				jarRequest.getAvailableBalance(), jarRequest.getDateCreated());
	}

	@Override
	public JarResponse postProcess(Jar jar) {
		if (jar == null)
			return null;
		return new JarResponse(String.valueOf(jar.getId()), jar.getName(), jar.getDescription(),
				String.valueOf(jar.getPercentage()), jar.getAvailableBalance(), jar.getDateCreated().toString());
	}
}
