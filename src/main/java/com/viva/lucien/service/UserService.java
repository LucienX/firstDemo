package com.viva.lucien.service;

import java.util.List;

import com.viva.lucien.model.User;

/**
 * 
 * @author qiaoxing
 *
 * 下午4:20:15
 * 业务逻辑接口
 */
public interface UserService {
	User load(Long id);

	User get(Long id);

	List<User> findAll();

	void persist(User entity);

	Long save(User entity);

	void saveOrUpdate(User entity);

	void delete(Long id);

	void flush();
}
