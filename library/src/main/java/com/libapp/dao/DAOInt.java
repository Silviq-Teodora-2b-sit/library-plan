package com.libapp.dao;

import java.util.List;
import java.util.Map;


public interface DAOInt<T> {
	T get(Class<T>cl,int id);
    
    void save(T t);
    
    void update(T t);
    
    void delete(T t);
    List<T> query(String from);
    
    T namedQuery(String query, Map<Integer, Object> params);
  
}
