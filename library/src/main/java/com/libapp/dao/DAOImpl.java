package com.libapp.dao;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.libapp.User;

public class DAOImpl<T> implements DAOInt<T>{
	
	 private SessionFactory sessionFactory;
	 
	
	 public DAOImpl(Class<T> cl, SessionFactory sessionFactory) {
	  this.sessionFactory = sessionFactory;
	  if (sessionFactory == null)
	   throw new RuntimeException("Session factory is null!!!");
	 }
	 
	@Override
	public T get(Class<T> cl, int id) {
		Session session = sessionFactory.getCurrentSession();
		 session.beginTransaction();
		T element = (T) session.get(cl, id);
		session.getTransaction().commit();
		return element;
	}

	@Override
	public void save(T t) {
		Session session = sessionFactory.getCurrentSession();
		  session.beginTransaction();
		  session.save(t);
		  session.getTransaction().commit();
		
	}

	@Override
	public void update(T t) {
		 Session session = sessionFactory.getCurrentSession();
		  session.beginTransaction();
		  session.update(t);
		  session.getTransaction().commit();
	}

	@Override
	public void delete(T t) {
		 Session session = sessionFactory.getCurrentSession();
		  session.beginTransaction();
		  session.delete(t);
		  session.getTransaction().commit();
	}
	@Override
	public  List<T> query(String from){
		 Session session = sessionFactory.getCurrentSession();
		  session.beginTransaction();
		  List<T> resultList=(List<T>) session.createQuery(from).list();
		  session.getTransaction().commit();
		  return resultList;
	}
	
	@Override
	public T namedQuery(String query, Map<Integer, Object> params){
		Session session = sessionFactory.getCurrentSession();
		  session.beginTransaction();
		  Query q=session.getNamedQuery(query); 
		   for (Integer i : params.keySet()) {
		    q.setParameter(i, params.get(i));
		   }
		   @SuppressWarnings("unchecked")
		T result= (T) q.uniqueResult();
		   session.getTransaction().commit();
		   return result;
	}
	
}
