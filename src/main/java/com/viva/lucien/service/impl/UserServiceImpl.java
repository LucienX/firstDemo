package com.viva.lucien.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.viva.lucien.dao.UserDao;
import com.viva.lucien.model.User;
import com.viva.lucien.service.UserService;

/**
 * 
 * @author qiaoxing
 *
 * @time:2017年4月10日 下午4:23:24
 * @Description:用户业务逻辑实现类
 */
@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	@Override
	public User load(Long id) {
		return userDao.load(id);
	}

	@Override
	public User get(Long id) {
		return userDao.get(id);
	}

	@Override
	public List<User> findAll() {
		return userDao.findAll();
	}

	@Override
	public void persist(User entity) {
		userDao.persist(entity);
	}

	@Override
	public Long save(User entity) {
		return userDao.save(entity);
	}

	@Override
	public void saveOrUpdate(User entity) {
		userDao.saveOrUpdate(entity);
	}

	@Override
	public void delete(Long id) {
		userDao.delete(id);
	}

	@Override
	public void flush() {
		userDao.flush();
	}

}
