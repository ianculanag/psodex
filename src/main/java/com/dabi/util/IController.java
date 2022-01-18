package com.dabi.util;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/rest")
public interface IController<T, REQ, RES> {
	
	public List<RES> findAll();
	
	public RES findById(int id);

	public void save(@RequestBody REQ request);

	public void update(@RequestBody REQ request, int id);

	public void delete(@PathVariable int id);

	public T preProcess(REQ request);

	public RES postProcess(T model);
}
