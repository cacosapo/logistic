package com.mkyong.persistence;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

public interface LaneDaoInterface<T, Id extends Serializable> {
	
	public Session openCurrentSession();
	
	public void closeCurrentSession();
	
	public Session openCurrentSessionwithTransaction();

	public void persist(T entity);

	public void update(T entity);

	public T findById(Id id);

	public void delete(T entity);

	public List<T> findAll();

	public void deleteAll();
	
	public List vertexList();
}
