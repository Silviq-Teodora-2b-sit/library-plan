package com.libapp.service;

import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.libapp.User;
import com.libapp.dao.DAOImpl;
import com.libapp.dao.DAOInt;

public class ServiceImpl<T> implements Service<T>  {

	 
	private DAOInt<T> dao;
	 private Class<T> cl;

	 public ServiceImpl(Class<T> cl, SessionFactory sessionFactory) {
	  this.cl=cl;
	  dao=new DAOImpl<T>(cl, sessionFactory);
	 }

	@Override
	public T get(Class<T> cl, int id) {
		return (T) dao.get(cl, id);
	}

	@Override
	public void save(T t) {
		dao.save(t);
	}

	@Override
	public void update(T t) {
		dao.update(t);
	}

	@Override
	public void delete(T t) {
		dao.delete(t);
	}

	@Override
	public  List<T> query(String from){
		
		return (List<T>) dao.query("from "+cl.getSimpleName());
	}
	
	@Override
	public  T namedQuery(String query, Map<Integer, Object> params){
		return (T)dao.namedQuery(query, params);
	}

}
