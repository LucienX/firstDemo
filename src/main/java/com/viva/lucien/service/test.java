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
		User user = new User();
		user.setRegisterTime(new Date());
		user.setName("张三");
		Long id=userService.save(user);
		System.out.println(id);
		LOGGER.info(JSON.toJSONString(id));
	}
}
