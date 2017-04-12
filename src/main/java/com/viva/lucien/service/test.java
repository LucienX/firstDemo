package com.viva.lucien.service;

import java.util.Date;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;
import com.viva.lucien.model.User;


/**
 * 
 * @author qiaoxing
 *
 * 下午4:21:10
 * 测试spring与hibernate的整合。
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring.xml",
		"classpath:spring-hibernate.xml" })
public class test {
	private static final Logger LOGGER = Logger
			.getLogger(test.class);

	@Autowired
	private UserService userService;

	@Test
	public void save() {
		User user=new User();
		user.setName("555");
		user.setRegisterTime(new Date());
	User us=	userService.save(user);
		System.out.println(us.getName());
	}
}
