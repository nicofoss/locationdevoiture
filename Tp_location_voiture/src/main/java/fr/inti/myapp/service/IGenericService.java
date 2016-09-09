package fr.inti.myapp.service;

import java.util.List;


public interface IGenericService<T> {

	public T add(T t);
	public List<T> getAll();
	public T update(T t);
	public T delete(T t);
}
