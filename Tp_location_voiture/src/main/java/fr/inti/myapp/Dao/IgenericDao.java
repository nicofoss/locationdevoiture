package fr.inti.myapp.Dao;

import java.util.List;

public interface IgenericDao<T> {
	
	public T add(T t);
	public List<T> getAll();
	public T update(T t);
	public T delete(T t);
	
}
