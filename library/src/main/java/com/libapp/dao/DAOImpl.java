package com.libapp.dao;

import java.util.List;
import java.util.Map;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class DAOImpl<T> implements DAOInt<T>{
	
	 private SessionFactory sessionFactory;
	 private Logger LOGGER;
	
	 public DAOImpl(Class<T> cl, SessionFactory sessionFactory) {
		 this.LOGGER = LogManager.getLogger(cl);
	  this.sessionFactory = sessionFactory;
	  if (sessionFactory == null)
	   throw new RuntimeException("Session factory is null!!!");
	 }
	 
	@Override
	public T get(Class<T> cl, int id) {
		LOGGER.info("STARTED- Get user by ID");
		Session session = sessionFactory.getCurrentSession();
		 session.beginTransaction();
		T element = (T) session.get(cl, id);
		session.getTransaction().commit();
		LOGGER.info("FINISHED - Get user by ID");
		return element;
	}

	@Override
	public void save(T t) {
		LOGGER.info("STARTED- Save user");
		Session session = sessionFactory.getCurrentSession();
		  session.beginTransaction();
		  session.save(t);
		  session.getTransaction().commit();
		  LOGGER.info("FINISHED- Save user");
	}

	@Override
	public void update(T t) {
		LOGGER.info("STARTED- Update user");
		 Session session = sessionFactory.getCurrentSession();
		  session.beginTransaction();
		  session.update(t);
		  session.getTransaction().commit();
		  LOGGER.info("FINISHED- Update user");
	}

	@Override
	public void delete(T t) {
		LOGGER.info("STARTED- Delete user");
		 Session session = sessionFactory.getCurrentSession();
		  session.beginTransaction();
		  session.delete(t);
		  session.getTransaction().commit();
		  LOGGER.info("FINISHED- Delete user");
	}
	@Override
	public  List<T> query(String from){
		LOGGER.info("STARTED- Query");
		 Session session = sessionFactory.getCurrentSession();
		  session.beginTransaction();
		  List<T> resultList=(List<T>) session.createQuery(from).list();
		  session.getTransaction().commit();
		  LOGGER.info("FINISHED- Query. Result suze="+resultList.size());
		  return resultList;
	}
	
	@Override
	public T namedQuery(String query, Map<Integer, Object> params){
		LOGGER.info("STARTED- Named Query");
		Session session = sessionFactory.getCurrentSession();
		  session.beginTransaction();
		  Query q=session.getNamedQuery(query); 
		   for (Integer i : params.keySet()) {
		    q.setParameter(i, params.get(i));
		   }
		T result= (T) q.uniqueResult();
		   session.getTransaction().commit();
		   LOGGER.info("FINISHED- Named Query");
		   return result;
	}

	@Override
	public List<T> createQuery(String hsql, Map<String, Object> params) {
		LOGGER.info("STARTED - Create Query with parameters returns list");
		Session session = sessionFactory.getCurrentSession();
		  session.beginTransaction();
		  Query query = session.createQuery(hsql);
		  if (params != null) {
		   for (String i : params.keySet()) {
		    query.setParameter(i, params.get(i));
		   }
		  }
		  List<T> result = null;
		  result = query.list();
		  LOGGER.info("FINISHED - Create Query. Result size="+result.size());
		  session.getTransaction().commit();
		return result;
	}

	

}
