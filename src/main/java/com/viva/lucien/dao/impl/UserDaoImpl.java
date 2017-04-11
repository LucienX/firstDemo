package com.viva.lucien.dao.impl;

import org.springframework.stereotype.Repository;

import com.viva.lucien.dao.UserDao;
import com.viva.lucien.model.User;

@Repository("userDao")
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao {


}
