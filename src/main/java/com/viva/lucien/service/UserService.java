package com.viva.lucien.service;

import java.util.List;

import com.viva.lucien.model.User;

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
