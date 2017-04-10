package com.viva.lucien.dao;

import java.io.Serializable;
import java.util.List;

/**
 * 
 * @author lucien
 * @param <T>泛型
 * @param <PK>主键泛型
 * Dao通用接口
 */
interface GenericDao<T, PK extends Serializable>  {
	T load(PK id);
	
	T get(PK id);
	
	List<T> findAll();
	
	void persist(T entity);
	
	Long save(T entity);
	
	void saveOrUpdate(T entity);
	
	void delete(PK id);
	
	void flush();
}
