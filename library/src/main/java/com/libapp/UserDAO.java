package com.libapp;

import java.util.List;
import java.util.Optional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class UserDAO implements DAO<User> {

	private Session currentSession;
    
    private Transaction currentTransaction;
    public Session openCurrentSession() {
        currentSession = getSessionFactory().openSession();
        return currentSession;
    }
 
    public Session openCurrentSessionwithTransaction() {
        currentSession = getSessionFactory().openSession();
        currentTransaction =  currentSession.beginTransaction();
        return currentSession;
    }
     
    public void closeCurrentSession() {
        currentSession.close();
    }
     
    public void closeCurrentSessionwithTransaction() {
        currentTransaction.commit();
        currentSession.close();
    }
     
    private static SessionFactory getSessionFactory() {
    	 StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
	                .configure() // configures settings from hibernate.cfg.xml
	                .build();
    	 SessionFactory sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
        return sessionFactory;
    }
 
    public Session getCurrentSession() {
        return currentSession;
    }
 
    public void setCurrentSession(Session currentSession) {
        this.currentSession = currentSession;
    }
 
    public Transaction getCurrentTransaction() {
        return currentTransaction;
    }
 
    public void setCurrentTransaction(Transaction currentTransaction) {
        this.currentTransaction = currentTransaction;
    }
	@Override
	public User get(int id) {
		// TODO Auto-generated method stub
		User user = (User) getCurrentSession().get(User.class, id);
        return user; 
	}

	@Override
	public List<User> getAll() {
		// TODO Auto-generated method stub
		List<User> u = (List<User>) getCurrentSession().createQuery("from User").list();
        return u;
	}

	@Override
	public void save(User t) {
		// TODO Auto-generated method stub
		  getCurrentSession().save(t);
	}

	@Override
	public void update(User t) {
		 getCurrentSession().update(t);
		
	}

	@Override
	public void delete(User t) {
		// TODO Auto-generated method stub
		  getCurrentSession().delete(t);
	}

	public User Validation(String email, String pass)
	{
		
		Query query=getCurrentSession().getNamedQuery("User.byEmailAndPass");
    	query.setParameter(0, email);
    	query.setParameter(1, pass);
 
    	return (User)query.uniqueResult();
	}

}
