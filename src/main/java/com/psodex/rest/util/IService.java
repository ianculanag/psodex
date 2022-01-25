package com.psodex.rest.util;

import java.util.List;

public interface IService<T> {
	public List<T> findAll();

	public T findById(int id);

	public void save(T model);

	public void update(T model, int id);

	public void delete(int id);
}
