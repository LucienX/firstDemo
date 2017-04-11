package com.viva.lucien.service.impl;

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
	public User save(User user) {
		return userDao.saveEntity(user);
	}

	

}
