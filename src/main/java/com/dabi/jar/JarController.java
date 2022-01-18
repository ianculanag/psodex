package com.dabi.jar;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JarController {
	
	@Autowired
	JarService jarService;

	@RequestMapping(method=RequestMethod.GET, value="/jars")
	public List<Jar> getAllJars() {
		return jarService.getAllJars();
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/jars")
	public void addJar(@RequestBody Jar jar) {
		jarService.addJar(jar);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/jars/{id}")
	public void updateJar(@RequestBody Jar jar, @PathVariable int id) {
		jarService.updateJar(jar, id);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/jars/{id}")
	public void deleteJar(@PathVariable int id) {
		jarService.deleteJar(id);
	}
}
